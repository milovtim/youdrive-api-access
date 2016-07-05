package youdrive.today.activities;

import android.content.Intent;
import android.os.Bundle;
import youdrive.today.App;
import youdrive.today.BaseActivity;

public class SplashActivity extends BaseActivity {
    public void bindActivity() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (App.getInstance().getPreference().isFirst() && App.getInstance().getPreference().getUser() == null) {
            startActivity(new Intent(this, WellcomeActivity.class));
        } else if (App.getInstance().getPreference().getUser() != null) {
            startActivity(new Intent(this, MapsActivity.class));
        } else {
            startActivity(new Intent(this, LoginActivity.class));
        }
        finish();
    }
}
