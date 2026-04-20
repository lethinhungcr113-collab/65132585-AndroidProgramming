package thigk2.lethinhung.baithi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Cau2Fragment extends Fragment {

    ArrayList<String> dsTT;
    ListView lvTenTinhThanh;

    public Cau2Fragment() {
        // Required empty public constructor
    }

    public static Cau2Fragment newInstance(String param1, String param2) {
        Cau2Fragment fragment = new Cau2Fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dsTT = new ArrayList<>();
        dsTT.add("HÀ NỘI");
        dsTT.add("QUẢNG NINH");
        dsTT.add("QUẢNG NGÃI");
        dsTT.add("THANH HÓA");
        dsTT.add("LẠNG SƠN");
        dsTT.add("ĐÀ NẴNG");
        dsTT.add("KHÁNH HÒA");
        dsTT.add("CẦN THƠ");
        dsTT.add("BÌNH DƯƠNG");
        dsTT.add("HẢI PHÒNG");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cau2, container, false);

        //  Ánh xạ ListView
        lvTenTinhThanh = view.findViewById(R.id.lvTenTinhThanh);

        //  Tạo adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getContext(),
                android.R.layout.simple_list_item_1,
                dsTT
        );

        //  Gán vào ListView
        lvTenTinhThanh.setAdapter(adapter);

        return view;
    }
}