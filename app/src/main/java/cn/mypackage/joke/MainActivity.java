package cn.mypackage.joke;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

import cn.mypackage.joke.fragment.CardFragmentAdpter;
import cn.mypackage.joke.http.OKUtils;
import cn.mypackage.joke.json.JokeDataInfo;
import cn.mypackage.joke.transformer.CardTransformer;
import cn.mypackage.joke.view.ITestView;

public class MainActivity extends FragmentActivity implements ITestView {

    private ViewPager mViewPager;
    private CardFragmentAdpter mAdpter;
    private OKUtils okUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        okUtils = OKUtils.getInstance(this);
        okUtils.get("https://www.mxnzp.com/api//jokes/list/random");
    }

    private void initView() {
        mViewPager = findViewById(R.id.viewPaget);
    }

    @Override
    public void updateUI(final List<JokeDataInfo> list) {
        Collections.reverse(list);
        mAdpter = new CardFragmentAdpter(getSupportFragmentManager(),list);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mViewPager.setAdapter(mAdpter);
                mViewPager.setOffscreenPageLimit(3);
                mViewPager.setCurrentItem(list.size() - 1, false);
                mViewPager.setPageTransformer(true, new CardTransformer());
            }
        });
    }

    @Override
    public void warningUI(final String data) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void click(View view) {
        okUtils.get("https://www.mxnzp.com/api//jokes/list/random");
    }
}
