package ltn.edu.chuyenmanhinh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ManHinh2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.trang2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main1), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void XacNhan (View view) {
        EditText edtName = (EditText) findViewById(R.id.edtName);
        EditText edtPassword = (EditText) findViewById(R.id.edtPassword);
        EditText edtEmail = (EditText) findViewById(R.id.edtEmail);
        String name = edtName.getText().toString();
        String pass = edtPassword.getText().toString();
        String email = edtEmail.getText().toString();

        if (name.isEmpty() || pass.isEmpty() || email.isEmpty()) {
            if (name.isEmpty()) {
                edtName.setError("Không được để trống");
            }

            if (email.isEmpty()) {
                edtEmail.setError("Không được để trống");
            }

            if (pass.isEmpty()) {
                edtPassword.setError("Không được để trống");
            }
            return;
        }


        Intent iManHinh3 = new Intent(this, ManHinh3.class);
        iManHinh3.putExtra("USERNAME", name);
        startActivity(iManHinh3);

    }
}
