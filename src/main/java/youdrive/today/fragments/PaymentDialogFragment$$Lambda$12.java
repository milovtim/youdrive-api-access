package youdrive.today.fragments;

import java.lang.invoke.LambdaForm.Hidden;
import rx.functions.Func1;

final /* synthetic */ class PaymentDialogFragment$$Lambda$12 implements Func1 {
    private static final PaymentDialogFragment$$Lambda$12 instance;

    static {
        instance = new PaymentDialogFragment$$Lambda$12();
    }

    private PaymentDialogFragment$$Lambda$12() {
    }

    public static Func1 lambdaFactory$() {
        return instance;
    }

    @Hidden
    public Object call(Object obj) {
        return PaymentDialogFragment.lambda$checkFields$31((CharSequence) obj);
    }
}
