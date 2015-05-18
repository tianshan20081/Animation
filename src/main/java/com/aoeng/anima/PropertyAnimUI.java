package com.aoeng.anima;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class PropertyAnimUI extends Activity implements View.OnClickListener {

    private Button btnMove;
    private ImageView imgObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_anim_ui);

        initDatas();
        findViews();
        setViewListener();
        process();

    }

    private void setViewListener() {
        imgObj.setOnClickListener(this);
        btnMove.setOnClickListener(this);
        findViewById(R.id.btnProComplex).setOnClickListener(this);
        findViewById(R.id.btnProComplex2).setOnClickListener(this);
        findViewById(R.id.btnProComplex3).setOnClickListener(this);
    }

    private void process() {


    }

    private void findViews() {
        btnMove = (Button) findViewById(R.id.btnMove);
        imgObj = (ImageView) findViewById(R.id.imgObject);
    }

    private void initDatas() {

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.imgObject:

                Toast.makeText(this, "onclick ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnMove:
// translationY ; rotation ;
                ObjectAnimator.ofFloat(imgObj, "translationX", 0f, 200f).setDuration(2000).start();
                break;
            case R.id.btnProComplex:
                ObjectAnimator.ofFloat(imgObj, "translationX", 0f, 200f).setDuration(2000).start();
                ObjectAnimator.ofFloat(imgObj, "translationY", 0f, 200f).setDuration(2000).start();
                ObjectAnimator.ofFloat(imgObj, "rotation", 0f, 360f).setDuration(2000).start();
                break;
            case R.id.btnProComplex2:
                PropertyValuesHolder p1 = PropertyValuesHolder.ofFloat("translationX", 0f, 200f);
                PropertyValuesHolder p2 = PropertyValuesHolder.ofFloat("translationY", 0f, 200f);
                PropertyValuesHolder p3 = PropertyValuesHolder.ofFloat("rotation", 0f, 360f);
                ObjectAnimator.ofPropertyValuesHolder(imgObj, p1, p2, p3).setDuration(3000).start();
                break;
            case R.id.btnProComplex3:
                ObjectAnimator anim1 = ObjectAnimator.ofFloat(imgObj, "translationX", 0f, 200f);
                ObjectAnimator anim2 = ObjectAnimator.ofFloat(imgObj, "translationY", 0f, 200f);
                ObjectAnimator anim3 = ObjectAnimator.ofFloat(imgObj, "rotation", 0f, 360f);
                AnimatorSet animSet = new AnimatorSet();
//                animSet.playTogether(anim1, anim2, anim3);
//                animSet.playSequentially(anim1,anim2, anim3);

                animSet.play(anim1).with(anim2);
                animSet.play(anim2).after(anim3);
                animSet.setDuration(3000);
                anim1.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {

                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });

                anim2.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                    }
                });
                animSet.start();
                break;
        }
    }
}
