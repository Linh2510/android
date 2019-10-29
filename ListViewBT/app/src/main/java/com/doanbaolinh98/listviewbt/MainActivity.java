package com.doanbaolinh98.listviewbt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<country> image_details = getListData();
        final ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(new CustomListAdapter(this,image_details));

        // Khi người dùng click vào các ListItem
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                country country = (country) o ;
                Toast.makeText(MainActivity.this, "Selected :" + " " + country, Toast.LENGTH_LONG).show();
            }
        });
    }

    private  List<country> getListData() {
        List<country> list = new ArrayList<country>();
        country cho = new country("Dog", "cho", 400);
        country meo = new country("Cat", "meo", 300);
        country voi = new country("\n" +
                "Elephant", "voi", 15000);
        country ho = new country("Tiger", "ho",3000);

        list.add(cho);
        list.add(meo);
        list.add(voi);
        list.add(ho);

        return list;
    }

}
