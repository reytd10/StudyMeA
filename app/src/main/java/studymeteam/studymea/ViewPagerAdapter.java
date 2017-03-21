package studymeteam.studymea;

/**
 * Created by ROG on 12/03/2017.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position ==0) {
            return new HomeTab();
        } else if (position == 1) {
            return new LecturesTab();
        } else if(position == 2){
            return new TestsTab();
        }
         else
            return new AccountsTab();
    }

    @Override
    public int getCount() {
        return 4;
    }
}