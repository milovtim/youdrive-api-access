package youdrive.today.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.databinding.DataBindingUtil;
import android.support.design.widget.Snackbar;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import youdrive.today.BaseActivity;
import youdrive.today.C1733R;
import youdrive.today.databinding.ActivityWellcomeBinding;
import youdrive.today.fragments.AboutFirst;
import youdrive.today.fragments.AboutFourth;
import youdrive.today.fragments.AboutSecond;
import youdrive.today.fragments.AboutThird;

public class WellcomeActivity extends BaseActivity implements OnPageChangeListener {
    private final int FIRST_SCREEN;
    private final int FOURTH_SCREEN;
    private final int SECOND_SCREEN;
    private final int THIRD_SCREEN;
    ActivityWellcomeBinding f799b;
    private AboutFirst mFirst;

    private class WelcomeAdapter extends FragmentPagerAdapter {
        public WelcomeAdapter(FragmentManager manager) {
            super(manager);
        }

        public Fragment getItem(int position) {
            switch (position) {
                case C1733R.styleable.View_android_theme /*0*/:
                    WellcomeActivity.this.mFirst = new AboutFirst();
                    return WellcomeActivity.this.mFirst;
                case C1733R.styleable.View_android_focusable /*1*/:
                    return new AboutSecond();
                case C1733R.styleable.View_paddingStart /*2*/:
                    return new AboutThird();
                case C1733R.styleable.View_paddingEnd /*3*/:
                    return new AboutFourth();
                default:
                    throw new RuntimeException("Unknown screen");
            }
        }

        public int getCount() {
            return 4;
        }
    }

    public WellcomeActivity() {
        this.FIRST_SCREEN = 0;
        this.SECOND_SCREEN = 1;
        this.THIRD_SCREEN = 2;
        this.FOURTH_SCREEN = 3;
    }

    public void bindActivity() {
        this.f799b = (ActivityWellcomeBinding) DataBindingUtil.setContentView(this, C1733R.layout.activity_wellcome);
        this.f799b.setListener(this);
        setPager();
        this.f799b.cpIndicator.setViewPager(this.f799b.viewPager);
        this.f799b.cpIndicator.setOnPageChangeListener(this);
    }

    private void setPager() {
        this.f799b.viewPager.setAdapter(new WelcomeAdapter(getFragmentManager()));
    }

    public void onBack(View view) {
        this.f799b.viewPager.setCurrentItem(3, true);
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (position == 0) {
            float alpha = ((float) positionOffsetPixels) / ((float) this.f799b.getRoot().getWidth());
            if (this.mFirst != null && this.mFirst.getView() != null) {
                this.mFirst.getView().setAlpha(1.0f - alpha);
            }
        }
    }

    public void onPageSelected(int position) {
    }

    public void onPageScrollStateChanged(int state) {
    }

    public void showMessage(String message) {
        Snackbar.make(this.f799b.getRoot(), (CharSequence) message, -1).show();
    }

    public void showErrorMessage(String message) {
        Snackbar.make(this.f799b.getRoot(), (CharSequence) message, -1).show();
    }
}
