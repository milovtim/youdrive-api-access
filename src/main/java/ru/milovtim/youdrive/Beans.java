package ru.milovtim.youdrive;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit.RestAdapter;
import youdrive.today.network.AddCookiesInterceptor;
import youdrive.today.network.CarsharingService;
import youdrive.today.network.CustomClient;
import youdrive.today.network.ReceivedCookiesInterceptor;

import java.util.concurrent.TimeUnit;

@Configuration
public class Beans {

    String host = "https://youdrive.today";
    @Bean
    CarsharingService service(OkHttpClient client) {
        new RestAdapter.Builder()
                .setEndpoint(host)
                .setClient(new CustomClient(client))
                .setLogLevel(RestAdapter.LogLevel.HEADERS)
                .build()
                .create(CarsharingService.class);
        return null;
    }


    @Bean
    OkHttpClient httpClient(Interceptor cookie) {
        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(5, TimeUnit.SECONDS);
        client.interceptors().add(cookie);
        client.interceptors().add(new ReceivedCookiesInterceptor());
        return client;
    }

    @Bean
    Interceptor addCookieInterceptor() {
        return new AddCookiesInterceptor();
    }
}
