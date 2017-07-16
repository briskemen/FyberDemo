package com.zhuoyian.fyberdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.fyber.Fyber;
import com.fyber.ads.AdFormat;
import com.fyber.ads.videos.RewardedVideoActivity;
import com.fyber.requesters.InterstitialRequester;
import com.fyber.requesters.OfferWallRequester;
import com.fyber.requesters.RequestCallback;
import com.fyber.requesters.RequestError;
import com.fyber.requesters.RewardedVideoRequester;

public class MainActivity extends AppCompatActivity {

    private String appId="103708";
    private String SecurityToken="19cb5cebeb166d5fba9f9d16a079ebaf";
    String TAG = "AppCompatActivity";
    private static final int OFFER_WALL_REQUEST_CODE     = 1234;// 积分墙
    private static final int INTERSTITIAL_REQUEST_CODE   = 9012;// 全屏广告
    private boolean isAdShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "onCreate ");
        showAd();
    }

    private void showAd() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                gotoAd();
                goWallAd();
                goIntersAd();
            }
        }, 400);
    }

    private void gotoAd() {
        Fyber.with(appId, this)
                // .withUserId(userID)
                .withSecurityToken(SecurityToken)
                .start();

        RewardedVideoRequester.create(requestCallback).request(this);
//        OfferWallRequester.create(requestCallback)
//                .closeOnRedirect(true)
//                .request(this);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume ");
       /* if (!isAdShow){
            showAd();
            isAdShow = true;
        }*/
    }

    // fyber广告墙
    private void goWallAd() {
        //fyber广告
        Fyber.with(appId, this)
                //.withUserId(userID)
                .withSecurityToken(SecurityToken)
                .start();
        Fyber.Settings settings = Fyber.with(appId, this).start();
        settings.notifyUserOnCompletion(false);

        OfferWallRequester.create(new RequestCallback() {
            @Override
            public void onAdAvailable(Intent intent) {
                startActivityForResult(intent, OFFER_WALL_REQUEST_CODE);//跳转到广告墙
            }

            @Override
            public void onAdNotAvailable(AdFormat adFormat) {

            }

            @Override
            public void onRequestError(RequestError requestError) {

            }
        })
                .closeOnRedirect(true)
                .request(this);
    }

    // fyber全屏广告
    private void goIntersAd() {
        //fyber广告
        Fyber.with(appId, this)
                //.withUserId(userID)
                .withSecurityToken(SecurityToken)
                .start();
        Fyber.Settings settings = Fyber.with(appId, this).start();
        settings.notifyUserOnCompletion(false);

        InterstitialRequester.create(new RequestCallback() {
            @Override
            public void onAdAvailable(Intent intent) {
                startActivityForResult(intent, INTERSTITIAL_REQUEST_CODE);//跳转到全屏广告
            }

            @Override
            public void onAdNotAvailable(AdFormat adFormat) {

            }

            @Override
            public void onRequestError(RequestError requestError) {

            }
        })
                .request(this);
    }


    RequestCallback requestCallback = new RequestCallback() {
        @Override
        public void onAdAvailable(Intent intent) {
            startActivityForResult(intent, REWARDED_VIDEO_REQUEST_CODE);// 跳转到激励视频
        }

        @Override
        public void onAdNotAvailable(AdFormat adFormat) {
            Log.e(TAG, "onAdNotAvailable ");
        }

        @Override
        public void onRequestError(RequestError requestError) {
            Log.e(TAG, "onRequestError ");
        }
    };

    protected static final int REWARDED_VIDEO_REQUEST_CODE = 5678;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Log.e(TAG, "resultCode: " + resultCode);

        if (resultCode == RESULT_OK && requestCode == REWARDED_VIDEO_REQUEST_CODE) {

            String engagementResult = data.getStringExtra(RewardedVideoActivity.ENGAGEMENT_STATUS);
            switch (engagementResult) {
                case RewardedVideoActivity.REQUEST_STATUS_PARAMETER_FINISHED_VALUE:
                    break;
                case RewardedVideoActivity.REQUEST_STATUS_PARAMETER_ABORTED_VALUE:
                    break;
                case RewardedVideoActivity.REQUEST_STATUS_PARAMETER_ERROR:
                    break;
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy ");
    }
}
