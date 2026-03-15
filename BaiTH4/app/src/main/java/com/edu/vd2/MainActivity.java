package com.edu.vd2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //khai báo các đối tượng gaắn vs đkhiển tương ứng
    EditText edtSo1, edtSo2, edtKQ;
    Button nutCong, nutTru, nutNhan, nutChia;
    void TimDieuKhien(){
        edtSo1 = (EditText) findViewById(R.id.edtSo1);
        edtSo2 = (EditText) findViewById(R.id.edtSo2);
        edtKQ = (EditText) findViewById(R.id.edtKQ);
        nutCong = (Button) findViewById(R.id.btnCong);
        nutTru = (Button) findViewById(R.id.btnTru);
        nutNhan = (Button) findViewById(R.id.btnNhan);
        nutChia = (Button) findViewById(R.id.btnChia);


    }
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
    }

    //xu ly cong
    public void XuLyCong(View v){
        //code xu ly
        //tìm edittext số 1, 2
        //lấy dữ liệu từ 2 đkhiển đó
        String sothu1 = edtSo1.getText().toString();
        String sothu2 = edtSo2.getText().toString();
        //chuyển chuỗi sang số
        float soA = Float.parseFloat(sothu1);
        float soB = Float.parseFloat(sothu2);
        //tính toán
        float tong = soA + soB;
        //hiển thị kết quả
        //tìm chỗ hiêện kq
        // chuẩn bị dl xuất, chuyển số sang chuỗi
        String chuoiKQ = String.valueOf(tong);
        //gắn hết quả
        edtKQ.setText(chuoiKQ);

    }
    public void XuLyTru(View v){
        //code xu ly
        String sothu1 = edtSo1.getText().toString();
        String sothu2 = edtSo2.getText().toString();
        //chuyển chuỗi sang số
        float soA = Float.parseFloat(sothu1);
        float soB = Float.parseFloat(sothu2);
        //tính toán
        float hieu = soA - soB;
        // chuẩn bị dl xuất, chuyển số sang chuỗi
        String chuoiKQ = String.valueOf(hieu);
        //gắn hết quả
        edtKQ.setText(chuoiKQ);
    }
    public void XuLyNhan(View v){
        //code xu ly
        String sothu1 = edtSo1.getText().toString();
        String sothu2 = edtSo2.getText().toString();
        //chuyển chuỗi sang số
        float soA = Float.parseFloat(sothu1);
        float soB = Float.parseFloat(sothu2);
        //tính toán
        float tich = soA * soB;
        //hiển thị kết quả
        // chuẩn bị dl xuất, chuyển số sang chuỗi
        String chuoiKQ = String.valueOf(tich);
        //gắn hết quả
        edtKQ.setText(chuoiKQ);
    }
    public void XuLyChia(View v){
        //code xu ly
        String sothu1 = edtSo1.getText().toString();
        String sothu2 = edtSo2.getText().toString();
        //chuyển chuỗi sang số
        float soA = Float.parseFloat(sothu1);
        float soB = Float.parseFloat(sothu2);
        //tính toán
        float thuong = soA / soB;
        //hiển thị kết quả
        // chuẩn bị dl xuất, chuyển số sang chuỗi
        String chuoiKQ = String.valueOf(thuong);
        //gắn hết quả
        edtKQ.setText(chuoiKQ);
    }
}