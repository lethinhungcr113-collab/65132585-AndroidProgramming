package thigk2.lethinhung.baithi;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Cau1Fragment extends Fragment {

    EditText edtSo1, edtSo2;
    TextView tvChuVi, tvDienTich;
    Button btnTinh;

    public Cau1Fragment() {
        // Required empty public constructor
    }

    public static Cau1Fragment newInstance(String param1, String param2) {
        Cau1Fragment fragment = new Cau1Fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cau1, container, false);

        // Ánh xạ
        edtSo1 = view.findViewById(R.id.edtSo1);
        edtSo2 = view.findViewById(R.id.edtSo2);
        tvChuVi = view.findViewById(R.id.tvChuVi);
        tvDienTich = view.findViewById(R.id.tvDienTich);
        btnTinh = view.findViewById(R.id.btnTinh);

        // Xử lý nút
        btnTinh.setOnClickListener(v -> {
            String s1 = edtSo1.getText().toString().trim();
            String s2 = edtSo2.getText().toString().trim();

            // Check rỗng
            if (TextUtils.isEmpty(s1) || TextUtils.isEmpty(s2)) {
                tvChuVi.setText("Nhập thiếu");
                tvDienTich.setText("Nhập thiếu");
                return;
            }

            try {
                double dai = Double.parseDouble(s1);
                double rong = Double.parseDouble(s2);

                double chuVi = (dai + rong) * 2;
                double dienTich = dai * rong;

                // Hiển thị (format đẹp)
                tvChuVi.setText(String.format("%.2f", chuVi));
                tvDienTich.setText(String.format("%.2f", dienTich));

            } catch (Exception e) {
                tvChuVi.setText("Lỗi nhập");
                tvDienTich.setText("Lỗi nhập");
            }
        });

        return view;
    }
}