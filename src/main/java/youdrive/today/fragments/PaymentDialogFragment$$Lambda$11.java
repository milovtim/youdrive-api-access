package youdrive.today.fragments;

import java.lang.invoke.LambdaForm.Hidden;
import rx.android.widget.OnTextChangeEvent;
import rx.functions.Func1;

final /* synthetic */ class PaymentDialogFragment$$Lambda$11 implements Func1 {
    private static final PaymentDialogFragment$$Lambda$11 instance;

    static {
        instance = new PaymentDialogFragment$$Lambda$11();
    }

    private PaymentDialogFragment$$Lambda$11() {
    }

    public static Func1 lambdaFactory$() {
        return instance;
    }

    @Hidden
    public Object call(Object obj) {
        return ((OnTextChangeEvent) obj).text();
    }
}
