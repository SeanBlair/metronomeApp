package com.sean.mymetronome;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int silencesToRepeat = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when user taps start **/
    public void start(View view) {
        setStatusText("Start button pressed.");
        startClick();
    }

    /** Called when user taps stop **/
    public void stop(View view) {
        setStatusText("Stop button pressed.");
    }

    private void setStatusText(String str) {
        TextView statusTextView = (TextView) findViewById(R.id.statusText);
        statusTextView.setText(str);
    }

    private void startClick() {
        Thread mThread = new Thread(new Runnable() {
            public void run() {
                final MediaPlayer click = MediaPlayer.create(getApplicationContext(), R.raw.click100msloud);
                final MediaPlayer silence = MediaPlayer.create(getApplicationContext(), R.raw.silence100ms);
                final int[] numSilences = {silencesToRepeat};

                click.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        silence.start();
                    }
                });

                silence.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        if (numSilences[0] > 0) {
                            numSilences[0] = numSilences[0] - 1;
                            silence.start();
                        } else {
                            numSilences[0] = silencesToRepeat;
                            click.start();
                        }
                    }
                });
                click.start();
            }
        });
        mThread.start();
    }
}
