package thigk2.lethinhung.baithi;

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
    ArrayList<LandScape> datas; //  bỏ static

    public ItemLandscapAdapter(Context _context, ArrayList<LandScape> _datas) {
        this.context = _context;
        this.datas = _datas;
    }

    @NonNull
    @Override
    public ItemLandscapViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(context)
                .inflate(R.layout.landscap_item, parent, false);
        return new ItemLandscapViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLandscapViewHolder holder, int position) {
        LandScape land = datas.get(position);

        // Tên
        holder.tvLandName.setText(land.getLandscapeName());

        // Địa chỉ
        holder.tvAddress.setText(land.getAddress());

        // Ảnh
        String packageName = holder.itemView.getContext().getPackageName();
        String tenFileAnh = land.getLandscapeImage();
        int imageID = holder.itemView.getResources()
                .getIdentifier(tenFileAnh, "drawable", packageName);

        holder.imLandPicture.setImageResource(imageID);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class ItemLandscapViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvLandName, tvAddress;
        ImageView imLandPicture;

        public ItemLandscapViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            tvLandName = itemView.findViewById(R.id.tvLandspaceName);
            tvAddress = itemView.findViewById(R.id.tvAddress);
            imLandPicture = itemView.findViewById(R.id.imLandscape);
        }

        @Override
        public void onClick(View v) {
            int pos = getAdapterPosition();
            LandScape land = datas.get(pos);

            Toast.makeText(v.getContext(),
                    land.getLandscapeName(),
                    Toast.LENGTH_SHORT).show();
        }
    }
}