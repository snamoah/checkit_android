package app.checkitapp.com.checkitapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by samuel on 2/5/15.
 */
public class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int arg0){
        switch (arg0){
            case 0:
                return  new IntroActivityFragmentOne();
            case 1:
                return new IntroActivityFragmentTwo();
            case 2:
                return new IntroActivityFragmentThree();
            case 3:
                return new IntroActivityFragmentFour();
            default:
                break;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
