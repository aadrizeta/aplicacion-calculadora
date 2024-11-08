package com.aadrizeta.mycalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        //Crear instancias de los botones
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        TextView pantalla = (TextView) findViewById(R.id.Pantalla);
        pantalla.setText("0");
        TextView pantalla2 = (TextView) findViewById(R.id.Pantalla2);
        Toast msgError = Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT);
        TextView textViewOperador = (TextView) findViewById(R.id.textViewOperador);
        textViewOperador.setText("");
        boolean result = false;


        Button boton0 = (Button) findViewById(R.id.button0);
        Button boton1 = (Button) findViewById(R.id.button1);
        Button boton2 = (Button) findViewById(R.id.button2);
        Button boton3 = (Button) findViewById(R.id.button3);
        Button boton4 = (Button) findViewById(R.id.button4);
        Button boton5 = (Button) findViewById(R.id.button5);
        Button boton6 = (Button) findViewById(R.id.button6);
        Button boton7 = (Button) findViewById(R.id.button7);
        Button boton8 = (Button) findViewById(R.id.button8);
        Button boton9 = (Button) findViewById(R.id.button9);
        Button botonSumar = (Button) findViewById(R.id.buttonSumar);
        Button botonRestar = (Button) findViewById(R.id.buttonRestar);
        Button botonMultiplicar = (Button) findViewById(R.id.buttonMultiplicar);
        Button botonDivision = (Button) findViewById(R.id.buttonDividir);
        Button botonComa = (Button) findViewById(R.id.buttonComa);
        Button botonResultado = (Button) findViewById(R.id.buttonResultado);
        Button botonReset = (Button) findViewById(R.id.buttonReset);
        Button botonBorrar = (Button) findViewById(R.id.buttonBorrar);

        botonSumar.setTag("+");
        botonRestar.setTag("-");
        botonMultiplicar.setTag("X");
        botonDivision.setTag("/");


        ArrayList<Button> botonesNum = new ArrayList<>();
        botonesNum.add(boton0);
        botonesNum.add(boton1);
        botonesNum.add(boton2);
        botonesNum.add(boton3);
        botonesNum.add(boton4);
        botonesNum.add(boton5);
        botonesNum.add(boton6);
        botonesNum.add(boton7);
        botonesNum.add(boton8);
        botonesNum.add(boton9);

        ArrayList<Button> botonesOp = new ArrayList<>();
        botonesOp.add(botonSumar);
        botonesOp.add(botonRestar);
        botonesOp.add(botonMultiplicar);
        botonesOp.add(botonDivision);

        for(Button boton : botonesOp){
            boton.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onClick(View view) {
                    //Comprobar si la pantalla está vacia
                    if(pantalla.getText().toString().equals("0")){
                        msgError.show();
                    } else {
                        CharSequence operador = (String) view.getTag();
                        pantalla2.setText(pantalla.getText());
                        textViewOperador.setText(operador);
                        pantalla.setText("");
                    }
                }
            });
        }

        for (Button boton : botonesNum){
            boton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    CharSequence digito = getResources().getResourceEntryName(view.getId()).substring(getResources().getResourceEntryName(view.getId()).length() - 1);

                    if (pantalla.getText().toString().equals("0")){
                        pantalla.setText(digito);
                    } else {
                        pantalla.append(digito);
                    }
                }
            });
        }
        botonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pantalla.setText("0");
                pantalla2.setText("");
                textViewOperador.setText("");
            }
        });
        botonBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!pantalla.getText().toString().equals("0")){
                    pantalla.setText(pantalla.getText().toString().substring(0, pantalla.getText().toString().length() - 1));
                    if(pantalla.getText().toString().isEmpty()){
                        pantalla.setText("0");
                    }
                }

            }

        });
        botonResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!pantalla.getText().toString().isEmpty() || !pantalla2.getText().toString().isEmpty() || !textViewOperador.getText().toString().isEmpty()){
                    int num1 = Integer.parseInt(pantalla2.getText().toString());
                    int num2 = Integer.parseInt(pantalla.getText().toString());
                    String operador = textViewOperador.getText().toString();
                    int resultado = 0;
                    switch (operador){
                        case "+":
                            resultado = num1 + num2;
                            break;
                        case "-":
                            resultado = num1 - num2;
                            break;
                        case "X":
                            resultado = num1 * num2;
                            break;
                        case "/":
                            if (!(num2 == 0)){
                                resultado = num1 / num2;
                            } else {
                                msgError.show();
                            }
                    }
                    pantalla.setText(String.valueOf(resultado));
                    pantalla2.setText("");
                    textViewOperador.setText("");
                }
            }
        });

    }
}
