package youdrive.today.network;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Response;
import java.io.IOException;

import ru.milovtim.youdrive.session.CookieStore;

public class ReceivedCookiesInterceptor implements Interceptor {

    private final CookieStore cookieStorage;

    public ReceivedCookiesInterceptor(CookieStore cookieStorage) {
        this.cookieStorage = cookieStorage;
    }

    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        originalResponse.headers("Set-Cookie").forEach(cookieStorage::addCookie);
        return originalResponse;
    }
}
