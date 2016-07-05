package youdrive.today.fragments;

import android.widget.TextView;
import java.lang.invoke.LambdaForm.Hidden;
import rx.functions.Func1;

final /* synthetic */ class PaymentDialogFragment$$Lambda$6 implements Func1 {
    private static final PaymentDialogFragment$$Lambda$6 instance;

    static {
        instance = new PaymentDialogFragment$$Lambda$6();
    }

    private PaymentDialogFragment$$Lambda$6() {
    }

    public static Func1 lambdaFactory$() {
        return instance;
    }

    @Hidden
    public Object call(Object obj) {
        return PaymentDialogFragment.lambda$checkFields$27((TextView) obj);
    }
}
