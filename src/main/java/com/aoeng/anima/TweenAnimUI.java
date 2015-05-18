package com.aoeng.anima;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;


public class TweenAnimUI extends Activity implements View.OnClickListener {

    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_anim_ui);

        findViewById(R.id.btnScale).setOnClickListener(this);
        findViewById(R.id.btnApla).setOnClickListener(this);
        findViewById(R.id.btnRotate).setOnClickListener(this);
        findViewById(R.id.btnTransalte).setOnClickListener(this);
        findViewById(R.id.btnScaleXml).setOnClickListener(this);
        findViewById(R.id.btnAplaXml).setOnClickListener(this);
        findViewById(R.id.btnRotateXml).setOnClickListener(this);
        findViewById(R.id.btnTransalteXml).setOnClickListener(this);
        findViewById(R.id.btnComplex).setOnClickListener(this);
        findViewById(R.id.btnStartActivity).setOnClickListener(this);
        img = (ImageView) findViewById(R.id.img);
        img.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img:
                Toast.makeText(this, "I'm is onClicked !", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnScale:
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.1f, 1.0f, .0f, 1.0f);
                scaleAnimation.setDuration(1000);
                final ScaleAnimation scaleAnimation2 = new ScaleAnimation(1f, .5f, 1.0f, .5f);
                scaleAnimation2.setDuration(1000);
                //设置连续动画
                scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        img.startAnimation(scaleAnimation2);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                img.startAnimation(scaleAnimation);
                break;
            case R.id.btnApla:
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
                alphaAnimation.setDuration(2000);
                img.startAnimation(alphaAnimation);
                break;
            case R.id.btnRotate:
//                AnimationUtils.loadAnimation();
                RotateAnimation rotateAnimation = new RotateAnimation(0, 360, 0.5f, 0.5f);
                rotateAnimation.setDuration(300);
                rotateAnimation.setRepeatMode(Animation.RESTART);
                rotateAnimation.setRepeatCount(Animation.INFINITE);
                img.startAnimation(rotateAnimation);
                break;
            case R.id.btnTransalte:
//                animation.setDuration(long durationMillis);//设置动画持续时间
//                animation.setRepeatCount(int i);//设置重复次数
//                animation.setRepeatMode(Animation.REVERSE);//设置反方向执行
//                final Animation translateAnimation=new TranslateAnimation(0,200,0,200);   //移动动画效果
//                translateAnimation.setDuration(3000);           //设置动画持续时间
//                translateAnimation.setFillAfter (true);        //保留在终止位置
//                translateAnimation.setFillEnabled(true);        //使能填充效果
//                image.setAnimation(translateAnimation);         //设置动画效果
//                translateAnimation.startNow();                  //启动动画
//                translateAnimation.cancel();                     //取消动画执行

//                TranslateAnimation translateAnimation = new TranslateAnimation(0, 300, 0, 0);
                TranslateAnimation translateAnimation = new TranslateAnimation(0, 300, 0, 0);
                translateAnimation.setDuration(5000);
                translateAnimation.setFillAfter(true);
                img.startAnimation(translateAnimation);
                img.setAnimation(translateAnimation);
//                启动动画
//                translateAnimation.startNow();
                //取消动画
//                translateAnimation.cancel();

                break;

            case R.id.btnScaleXml:
                Animation scaleXml = AnimationUtils.loadAnimation(this, R.anim.scale);
                img.startAnimation(scaleXml);
                break;
            case R.id.btnAplaXml:
                Animation aplaXml = AnimationUtils.loadAnimation(this, R.anim.apla);
                img.startAnimation(aplaXml);
                break;
            case R.id.btnRotateXml:
                Animation rotateXml = AnimationUtils.loadAnimation(this, R.anim.rotate);
                img.startAnimation(rotateXml);
                break;
            case R.id.btnTransalteXml:
                Animation translateXml = AnimationUtils.loadAnimation(this, R.anim.translate);
                img.startAnimation(translateXml);
                break;
            case R.id.btnComplex:
                AnimationSet complex = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.complex);
//                img.setAnimation(complex);
                img.startAnimation(complex);
//                complex.startNow();

                break;
            case R.id.btnStartActivity:
                Intent intent = new Intent(this,NewActivityUI.class);
                startActivity(intent);
                overridePendingTransition(R.anim.ui_in,R.anim.ui_out);
                break;

        }
    }
}
