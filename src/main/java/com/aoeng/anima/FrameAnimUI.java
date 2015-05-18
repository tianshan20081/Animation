package com.aoeng.anima;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by sczhang on 15/5/4.
 */
public class FrameAnimUI  extends Activity{

    private ImageView imgFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ui_frame);

        imgFrame =(ImageView) findViewById(R.id.imgFrame);

        AnimationDrawable animationDrawable = (AnimationDrawable) imgFrame.getDrawable();
        animationDrawable.start();
    }
}
