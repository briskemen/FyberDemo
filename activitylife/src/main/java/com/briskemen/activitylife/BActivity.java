package com.briskemen.activitylife;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class BActivity extends AppCompatActivity {
    private static final String TAG = "BActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        Log.i(TAG,"==========onCreate BActivity=========");
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"==========onStart BActivity=========");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"==========onResume BActivity=========");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"==========onPause BActivity=========");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"==========onStop BActivity=========");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"==========onRestart BActivity=========");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"==========onDestroy BActivity=========");
    }
}
