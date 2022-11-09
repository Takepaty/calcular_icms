package com.empresadelogistica.calcular_icms;

import static com.empresadelogistica.calcular_icms.R.id.editTextValor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mEditTextEstado;
    private EditText mEditTextValor;
    private TextView mTextViewPorcentagem;
    private TextView mTextViewTotal;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextEstado = findViewById(R.id.editTextEstado);
        mEditTextValor = findViewById(editTextValor);
        mTextViewPorcentagem = findViewById(R.id.textViewPorcentagem);
        mTextViewTotal = findViewById(R.id.textViewTotal);
    }


    public void calcular(View view) {
        String estado = mEditTextEstado.getText().toString();

        String valorString = mEditTextValor.getText().toString();
        float valor = Float.parseFloat(valorString);

        float porcentagem = 0;
        switch (estado){
            case "RO":
                porcentagem = 17.5f;
                break;
            case "SP":
                porcentagem = 18;
                break;
            case "RJ":
                porcentagem = 20;
                break;
            case "GO":
                porcentagem = 17;
                break;

        }
        float total = valor +(valor*porcentagem/100);

        mTextViewPorcentagem.setText(String.valueOf(porcentagem)+"%");
        mTextViewTotal.setText(String.format("R$ %.2f", total));
    }
}
