package org.gmele.android.examples.a01basics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class Act2 extends AppCompatActivity implements View.OnClickListener
{

    EditText EtLines;
    EditText EtColumns;
    Button BtDoit;
    HorizontalScrollView HSV;
    TableLayout TlMat;

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.act2_lay);
        EtLines = (EditText) findViewById (R.id.EtLines);
        EtColumns = (EditText) findViewById (R.id.EtCols);
        BtDoit = (Button) findViewById (R.id.BtDoIt);
        BtDoit.setOnClickListener (this);
        HSV = (HorizontalScrollView) findViewById (R.id.SvInternal);
    }

    @Override
    public void onClick (View v)
    {
        if (v == BtDoit)
        {
            int L;
            int C;
            L = Integer.parseInt (EtLines.getText ().toString ());
            C = Integer.parseInt (EtColumns.getText ().toString ());
            TlMat = new TableLayout (this);
            for (int i = 0; i < L; i++)
            {
                TableRow Row = new TableRow (this);
                for (int j = 0; j < C; j++)
                {
                    ImageView img = new ImageView (this);
                    img.setImageResource (R.mipmap.ic_launcher);
                    img.setTag ("Picture: " + (i + 1) + " X " + (j + 1));
                    img.setOnClickListener (this);
                    Row.addView (img);
                }
                TlMat.addView (Row);
            }
            HSV.removeAllViews ();
            HSV.addView (TlMat);
        }
        else
        {
            Toast toast = Toast.makeText (getApplicationContext (), v.getTag ().toString (),
                    Toast.LENGTH_LONG);
            toast.setGravity (Gravity.CENTER, 0, 0);
            toast.show ();
        }
    }
}
