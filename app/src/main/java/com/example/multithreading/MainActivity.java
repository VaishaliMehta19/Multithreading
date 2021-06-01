package com.example.multithreading;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progress;
    private TextView T1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progress = (ProgressBar) findViewById(R.id.progressBar);
        T1 = (TextView) findViewById(R.id.txtdis);

    }

    public void startprogress(View view) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 0; i++) {
                    final int value = i;
                    doSomeWork();
                    progress.post(new Runnable() {
                        @Override
                        public void run() {
                            T1.setText("updating");
                            progress.setProgress(value);

                        }
                    });
                }
            }
        };
           new Thread(runnable).start();

    }
    
    private void doSomeWork(){
        try{
            Thread.sleep(2000);
        }
        catch(Exception e){

        }
    }
}
