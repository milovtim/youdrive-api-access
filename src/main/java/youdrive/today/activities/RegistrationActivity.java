package youdrive.today.activities;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.widget.Toast;
import youdrive.today.BaseActivity;
import youdrive.today.C1733R;
import youdrive.today.databinding.ActivityRegistrationBinding;
import youdrive.today.fragments.RegisterOffertFragment;
import youdrive.today.models.RegistrationUser;
import youdrive.today.network.ApiClient;

public class RegistrationActivity extends BaseActivity {
    private ActivityRegistrationBinding f797b;
    public ApiClient mClient;
    public RegistrationUser mUser;
    private ProgressDialog pdLoading;
    public String userId;

    public void bindActivity() {
        this.f797b = (ActivityRegistrationBinding) DataBindingUtil.setContentView(this, C1733R.layout.activity_registration);
        this.mClient = new ApiClient();
        this.pdLoading = new ProgressDialog(this);
        this.pdLoading.setMessage(getString(C1733R.string.loading));
        this.pdLoading.setCancelable(false);
        startFragment();
    }

    private void startFragment() {
        getFragmentManager().beginTransaction().replace(C1733R.id.flContainer, new RegisterOffertFragment()).commitAllowingStateLoss();
    }

    public void startFragmentLeft(Fragment fragment) {
        getFragmentManager().beginTransaction().setCustomAnimations(C1733R.animator.move_right_in, C1733R.animator.move_right_out, C1733R.animator.move_left_in, C1733R.animator.move_left_out).replace(C1733R.id.flContainer, fragment).addToBackStack(null).commitAllowingStateLoss();
    }

    public void onCreateFailure(Throwable throwable) {
        hideProgress();
        Toast.makeText(this, C1733R.string.cannot_register_user, 0).show();
    }

    public void showProgress() {
        this.pdLoading.show();
    }

    public void hideProgress() {
        this.pdLoading.hide();
    }
}
