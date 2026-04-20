package thigk2.lethinhung.baithi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Cau3Fragment extends Fragment {

    RecyclerView ryCau3;
    ArrayList<LandScape> ds;

    public Cau3Fragment() {
        // Required empty public constructor
    }

    public static Cau3Fragment newInstance(String param1, String param2) {
        Cau3Fragment fragment = new Cau3Fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cau3, container, false);

        //  Ánh xạ
        ryCau3 = view.findViewById(R.id.ryCau3);

        // Dữ liệu
        ds = new ArrayList<>();
        ds.add(new LandScape("Lũng cú Hà Giang", "cotco", "Khánh Hòa"));
        ds.add(new LandScape("Bà Nà Hill Đà Nẵng", "bnhill", "Miền Trung"));
        ds.add(new LandScape("Phố cổ Hội An ", "hoian", "Thủ đô Việt Nam"));
        ds.add(new LandScape("Quần thể Tràng An Ninh Bình", "quangninh", "Lâm Đồng"));
        ds.add(new LandScape("Vịnh Hạ Long", "vhlong", "Kiên Giang"));

        //  LayoutManager (BẮT BUỘC)
        ryCau3.setLayoutManager(new LinearLayoutManager(getContext()));

        //  Adapter
        ItemLandscapAdapter adapter = new ItemLandscapAdapter(getContext(), ds);
        ryCau3.setAdapter(adapter);

        return view;
    }
}