package com.aoeng.anima;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class LayoutAnimUI extends Activity {

    private ListView lvLayout;
    private List<String> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_anim_ui);

        initDatas();
        findViews();
        process();
    }

    private void process() {

        LayoutAnimationController lac = new LayoutAnimationController(AnimationUtils.loadAnimation(this, R.anim.apla));
        lac.setOrder(LayoutAnimationController.ORDER_RANDOM);
        lvLayout.setLayoutAnimation(lac);
        lac.setDelay(0.5f);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mDatas);
        lvLayout.setAdapter(adapter);
    }

    private void findViews() {
        lvLayout = (ListView) findViewById(R.id.lvLayout);
    }

    private void initDatas() {
        mDatas = new ArrayList<String>();
        for (int i = 0; i < 30; i++) {
            mDatas.add("数据源" + i);
        }
    }


}
