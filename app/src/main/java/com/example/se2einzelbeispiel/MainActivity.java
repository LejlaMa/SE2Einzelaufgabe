package com.example.se2einzelbeispiel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText input;
    TextView response;
    Button sendBtn;
    Button calcBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText) findViewById(R.id.input);
        response = (TextView) findViewById(R.id.response);
        sendBtn = (Button) findViewById(R.id.sendBtn);
        calcBtn = (Button) findViewById(R.id.calcBtn);
    }
}
