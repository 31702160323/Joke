package cn.mypackage.joke.http;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URL;

import cn.mypackage.joke.view.ITestView;
import cn.mypackage.joke.json.JokeInfo;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OKUtils extends OkHttpClient{
    private static OKUtils mOkUtils;
    private static ITestView mITestView;

    public static OKUtils getInstance(ITestView iTestView){
        if (mOkUtils == null){
            mOkUtils = new OKUtils();
        }
        mITestView = iTestView;
        return mOkUtils;
    }

    public void get(String urlStr) {
        try {
            URL url = new URL(urlStr);
            Request request = new Request.Builder()
                    .url(url)
                    .get()
                    .build();
            Call call = this.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String str = response.body().string();
                    Gson gson = new Gson();
                    JokeInfo jokeInfo = gson.fromJson(str, JokeInfo.class);
                    if (jokeInfo.getCode() == 1) {
                        mITestView.updateUI(jokeInfo.getData());
                    } else {
                        mITestView.warningUI(jokeInfo.getMsg());
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
