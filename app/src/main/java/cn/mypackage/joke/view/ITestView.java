package cn.mypackage.joke.view;

import java.util.List;

import cn.mypackage.joke.json.JokeDataInfo;

public interface ITestView {
    void updateUI(List<JokeDataInfo> list);
    void warningUI(String data);
}
