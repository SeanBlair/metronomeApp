package com.sean.mymetronome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when user taps start **/
    public void start(View view) {
        setStatusText("Start button pressed.");
    }

    /** Called when user taps stop **/
    public void stop(View view) {
        setStatusText("Stop button pressed.");
    }

    private void setStatusText(String str) {
        TextView statusTextView = (TextView) findViewById(R.id.statusText);
        statusTextView.setText(str);
    }
}
