package youdrive.today.fragments;

import java.lang.invoke.LambdaForm.Hidden;
import youdrive.today.listeners.Function;

final /* synthetic */ class RegisterDocumentsFragment$$Lambda$7 implements Function {
    private final RegisterDocumentsFragment arg$1;

    private RegisterDocumentsFragment$$Lambda$7(RegisterDocumentsFragment registerDocumentsFragment) {
        this.arg$1 = registerDocumentsFragment;
    }

    private static Function get$Lambda(RegisterDocumentsFragment registerDocumentsFragment) {
        return new RegisterDocumentsFragment$$Lambda$7(registerDocumentsFragment);
    }

    public static Function lambdaFactory$(RegisterDocumentsFragment registerDocumentsFragment) {
        return new RegisterDocumentsFragment$$Lambda$7(registerDocumentsFragment);
    }

    @Hidden
    public void apply() {
        this.arg$1.chooseFile();
    }
}
