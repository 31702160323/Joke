package cn.mypackage.joke.json;

import java.util.List;

public class JokeInfo {
    private int code;
    private String msg;
    private List<JokeDataInfo> data;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public List<JokeDataInfo> getData() {
        return data;
    }
}
