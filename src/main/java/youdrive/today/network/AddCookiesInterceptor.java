package youdrive.today.network;

import com.google.common.collect.Sets;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import youdrive.today.App;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AddCookiesInterceptor implements Interceptor {

    Set<String> cookies = Sets.newConcurrentHashSet();

    public Response intercept(Chain chain) throws IOException {
        Builder builder = chain.request().newBuilder();
        cookies.forEach (cookie -> builder.addHeader("Cookie", cookie));
        return chain.proceed(builder.build());
    }
}
