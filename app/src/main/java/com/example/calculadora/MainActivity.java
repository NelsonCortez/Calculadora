package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txtRes;
    private EditText txtNum1;
    private EditText txtNum2;
    private Button btnSum;
    private Button btnRes;
    private Button btnMul;
    private Button btnDiv;
    private Float Num1;
    private Float Num2;
    private String Resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtRes = findViewById(R.id.txtRes);
        txtNum1 = findViewById(R.id.txtNum1);
        txtNum2 = findViewById(R.id.txtNum2);
        btnSum = findViewById(R.id.btnSum);
        btnRes = findViewById(R.id.btnRes);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);

        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtRes.setText(calculo(txtNum1.getText().toString().trim(), txtNum2.getText().toString().trim(),"+"));
            }
        });

        btnRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtRes.setText(calculo(txtNum1.getText().toString().trim(), txtNum2.getText().toString().trim(),"-"));
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtRes.setText(calculo(txtNum1.getText().toString().trim(), txtNum2.getText().toString().trim(),"*"));
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtRes.setText(calculo(txtNum1.getText().toString().trim(), txtNum2.getText().toString().trim(),"/"));
            }
        });

    }

    public String calculo(String Numero1, String Numero2, String Operacion){
        if(!Numero1.toString().isEmpty()) {
            Num1 = Float.parseFloat(Numero1.trim());
        }else {
            Num1 = Float.parseFloat("0");
        }
        if(!Numero2.toString().isEmpty()){
            Num2 = Float.parseFloat(Numero2.trim());
        }else{
            Num2 = Float.parseFloat("0");
        }

        switch(Operacion) {
            case "+":
                Resultado = Float.toString ( (Num1 + Num2 ));
                break;
            case "-":
                Resultado = Float.toString ( (Num1 - Num2 ));
                break;
            case "*":
                Resultado = Float.toString ( (Num1 * Num2 ));
                break;
            case "/":
                if (Num2 != 0) {
                    Resultado = Float.toString ( (Num1 / Num2 ));
                }else{
                    Resultado = "Indefinido";
                }
                break;
            default:
                Resultado = Float.toString ( (Num1 + Num2 ));
                break;
        }
        return Resultado ;
    }
}