package youdrive.today.fragments;

import java.lang.invoke.LambdaForm.Hidden;
import rx.functions.Action1;

final /* synthetic */ class PaymentDialogFragment$$Lambda$10 implements Action1 {
    private final PaymentDialogFragment arg$1;

    private PaymentDialogFragment$$Lambda$10(PaymentDialogFragment paymentDialogFragment) {
        this.arg$1 = paymentDialogFragment;
    }

    private static Action1 get$Lambda(PaymentDialogFragment paymentDialogFragment) {
        return new PaymentDialogFragment$$Lambda$10(paymentDialogFragment);
    }

    public static Action1 lambdaFactory$(PaymentDialogFragment paymentDialogFragment) {
        return new PaymentDialogFragment$$Lambda$10(paymentDialogFragment);
    }

    @Hidden
    public void call(Object obj) {
        this.arg$1.lambda$checkFields$30((Boolean) obj);
    }
}
