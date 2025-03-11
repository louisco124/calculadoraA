package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText num1, num2;
    private Spinner operador;
    private TextView resultado;
    private Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        operador = findViewById(R.id.operador);
        resultado = findViewById(R.id.resultado);
        calcular = findViewById(R.id.calcular);

        String[] operadores = {"+", "-", "*", "/"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, operadores);
        operador.setAdapter(adapter);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularResultado();
            }
        });
    }

    private void calcularResultado() {
        String input1 = num1.getText().toString();
        String input2 = num2.getText().toString();

        if (input1.isEmpty() || input2.isEmpty()) {
            resultado.setText("Ingrese ambos números");
            return;
        }

        double numero1 = Double.parseDouble(input1);
        double numero2 = Double.parseDouble(input2);
        String operadorSeleccionado = operador.getSelectedItem().toString();
        double resultadoOperacion = 0;

        switch (operadorSeleccionado) {
            case "+":
                resultadoOperacion = numero1 + numero2;
                break;
            case "-":
                resultadoOperacion = numero1 - numero2;
                break;
            case "*":
                resultadoOperacion = numero1 * numero2;
                break;
            case "/":
                if (numero2 != 0) {
                    resultadoOperacion = numero1 / numero2;
                } else {
                    resultado.setText("Error: División por 0");
                    return;
                }
                break;
        }
        resultado.setText("Resultado: " + resultadoOperacion);
    }
}
