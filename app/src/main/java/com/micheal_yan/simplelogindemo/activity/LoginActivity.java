package com.micheal_yan.simplelogindemo.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.Toast;

import com.micheal_yan.simplelogindemo.R;

/**
 * Created by micheal-yan on 2016/11/26.
 */

public class LoginActivity extends BaseActivity {

    private EditText accountEdit;
    private EditText passwordEdit;
    private Checkable rememberPassword;
    private Button login;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //初始化所有组件
        setContentView(R.layout.activity_login);
        accountEdit = (EditText) findViewById(R.id.account);
        passwordEdit = (EditText) findViewById(R.id.password);
        rememberPassword = (Checkable) findViewById(R.id.rememberPassword);
        login = (Button) findViewById(R.id.login);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = preferences.edit();

        if (preferences.getBoolean("isRemember", false)) {
            accountEdit.setText(preferences.getString("account", ""));
            passwordEdit.setText(preferences.getString("password", ""));
            rememberPassword.setChecked(true);
        }

        //为登陆按钮绑定点击事件
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                if (account.equals("admin") && password.equals("123456")) {
                    if (rememberPassword.isChecked()) {
                        editor.putString("account", account);
                        editor.putString("password", password);
                        editor.putBoolean("isRemember", true);
                    } else {
                        editor.clear();
                    }
                    editor.commit();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "账户或密码输入错误", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
