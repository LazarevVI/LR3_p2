package com.example.lr3_p2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<String> oil_type_list = new ArrayList<String>();
    public ArrayList<String> oil_spin_list = new ArrayList<String>();
    public ArrayList<Integer> oil_price_list = new ArrayList<Integer>();
    public ArrayList<Integer> oil_volume_list = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        oil_price_list.add(10);
        oil_price_list.add(20);
        oil_price_list.add(30);

        oil_spin_list.add("АИ 80");
        oil_spin_list.add("АИ 92");
        oil_spin_list.add("АИ 95");

    }

    public void OnClickNew(View v) {

        Spinner spin = findViewById(R.id.spinner_id);
        EditText volume = findViewById(R.id.volume_id);
        TextView result = findViewById(R.id.result_id);

        if (volume.length()==0)
        {
            Toast toast = Toast.makeText(this, "Укажите количестсво!",Toast.LENGTH_LONG);
            toast.show();
        }
        else {
            oil_type_list.add(spin.getSelectedItem().toString());
            oil_volume_list.add(Integer.parseInt(volume.getText().toString()));

            volume.setText("");
            result.setText("");
        }
    }

    public void OnClickClose(View v) {
        Double summa = 0.0;

        Double summa1 = 0.0;
        Double summa2 = 0.0;
        Double summa3 = 0.0;

        Double vol1 = 0.0;
        Double vol2 = 0.0;
        Double vol3 = 0.0;

        TextView result = findViewById(R.id.result_id);

        for (int i = 0; i < oil_type_list.size(); i++)
        {
            switch(oil_type_list.get(i)) {
                case "АИ 80":
                    summa += oil_volume_list.get(i) * oil_price_list.get(0);
                    summa1 += oil_volume_list.get(i) * oil_price_list.get(0);
                    vol1 += oil_volume_list.get(i);
                    break;
                case "АИ 92":
                    summa += oil_volume_list.get(i) * oil_price_list.get(1);
                    summa2 += oil_volume_list.get(i) * oil_price_list.get(1);
                    vol2 += oil_volume_list.get(i);
                    break;
                case "АИ 95":
                    summa += oil_volume_list.get(i) * oil_price_list.get(2);
                    summa3 += oil_volume_list.get(i) * oil_price_list.get(2);
                    vol3 += oil_volume_list.get(i);
                    break;
            }
        }

        String set_test = "Вид  Сумма Количество"
                + System.getProperty("line.separator")

                +oil_spin_list.get(0).toString() + "  "
                + summa1 + "  "
                + vol1 + "  "
                + System.getProperty("line.separator")

                + oil_spin_list.get(1).toString() + "  "
                + summa2 + "  "
                + vol2 + "  "
                + System.getProperty("line.separator")

                + oil_spin_list.get(2).toString() + "  "
                + summa3 + "  "
                + vol3 + "  "
                + System.getProperty("line.separator")

                + "Общая выручка: " + summa;

        result.setText(set_test);

        oil_volume_list.clear();
        oil_type_list.clear();

    }
}