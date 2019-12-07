package cn.mypackage.joke.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import cn.mypackage.joke.fragment.CardFragment;
import cn.mypackage.joke.json.JokeDataInfo;

public class CardFragmentAdpter extends FragmentStatePagerAdapter {
    private List<JokeDataInfo> mList;
    public CardFragmentAdpter(FragmentManager fm, List<JokeDataInfo> list) {
        super(fm);
        this.mList = list;
    }

    @Override
    public Fragment getItem(int i) {
        return CardFragment.getInstance(mList.get(i));
    }

    @Override
    public int getCount() {
        return mList.size();
    }
}
