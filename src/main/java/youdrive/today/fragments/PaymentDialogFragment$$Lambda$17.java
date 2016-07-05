package youdrive.today.fragments;

import java.lang.invoke.LambdaForm.Hidden;
import rx.functions.Func4;

final /* synthetic */ class PaymentDialogFragment$$Lambda$17 implements Func4 {
    private static final PaymentDialogFragment$$Lambda$17 instance;

    static {
        instance = new PaymentDialogFragment$$Lambda$17();
    }

    private PaymentDialogFragment$$Lambda$17() {
    }

    public static Func4 lambdaFactory$() {
        return instance;
    }

    @Hidden
    public Object call(Object obj, Object obj2, Object obj3, Object obj4) {
        return PaymentDialogFragment.lambda$checkFields$35((Boolean) obj, (Boolean) obj2, (Boolean) obj3, (Boolean) obj4);
    }
}
