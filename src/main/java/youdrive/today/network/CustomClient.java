package youdrive.today.network;

import com.squareup.okhttp.OkHttpClient;
import java.io.IOException;
import retrofit.client.OkClient;
import retrofit.client.Request;
import retrofit.client.Response;

public class CustomClient extends OkClient {
    public CustomClient(OkHttpClient client) {
        super(client);
    }

    public Response execute(Request request) throws IOException {
        Response originalRespone = super.execute(request);
        int statusCode = 200;
        return new Response(originalRespone.getUrl(),
                statusCode,
                originalRespone.getReason(), originalRespone.getHeaders(), originalRespone.getBody());
    }
}
