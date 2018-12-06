package com.example.android.bluetoothlegatt;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends Activity {
    private Button button1;
    private Button button2;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openThird_Activity();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFourth_Activity();
            }
        });
    }

    public void openMain() {
        Intent intent = new Intent(this, DeviceScanActivity.class);
        startActivity(intent);
    }
    public void openThird_Activity() {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }
    public void openFourth_Activity() {
        Intent intent = new Intent(this, Fourth_Activity.class);
        startActivity(intent);
    }
}
