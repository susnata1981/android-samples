package com.ziplly.mobile.activitytransition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

/**
 * Created by susnata on 2/1/16.
 */
public class RectImageView extends View {
  private int mColor = Color.RED;
  private int mRadius = 64;
  private Paint mPaint;

  public RectImageView(Context context, AttributeSet attrs) {
    super(context, attrs);
    TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RectImageView);
    if (typedArray.hasValue(R.styleable.RectImageView_ri_color)) {
      mColor = typedArray.getColor(R.styleable.RectImageView_ri_color, Color.BLACK);
    }

    if (typedArray.hasValue(R.styleable.RectImageView_ri_radius)) {
      mRadius = typedArray.getInt(0, R.styleable.RectImageView_ri_radius);
    }

    typedArray.recycle();
    init();
  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
    DisplayMetrics metrics = new DisplayMetrics();
    wm.getDefaultDisplay().getMetrics(metrics);
    int width = metrics.widthPixels;
    setMeasuredDimension(MeasureSpec.makeMeasureSpec(width/2, MeasureSpec.EXACTLY), heightMeasureSpec);
  }

  public RectImageView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  private void init() {
    setWillNotDraw(false);
    mPaint = new Paint();
    mPaint.setColor(mColor);
    setBackground(getContext().getDrawable(R.drawable.border));
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    int [] loc = new int[2];
    getLocationOnScreen(loc);
    int top = loc[1];
    int left = loc[0];
    int radius = mRadius;
    canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
  }
}

