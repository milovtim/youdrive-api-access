package youdrive.today.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.view.View;
import youdrive.today.BaseActivity;
import youdrive.today.C1733R;
import youdrive.today.databinding.ActivityInformBinding;

public class InformActivity extends BaseActivity {
    private ActivityInformBinding f794b;

    public void auth(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }

    public void bindActivity() {
        this.f794b = (ActivityInformBinding) DataBindingUtil.setContentView(this, C1733R.layout.activity_inform);
        this.f794b.setListener(this);
    }
}
