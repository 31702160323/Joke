package cn.mypackage.joke.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.mypackage.joke.R;
import cn.mypackage.joke.json.JokeDataInfo;


/**
 * A simple {@link Fragment} subclass.
 */
public class CardFragment extends Fragment {
    private View mRootView;
    private TextView tvContent;
    private JokeDataInfo mJokeDataInfo;

    public static CardFragment getInstance(JokeDataInfo info){
        CardFragment fragment = new CardFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("info",info);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView = inflater.inflate(R.layout.fragment_card, container, false);
        tvContent = mRootView.findViewById(R.id.tv_content);
        return mRootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mJokeDataInfo = (JokeDataInfo) getArguments().getSerializable("info");
        tvContent.setText(mJokeDataInfo.content);
    }
}
