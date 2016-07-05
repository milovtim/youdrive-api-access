package youdrive.today.fragments;

import android.content.Intent;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder;
import com.yandex.metrica.YandexMetrica;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import youdrive.today.App;
import youdrive.today.C1733R;
import youdrive.today.activities.RegistrationActivity;
import youdrive.today.databinding.FragmentRegisterDocumentsBinding;
import youdrive.today.databinding.ItemImageBinding;
import youdrive.today.models.RegistrationUser;
import youdrive.today.response.RegistrationModel;
import youdrive.today.response.UploadCareResponse;
import youdrive.today.response.UploadGroupResponse;

public class RegisterDocumentsFragment extends BaseFragment<RegistrationActivity> {
    private static final int ACTIVITY_CHOOSE_FILE = 3;
    private FragmentRegisterDocumentsBinding f805b;
    private Subscription mUpdateSubscription;
    private String parameter;
    private Map<String, String> params;
    private Subscription uploadGroupSubscription;
    private Subscription uploadingSubscription;

    public RegisterDocumentsFragment() {
        this.parameter = "files[%d]";
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.f805b == null) {
            this.f805b = (FragmentRegisterDocumentsBinding) DataBindingUtil.inflate(inflater, C1733R.layout.fragment_register_documents, container, false);
            this.f805b.setListener(this);
            this.f805b.tvForvard.setEnabled(false);
            this.params = new HashMap();
        }
        return this.f805b.getRoot();
    }

    public void onStop() {
        if (this.uploadGroupSubscription != null) {
            this.uploadGroupSubscription.unsubscribe();
        }
        if (this.uploadingSubscription != null) {
            this.uploadingSubscription.unsubscribe();
        }
        if (this.mUpdateSubscription != null) {
            this.mUpdateSubscription.unsubscribe();
        }
        super.onStop();
    }

    private void onUploadGroupSuccess(UploadGroupResponse response) {
        ((RegistrationActivity) this.mActivity).mUser.setDocuments_storage_url(response.getUrl());
        updateUser(((RegistrationActivity) this.mActivity).userId, ((RegistrationActivity) this.mActivity).mUser);
    }

    private void onUploadGroupsFailed(Throwable t) {
        ((RegistrationActivity) this.mActivity).hideProgress();
        Toast.makeText(this.mActivity, "O\u0448\u0438\u0431\u043a\u0430 \u0441\u0435\u0442\u0438", 0).show();
    }

    private void chooseFile() {
        Intent photoPickerIntent = new Intent("android.intent.action.PICK");
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, ACTIVITY_CHOOSE_FILE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == -1 && requestCode == ACTIVITY_CHOOSE_FILE) {
            addImageView(getRealPathFromURI(data.getData()));
        }
    }

    public void onUploadSuccess(UploadCareResponse file, ProgressBar progressBar) {
        this.f805b.btnLoad.setEnabled(true);
        progressBar.setVisibility(8);
        addParams(file.getFile());
    }

    public void onStart() {
        super.onStart();
        YandexMetrica.reportEvent("registration_3_0");
        App.tracker().setScreenName("registration_0_3");
        App.tracker().send(new ScreenViewBuilder().build());
    }

    public void addParams(String id) {
        this.params.put(String.format(this.parameter, new Object[]{Integer.valueOf(this.params.size() + 1)}), id);
        if (this.params.size() >= 2) {
            this.f805b.tvForvard.setEnabled(true);
        }
        if (this.params.size() > 5) {
            this.f805b.btnLoad.setEnabled(false);
        }
    }

    public void onUploadFailure(Throwable t, ProgressBar progressBar) {
        this.f805b.btnLoad.setEnabled(true);
        progressBar.setVisibility(8);
        Toast.makeText(this.mActivity, "failure", 0).show();
    }

    private void addImageView(String filePath) {
        ItemImageBinding item = (ItemImageBinding) DataBindingUtil.inflate(((RegistrationActivity) this.mActivity).getLayoutInflater(), C1733R.layout.item_image, null, false);
        item.ivThumb.setImageBitmap(decodeSampledBitmapFromFile(filePath));
        this.f805b.glImages.addView(item.getRoot());
        uploadFile(filePath, item.pbLoading);
    }

    private void uploadFile(String filePath, ProgressBar bar) {
        this.f805b.btnLoad.setEnabled(false);
        this.uploadingSubscription = ((RegistrationActivity) this.mActivity).mClient.uploadFile(new File(filePath)).retry(3).timeout(15, TimeUnit.SECONDS).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(RegisterDocumentsFragment$$Lambda$1.lambdaFactory$(this, bar), RegisterDocumentsFragment$$Lambda$2.lambdaFactory$(this, bar));
    }

    private /* synthetic */ void lambda$uploadFile$36(ProgressBar bar, UploadCareResponse response) {
        onUploadSuccess(response, bar);
    }

    private /* synthetic */ void lambda$uploadFile$37(ProgressBar bar, Throwable error) {
        onUploadFailure(error, bar);
    }

    public static Bitmap decodeSampledBitmapFromFile(String path) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);
        options.inSampleSize = calculateInSampleSize(options, 300, 300);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(path, options);
    }

    public static int calculateInSampleSize(Options options, int reqWidth, int reqHeight) {
        int height = options.outHeight;
        int width = options.outWidth;
        if (height <= reqHeight && width <= reqWidth) {
            return 1;
        }
        if (width > height) {
            return Math.round(((float) height) / ((float) reqHeight));
        }
        return Math.round(((float) width) / ((float) reqWidth));
    }

    public String getRealPathFromURI(Uri contentUri) {
        Cursor cursor = ((RegistrationActivity) this.mActivity).getContentResolver().query(contentUri, new String[]{"_data"}, null, null, null);
        if (cursor == null) {
            return null;
        }
        int column_index = cursor.getColumnIndexOrThrow("_data");
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

    public void updateUser(String userId, RegistrationUser user) {
        user.setOnline_contract_signed(true);
        ((RegistrationActivity) this.mActivity).showProgress();
        Observable updateUser = ((RegistrationActivity) this.mActivity).mClient.updateUser(userId, user);
        Action1 lambdaFactory$ = RegisterDocumentsFragment$$Lambda$3.lambdaFactory$(this);
        RegistrationActivity registrationActivity = (RegistrationActivity) this.mActivity;
        registrationActivity.getClass();
        this.mUpdateSubscription = updateUser.subscribe(lambdaFactory$, RegisterDocumentsFragment$$Lambda$4.lambdaFactory$(registrationActivity));
    }

    public void onUpdateSuccess(RegistrationModel model) {
        ((RegistrationActivity) this.mActivity).hideProgress();
        ((RegistrationActivity) this.mActivity).mUser = model.getData();
        ((RegistrationActivity) this.mActivity).startFragmentLeft(new RegisterPaymentsFragment());
    }

    public void onForvard(View view) {
        ((RegistrationActivity) this.mActivity).showProgress();
        this.uploadGroupSubscription = ((RegistrationActivity) this.mActivity).mClient.uploadGroup(this.params).retry(3).timeout(15, TimeUnit.SECONDS).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(RegisterDocumentsFragment$$Lambda$5.lambdaFactory$(this), RegisterDocumentsFragment$$Lambda$6.lambdaFactory$(this));
    }

    public void onLoad(View view) {
        ((RegistrationActivity) this.mActivity).getWriteExternalPermission(RegisterDocumentsFragment$$Lambda$7.lambdaFactory$(this));
    }

    public void onBack(View view) {
        ((RegistrationActivity) this.mActivity).getFragmentManager().popBackStack();
    }
}
