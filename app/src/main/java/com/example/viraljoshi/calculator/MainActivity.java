package com.example.viraljoshi.calculator;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Variable declaration
    private EditText etxValue1, etxValue2;
    private TextView txtResultValue;
    private Button btnAdd, btnSub, btnMul, btnDiv;

    public static final String SHARD_PREFS = "sharedprefs";
    public static final String VALUE1 = "value1";
    public static final String VALUE2 = "value2";
    public static final String ADD = "addditon";
    public static final String SUB = "substraction";
    public static final String MUL = "multiplication";
    public static final String DIV = "division";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etxValue1 = (EditText) findViewById(R.id.etx_value1);
        etxValue2 = (EditText) findViewById(R.id.etx_value2);

        txtResultValue = (TextView) findViewById(R.id.txt_result_value);

        btnAdd = (Button) findViewById(R.id.btn_add);
        btnSub = (Button) findViewById(R.id.btn_sub);
        btnMul = (Button) findViewById(R.id.btn_mul);
        btnDiv = (Button) findViewById(R.id.btn_div);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation(ADD);
            }


        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation(SUB);
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation(MUL);
            }
        });


        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation(DIV);
            }
        });
        loadData();

    }

    public void operation(String calculation) {

        if (TextUtils.isEmpty(etxValue1.getText().toString()) || TextUtils.isEmpty(etxValue2.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please Enter data in both the Box..", Toast.LENGTH_LONG).show();
        } else {

            int etxNum1 = Integer.parseInt(etxValue1.getText().toString());
            int etxNum2 = Integer.parseInt(etxValue2.getText().toString());
            int etxRes;
            if (calculation.equals(ADD)) {

                etxRes = etxNum1 + etxNum2;
                txtResultValue.setText(String.valueOf(etxRes));
            } else if (calculation.equals(SUB)) {

                etxRes = etxNum1 - etxNum2;
                txtResultValue.setText(String.valueOf(etxRes));
            } else if (calculation.equals(MUL)) {
                etxRes = etxNum1 * etxNum2;
                txtResultValue.setText(String.valueOf(etxRes));
            } else if (calculation.equals(DIV)) {

                etxRes = etxNum1 / etxNum2;
                txtResultValue.setText(String.valueOf(etxRes));
            }
            saveData();

        }


    }


    public void saveData() {

        SharedPreferences sharedPreferences = getSharedPreferences(SHARD_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(VALUE1, etxValue1.getText().toString());
        editor.putString(VALUE2, etxValue2.getText().toString());
        editor.apply();
        editor.commit();
        Toast.makeText(getApplicationContext(), "Data Saved..", Toast.LENGTH_LONG).show();

    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARD_PREFS, MODE_PRIVATE);
        String intNo1 = sharedPreferences.getString(VALUE1, "");
        etxValue1.setText(intNo1);
        String intNo2 = sharedPreferences.getString(VALUE2, "");
        etxValue2.setText(intNo2);
    }


}