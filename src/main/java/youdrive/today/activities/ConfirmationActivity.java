package youdrive.today.activities;

import android.databinding.DataBindingUtil;
import android.view.View;
import youdrive.today.BaseActivity;
import youdrive.today.C1733R;
import youdrive.today.databinding.ActivityConfirmationBinding;

public class ConfirmationActivity extends BaseActivity {
    ActivityConfirmationBinding f793b;

    public void onOk(View view) {
        setResult(-1);
        finish();
    }

    public void onCancel(View view) {
        setResult(0);
        finish();
    }

    public void bindActivity() {
        this.f793b = (ActivityConfirmationBinding) DataBindingUtil.setContentView(this, C1733R.layout.activity_confirmation);
        this.f793b.setListener(this);
    }
}
