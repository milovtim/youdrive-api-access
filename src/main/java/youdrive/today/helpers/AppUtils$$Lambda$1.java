package youdrive.today.helpers;

import com.dd.CircularProgressButton;
import java.lang.invoke.LambdaForm.Hidden;

final /* synthetic */ class AppUtils$$Lambda$1 implements Runnable {
    private final CircularProgressButton arg$1;
    private final String arg$2;

    private AppUtils$$Lambda$1(CircularProgressButton circularProgressButton, String str) {
        this.arg$1 = circularProgressButton;
        this.arg$2 = str;
    }

    private static Runnable get$Lambda(CircularProgressButton circularProgressButton, String str) {
        return new AppUtils$$Lambda$1(circularProgressButton, str);
    }

    public static Runnable lambdaFactory$(CircularProgressButton circularProgressButton, String str) {
        return new AppUtils$$Lambda$1(circularProgressButton, str);
    }

    @Hidden
    public void run() {
        AppUtils.lambda$success$54(this.arg$1, this.arg$2);
    }
}
