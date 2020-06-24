package com.tis91d.appgeo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText txbBoxX1;
    private EditText txbBoxY1;
    private EditText txbBoxX2;
    private EditText txbBoxY2;
    private EditText txbD;
    private EditText txbI;
    private Button btnCalcular;



    private void iniciar(){

        txbBoxX1 = (EditText)findViewById(R.id.txtBoxX1);
        txbBoxY1 = (EditText)findViewById(R.id.txtBoxY1);
        txbBoxX2 = (EditText)findViewById(R.id.txtBoxX2);
        txbBoxY2 = (EditText)findViewById(R.id.txtBoxY2);
        txbD = (EditText)findViewById(R.id.txbDistancia);
        txbI = (EditText)findViewById(R.id.txbInclinacion);

        // Inicializamos el Boton:

        btnCalcular = (Button)findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calcular();
            }
        });

    }

    private void calcular(){



        int x1 = Integer.parseInt(txbBoxX1.getText().toString());
        int y1 = Integer.parseInt(txbBoxY1.getText().toString());
        int x2 = Integer.parseInt(txbBoxX2.getText().toString());
        int y2 = Integer.parseInt(txbBoxY2.getText().toString());
        double distancia = 0;
        double inclinacion = 0;

        distancia =  Math.sqrt(((x1 - x2 )*(x1-x2))+((y1 - y2 )*(y1-y2)));
        inclinacion = (y2 -y1);
        inclinacion = inclinacion / (x2-x1);


        txbD.setText(String.valueOf(distancia));
        txbI.setText(String.valueOf(inclinacion));


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciar();
    }
}