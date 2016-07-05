package youdrive.today.fragments;

import android.widget.TextView;
import java.lang.invoke.LambdaForm.Hidden;
import rx.functions.Func1;

final /* synthetic */ class PaymentDialogFragment$$Lambda$9 implements Func1 {
    private static final PaymentDialogFragment$$Lambda$9 instance;

    static {
        instance = new PaymentDialogFragment$$Lambda$9();
    }

    private PaymentDialogFragment$$Lambda$9() {
    }

    public static Func1 lambdaFactory$() {
        return instance;
    }

    @Hidden
    public Object call(Object obj) {
        return PaymentDialogFragment.lambda$checkFields$29((TextView) obj);
    }
}
