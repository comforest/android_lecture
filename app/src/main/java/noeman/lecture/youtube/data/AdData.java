package noeman.lecture.youtube.data;

import android.graphics.drawable.Drawable;

public class AdData extends MainData{
    public Drawable thumbnail;

    public String title;
    public String info;

    public float rating;
    public String charge;

    public AdData(Drawable thumbnail, String title, String info, float rating, String charge){
        this.thumbnail = thumbnail;
        this.title = title;
        this.info = info;
        this.rating = rating;
        this.charge = charge;
    }
}
