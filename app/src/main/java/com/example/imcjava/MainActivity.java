package com.example.imcjava;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText pesoEditText;
    private EditText alturaEditText;
    private TextView resultadoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pesoEditText = findViewById(R.id.pesoEditText);
        alturaEditText = findViewById(R.id.alturaEditText);
        resultadoTextView = findViewById(R.id.resultadoTextView);

        Button calcularButton = findViewById(R.id.calcularButton);
        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularIMC();
            }
        });

        Button borrarButton = findViewById(R.id.borrarButton);
        borrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                borrarCampos();
            }
        });

        Button salirButton = findViewById(R.id.salirButton);
        salirButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void calcularIMC() {
        String pesoString = pesoEditText.getText().toString();
        String alturaString = alturaEditText.getText().toString();

        if (!pesoString.isEmpty() && !alturaString.isEmpty()) {
            try {
                double peso = Double.parseDouble(pesoString);
                double altura = Double.parseDouble(alturaString);

                double imc = peso / (altura * altura);
                resultadoTextView.setText(String.format("Tu IMC es: %.2f", imc));
            } catch (NumberFormatException e) {
                Toast.makeText(this,
                        "Los valores ingresados no son válidos", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this,
                    "Favor de ingresar los datos correspondientes", Toast.LENGTH_SHORT).show();
        }
    }

    private void borrarCampos() {
        pesoEditText.setText("");
        alturaEditText.setText("");
        resultadoTextView.setText("");
    }
}
