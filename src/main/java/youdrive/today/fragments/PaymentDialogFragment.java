package youdrive.today.fragments;

import android.app.DialogFragment;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.AllCaps;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.dd.CircularProgressButton;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import ru.cloudpayments.sdk.CardFactory;
import ru.cloudpayments.sdk.ICard;
import rx.Observable;
import rx.Subscription;
import rx.android.widget.WidgetObservable;
import youdrive.today.C1733R;
import youdrive.today.activities.RegistrationActivity;
import youdrive.today.databinding.FragmentPaymentBinding;
import youdrive.today.listeners.ValueFunction;
import youdrive.today.models.CreditCardModel;
import youdrive.today.models.CreditCardResponse;

public class PaymentDialogFragment extends DialogFragment {
    public static final String productionId = "pk_7b64d8f50ff4d81f83b50ca103f8a";
    private FragmentPaymentBinding f804b;
    private ValueFunction<String> mFunction;
    private String mPrice;
    private String mRegId;
    private Subscription mSubscription;

    public static DialogFragment newInstance(String regId, String price, ValueFunction<String> callback) {
        PaymentDialogFragment fragment = new PaymentDialogFragment();
        fragment.setPrice(price);
        fragment.setRegId(regId);
        fragment.setCallback(callback);
        return fragment;
    }

    private void setCallback(ValueFunction<String> callback) {
        this.mFunction = callback;
    }

    private void setRegId(String regId) {
        this.mRegId = regId;
    }

    private void setPrice(String price) {
        this.mPrice = price;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.f804b = (FragmentPaymentBinding) DataBindingUtil.inflate(inflater, C1733R.layout.fragment_payment, container, false);
        this.f804b.setListener(this);
        this.f804b.btnPay.setIdleText(this.mPrice + " \u0440\u0443\u0431\u043b\u0435\u0439");
        this.f804b.btnPay.setEnabled(false);
        checkFields();
        return this.f804b.getRoot();
    }

    public void onPay(View view) {
        if (this.f804b.btnPay.getProgress() == 0) {
            this.f804b.btnPay.setProgress(50);
            setCancelable(false);
            makePayment();
        }
    }

    public void onStop() {
        super.onStop();
        if (this.mSubscription != null) {
            this.mSubscription.unsubscribe();
        }
    }

    private void makePayment() {
        ICard card = CardFactory.create(this.f804b.etCardNumber.getText().toString().replaceAll(" ", BuildConfig.FLAVOR), this.f804b.etExpired.getText().toString().replaceAll("/", BuildConfig.FLAVOR), this.f804b.etCvv.getText().toString());
        if (card.isValidNumber()) {
            ((RegistrationActivity) getActivity()).mUser.setCard_number(this.f804b.etCardNumber.getText().toString());
            this.mSubscription = ((RegistrationActivity) getActivity()).mClient.initCard(new CreditCardModel(this.mRegId, this.mPrice, this.f804b.etName.getText().toString().toUpperCase(), card.cardCryptogram(productionId))).subscribe(PaymentDialogFragment$$Lambda$1.lambdaFactory$(this), PaymentDialogFragment$$Lambda$4.lambdaFactory$(this));
            return;
        }
        this.f804b.etCardNumber.setError(getString(C1733R.string.wrong_card_id));
        this.f804b.btnPay.setProgress(0);
    }

