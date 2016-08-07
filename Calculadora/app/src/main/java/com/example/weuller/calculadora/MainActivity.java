package com.example.weuller.calculadora;

import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements View.OnClickListener{

    private EditText edtValor1;
    private EditText edtValor2;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //configura qual página está linkada com esse arquivo
        setContentView(R.layout.act_layout);

        //Recuperando elementos da tela
        edtValor1 = (EditText) findViewById(R.id.edtValor1);
        edtValor2 = (EditText) findViewById(R.id.edtValor2);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);

        //configurando o botão para ouvir o evento de click
        btnCalcular.setOnClickListener(this);

    }

    //método implementado para capturar o evento de click do botão
    @Override
    public void onClick(View v) {

        if (edtValor1.getText().toString().trim().isEmpty() || edtValor2.getText().toString().trim().isEmpty() ){

            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setMessage("Favor preencher ambos os valores");
            dialog.setNeutralButton("OK", null);
            dialog.show();

            return;
        }

        //recuperando valor digitado no campo de texto 1 e convertendo para double
        double valor1 = Double.parseDouble(edtValor1.getText().toString());

        //recuperando valor digitado no campo de texto 2 e convertendo para double
        double valor2 = Double.parseDouble(edtValor2.getText().toString());

        double resultado = valor1 + valor2;

        //criando componente de dialog para exibir resultado da operação
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage("Valor somado: " + resultado);
        dialog.setNeutralButton("OK", null);
        dialog.show();

    }
}
