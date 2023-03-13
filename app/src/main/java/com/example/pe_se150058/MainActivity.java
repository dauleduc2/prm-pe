package com.example.pe_se150058;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pe_se150058.adapter.DataAdapter;
import com.example.pe_se150058.dto.CarDTO;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataAdapter handler = new DataAdapter(this, null, null, 1);
//        add table UI
        TableLayout tableLayout = findViewById(R.id.my_table);
        TableRow header = new TableRow(this);
        TextView idHeaderCell = new TextView(this);
        idHeaderCell.setPadding(16, 16, 16, 16);
        idHeaderCell.setBackgroundResource(R.drawable.cell_border);
        idHeaderCell.setTypeface(Typeface.DEFAULT_BOLD);
        idHeaderCell.setText("ID");
        header.addView(idHeaderCell);

        TextView nameHeaderCell = new TextView(this);
        nameHeaderCell.setText("Name");
        nameHeaderCell.setPadding(16, 16, 16, 16);
        nameHeaderCell.setBackgroundResource(R.drawable.cell_border);
        nameHeaderCell.setTypeface(Typeface.DEFAULT_BOLD);
        header.addView(nameHeaderCell);

        TextView priceHeaderCell = new TextView(this);
        priceHeaderCell.setText("Price");
        priceHeaderCell.setPadding(16, 16, 16, 16);
        priceHeaderCell.setBackgroundResource(R.drawable.cell_border);
        priceHeaderCell.setTypeface(Typeface.DEFAULT_BOLD);
        header.addView(priceHeaderCell);

        tableLayout.addView(header);

        List<CarDTO> data = handler.loadDataAdapter();

        for (CarDTO car: data){
            TableRow row = new TableRow(this);
            TextView idCell = new TextView(this);
            idCell.setText(String.valueOf(car.getId()));
            idCell.setPadding(16, 16, 16, 16);
            idCell.setBackgroundResource(R.drawable.cell_border);
            row.addView(idCell);

            TextView nameCell = new TextView(this);
            nameCell.setText(String.valueOf(car.getModel()));
            nameCell.setPadding(16, 16, 16, 16);
            nameCell.setBackgroundResource(R.drawable.cell_border);
            row.addView(nameCell);

            TextView priceCell = new TextView(this);
            priceCell.setText(String.valueOf(car.getPrice()));
            priceCell.setPadding(16, 16, 16, 16);
            priceCell.setBackgroundResource(R.drawable.cell_border);
            row.addView(priceCell);

            tableLayout.addView(row);
        }

    }

    public void addProduct(View view) {
        Intent intent = new Intent(MainActivity.this, AddActivity.class);
        startActivity(intent);
    }
    public void deleteProduct(View view) {
        DataAdapter handler = new DataAdapter(this, null, null, 1);

        List<CarDTO> data = handler.loadDataAdapter();

        if (!data.isEmpty()) {
            Intent intent = new Intent(MainActivity.this, DeleteActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Doesn't have any car to delete!", Toast.LENGTH_SHORT).show();
        }
    }
    public void updateProduct(View view) {
        DataAdapter handler = new DataAdapter(this, null, null, 1);
        List<CarDTO> data = handler.loadDataAdapter();
        if (!data.isEmpty()) {
            Intent intent = new Intent(MainActivity.this, com.example.pe_se150058.UpdateActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Doesn't have any car to update!", Toast.LENGTH_SHORT).show();
        }

    }
}