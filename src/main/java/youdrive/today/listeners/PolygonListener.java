package youdrive.today.listeners;

import youdrive.today.response.PolygonResponse;

public interface PolygonListener {
    void onPolygonFailed();

    void onPolygonSuccess(PolygonResponse polygonResponse);
}
