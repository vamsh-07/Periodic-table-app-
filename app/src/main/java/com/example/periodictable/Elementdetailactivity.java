package com.example.periodictable;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.periodictable.model.Element;

public class ElementDetailActivity extends AppCompatActivity {

    TextView name, symbol, number, mass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element_detail);

        Element element = (Element) getIntent().getSerializableExtra("element");

        name = findViewById(R.id.element_name);
        symbol = findViewById(R.id.element_symbol);
        number = findViewById(R.id.atomic_number);
        mass = findViewById(R.id.atomic_mass);

        name.setText("Name: " + element.getName());
        symbol.setText("Symbol: " + element.getSymbol());
        number.setText("Atomic Number: " + element.getAtomicNumber());
        mass.setText("Atomic Mass: " + element.getAtomicMass());
    }
}
