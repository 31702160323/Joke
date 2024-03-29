package cn.mypackage.joke.transformer;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.view.View;

public class CardTransformer implements ViewPager.PageTransformer {
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void transformPage(@NonNull View page, float position) {
        if(position < 0) {
            page.setTranslationX(-position*page.getWidth());
            page.setTranslationZ(position);

            float scale = (page.getWidth()+60*position)/page.getWidth();
            page.setScaleY(scale);
            page.setScaleX(scale);

            page.setTranslationY(-position*60);
        }
    }
}
