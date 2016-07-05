package youdrive.today.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.view.View;
import youdrive.today.BaseActivity;
import youdrive.today.C1733R;
import youdrive.today.databinding.ActivityThanksBinding;

public class ThanksActivity extends BaseActivity {
    ActivityThanksBinding f798b;

    public void onAuth(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }

    public void bindActivity() {
        this.f798b = (ActivityThanksBinding) DataBindingUtil.setContentView(this, C1733R.layout.activity_thanks);
        this.f798b.setListener(this);
    }
}
