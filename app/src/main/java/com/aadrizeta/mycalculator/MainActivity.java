package com.aadrizeta.mycalculator;

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
        Toast msgError = Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT);


        Button boton0 = (Button) findViewById(R.id.button0);
        Button boton1 = (Button) findViewById(R.id.buttonReset);
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
        Button botonDivision = (Button) findViewById(R.id.buttonDivision);
        Button botonComa = (Button) findViewById(R.id.buttonComa);
        Button botonResultado = (Button) findViewById(R.id.buttonResultado);

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
                @Override
                public void onClick(View view) {
                    //Comprobar si la pantalla está vacia
                    if(pantalla.getText().toString().equals("0")){
                        msgError.show();
                    } else {
                        pantalla.append(boton.getText().toString());
                    }
                }
            });
        }

        for (Button boton : botonesNum){
            boton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    String buttonID = getResources().getResourceEntryName(view.getId());
                    String digito = buttonID.substring(buttonID.length() - 1);

                    if (pantalla.getText().equals("0")){
                        pantalla.setText(digito);
                    } else {
                        pantalla.append(digito);
                    }

                }
            });
        }


    }
}
