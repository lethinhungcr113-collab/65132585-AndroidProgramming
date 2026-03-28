package ltn.edu.recyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //1.khai báo các biến truy ập toaàn cục
    ItemLandscapAdapter adapter;
    ArrayList<LandScape> landScapeList; //nguồn dl;
    //2. khai báo các biến đại diện cho các view cần tương tác
    RecyclerView recyclerViewLand;

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
        //3. chuẩn bị dl cho landScapeList
        landScapeList = getDataForRecycler();
        //4. tìm đk Recycler
        recyclerViewLand = findViewById(R.id.recyclerLand);
        //5. Tạo layout manager để đặt bố cục cho Recycler
        RecyclerView.LayoutManager layoutLinear = new LinearLayoutManager(this);
        recyclerViewLand.setLayoutManager(layoutLinear);
        //6. tạo adapter gắn với nguồn dl
        adapter = new ItemLandscapAdapter(this, landScapeList);
        //7. gắn adapter với Recycler
        recyclerViewLand.setAdapter(adapter);
    }
    private ArrayList<LandScape> getDataForRecycler() {
        ArrayList<LandScape> listData = new ArrayList<LandScape>();
        listData.add(new LandScape("Bà Nà Hill", "bnhill"));
        listData.add(new LandScape("Cột cờ Phía Bắc", "cotco"));
        listData.add(new LandScape("Phố cổ Hội An", "hoian"));
        listData.add(new LandScape("Quảng Ninh", "quangninh"));
        listData.add(new LandScape("Vịnh Hạ Long", "vhlong"));
        listData.add(new LandScape("Thác nước Đăk Lăk", "thac"));
        return listData;

    }
}