package noeman.lecture.youtube.data;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

public class SmallAdListData extends MainData {
    List<SmallAdData> list;

    public SmallAdListData(List<SmallAdData> list) {
        this.list = list;
    }

    public static SmallAdListData getSample(Resources resources) {
        ArrayList<SmallAdData> list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            list.add(SmallAdData.getSample(resources));
        }

        return new SmallAdListData(list);
    }
}
