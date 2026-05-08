package ltn.vieccanlam;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class ThemTaskActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_task);
        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // lay dl
                EditText editTextName = findViewById(R.id.editTextTenCV);
                EditText editTextMessage = findViewById(R.id.editTextMessage);
                EditText editTextDate = findViewById(R.id.editTextDate);
                EditText editTextPriority = findViewById(R.id.editTextPriority);
                String tenCV = editTextName.getText().toString();
                String message = editTextMessage.getText().toString();
                String date = editTextDate.getText().toString();
                String priority = editTextPriority.getText().toString();
                // gán vao task
                TASKS task = new TASKS(tenCV, date, message, Integer.parseInt(priority));
                //ket noi db, them
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference databaseReference = database.getReference("TASKS");
                String key = databaseReference.push().getKey();

                HashMap<String, Object> item = new HashMap<String, Object>();
                item.put(key, task.toFirebaseObject());

                databaseReference.updateChildren(item, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                        if (error == null) finish();
                    }
                });

            }
        });
    }
}

