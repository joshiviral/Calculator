package com.example.viraljoshi.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Variable declaration
    private EditText etx1, etx2, etx3;
    private Button add, sub, mul, div, submit;

    private int num1, num2, res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//Taking references from the xml file of each view controls
        etx1 = (EditText) findViewById(R.id.etx_value1);
        etx2 = (EditText) findViewById(R.id.etx_value2);
        etx3 = (EditText) findViewById(R.id.etx_result);

        add = (Button) findViewById(R.id.btn_add);
        sub = (Button) findViewById(R.id.btn_sub);
        mul = (Button) findViewById(R.id.btn_mul);
        div = (Button) findViewById(R.id.btn_div);
        submit = (Button) findViewById(R.id.btn_submit);

// On click listener is used when user performs an action by pressing button on runtime
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //As edittext takes only String values. So that has to converted to Integer to take inputs from the user
                num1 = Integer.parseInt(etx1.getText().toString());
                num2 = Integer.parseInt(etx2.getText().toString());

                // Addition of the both the edit text
                res = num1 + num2;
// Results showed on 3rd edit textg
                etx3.setText(String.valueOf(res));

            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Integer.parseInt(etx1.getText().toString());
                num2 = Integer.parseInt(etx2.getText().toString());
                res = num1 - num2;

                etx3.setText(String.valueOf(res));
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Integer.parseInt(etx1.getText().toString());
                num2 = Integer.parseInt(etx2.getText().toString());
                res = num1 * num2;

                etx3.setText(String.valueOf(res));
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Integer.parseInt(etx1.getText().toString());
                num2 = Integer.parseInt(etx2.getText().toString());
                res = num1 / num2;

                etx3.setText(String.valueOf(res));
            }
        });
    }
}