package com.ziplly.mobile.activitytransition;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private boolean showScene1 = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Transition transition = TransitionInflater.from(
                  MainActivity.this).inflateTransition(R.transition.whirl);
              SimpleFragment fragment = new SimpleFragment();
//              fragment.setEnterTransition(transition);
//              fragment.setExitTransition(transition);
              FragmentTransaction ft = getFragmentManager().beginTransaction();
              ft
                  .setCustomAnimations(R.anim.slide_in, R.anim.slide_out, R.anim.slide_in, R.anim.slide_out)
                  .replace(R.id.container, fragment)
                  .addToBackStack(null)
                  .commit();
            }
        });
    }

  @Override
  public void onBackPressed() {
    getFragmentManager().popBackStack();
  }
}

