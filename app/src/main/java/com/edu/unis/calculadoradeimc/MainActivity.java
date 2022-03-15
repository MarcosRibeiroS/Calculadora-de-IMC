package com.edu.unis.calculadoradeimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editPeso;
    EditText editAltura;
    TextView textResultado;
    Button btncalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CarregarCompontes();
        CalcularValores();

    }

    public void CarregarCompontes() {

        editPeso = findViewById(R.id.editPeso);
        editAltura = findViewById(R.id.editAltura);
        textResultado = findViewById(R.id.textResultado);
        btncalcular = findViewById(R.id.button);
    }

    public void CalcularValores() {
        btncalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resultado = calcularIMC();
                Log.d("resultado", resultado);
                exibiCalculo(resultado);
                LimparCampos();
            }

            public String calcularIMC() {

                double peso = Double.parseDouble(editPeso.getText().toString());
                double altura = Double.parseDouble(editAltura.getText().toString());

                double resultado = peso / (altura * altura);
                /*IMC = peso/(altura*altura)*/
                String texto = "Valores inválidos, tente novamente!";
                if (resultado < 16)
                    texto = "Magreza grave";
                else if (resultado >= 16 && resultado < 17)
                    texto = "Magreza moderada";
                else if (resultado >= 17 && resultado < 18.5)
                    texto = "Magreza leve";
                else if (resultado >= 18.5 && resultado < 25)
                    texto = "Saudável";
                else if (resultado >= 25 && resultado < 30)
                    texto = "Sobrepeso";
                else if (resultado >= 30 && resultado < 35)
                    texto = "Obesidade Grau I";
                else if (resultado >= 35 && resultado < 40)
                    texto = "Obesidade Grau I";
                else if (resultado >= 40)
                    texto = "Obesidade Grau I";
                else texto = "Valores inválidos, tente novamente!";
                return texto;
            }

            protected void exibiCalculo(String resultado) {
                textResultado.setText(resultado);
            }

            public void LimparCampos() {
                editAltura.setText("");
                editPeso.setText("");

            }


        });
    }
}