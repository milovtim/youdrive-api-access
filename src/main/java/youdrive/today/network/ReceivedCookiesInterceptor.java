package youdrive.today.network;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Interceptor.Chain;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import ru.milovtim.youdrive.Beans;
import youdrive.today.App;

public class ReceivedCookiesInterceptor implements Interceptor {

    private final Beans.CookieStore cookieStorage;

    public ReceivedCookiesInterceptor(Beans.CookieStore cookieStorage) {
        this.cookieStorage = cookieStorage;
    }

    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        originalResponse.headers("Set-Cookie").forEach(cookieStorage::addCookie);
        return originalResponse;
    }
}
