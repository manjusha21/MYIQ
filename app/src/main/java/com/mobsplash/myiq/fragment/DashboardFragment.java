package com.mobsplash.myiq.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.mobsplash.myiq.DashboardActivity;
import com.mobsplash.myiq.R;
import com.mobsplash.myiq.adapters.ViewPagerAdapter;

import java.util.Timer;
import java.util.TimerTask;

import me.crosswall.lib.coverflow.CoverFlow;
import me.crosswall.lib.coverflow.core.PagerContainer;

/**
 * Created by Sharan Kumar on 27/1/19.
 */
public class DashboardFragment extends Fragment {

    public static final String TAG = "DashboardFragment";
    DashboardActivity parent;
    View convertView;

    private ViewPager intro_images;
    private ViewPagerAdapter mAdapter;
    private int[] mImageResources = {
            R.drawable.banner1,
            R.drawable.banner2,
            R.drawable.banner1,
            R.drawable.banner2

    };
    Timer timer;
    final long DELAY_MS = 500;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 3000;
    private int currentPage=0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        parent=(DashboardActivity)getActivity();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        convertView=inflater.inflate(R.layout.fragment_dashboard,null);

        initViews();
        return convertView;
    }

    private void initViews() {
        intro_images = convertView.findViewById(R.id.pager_introduction);
        mAdapter = new ViewPagerAdapter(parent, mImageResources);
        intro_images.setAdapter(mAdapter);
        intro_images.setCurrentItem(0);


        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == mImageResources.length-1) {
                    currentPage = 0;
                }
                intro_images.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer(); // This will create a new Thread
        timer .schedule(new TimerTask() { // task to be scheduled

            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);

        initPager();

    }

    public void initPager(){
        PagerContainer pagerContainer=convertView.findViewById(R.id.pager_container);
        ViewPager pager = pagerContainer.getViewPager();
        pager.setAdapter(new MyPagerAdapter());
        pager.setClipChildren(false);
        //
        pager.setOffscreenPageLimit(15);
        new CoverFlow.Builder()
                .with(pager)
                .scale(0.1f)
                .pagerMargin(getResources().getDimensionPixelSize(R.dimen.pager_margin))
                .spaceSize(0f)
                .build();

    }

    private class MyPagerAdapter extends PagerAdapter {

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            View view = LayoutInflater.from(parent).inflate(R.layout.item_cover,null);
            ImageView imageView = (ImageView) view.findViewById(R.id.image_cover);
            imageView.setImageDrawable(getResources().getDrawable(mImageResources[position]));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }

        @Override
        public int getCount() {
            return mImageResources.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return (view == object);
        }
    }
}
