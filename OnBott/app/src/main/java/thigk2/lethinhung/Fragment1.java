package thigk2.lethinhung;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Fragment1 extends Fragment {
    EditText edtMET;
    EditText edtKILOMET;
    Button btnChuyen;


    public Fragment1() {
        // Required empty public constructor
    }
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewCau1 = inflater.inflate(R.layout.fragment_1, container, false);
        //tìm đk trong view này
        edtMET = viewCau1.findViewById(R.id.edtSoMet);
        edtKILOMET = viewCau1.findViewById(R.id.edtSoKiloMet);
        btnChuyen = viewCau1.findViewById(R.id.btnDoi);
        btnChuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String duLieusoMet = edtMET.getText().toString();
                String duLieusoKiloMet = edtKILOMET.getText().toString();
                if (!duLieusoMet.isEmpty()) //user co nhap so met can doi sang km k
                {
                    Toast.makeText(viewCau1.getContext(), "m->km", Toast.LENGTH_SHORT).show();
                }
                else//doi tu km sang m
                {
                    Toast.makeText(viewCau1.getContext(), "km->m", Toast.LENGTH_SHORT).show();
                }
            }
        });



        return viewCau1;
    }
}