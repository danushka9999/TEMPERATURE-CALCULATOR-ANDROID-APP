package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_value;
    RadioButton btn_celsius;
    RadioButton btn_faranhite;
    Button btn_calculate;
    TextView et_final;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_value = findViewById(R.id.et_value);
        btn_celsius = findViewById(R.id.btn_celsius);
        btn_faranhite = findViewById(R.id.btn_faranhite);
        btn_calculate = findViewById(R.id.btn_calculate);
        et_final = findViewById(R.id.et_final);


    }

    @Override
    protected void onResume() {
        super.onResume();
        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calculateAnswer();
            }
        });
    }
    private void calculateAnswer(){
        Calculation calculation = new Calculation();
        String temp_value = et_value.getText().toString();

        if(TextUtils.isEmpty(temp_value)){
            Toast.makeText(this, "Please enter a temperature value", Toast.LENGTH_LONG).show();
            temp_value = "0.0";
            et_final.setText(temp_value);
        }
        else{
            try{
                float temp = Float.parseFloat(temp_value);

                if(btn_celsius.isChecked()){
                    temp = calculation.convertFahrenheitToCelcius(temp);
                }else if(btn_faranhite.isChecked()){
                    temp = calculation.convertCelciusToFahrenheit(temp);
                }else{
                    Toast.makeText( this, "Select Radio", Toast.LENGTH_LONG).show();
                    temp = 0.0f;
                }
                et_final.setText(new Float(temp).toString());
            }catch(NullPointerException e){}
        }
    }


}