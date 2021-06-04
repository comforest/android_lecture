package noeman.lecture.youtube;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import noeman.lecture.youtube.data.ThumbnailData;

public class ThumbnailAdapter extends RecyclerView.Adapter<ThumbnailAdapter.ThumbnailViewHolder> {

    private List<ThumbnailData> datas;

    @NonNull
    @Override
    public ThumbnailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_thumbnail, parent, false);
        return new ThumbnailViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ThumbnailViewHolder holder, int position) {
        ThumbnailData item = datas.get(position);

        holder.thumbnailImg.setImageDrawable(item.thumbnail);
        holder.profileImg.setImageDrawable(item.profile);
        holder.title.setText(item.title);
        holder.info.setText(item.info);
        holder.time.setText(item.time+"");

    }

    @Override
    public int getItemCount() {
        if (datas == null) return 0;
        return datas.size();
    }

    public void setDatas(List<ThumbnailData> list){
        datas = list;
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
}
