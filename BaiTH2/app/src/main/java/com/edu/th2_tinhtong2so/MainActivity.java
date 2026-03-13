package com.edu.th2_tinhtong2so;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //gắn Layout tương ứng với file này
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    //lắng nghe và xử lý sự kiện click lên nút TÍNH TỔNG
    public void XuLyCong (View view) {
        //tìm,tham chiếu đến điều khiển trên tệp xml, mapping sang java file
        EditText editTextSoA = findViewById(R.id.edtA);
        EditText editTextSoB = findViewById(R.id.edtB);
        EditText editTextKQ = findViewById(R.id.edtKQ);
        // Lấy dữ liệu về ở đk số a
        String strA = editTextSoA.getText().toString(); //strA = "1"
        // Lấy dữ liệu về ở đk số b
        String strB = editTextSoB.getText().toString(); //strB = "6"

        //chuyển dữ liệu sang dạng số
        int soA = Integer.parseInt(strA);
        int soB = Integer.parseInt(strB);
        //tính tổng theo yêu cầu
        int tong = soA + soB;
        String strTong = String.valueOf(tong); //chuyen sang chuoi
        //hien ra man hinh
        editTextKQ.setText(strTong);

    }
}