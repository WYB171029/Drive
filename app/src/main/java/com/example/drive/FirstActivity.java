package com.example.drive;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class FirstActivity extends AppCompatActivity {
    private List<Fragment> fragments = new ArrayList<>();
    private ViewPager viewPager;
    private RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        initView();
        initListener();
    }

    private void initListener() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i) {
                    case 0:
                        radioGroup.check(R.id.rb_1);
                        break;
                    case 1:
                        radioGroup.check(R.id.rb_2);
                        break;
                    case 2:
                        radioGroup.check(R.id.rb_3);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_1:
                        viewPager.setCurrentItem(0,false);
                        break;
                    case R.id.rb_2:
                        viewPager.setCurrentItem(1,false);
                        break;
                    case R.id.rb_3:
                        viewPager.setCurrentItem(2,false);
                        break;
                }
            }
        });
    }

    private void initView() {
        viewPager = findViewById(R.id.viewPager);
        radioGroup = findViewById(R.id.radioGroup);
        fragments.add(new HomeFragment());
        fragments.add(new VideoFragment());
        fragments.add(new MeFragment());
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        viewPager.setCurrentItem(0);
    }
}
