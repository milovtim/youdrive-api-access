package youdrive.today.fragments;

import java.lang.invoke.LambdaForm.Hidden;
import rx.android.widget.OnTextChangeEvent;
import rx.functions.Func1;

final /* synthetic */ class PaymentDialogFragment$$Lambda$8 implements Func1 {
    private static final PaymentDialogFragment$$Lambda$8 instance;

    static {
        instance = new PaymentDialogFragment$$Lambda$8();
    }

    private PaymentDialogFragment$$Lambda$8() {
    }

    public static Func1 lambdaFactory$() {
        return instance;
    }

    @Hidden
    public Object call(Object obj) {
        return ((OnTextChangeEvent) obj).view();
    }
}
