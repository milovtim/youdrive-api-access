package youdrive.today.fragments;

import java.lang.invoke.LambdaForm.Hidden;
import rx.functions.Func1;

final /* synthetic */ class RegisterProfileFragment$$Lambda$21 implements Func1 {
    private static final RegisterProfileFragment$$Lambda$21 instance;

    static {
        instance = new RegisterProfileFragment$$Lambda$21();
    }

    private RegisterProfileFragment$$Lambda$21() {
    }

    public static Func1 lambdaFactory$() {
        return instance;
    }

    @Hidden
    public Object call(Object obj) {
        return RegisterProfileFragment.lambda$checkFields$49((CharSequence) obj);
    }
}
