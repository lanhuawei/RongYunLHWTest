package com.lanhuawei.rongyunlhwtext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private String tokean = "gYGatjxyPW110sQfIELlON5xm+GfuSvn3d06+QcEmBWwjqHxnLeCggmCc5O3mNyOJnzbbW2M0PM=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RongIM.connect(tokean, new RongIMClient.ConnectCallback() {
                    @Override
                    public void onTokenIncorrect() {
                        Log.e("MainActivity", "--onTokenIncorrect");
                    }

                    @Override
                    public void onSuccess(String s) {
                        Log.e("MainActivity", "--onSuccess--" + s);
                        Toast.makeText(MainActivity.this, "登录成功,用户：" + s, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(RongIMClient.ErrorCode errorCode) {
                        Log.e("MainActivity", "--onError");
                    }
                });
            }
        });
    }



}
