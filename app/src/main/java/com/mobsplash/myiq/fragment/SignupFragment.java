package com.mobsplash.myiq.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobsplash.myiq.DashboardActivity;
import com.mobsplash.myiq.R;


/**
 * Created by Sharan Kumar on 6/2/19.
 */
public class SignupFragment extends Fragment {

    public static final String TAG = "SignupFragment";
    DashboardActivity parent;
    View convertView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        parent=(DashboardActivity)getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        convertView=inflater.inflate(R.layout.fragment_dashboard,null);
        return convertView;
    }
}
