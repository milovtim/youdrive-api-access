package youdrive.today;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.yandex.metrica.YandexMetrica;
import youdrive.today.helpers.FontsOverride;
import youdrive.today.listeners.Function;

public abstract class BaseActivity extends AppCompatActivity {
    private static final String READ_EXTERNAL_STORAGE = "android.permission.READ_EXTERNAL_STORAGE";
    private final int LOCATION_PERMISSION;
    private final int PHONE;
    private final int WRITE_PERMISSION;
    private Function mLocationFunction;
    private Function mPhonePemission;
    private Function mWritePermission;

    public abstract void bindActivity();

    public BaseActivity() {
        this.LOCATION_PERMISSION = 10;
        this.WRITE_PERMISSION = 9;
        this.PHONE = 8;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FontsOverride.setDefaultFont(this, "MONOSPACE", "HelveticaRegular.ttf");
        bindActivity();
    }

    protected void showToast(String text) {
        Toast.makeText(this, text, 1).show();
    }

    public boolean isNetworkConnected() {
        NetworkInfo activeInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        return activeInfo != null && activeInfo.isConnected();
    }

    public void getWriteExternalPermission(Function function) {
        this.mWritePermission = function;
        if (ContextCompat.checkSelfPermission(this, READ_EXTERNAL_STORAGE) == 0 || ContextCompat.checkSelfPermission(this, READ_EXTERNAL_STORAGE) == 0) {
            this.mWritePermission.apply();
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{READ_EXTERNAL_STORAGE}, 9);
    }

    public void getLocationPermission(Function function) {
        this.mLocationFunction = function;
        if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            this.mLocationFunction.apply();
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 10);
    }

    public void checkPhonePermission(Function phonePemission) {
        this.mPhonePemission = phonePemission;
        if (ContextCompat.checkSelfPermission(this, "android.permission.CALL_PHONE") == 0) {
            phonePemission.apply();
        } else if (!ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.CALL_PHONE")) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.CALL_PHONE"}, 8);
        }
    }

    protected void onResume() {
        super.onResume();
        YandexMetrica.onResumeActivity(this);
    }

    protected void onPause() {
        YandexMetrica.onPauseActivity(this);
        super.onPause();
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case C1733R.styleable.Toolbar_contentInsetRight /*8*/:
                if (grantResults[0] != 0) {
                    Toast.makeText(this, "You did not allow to use phone`", 1).show();
                } else if (this.mPhonePemission != null) {
                    this.mPhonePemission.apply();
                }
            case C1733R.styleable.Toolbar_popupTheme /*9*/:
                if (grantResults[0] != 0) {
                    Toast.makeText(this, "You did not allow to choose picture`", 1).show();
                } else if (this.mWritePermission != null) {
                    this.mWritePermission.apply();
                }
            case C1733R.styleable.Toolbar_titleTextAppearance /*10*/:
                if (grantResults[0] != 0) {
                    Toast.makeText(this, "You did not allow to access your current location", 1).show();
                } else if (this.mLocationFunction != null) {
                    this.mLocationFunction.apply();
                }
            default:
        }
    }
}
