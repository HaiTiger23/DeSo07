package htg.haitran.deso07;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Weather> weathers;
    public CustomAdapter(Context context, ArrayList<Weather> weathers) {
    this.context = context;
    this.weathers = weathers;
    }

    @Override
    public int getCount() {
        return weathers.size();
    }

    @Override
    public Object getItem(int i) {
        return weathers.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.item_layout, viewGroup,false);
        TextView city = (TextView) view.findViewById(R.id.name);
        city.setText(weathers.get(i).getCity());
        TextView nhietdo = (TextView) view.findViewById(R.id.nhietdo);
        TextView status = (TextView) view.findViewById(R.id.status);
        ImageView image = (ImageView) view.findViewById(R.id.image);
        nhietdo.setText(weathers.get(i).getNhietdo()+" *C");
        Button menu = (Button) view.findViewById(R.id.btn_menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(context, viewGroup);
                popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case  R.id.menu_item_1:
                                Toast.makeText(context,"Bạn chọn cập nhật",Toast.LENGTH_SHORT).show();
                                return  true;
                            case R.id.menu_item_2:
                                Toast.makeText(context,"Bạn chọn xóa",Toast.LENGTH_SHORT).show();
                                return  true;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
        if(weathers.get(i).getNhietdo() < 15 ){
          status.setText("Rainy");
          image.setImageResource(R.drawable.ic_baseline_water_24);
        }
            else if(weathers.get(i).getNhietdo() < 30) {
            image.setImageResource(R.drawable.ic_baseline_cloud_24);
            status.setText("Cloudy");
        }
            else {
            image.setImageResource(R.drawable.ic_baseline_wb_sunny_24);
            status.setText("Sunny");

        }

        return view;
    }
}
