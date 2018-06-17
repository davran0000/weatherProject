package com.example.virus.weatherprojecttop;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.TabLayout;


import com.example.virus.weatherprojecttop.fragments.ChooseLocationFragment;
import com.example.virus.weatherprojecttop.fragments.CurrentLocationFragment;
import com.example.virus.weatherprojecttop.fragments.FindLocationFragment;

public class MainActivity extends AppCompatActivity {
    private SectionPagerAdapter sectionPagerAdapter;
    private ViewPager viewPager;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupTabsOfViewPager();

    }

    private void setupTabsOfViewPager() {
        sectionPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.container);
        setupViewPager(viewPager);
        TabLayout tableLayout = findViewById(R.id.tabs);
        tableLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        sectionPagerAdapter.addFragment(new CurrentLocationFragment(),getResources().getString(R.string.tab1));
        sectionPagerAdapter.addFragment(new ChooseLocationFragment(),getResources().getString(R.string.tab2));
        sectionPagerAdapter.addFragment(new FindLocationFragment(),getResources().getString(R.string.tab3));
        viewPager.setAdapter(sectionPagerAdapter);

    }
}
