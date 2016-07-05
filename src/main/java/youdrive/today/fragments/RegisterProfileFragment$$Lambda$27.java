package youdrive.today.fragments;

import android.widget.TextView;
import java.lang.invoke.LambdaForm.Hidden;
import rx.functions.Action1;

final /* synthetic */ class RegisterProfileFragment$$Lambda$27 implements Action1 {
    private final TextView arg$1;

    private RegisterProfileFragment$$Lambda$27(TextView textView) {
        this.arg$1 = textView;
    }

    private static Action1 get$Lambda(TextView textView) {
        return new RegisterProfileFragment$$Lambda$27(textView);
    }

    public static Action1 lambdaFactory$(TextView textView) {
        return new RegisterProfileFragment$$Lambda$27(textView);
    }

    @Hidden
    public void call(Object obj) {
        this.arg$1.setEnabled(((Boolean) obj).booleanValue());
    }
}
