package com.example.ea.prolink;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends DrawerActivity {


    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences prefs = getSharedPreferences("userInfo",MODE_PRIVATE);
        String id=prefs.getString("userId","");
       // Toast.makeText(this,id,Toast.LENGTH_SHORT).show();
      //  setContentView(R.layout.activity_home);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //inflate your activity layout here!
        View contentView = inflater.inflate(R.layout.activity_home, null, false);
        mDrawerLayout.addView(contentView, 0);
        tabLayout = (TabLayout)findViewById(R.id.homeTabs);
        viewPager = (ViewPager)findViewById(R.id.homeViewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        //Add Fragment Here
        viewPagerAdapter.AddFragment(new FragmentPosts(),"Posts");
        viewPagerAdapter.AddFragment(new FragmentCourses(),"Courses");
        viewPagerAdapter.AddFragment(new FragmentEvents(),"Events");

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        //Remove shadow from the action bar



    }
}
