package noeman.lecture.youtube.data;

import android.graphics.drawable.Drawable;

public class ThumbnailData {
    public Drawable thumbnail;
    public Drawable profile;

    public String title;
    public String info;
    public int time;

    public ThumbnailData(Drawable thumbnail, Drawable profile, String title, String info, int time){
        this.thumbnail = thumbnail;
        this.profile = profile;
        this.title = title;
        this.info = info;
        this.time = time;
    }
}
