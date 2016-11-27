package com.micheal_yan.simplelogindemo.activity;

import android.app.Activity;
import android.os.Bundle;

import com.micheal_yan.simplelogindemo.util.ActivityCollector;

/**
 * Created by micheal-yan on 2016/11/26.
 */

public class BaseActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
