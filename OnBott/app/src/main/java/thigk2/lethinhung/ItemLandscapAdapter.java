package thigk2.lethinhung;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemLandscapAdapter extends RecyclerView.Adapter<ItemLandscapAdapter.ItemLandscapViewHolder> {
    Context context;
    static ArrayList<LandScape> datas;
    public ItemLandscapAdapter(Context _context, ArrayList<LandScape> _datas) {
        this.context = _context;
        this.datas = _datas;
    }

    @NonNull
    @Override
    public ItemLandscapViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutinflater = LayoutInflater.from(context);
        View viewItem = layoutinflater.inflate(R.layout.landscap_item, parent, false);
        ItemLandscapViewHolder viewHolder = new ItemLandscapViewHolder(viewItem);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLandscapViewHolder holder, int position) {
        //lấy p.tử ở vị trí position trong mảng datas
        LandScape land = datas.get(position);
        //đặt vào các thuộc tính hiển thị của view con
        //đặt tên
        holder.tvLandName.setText(land.getLandscapeName());
        //đặt ảnh
            String packageName = holder.itemView.getContext().getPackageName();
        //tìm id ảnh thông qua tên ảnh
            String tenFileAnh = land.getLandscapeImage();
            int imageID = holder.itemView.getResources().getIdentifier(tenFileAnh, "drawable", packageName);
            holder.imLandPicture.setImageResource(imageID);

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
    static final class ItemLandscapViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvLandName;
        ImageView imLandPicture;
        public ItemLandscapViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tvLandName = itemView.findViewById(R.id.tvLandspaceName);
            imLandPicture = itemView.findViewById(R.id.imLandscape);
        }

        @Override
        public void onClick(View v) {
            //lấy vtri của item đc click thông qua p.thức getAdapterPosition()
            int clickPosition = getAdapterPosition();
            //lấy dl tương ứng từ danh sách theo vtri
            LandScape land = datas.get(clickPosition);
            //hiển thị thông báo ỏ xử lý khác
            Toast.makeText(v.getContext(), "Clicked " + land.getLandscapeName(), Toast.LENGTH_SHORT).show();

        }
    }
}
