package com.mobsplash.myiq.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ProgressBar;

/**
 * Created by Sharan Kumar on 12/9/18.
 */
public class Utils {

//    private static Retrofit retrofit = null;

    public static void replaceFragment(final Fragment newFrag, final int containerID, final FragmentManager fragmentManager, final boolean addToBackStack, final String tag, final Bundle bundle) {


        Handler mHandler = new Handler();
        Runnable mTranscationRunnable = new Runnable() {
            @SuppressLint("ResourceType")
            @Override
            public void run() {


                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);
                fragmentTransaction.replace(containerID, newFrag, tag);

                if (addToBackStack)
                    fragmentTransaction.addToBackStack(null);
                if (bundle != null) {
                    newFrag.setArguments(bundle);
                }

//        fragmentTransaction.commit();
                fragmentTransaction.commitAllowingStateLoss();
                fragmentManager.executePendingTransactions();

            }
        };
        if (mTranscationRunnable != null) {
            mHandler.post(mTranscationRunnable);
        }


    }

    public static void showProgressBar(ProgressBar progressBar) {
        progressBar.setVisibility(View.VISIBLE);
        progressBar.bringToFront();
    }

    public static void dismissProgressBar(ProgressBar progressBar) {
        progressBar.setVisibility(View.GONE);
    }


    /*public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Configuration.ROOT_PATH)
                    .client(ApiClient.getHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }*/

    public static boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

    public static String checkString(String value) {
        String str;
        if (value == null || value.equals("") || value.equals("null")
                || value.trim().length() == 0) {
            str = " - ";
        } else
            str = value;
        return str;
    }


}
