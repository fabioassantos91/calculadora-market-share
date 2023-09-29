package com.example.calculadorashare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textResultado;
    private EditText editMotorola;
    private EditText editSamsung;
    private EditText editApple;
    private EditText editOutros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textResultado = findViewById(R.id.textResultado);
        editMotorola = findViewById(R.id.editMotorola);
        editSamsung = findViewById(R.id.editSamsung);
        editApple = findViewById(R.id.editApple);
        editOutros = findViewById(R.id.editOutros);

    }

    public void calcularMarketShare(View view) {
        // Get the sales information from the user.
        int motorolaSales = Integer.parseInt(editMotorola.getText().toString());
        int samsungSales = Integer.parseInt(editSamsung.getText().toString());
        int appleSales = Integer.parseInt(editApple.getText().toString());
        int outrosSales = Integer.parseInt(editOutros.getText().toString());

        // Calculate the percentages for each company.
        int totalSales = motorolaSales + samsungSales + appleSales + outrosSales;
        double motorolaPercentage = (double) motorolaSales / totalSales * 100;
        double samsungPercentage = (double) samsungSales / totalSales * 100;
        double applePercentage = (double) appleSales / totalSales * 100;
        double outrosPercentage = (double) outrosSales / totalSales * 100;

        textResultado.setText("Motorola: " + String.format("%.2f", motorolaPercentage) + "%\n" +
                "Samsung: " + String.format("%.2f", samsungPercentage) + "%\n" +
                "Apple: " + String.format("%.2f", applePercentage) + "%\n" +
                "Outros: " + String.format("%.2f", outrosPercentage) + "%");

        // Hide the keyboard after the user clicks the "CALCULAR" button.
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(editOutros.getWindowToken(), 0);

    }
}