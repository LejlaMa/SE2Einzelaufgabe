package com.example.se2einzelbeispiel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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

    public void buttonOnClick(View v) {

        char [] el = input.getText().toString().toCharArray();

        StringBuilder result = new StringBuilder();

        //output only those digits that are prime numbers
        for (int i = 0; i <= el.length-1; i++){
            if (isPrime(Character.getNumericValue(el[i]))) {
                result.append(el[i]);
            }
        }

        response.setText("Die Matrikelnummer ausschließlich mit Ziffern, die Primzahlen sind, lautet: " + result.toString());

    }

    //checking for prime numbers
    public boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num == 2 || num == 3) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(num) + 1;
        for (int i = 3; i < sqrt; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;

    }


    public void sendOnCLick(View v) {

        String mnr = input.getText().toString();
        TCP tcp = new TCP(mnr);

        Thread t = new Thread(tcp);
        t.start();

        try {

            t.join();
            if (tcp.modifiedSentence != null) {
                response.setText(tcp.modifiedSentence);
            }

        } catch (InterruptedException ie) {

            ie.printStackTrace();
            response.setText("Verbindung fehlgeschlagen.");

        }

        System.out.println(t.getState());

    }
}
