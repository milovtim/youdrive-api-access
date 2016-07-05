package youdrive.today.response;

public class UploadGroupResponse {
    private String cdn_url;
    private String datetime_created;
    private String datetime_stored;
    private int files_count;
    private String id;
    private String url;

    public String getId() {
        return this.id;
    }

    public String getDatetime_created() {
        return this.datetime_created;
    }

    public String getDatetime_stored() {
        return this.datetime_stored;
    }

    public int getFiles_count() {
        return this.files_count;
    }

    public String getCdn_url() {
        return this.cdn_url;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "UploadGroupResponse{id='" + this.id + '\'' + ", datetime_created='" + this.datetime_created + '\'' + ", datetime_stored='" + this.datetime_stored + '\'' + ", files_count=" + this.files_count + ", cdn_url='" + this.cdn_url + '\'' + ", url='" + this.url + '\'' + '}';
    }
}
