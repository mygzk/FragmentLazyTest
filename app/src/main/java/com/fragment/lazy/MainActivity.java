package com.fragment.lazy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main0);
        initView();
    }

    private void initView() {
        findViewById(R.id.viewpagertest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,ViewPagerFragmentActivity.class);
                startActivity(i);
            }
        });

        findViewById(R.id.btntest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,RadioGroupFragmentActivity.class);
                startActivity(i);
            }
        });
    }
}
