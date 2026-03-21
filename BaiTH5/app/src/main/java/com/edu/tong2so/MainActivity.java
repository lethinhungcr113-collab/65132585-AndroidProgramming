package com.edu.tong2so;

import android.os.Bundle;import android.view.View;import android.widget.Button;import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //khai báo các đối tượng gắn với điều khiển tương ứng
    EditText edtSo1, edtSo2, edtKQ;
    Button nutCong, nutTru, nutNhan, nutChia;

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
        TimDieuKhien();
        //gắn b lắng nghe sự kiêện và code xử lý cho từng btn
        nutCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //xử lý ở đây
                XULY_CONG();
            }
        });

        nutTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //xử lý ở đây
                XULY_TRU();
            }
        });
        nutNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //xử lý ở đây
                XULY_NHAN();
            }
        });
        nutChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //xử lý ở đây
                XULY_CHIA();
            }
        });



    }
    void TimDieuKhien() {
        edtSo1 = (EditText) findViewById(R.id.edtSo1);
        edtSo2 = (EditText) findViewById(R.id.edtSo2);
        edtKQ = (EditText) findViewById(R.id.edtKQ);
        nutCong = (Button) findViewById(R.id.btnCong);
        nutTru = (Button) findViewById(R.id.btnTru);
        nutNhan = (Button) findViewById(R.id.btnNhan);
        nutChia = (Button) findViewById(R.id.btnChia);
    }
    // xử lý cộng
    void XULY_CONG(){
        //code xử lý
        String sothu1 = edtSo1.getText().toString();
        String sothu2 = edtSo2.getText().toString();
        float soA = Float.parseFloat(sothu1);
        float soB = Float.parseFloat(sothu2);
        float tong = soA + soB;
        String chuoiKQ = String.valueOf(tong);
        edtKQ.setText(chuoiKQ);

    }
    // xử lý trừ
    void XULY_TRU(){
        //code xử lý

        String sothu1 = edtSo1.getText().toString();
        String sothu2 = edtSo2.getText().toString();
        float soA = Float.parseFloat(sothu1);
        float soB = Float.parseFloat(sothu2);
        float hieu = soA - soB;
        String chuoiKQ = String.valueOf(hieu);
        edtKQ.setText(chuoiKQ);
    }
    // xử lý Nhân
    void XULY_NHAN(){
        //code xử lý

        String sothu1 = edtSo1.getText().toString();
        String sothu2 = edtSo2.getText().toString();
        float soA = Float.parseFloat(sothu1);
        float soB = Float.parseFloat(sothu2);
        float tich = soA * soB;
        String chuoiKQ = String.valueOf(tich);
        edtKQ.setText(chuoiKQ);
    }
    // xử lý chia
    void XULY_CHIA(){
        //code xử lý

        String sothu1 = edtSo1.getText().toString();
        String sothu2 = edtSo2.getText().toString();
        float soA = Float.parseFloat(sothu1);
        float soB = Float.parseFloat(sothu2);
        float thuong = soA / soB;
        String chuoiKQ = String.valueOf(thuong);
        edtKQ.setText(chuoiKQ);
    }
}