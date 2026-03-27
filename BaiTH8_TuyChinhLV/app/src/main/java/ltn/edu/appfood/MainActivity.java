package ltn.edu.appfood;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

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
        //tìm listview
        ListView lvDSMonAn = (ListView) findViewById(R.id.lvDSMonAn);;
        //chuẩn bị nguồn DL
        ArrayList<MonAn> dsMonAn = new ArrayList<MonAn>();
        MonAn m1 = new MonAn("Cơm tấm sườn", 35000, "Món ăn ngon", R.drawable.csbi);
        MonAn m2 = new MonAn("Cơm tấm ", 25000, "Món ăn ngon", R.drawable.ctam);
        MonAn m3 = new MonAn("Cơm gà", 30000, "Món ăn ngon", R.drawable.cg);
        MonAn m4 = new MonAn("Cơm trứng", 25000, "Món ăn ngon", R.drawable.ctrung);
        MonAn m5 = new MonAn("Cơm Lam", 20000, "Món ăn ngon", R.drawable.clam);

        dsMonAn.add(m1);
        dsMonAn.add(m2);
        dsMonAn.add(m3);
        dsMonAn.add(m4);
        dsMonAn.add(m5);

        //tạo adapter
        MonAnAdapter adapter = new MonAnAdapter(this, dsMonAn);
        //gán adapter lên listview
        lvDSMonAn.setAdapter(adapter);

        //bắt và xử lý sk
        lvDSMonAn.setOnItemClickListener((adapterView, view, i, l) -> {
            //lấy phần tử đc chạm
            MonAn monAnChon = dsMonAn.get(i);
            //làm gì tùy bài: hiện lên
            //thông báo
            Toast.makeText(MainActivity.this, monAnChon.getTenMonAn(), Toast.LENGTH_SHORT).show();
        });

        }




    }