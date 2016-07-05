package youdrive.today.listeners;

import youdrive.today.response.BaseResponse;

public interface RequestListener {
    BaseResponse onRequest();
}
