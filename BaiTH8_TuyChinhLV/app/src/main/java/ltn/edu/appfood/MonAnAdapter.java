package ltn.edu.appfood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MonAnAdapter extends BaseAdapter {
    //
    private ArrayList<MonAn> dsMonAn;
    private LayoutInflater layoutinflater;
    private Context context;
    //hàm tạo
    public MonAnAdapter(Context _context, ArrayList<MonAn> dsMonAn) {
        this.dsMonAn = dsMonAn;
        this.context = _context;
        this.layoutinflater = LayoutInflater.from(_context);
    }

    @Override
    public int getCount() {
        return dsMonAn.size();
    }

    @Override
    public Object getItem(int i) {
        return dsMonAn.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //view của item hiện hành
        View viewHienHanh = view;
        //ktra xem view có null hay không
        if (viewHienHanh == null)
            viewHienHanh = layoutinflater.inflate(R.layout.item_monan, null);
        //nếu k null: lấy dl
        MonAn monAnHienTai = dsMonAn.get(i);
        //gán lên các điều khiển
        //tìm điều khiển trước
        TextView textView_TenMon = (TextView) viewHienHanh.findViewById(R.id.tvTenMonAn);
        TextView textView_DonGia = (TextView) viewHienHanh.findViewById(R.id.tvDonGia);
        TextView textView_MoTa = (TextView) viewHienHanh.findViewById(R.id.tvMoTa);
        ImageView imageView = (ImageView) viewHienHanh.findViewById(R.id.imAnhDaiDien);
        // set lên
        textView_TenMon.setText(monAnHienTai.getTenMonAn());
        textView_DonGia.setText(String.valueOf(monAnHienTai.getDonGia()) );
        textView_MoTa.setText(monAnHienTai.getMoTa());
        imageView.setImageResource(monAnHienTai.getIdAnhMH());

        return viewHienHanh;




    }
}
