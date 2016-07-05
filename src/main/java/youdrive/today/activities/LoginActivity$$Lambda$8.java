package youdrive.today.activities;

import com.dd.CircularProgressButton;
import java.lang.invoke.LambdaForm.Hidden;
import rx.functions.Action1;

final /* synthetic */ class LoginActivity$$Lambda$8 implements Action1 {
    private final CircularProgressButton arg$1;

    private LoginActivity$$Lambda$8(CircularProgressButton circularProgressButton) {
        this.arg$1 = circularProgressButton;
    }

    private static Action1 get$Lambda(CircularProgressButton circularProgressButton) {
        return new LoginActivity$$Lambda$8(circularProgressButton);
    }

    public static Action1 lambdaFactory$(CircularProgressButton circularProgressButton) {
        return new LoginActivity$$Lambda$8(circularProgressButton);
    }

    @Hidden
    public void call(Object obj) {
        this.arg$1.setEnabled(((Boolean) obj).booleanValue());
    }
}
