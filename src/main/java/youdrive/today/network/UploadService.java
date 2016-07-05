package youdrive.today.network;

import java.util.Map;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.http.PartMap;
import retrofit.mime.TypedFile;
import rx.Observable;
import youdrive.today.response.UploadCareResponse;
import youdrive.today.response.UploadGroupResponse;

public interface UploadService {
    @POST("/base/")
    @Multipart
    Observable<UploadCareResponse> uploadFile(@Part("UPLOADCARE_PUB_KEY") String str, @Part("UPLOADCARE_STORE") int i, @Part("file") TypedFile typedFile);

    @POST("/group/")
    @Multipart
    Observable<UploadGroupResponse> uploadGroup(@Part("pub_key") String str, @PartMap Map<String, String> map);
}
