package com.mobsplash.myiq.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mobsplash.myiq.DashboardActivity;
import com.mobsplash.myiq.MainActivity;
import com.mobsplash.myiq.R;

/**
 * Created by Sharan Kumar on 6/2/19.
 */
public class LoginFragment extends Fragment {

    public static final String TAG = "LoginFragment";
    MainActivity parent;
    View convertView;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        parent=(MainActivity)getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        convertView=inflater.inflate(R.layout.fragment_login,null);
        initViews();
        return convertView;
    }

    public void initViews(){
        Button btnLogin=convertView.findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToDashboard();
            }
        });

        TextView tvNewUser=convertView.findViewById(R.id.tvNewUser);
        tvNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parent.includeSignupFragment();
            }
        });


    }



        public void navigateToDashboard() {
            Intent intent = new Intent(parent, DashboardActivity.class);
            startActivity(intent);
        }
}
