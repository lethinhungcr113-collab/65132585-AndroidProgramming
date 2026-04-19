package thigk2.lethinhung;

import static android.content.Context.MODE_PRIVATE;
import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class Fragment4 extends Fragment {
    public Fragment4() {
        // Required empty public constructor
    }
    public static Fragment4 newInstance(String param1, String param2) {
        Fragment4 fragment = new Fragment4();
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
//        // b0: tạo file csdl
//        SQLiteDatabase db =getActivity().openOrCreateDatabase("QLSach.db", MODE_PRIVATE, null);
//        //b1 tao bang
//        String sqlXoaBangNeuDaCo = "DROP TABLE IF EXISTS Books;";
//        String sqlTaoBang = "CREATE TABLE  Books( BookID integer PRIMARY KEY,"+
//                                                    "BookName text,"+
//                                                    "Pages integer,"+
//                                                    "Price Float,"+
//                                                    "Description text);";
//        //thuc hien lenh sql
//        db.execSQL(sqlXoaBangNeuDaCo);
//        db.execSQL(sqlTaoBang);
//        //them dl vao bang
//        String sqlThem1 = "INSERT INTO Books VALUES(1, 'Java', 100, 9.99, 'sách về java');";
//        String sqlThem2 = "INSERT INTO Books VALUES(2, 'Android', 320, 19.00, 'Android cơ bản');";
//        String sqlThem3 = "INSERT INTO Books VALUES(3, 'Học làm giàu', 120, 0.99, 'sách đọc cho vui');";
//        String sqlThem4 = "INSERT INTO Books VALUES(4, 'Từ điển Anh-việt', 1000, 29.50, 'Từ điền 100.000 từ');";
//        String sqlThem5 = "INSERT INTO Books VALUES(5, 'CNXH', 1, 1, 'chuyện cổ tích');";
//        db.execSQL(sqlThem1);
//        db.execSQL(sqlThem2);
//        db.execSQL(sqlThem3);
//        db.execSQL(sqlThem4);
//        db.execSQL(sqlThem5);
//
////         Để quan sát trực quan file .db ? ==> Dùng ứng dụng DB Browser for SQLite
////         Để mở được, ta file save file từ điện thoai ra đĩa cứnc
//
//        // Ta đóng lai để check
//        db.close();
        SQLiteDatabase db =getActivity().openOrCreateDatabase("QLSach.db", MODE_PRIVATE, null);
        //thuc thi cau lenh
        String sqlSelect = "Select * from Books;";
        Cursor cs = db.rawQuery(sqlSelect, null);
        cs.moveToFirst(); //dua con tro ban ghi ve hang dau tien
        // b3: đổ vao bien nao do de xd
        ArrayList<Book> dsSach = new ArrayList<Book>();
        while (cs.moveToNext()){
            int idSach = cs.getInt(0);
            String tenSach = cs.getString(1);
            int soTrang = cs.getInt(2);
            float gia = cs.getFloat(3);
            String moTa = cs.getString(4);
            //tao doi tuong va them vao ds
            Book b = new Book(idSach, tenSach, soTrang, gia, moTa);
            dsSach.add(b);

        }
        //b4: hien len listview, recyclerview,...
        ArrayList<String> dsTenSach = new ArrayList<String>();
        for(int i=0; i<dsSach.size(); i++){
            dsTenSach.add(dsSach.get(i).getBookName());
        }
        //hien thi len dk listview



        View viewCau4 = inflater.inflate(R.layout.fragment_4, container, false);
        ListView listViewCau4 = viewCau4.findViewById(R.id.lvTenSach);
        ArrayAdapter<String> adapterTenSach = new ArrayAdapter<String>(
                getContext(),
                R.layout.item_sach,
                R.id.txtTenSach,
                dsTenSach

        );
        listViewCau4.setAdapter(adapterTenSach);
        // lang nghe va xu ly
        //listViewCau4.setOnItemClickListener((parent, view, position, id) -> {

        return viewCau4;
    }
}