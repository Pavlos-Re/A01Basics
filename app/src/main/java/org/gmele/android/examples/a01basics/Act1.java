package org.gmele.android.examples.a01basics;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class Act1 extends AppCompatActivity implements View.OnClickListener {

    EditText EtN1;
    EditText EtN2;
    TextView TvRes;
    Button BtPlus;
    Button BtMinus;
    Button BtNext;
    Button BtMul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act1_lay);
        EtN1 = (EditText) findViewById(R.id.EtNum1);
        EtN2 = (EditText) findViewById(R.id.EtNum2);
        TvRes = (TextView) findViewById(R.id.TvResult);
        BtPlus = (Button) findViewById(R.id.BtPlus);
        BtMinus = (Button) findViewById(R.id.BtMinus);
        BtMul = (Button) findViewById(R.id.BtMul);
        BtNext = (Button) findViewById(R.id.BtNext);
        BtPlus.setOnClickListener(this);
        BtMinus.setOnClickListener(this);
        BtMul.setOnClickListener(this);
        BtNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Act2.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v == BtPlus) {
            if ((EtN1.getText().toString() !=  null) && (EtN2.getText().toString() != null) ) {
                
            int Αριθμ1 = Integer.parseInt(EtN1.getText().toString());
            int Αριθμ2 = Integer.parseInt(EtN2.getText().toString());
                TvRes.setText("Άθροισμα : " + (Αριθμ1 + Αριθμ2));
            }
        }

        if (v == BtMinus) {
            int Num1 = Integer.parseInt(EtN1.getText().toString());
            int Num2 = Integer.parseInt(EtN2.getText().toString());
            TvRes.setText("Διαφορά : " + (Num1 - Num2));
        }

        if (v == BtMul) {
            int Num1 = Integer.parseInt(EtN1.getText().toString());
            int Num2 = Integer.parseInt(EtN2.getText().toString());
            TvRes.setText("Πολλαπλασιαμός: " + (Num1 * Num2));
        }
    }

    public void ChColor(View V) {
        Random Ra = new Random();
        int color = Color.argb(255, Ra.nextInt(256), Ra.nextInt(256), Ra.nextInt(256));
        ((TextView) V).setTextColor(color);
    }

}
