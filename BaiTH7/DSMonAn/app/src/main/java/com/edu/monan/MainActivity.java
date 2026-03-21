package com.edu.monan;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // hiển thị dữ liệu lên Listview
        // B1: Cần có DL
        // từ đâu có?? từ CSDL(SQL,noSQL, XML,...)
        // hard code cho sẵn dữ liệu trực tiếp
        //cần biến phù hợp để chứa DL
        ArrayList<String> dsMA ;// khai báo
        dsMA = new ArrayList<>();// khởi tạo cụ thể
        dsMA.add("Món ăn 1");
        dsMA.add("Món ăn 2");
        dsMA.add("Món ăn 3");
        dsMA.add("Món ăn 4");
        dsMA.add("Món ăn 5");

        //B2: tạo adapter
        ArrayAdapter<String> adapterMonAn ;// khai báo
        adapterMonAn = new ArrayAdapter<String>(this, R.layout.item_monan, dsMA);
        //B3: gắn adapter lên listview
        //3.1 tìm
        ListView lvDanhSachVL = findViewById(R.id.lvDSMonAn);
        //3.2 gắn
        lvDanhSachVL.setAdapter(adapterMonAn);
        //3.3 lắng nghe và xử lý sự kiện người dùng tương tác
    }
}