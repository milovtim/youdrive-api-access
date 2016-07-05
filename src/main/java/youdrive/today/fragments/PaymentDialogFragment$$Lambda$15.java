package youdrive.today.fragments;

import java.lang.invoke.LambdaForm.Hidden;
import rx.functions.Func1;

final /* synthetic */ class PaymentDialogFragment$$Lambda$15 implements Func1 {
    private static final PaymentDialogFragment$$Lambda$15 instance;

    static {
        instance = new PaymentDialogFragment$$Lambda$15();
    }

    private PaymentDialogFragment$$Lambda$15() {
    }

    public static Func1 lambdaFactory$() {
        return instance;
    }

    @Hidden
    public Object call(Object obj) {
        return PaymentDialogFragment.lambda$checkFields$33((CharSequence) obj);
    }
}