    private void openUrl(String url) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
    }

    private void onCreditCardSuccess(CreditCardResponse response) {
        this.f804b.btnPay.setProgress(0);
        if (response.getReq_url() != null) {
            this.mFunction.apply(response.getReq_url());
        } else if (response.getFinish_url() != null) {
            this.mFunction.apply(response.getFinish_url());
        } else {
            this.mFunction.apply("http://www.yandex.ru");
        }
    }

    private void onFailure(Throwable t) {
        this.f804b.btnPay.setProgress(0);
    }

    public void checkFields() {
        Observable<Boolean> cardNum = WidgetObservable.text(this.f804b.etCardNumber).distinctUntilChanged().map(PaymentDialogFragment$$Lambda$5.lambdaFactory$()).map(PaymentDialogFragment$$Lambda$6.lambdaFactory$()).doOnNext(PaymentDialogFragment$$Lambda$7.lambdaFactory$(this));
        Observable<Boolean> date = WidgetObservable.text(this.f804b.etExpired).distinctUntilChanged().map(PaymentDialogFragment$$Lambda$8.lambdaFactory$()).map(PaymentDialogFragment$$Lambda$9.lambdaFactory$()).doOnNext(PaymentDialogFragment$$Lambda$10.lambdaFactory$(this));
        this.f804b.etName.setFilters(new InputFilter[]{new AllCaps()});
        Observable distinctUntilChanged = Observable.combineLatest(cardNum, date, WidgetObservable.text(this.f804b.etName).distinctUntilChanged().map(PaymentDialogFragment$$Lambda$11.lambdaFactory$()).map(PaymentDialogFragment$$Lambda$12.lambdaFactory$()).doOnNext(PaymentDialogFragment$$Lambda$13.lambdaFactory$(this)), WidgetObservable.text(this.f804b.etCvv).distinctUntilChanged().map(PaymentDialogFragment$$Lambda$14.lambdaFactory$()).map(PaymentDialogFragment$$Lambda$15.lambdaFactory$()).doOnNext(PaymentDialogFragment$$Lambda$16.lambdaFactory$(this)), PaymentDialogFragment$$Lambda$17.lambdaFactory$()).distinctUntilChanged();
        CircularProgressButton circularProgressButton = this.f804b.btnPay;
        circularProgressButton.getClass();
        distinctUntilChanged.subscribe(PaymentDialogFragment$$Lambda$18.lambdaFactory$(circularProgressButton));
    }

    private static /* synthetic */ Boolean lambda$checkFields$27(TextView textView) {
        Editable s = textView.getEditableText();
        if (s.length() > 0 && s.length() % 5 == 0 && ' ' == s.charAt(s.length() - 1)) {
            s.delete(s.length() - 1, s.length());
        }
        if (s.length() > 0 && s.length() % 5 == 0 && Character.isDigit(s.charAt(s.length() - 1)) && TextUtils.split(s.toString(), String.valueOf(' ')).length <= 4) {
            s.insert(s.length() - 1, String.valueOf(' '));
        }
        boolean z = s.length() == 19 || s.length() == 22;
        return Boolean.valueOf(z);
    }

    private /* synthetic */ void lambda$checkFields$28(Boolean bool) {
        if (!bool.booleanValue()) {
            this.f804b.etCardNumber.setError("\u0412 \u043d\u043e\u043c\u0435\u0440\u0435 \u043a\u0430\u0440\u0442\u044b \u0434\u043e\u043f\u0443\u0449\u0435\u043d\u044b \u043e\u0448\u0438\u0431\u043a\u0438");
        }
    }

    private static /* synthetic */ Boolean lambda$checkFields$29(TextView textView) {
        Editable s = textView.getEditableText();
        if (s.length() > 0 && s.length() % 3 == 0 && '/' == s.charAt(s.length() - 1)) {
            s.delete(s.length() - 1, s.length());
        }
        if (s.length() > 0 && s.length() % 3 == 0 && Character.isDigit(s.charAt(s.length() - 1)) && TextUtils.split(s.toString(), String.valueOf('/')).length <= 2) {
            s.insert(s.length() - 1, String.valueOf('/'));
        }
        return Boolean.valueOf(s.length() == 5);
    }

    private /* synthetic */ void lambda$checkFields$30(Boolean bool) {
        if (!bool.booleanValue()) {
            this.f804b.etExpired.setError("\u041e\u0448\u0438\u0431\u043a\u0430");
        }
    }

    private static /* synthetic */ Boolean lambda$checkFields$31(CharSequence t) {
        return Boolean.valueOf(t.length() != 0);
    }

    private /* synthetic */ void lambda$checkFields$32(Boolean bool) {
        if (!bool.booleanValue()) {
            this.f804b.etName.setError(getString(C1733R.string.empty));
        }
    }

    private static /* synthetic */ Boolean lambda$checkFields$33(CharSequence t) {
        return Boolean.valueOf(t.length() == 3);
    }

    private /* synthetic */ void lambda$checkFields$34(Boolean bool) {
        if (!bool.booleanValue()) {
            this.f804b.etCvv.setError("\u041e\u0448\u0438\u0431\u043a\u0430");
        }
    }

    private static /* synthetic */ Boolean lambda$checkFields$35(Boolean a, Boolean b, Boolean c, Boolean d) {
        boolean z = a.booleanValue() && b.booleanValue() && c.booleanValue() && d.booleanValue();
        return Boolean.valueOf(z);
    }
}
