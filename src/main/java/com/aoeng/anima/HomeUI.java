package com.aoeng.anima;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class HomeUI extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_home);


        findViewById(R.id.btnTween).setOnClickListener(this);
        findViewById(R.id.btnFrame).setOnClickListener(this);
        findViewById(R.id.btnLayout).setOnClickListener(this);
        findViewById(R.id.btnProperty).setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Intent newIntent = null;
        switch (view.getId()) {
            case R.id.btnTween:
                newIntent = new Intent(this, TweenAnimUI.class);
                startActivity(newIntent);
                break;
            case R.id.btnFrame: {
                newIntent = new Intent(this, FrameAnimUI.class);
                startActivity(newIntent);
            }
            case R.id.btnLayout: {

                newIntent = new Intent(this, LayoutAnimUI.class);
                startActivity(newIntent);
            }
            case R.id.btnProperty: {
                newIntent = new Intent(this, PropertyAnimUI.class);
                startActivity(newIntent);
            }
        }
    }
}
