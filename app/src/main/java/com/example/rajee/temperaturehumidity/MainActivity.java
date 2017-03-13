package com.example.rajee.temperaturehumidity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_set = (Button) findViewById(R.id.set);
        btn_set.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                intent.setAction("com.example.broadcast.MY_NOTIFICATION");
                EditText temp = (EditText) findViewById(R.id.temperature);
                EditText humidity = (EditText) findViewById(R.id.humidity);
                intent.putExtra("temperature", temp.getText().toString());
                intent.putExtra("humidity", humidity.getText().toString());
                sendBroadcast(intent);
            }
        });

        Button btn_cancel = (Button) findViewById(R.id.cancel);
        btn_cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
