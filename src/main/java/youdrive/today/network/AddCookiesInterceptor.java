package youdrive.today.network;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import ru.milovtim.youdrive.Beans;

import java.io.IOException;
import java.util.Set;

public class AddCookiesInterceptor implements Interceptor {

    private final Beans.CookieStore cookies;

    public AddCookiesInterceptor(Beans.CookieStore cookies) {
        this.cookies = cookies;
    }

    public Response intercept(Chain chain) throws IOException {
        Builder builder = chain.request().newBuilder();
        cookies.forEach (cookie -> builder.addHeader("Cookie", cookie));
        return chain.proceed(builder.build());
    }
}
