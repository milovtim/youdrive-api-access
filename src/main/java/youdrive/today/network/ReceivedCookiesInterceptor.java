package youdrive.today.network;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Interceptor.Chain;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.util.HashSet;
import youdrive.today.App;

public class ReceivedCookiesInterceptor implements Interceptor {
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            HashSet<String> cookies = new HashSet();
            for (String header : originalResponse.headers("Set-Cookie")) {
                cookies.add(header);
            }
            App.getInstance().getPreference().putSession(cookies);
        }
        return originalResponse;
    }
}
