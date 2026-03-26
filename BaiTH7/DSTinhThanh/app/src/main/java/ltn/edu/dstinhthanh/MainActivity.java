package ltn.edu.dstinhthanh;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> dsTT ;
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
        //chuyển ra ngoài ArrayList<String> dsTT ;// khai báo
        dsTT = new ArrayList<>();// khởi tạo cụ thể
        dsTT.add("HÀ NỘI");
        dsTT.add("QUẢNG NINH");
        dsTT.add("QUẢNG NGÃI");
        dsTT.add("THANH HÓA");
        dsTT.add("LẠNG SƠN");
        //B2: tạo adapter
        ArrayAdapter<String> adapterTinhThanh ;// khai báo
        adapterTinhThanh = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dsTT);
        //B3: gắn adapter lên listview
        //3.1 tìm
        ListView lvDanhSachVL = findViewById(R.id.lvDSTT);
        //3.2 gắn
        lvDanhSachVL.setAdapter(adapterTinhThanh
        );
        //3.3 lắng nghe và xử lý sự kiện người dùng tương tác
        // gắn bộ lắng nghe
        lvDanhSachVL.setOnItemClickListener(BoLangNghevaXL);
    }
    // tạo bộ lắng nghe và xử lý sự kiện OnItemClick, đặt vào 1 biến
    // vd: BoLangNghevaXL
    AdapterView.OnItemClickListener BoLangNghevaXL = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            //code xu ly
            // i là vị trí phần tử vừa đc click
            //vd xly ở đây hiện lên thông báo nhanh về vtri của p.tử vwuaf chọn
            //Toast.makeText(MainActivity.this,"Bạn vừa chọn: " + String.valueOf(i), Toast.LENGTH_SHORT).show();

            // vd hiện giá trị
            // lấy gtri của p.tử thứ i
            String strTenTinhThanh = dsTT.get(i);
            // hiện lên toast
            Toast.makeText(MainActivity.this, "Bạn vừa chọn: " + strTenTinhThanh, Toast.LENGTH_SHORT).show();

        }
    };
}