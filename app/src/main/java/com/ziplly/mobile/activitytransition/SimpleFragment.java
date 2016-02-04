package com.ziplly.mobile.activitytransition;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

/**
 * Created by susnata on 2/3/16.
 */
public class SimpleFragment extends Fragment {

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.content1, container, false);
  }

  public void setYfrac(final float f) {
    final View view = getView();
    android.util.Log.d("SHAAN", "f = "+f+" h="+view.getHeight());
    if (view.getHeight() == 0) {
      view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
        @Override
        public boolean onPreDraw() {
          view.getViewTreeObserver().removeOnPreDrawListener(this);
          setYfrac(f);
          return true;
        }
      });
      return;
    }

    getView().setTranslationY(getView().getTranslationY()/getView().getHeight());
  }

  public float getYfrac() {
    return getView().getTranslationY()/getView().getHeight();
  }
}
