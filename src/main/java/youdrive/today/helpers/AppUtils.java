package youdrive.today.helpers;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.widget.Toast;
import com.dd.CircularProgressButton;

public class AppUtils {

    /* renamed from: youdrive.today.helpers.AppUtils.1 */
    static class C17381 implements Runnable {
        final /* synthetic */ CircularProgressButton val$button;

        C17381(CircularProgressButton circularProgressButton) {
            this.val$button = circularProgressButton;
        }

        public void run() {
            this.val$button.setProgress(0);
        }
    }

    public static void error(String text, CircularProgressButton button) {
        Toast.makeText(button.getContext(), text, 1).show();
        button.setProgress(-1);
        new Handler().postDelayed(new C17381(button), 1500);
    }

    public static void success(CircularProgressButton button, String string) {
        button.setProgress(100);
        new Handler().postDelayed(AppUtils$$Lambda$1.lambdaFactory$(button, string), 1500);
    }

    private static /* synthetic */ void lambda$success$54(CircularProgressButton button, String string) {
        button.setProgress(0);
        button.setIdleText(string);
    }

    public static void about(Context context) {
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://youdrive.today/")));
    }

    public static void restore(Context context) {
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://youdrive.today/password_reset")));
    }

    public static String toKm(int meters) {
        return String.format("%.2f \u043a\u043c", new Object[]{Double.valueOf(((double) meters) * 0.001d)});
    }

    public static String toTime(int seconds) {
        return String.valueOf((long) (seconds / 60)) + " \u043c\u0438\u043d";
    }

    public static void success(CircularProgressButton button) {
        button.setProgress(100);
    }
}
