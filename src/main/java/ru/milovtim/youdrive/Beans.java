package ru.milovtim.youdrive;

import com.google.common.collect.Sets;
import com.squareup.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit.RestAdapter;
import youdrive.today.models.LoginUser;
import youdrive.today.network.AddCookiesInterceptor;
import youdrive.today.network.CarsharingService;
import youdrive.today.network.CustomClient;
import youdrive.today.network.ReceivedCookiesInterceptor;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Configuration
public class Beans {

    String host = "https://youdrive.today";
    @Bean
    CarsharingService service(OkHttpClient client) {
        return new RestAdapter.Builder()
                .setEndpoint(host)
                .setClient(new CustomClient(client))
                .setLogLevel(RestAdapter.LogLevel.HEADERS)
                .build()
                .create(CarsharingService.class);
    }


    @Bean
    OkHttpClient httpClient(AddCookiesInterceptor cookie, ReceivedCookiesInterceptor setCookie) {
        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(5, TimeUnit.SECONDS);
        client.interceptors().add(cookie);
        client.interceptors().add(setCookie);
        return client;
    }

    @Bean
    CookieStore cookieStorage() {
        return new CookieStore();
    }

    @Bean
    AddCookiesInterceptor addStoredCookiesToRequests(CookieStore cookieStorage) {
        return new AddCookiesInterceptor(cookieStorage);
    }

    @Bean
    ReceivedCookiesInterceptor storeInputCookies(CookieStore cookieStorage) {
        return new ReceivedCookiesInterceptor(cookieStorage);
    }

    @Bean
    LoginUser loginUser() {
        return new LoginUser("milovtim@ya.ru", "LeAB80KSwhMOwI39");
    }

    public static class CookieStore implements Iterable<String> {
        Set<String> cookies = Sets.newConcurrentHashSet();

        @Override
        public Iterator<String> iterator() {
            return cookies.iterator();
        }

        public void addCookie(String cookie) {
            cookies.add(cookie);
        }
    }

}
