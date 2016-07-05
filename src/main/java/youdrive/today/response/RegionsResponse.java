package youdrive.today.response;

import java.util.List;
import youdrive.today.models.Region;

public class RegionsResponse extends BaseResponse {
    private List<Region> regions;

    public List<Region> getRegions() {
        return this.regions;
    }
}
