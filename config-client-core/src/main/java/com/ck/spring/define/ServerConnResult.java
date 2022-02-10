package com.ck.spring.define;

import javax.annotation.Nullable;

/**
 * @Author caikun
 * @Description //TODO $END
 * @Date 下午3:25 22-2-10
 **/
public class ServerConnResult {

    @Nullable
    private String data;

    private String releaseKey;

    private int refresh;

    public int getRefresh() {
        return refresh;
    }

    public void setRefresh(int refresh) {
        this.refresh = refresh;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getReleaseKey() {
        return releaseKey;
    }

    public void setReleaseKey(String releaseKey) {
        this.releaseKey = releaseKey;
    }
}
