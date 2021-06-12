package noeman.lecture.youtube;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import noeman.lecture.youtube.data.AdData;
import noeman.lecture.youtube.data.MainData;
import noeman.lecture.youtube.data.ThumbnailData;

public class MainActivity extends AppCompatActivity {

    private ArrayList<MainData> datas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        datas.add(new ThumbnailData(
                ResourcesCompat.getDrawable(getResources(), R.drawable.thumbnail00, null),
                ResourcesCompat.getDrawable(getResources(), R.drawable.profile00, null),
                "Title - 00",
                "info - asdf - fdsa",
                6 * 60
        ));

        datas.add(new ThumbnailData(
                ResourcesCompat.getDrawable(getResources(), R.drawable.thumbnail01, null),
                ResourcesCompat.getDrawable(getResources(), R.drawable.profile01, null),
                "Title - 01",
                "info01 - asdf - fdsa",
                12 * 60
        ));

        datas.add(new AdData(
                ResourcesCompat.getDrawable(getResources(), R.drawable.thumbnail00, null),
                "Title - 00",
                "info - asdf - fdsa",
                4.5f,
                "free"
        ));

        datas.add(new ThumbnailData(
                ResourcesCompat.getDrawable(getResources(), R.drawable.thumbnail02, null),
                ResourcesCompat.getDrawable(getResources(), R.drawable.profile02, null),
                "Title - 01",
                "info01 - asdf - fdsa",
                12 * 60
        ));

        datas.add(new ThumbnailData(
                ResourcesCompat.getDrawable(getResources(), R.drawable.thumbnail03, null),
                ResourcesCompat.getDrawable(getResources(), R.drawable.profile03, null),
                "Title - 01",
                "info01 - asdf - fdsa",
                12 * 60
        ));

        datas.add(new ThumbnailData(
                ResourcesCompat.getDrawable(getResources(), R.drawable.thumbnail04, null),
                ResourcesCompat.getDrawable(getResources(), R.drawable.profile04, null),
                "Title - 01",
                "info01 - asdf - fdsa",
                12 * 60
        ));

        datas.add(new ThumbnailData(
                ResourcesCompat.getDrawable(getResources(), R.drawable.thumbnail05, null),
                ResourcesCompat.getDrawable(getResources(), R.drawable.profile05, null),
                "Title - 01",
                "info01 - asdf - fdsa",
                12 * 60
        ));

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        ThumbnailAdapter adapter = new ThumbnailAdapter();

        adapter.setDatas(datas);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}