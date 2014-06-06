package me.biubiubiu.flipperview.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by ccheng on 6/6/14.
 */
public class FlipperView extends FrameLayout {

    private float mPrevX;
    private View mPositveView;
    private View mNegativeView;

    public FlipperView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mPositveView = findViewById(R.id.positive);
        mNegativeView = findViewById(R.id.negative);
        mNegativeView.setVisibility(View.GONE);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        System.out.println("FlipperView.onTouchEvent");
        System.out.println("event.getAction() = " + event.getAction());
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                float d = event.getX() - mPrevX;
                mPositveView.setRotationX(d);
                mPrevX = event.getX();
                break;

        }
        return super.onTouchEvent(event);
    }
}
