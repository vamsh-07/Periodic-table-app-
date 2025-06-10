package com.example.periodictable;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.periodictable.model.Element;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    ArrayList<Element> elements = new ArrayList<>();
    ListView listView;
    ElementAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.element_list);
        loadElementsFromJSON();
        adapter = new ElementAdapter(this, elements);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Element selected = elements.get(position);
            Intent intent = new Intent(MainActivity.this, ElementDetailActivity.class);
            intent.putExtra("element", selected);
            startActivity(intent);
        });
    }

    private void loadElementsFromJSON() {
        try {
            InputStream is = getAssets().open("elements.json");
            String json = new Scanner(is).useDelimiter("\\A").next();
            JSONArray array = new JSONArray(json);
            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);
                elements.add(new Element(
                        obj.getString("name"),
                        obj.getString("symbol"),
                        obj.getInt("atomicNumber"),
                        obj.getDouble("atomicMass")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
