package development.uble.android.com.i.cor;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


/**
 * Created by ederpadilla on 09/01/17.
 */

public class BannerViewPagerAdapter extends FragmentPagerAdapter {

    public BannerViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int pos) {
        switch(pos) {
            case 0: return new ViewPagerPicOne();
            case 1: return new ViewPagerPicTwo();
            case 2: return new ViewPagerPicThree();
            default: return ViewPagerPicOne.newInstance();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}

