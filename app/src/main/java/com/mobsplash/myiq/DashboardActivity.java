package com.mobsplash.myiq;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.widget.FrameLayout;


import com.mobsplash.myiq.fragment.DashboardFragment;
import com.mobsplash.myiq.utils.Utils;

/**
 * Created by Sharan Kumar on 27/1/19.
 */
public class DashboardActivity extends BaseActivity {

    FrameLayout flContainer;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        flContainer=findViewById(R.id.flContainerLay);
        fragmentManager = getSupportFragmentManager();

        includeHomeFragment();

    }


    public void includeHomeFragment() {

        Bundle bundle = new Bundle();
        DashboardFragment dashboardFragment = new DashboardFragment();
        Utils.replaceFragment(dashboardFragment, R.id.flContainerLay, fragmentManager, false, DashboardFragment.TAG, bundle);

    }
}
