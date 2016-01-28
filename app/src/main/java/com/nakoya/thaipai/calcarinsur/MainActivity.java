package com.nakoya.thaipai.calcarinsur;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    private Button btnCar, btnPiup210, btnPiup320, btnVan;
    Intent calCar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCar = (Button)findViewById(R.id.buttonCar);
        btnPiup210 = (Button)findViewById(R.id.buttonPiup210);
        btnPiup320 = (Button)findViewById(R.id.buttonPiup320);
        btnVan = (Button)findViewById(R.id.buttonVan);
        btnCar.setText(R.string.car);
        btnPiup210.setText(R.string.piup210);
        btnPiup320.setText(R.string.piup320);

        btnCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calCar = new Intent(MainActivity.this, CalCarActivity.class);
                startActivity(calCar);
            }
        });
        btnPiup210.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calCar = new Intent(MainActivity.this, CalCarActivity.class);
                startActivity(calCar);
            }
        });
        btnPiup320.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calCar = new Intent(MainActivity.this, CalCarActivity.class);
                startActivity(calCar);
            }
        });
    }
}
