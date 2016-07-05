package youdrive.today.fragments;

import com.dd.CircularProgressButton;
import java.lang.invoke.LambdaForm.Hidden;
import rx.functions.Action1;

final /* synthetic */ class PaymentDialogFragment$$Lambda$18 implements Action1 {
    private final CircularProgressButton arg$1;

    private PaymentDialogFragment$$Lambda$18(CircularProgressButton circularProgressButton) {
        this.arg$1 = circularProgressButton;
    }

    private static Action1 get$Lambda(CircularProgressButton circularProgressButton) {
        return new PaymentDialogFragment$$Lambda$18(circularProgressButton);
    }

    public static Action1 lambdaFactory$(CircularProgressButton circularProgressButton) {
        return new PaymentDialogFragment$$Lambda$18(circularProgressButton);
    }

    @Hidden
    public void call(Object obj) {
        this.arg$1.setEnabled(((Boolean) obj).booleanValue());
    }
}
