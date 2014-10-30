package com.detroitlabs.fragmentsdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.detroitlabs.fragmentsdemo.basic.BasicFragmentActivity;
import com.detroitlabs.fragmentsdemo.viewpager.FragmentViewPagerActivity;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_basics)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        openBasicDemoActivity();
                    }
                });

        findViewById(R.id.btn_viewpager)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        openViewPagerActivity();
                    }
                });
    }

    private void openViewPagerActivity() {
        startActivity(new Intent(MainActivity.this, FragmentViewPagerActivity.class));
    }

    private void openBasicDemoActivity() {
        startActivity(new Intent(MainActivity.this, BasicFragmentActivity.class));
    }
}
