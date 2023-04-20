package htg.haitran.deso07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtCity, edtNhietDo;
    Button btnAdd, btnView;
    ListView lv;
    ArrayList<Weather> weathers = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtCity = findViewById(R.id.edt_city);
        edtNhietDo = findViewById(R.id.edt_nhietdo);
        btnAdd = findViewById(R.id.btn_add);
        btnView = findViewById(R.id.btn_view);
        lv = findViewById(R.id.lv);

        CustomAdapter adapter = new CustomAdapter(MainActivity.this, weathers);
        lv.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String city = edtCity.getText().toString();
                int nhietDo = Integer.parseInt(edtNhietDo.getText().toString());
                if(city.length() ==0 || edtNhietDo.getText().toString().length() == 0) {
                    Toast.makeText(MainActivity.this, "Bạn nhập thông tin chưa chính xác",Toast.LENGTH_SHORT).show();
                }else {
                    weathers.add(new Weather(city,nhietDo));

                    adapter.notifyDataSetChanged();
                }
            }
        });
    }
}