package app.checkitapp.com.checkitapp;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

public class IntroActivity extends FragmentActivity {

    ViewPager viewpager;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        viewpager=(ViewPager)findViewById(R.id.pager);
        PagerAdapter pa = new PagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(pa);


    }
}
