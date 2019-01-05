package com.example.viraljoshi.calculator;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Variable declaration
    private EditText etx1, etx2;
    private TextView txt_result_value;
    private Button add, sub, mul, div;

    public static final String SHARD_PREFS = "sharedprefs";
    public static final String text = "text";

    private String intNo;
    private boolean switchOn;


    private int num1, num2, res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//Taking references from the xml file of each view controls
        etx1 = (EditText) findViewById(R.id.etx_value1);
        etx2 = (EditText) findViewById(R.id.etx_value2);

        txt_result_value = (TextView) findViewById(R.id.txt_result_value);


        add = (Button) findViewById(R.id.btn_add);
        sub = (Button) findViewById(R.id.btn_sub);
        mul = (Button) findViewById(R.id.btn_mul);
        div = (Button) findViewById(R.id.btn_div);
//       SharedPreferences = getApplicationContext().getSharedPreferences("MyPref", 0);

// On click listener is used when user performs an action by pressing button on runtime
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //As edittext takes only String values. So that has to converted to Integer to take inputs from the user
                num1 = Integer.parseInt(etx1.getText().toString());
                num2 = Integer.parseInt(etx2.getText().toString());
                // Addition of the both the edit text
                res = num1 + num2;
// Results showed on 3rd edit text
                txt_result_value.setText(String.valueOf(res));

            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Integer.parseInt(etx1.getText().toString());
                num2 = Integer.parseInt(etx2.getText().toString());
                res = num1 - num2;
                txt_result_value.setText(String.valueOf(res));

            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Integer.parseInt(etx1.getText().toString());
                num2 = Integer.parseInt(etx2.getText().toString());
                res = num1 * num2;
                txt_result_value.setText(String.valueOf(res));

            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Integer.parseInt(etx1.getText().toString());
                num2 = Integer.parseInt(etx2.getText().toString());
                res = num1 / num2;
                txt_result_value.setText(String.valueOf(res));

            }
        });
        savedata();

    }

    public void savedata() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARD_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(text, String.valueOf(num1));
        editor.putString(text, String.valueOf(num2));
        editor.apply();
        editor.commit();
        Toast.makeText(getApplicationContext(), "Data Saved..", Toast.LENGTH_LONG).show();
    }

    public void loaddata() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARD_PREFS, MODE_PRIVATE);
        intNo = sharedPreferences.getString(text, "");
        Toast.makeText(getApplicationContext(), "Data Loaded..", Toast.LENGTH_LONG).show();
    }

    public void updateViews() {
        etx1.setText("");
    }

}