package noeman.lecture.youtube.data;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import androidx.core.content.res.ResourcesCompat;

import noeman.lecture.youtube.R;

public class SmallAdData {
    Drawable img;
    String title;
    int price;
    String shop;
    String ship;

    SmallAdData(Drawable img, String title, int price, String shop, String ship) {
        this.img = img;
        this.title = title;
        this.price = price;
        this.shop = shop;
        this.ship = ship;
    }

    public static SmallAdData getSample(Resources resources) {
        return new SmallAdData(
                ResourcesCompat.getDrawable(resources, R.drawable.goods, null),
                "아무튼 엄청 긴 타이틀 아무튼 엄청 긴 타이틀 아무튼 엄청 긴 타이틀 아무튼 엄청 긴 타이틀",
                45000,
                "Interpark",
                "무료 배송"
        );
    }
}
