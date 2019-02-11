package com.mobsplash.myiq;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.widget.FrameLayout;



import com.mobsplash.myiq.fragment.LoginFragment;
import com.mobsplash.myiq.fragment.SignupFragment;
import com.mobsplash.myiq.utils.Utils;

public class MainActivity extends BaseActivity {


    FrameLayout flMainLay;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flMainLay=findViewById(R.id.flMainLay);
        fragmentManager = getSupportFragmentManager();


        includeLoginFragment();


    }

    public void includeLoginFragment() {

        Bundle bundle = new Bundle();
        LoginFragment loginFragment = new LoginFragment();
        Utils.replaceFragment(loginFragment, R.id.flMainLay, fragmentManager, false, LoginFragment.TAG, bundle);

    }

    public void includeSignupFragment() {

        Bundle bundle = new Bundle();
        SignupFragment signupFragment = new SignupFragment();
        Utils.replaceFragment(signupFragment, R.id.flMainLay, fragmentManager, true, SignupFragment.TAG, bundle);

    }



}
