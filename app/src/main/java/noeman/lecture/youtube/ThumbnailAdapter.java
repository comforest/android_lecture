package noeman.lecture.youtube;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;

import noeman.lecture.youtube.data.AdData;
import noeman.lecture.youtube.data.MainData;
import noeman.lecture.youtube.data.SmallAdListData;
import noeman.lecture.youtube.data.ThumbnailData;

public class ThumbnailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<MainData> datas;
    SimpleDateFormat underHourSDF = new SimpleDateFormat("m:ss");
    SimpleDateFormat overHourSDF = new SimpleDateFormat("mm:ss");

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if(viewType == 1){
            View v = inflater.inflate(R.layout.item_ad_thumbnail, parent, false);
            return new AdViewHolder(v);
        }else if(viewType == 2){
            View v = inflater.inflate(R.layout.item_ad_list, parent, false);
            return new SmallAdListViewHolder(v);
        }

        View v = inflater.inflate(R.layout.item_thumbnail, parent, false);
        return new ThumbnailViewHolder(v);
    }

    @Override
    public int getItemViewType(int position) {
        MainData item = datas.get(position);

        if(item instanceof AdData){
            return 1;
        } else if(item instanceof SmallAdListData){
            return 2;
        }

        return 0;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof ThumbnailViewHolder){
            ThumbnailViewHolder h = (ThumbnailViewHolder) holder;
            ThumbnailData item = (ThumbnailData) datas.get(position);

            h.thumbnailImg.setImageDrawable(item.thumbnail);
//        holder.profileImg.setImageDrawable(item.profile);

            Bitmap profileBitmap = ((BitmapDrawable) item.profile).getBitmap();
            Bitmap cropProfile = getRoundedCroppedBitmap(profileBitmap);
            h.profileImg.setImageBitmap(cropProfile);


            h.title.setText(item.title);
            h.info.setText(item.info);

            if (item.time < 60 * 60) {
                h.time.setText(underHourSDF.format(item.time));
            } else {
                h.time.setText(overHourSDF.format(item.time));
            }
        }else if(holder instanceof AdViewHolder){
            AdViewHolder h = (AdViewHolder) holder;
            AdData item = (AdData) datas.get(position);

            h.thumbnailImg.setImageDrawable(item.thumbnail);

            h.title.setText(item.title);
            h.info.setText(item.info);

            h.charge.setText(item.charge);
            h.rating.setText(item.rating + "★");
        }else if(holder instanceof SmallAdListViewHolder){
            SmallAdListViewHolder h = (SmallAdListViewHolder) holder;
            SmallAdListData item = (SmallAdListData) datas.get(position);

            LinearLayoutManager layoutManager = new LinearLayoutManager(
                    h.itemView.getContext(),
                    LinearLayoutManager.HORIZONTAL,
                    false
            );
            h.recyclerView.setLayoutManager(layoutManager);


        }




    }

    @Override
    public int getItemCount() {
        if (datas == null) return 0;
        return datas.size();
    }

    public void setDatas(List<MainData> list) {
        datas = list;
    }

    private Bitmap getRoundedCroppedBitmap(Bitmap bitmap) {
        int widthLight = bitmap.getWidth();
        int heightLight = bitmap.getHeight();

        int length;
        if (widthLight < heightLight) {
            length = widthLight;
        } else {
            length = heightLight;
        }

        Bitmap output = Bitmap.createBitmap(length, length,
                Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(output);
        Paint paintColor = new Paint();
        paintColor.setFlags(Paint.ANTI_ALIAS_FLAG);

        RectF rectF = new RectF(new Rect(0, 0, widthLight, heightLight));


//        canvas.drawRoundRect(rectF, widthLight / 2, heightLight / 2, paintColor);
        canvas.drawCircle(length / 2, length / 2, length / 2, paintColor);


        Paint paintImage = new Paint();
        paintImage.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(bitmap, 0, 0, paintImage);

        return output;
    }

    public class ThumbnailViewHolder extends RecyclerView.ViewHolder {
        private ImageView thumbnailImg;
        private ImageView profileImg;
        private TextView title;
        private TextView info;
        private TextView time;

        public ThumbnailViewHolder(@NonNull View itemView) {
            super(itemView);
            thumbnailImg = itemView.findViewById(R.id.thumbnail_img);
            profileImg = itemView.findViewById(R.id.profile_img);
            title = itemView.findViewById(R.id.title);
            info = itemView.findViewById(R.id.info);
            time = itemView.findViewById(R.id.time);
        }
    }

    public class AdViewHolder extends RecyclerView.ViewHolder {
        private ImageView thumbnailImg;
        private TextView title;
        private TextView info;
        private TextView rating;
        private TextView charge;

        public AdViewHolder(@NonNull View itemView) {
            super(itemView);
            thumbnailImg = itemView.findViewById(R.id.thumbnail_img);
            title = itemView.findViewById(R.id.title);
            info = itemView.findViewById(R.id.info);
            rating = itemView.findViewById(R.id.rating);
            charge = itemView.findViewById(R.id.charge);

        }
    }

    public class SmallAdListViewHolder extends RecyclerView.ViewHolder{
        private RecyclerView recyclerView;
        public SmallAdListViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recyclerview);
        }
    }
}
