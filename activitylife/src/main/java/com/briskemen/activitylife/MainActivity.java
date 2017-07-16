package com.briskemen.activitylife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"==========onCreate MainActivity=========");
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,BActivity.class);
                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==0){

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"==========onStart MainActivity=========");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"==========onResume MainActivity=========");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"==========onPause MainActivity=========");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"==========onStop MainActivity=========");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"==========onRestart MainActivity=========");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"==========onDestroy MainActivity=========");
    }
}
