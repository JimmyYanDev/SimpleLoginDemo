package com.micheal_yan.simplelogindemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.micheal_yan.simplelogindemo.R;

public class MainActivity extends BaseActivity {

    private Button forceOffline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        forceOffline = (Button) findViewById(R.id.forceOffline);
        forceOffline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.micheal_yan.FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });
    }
}
