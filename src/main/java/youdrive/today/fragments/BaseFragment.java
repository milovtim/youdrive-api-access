package youdrive.today.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

public class BaseFragment<T extends Activity> extends Fragment {
    protected T mActivity;

    public void onCreate(Bundle savedInstanceState) {
        this.mActivity = getActivity();
        super.onCreate(savedInstanceState);
    }
}
