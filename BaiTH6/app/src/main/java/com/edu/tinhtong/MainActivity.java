package com.edu.tinhtong;

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

//    EditText edtA, edtB, edtKQ;
//    Button btnCong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        // gắn layout tương ứng
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
       // TimDieuKhien();
    }
//    void TimDieuKhien(){
//        edtA = findViewById(R.id.edtA);
//        edtB = findViewById(R.id.edtB);
//        edtKQ = findViewById(R.id.edtKQ);
//        btnCong = findViewById(R.id.btnCong);
//    }
    public void XuLyCong(View v) {
        EditText editTextSoA = findViewById(R.id.edtA);
        EditText editTextSoB = findViewById(R.id.edtB);
        EditText editTextKetQua = findViewById(R.id.edtKQ);

        String soA = editTextSoA.getText().toString();
        String soB = editTextSoB.getText().toString();

        int so_A = Integer.parseInt(soA);
        int so_B = Integer.parseInt(soB);

        int tong = so_A + so_B;
        String strTong = String.valueOf(tong);

        editTextKetQua.setText(strTong);
    }

}