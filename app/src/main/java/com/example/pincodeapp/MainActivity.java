package com.example.pincodeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextView numZero, numOne, numTwo,
            numThree, numFour, numFive,
            numSix, numSeven, numEight,
            numNine, clearBtn, delBtn,
            passTV, messageTV;
    private ImageView lockImageView;
    private final String CORRECT_PASS = "2332";
    private int counter = 0, attempt =2;
    private final int MILLI_SECONDS = 16000;
    private CountDownTimer timer;
    private long timeLeftInMillis = MILLI_SECONDS;
    private boolean isTimeRunning;
    private LinearLayout parentView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numZero = findViewById(R.id.num_zero);
        numOne = findViewById(R.id.num_one);
        numTwo = findViewById(R.id.num_two);
        numThree = findViewById(R.id.num_three);
        numFour = findViewById(R.id.num_four);
        numFive = findViewById(R.id.num_five);
        numSix = findViewById(R.id.num_six);
        numSeven = findViewById(R.id.num_seven);
        numEight = findViewById(R.id.num_eight);
        numNine = findViewById(R.id.num_nine);
        clearBtn = findViewById(R.id.clear_btn);
        delBtn = findViewById(R.id.del_btn);
        passTV = findViewById(R.id.pass_ET);
        messageTV = findViewById(R.id.message_TV);
        lockImageView = findViewById(R.id.locker);
        lockImageView = findViewById(R.id.locker);
        parentView = findViewById(R.id.linear_parent);


        numZero.setOnClickListener(appendToPassTv(numZero));
        numOne.setOnClickListener(appendToPassTv(numOne));
        numTwo.setOnClickListener(appendToPassTv(numTwo));
        numThree.setOnClickListener(appendToPassTv(numThree));
        numFour.setOnClickListener(appendToPassTv(numFour));
        numFive.setOnClickListener(appendToPassTv(numFive));
        numSix.setOnClickListener(appendToPassTv(numSix));
        numSeven.setOnClickListener(appendToPassTv(numSeven));
        numEight.setOnClickListener(appendToPassTv(numEight));
        numNine.setOnClickListener(appendToPassTv(numNine));
        clearBtn.setOnClickListener(appendToPassTv(clearBtn));
        delBtn.setOnClickListener(appendToPassTv(delBtn));


    }

    private View.OnClickListener appendToPassTv(final TextView view) {



        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (view == clearBtn && !isTimeRunning) {
                    passTV.setText("");
                    messageTV.setVisibility(View.GONE);
                    lockImageView.setImageResource(R.drawable.ic_locked_black_24dp);
                } else if (view == delBtn) {
                    String currentText = passTV.getText().toString();
                    if (currentText.length() > 0 && currentText.length() < 4) {
                        passTV.setText(currentText.substring(0, currentText.length() - 1));
                    }

                } else {
                    if(!isTimeRunning)
                        passTV.append(view.getText().toString());
                    else {
                        parentView.setFocusable(false);
                        parentView.setClickable(false);
                    }

                    if (passTV.getText().toString().equals(CORRECT_PASS)) {
                        counter =0;
                        messageTV.setText("Welcome");
                        messageTV.setTextColor(getResources().getColor(R.color.right_pass));
                        lockImageView.setImageResource(R.drawable.ic_lock_open_black_24dp);
                        messageTV.setVisibility(View.VISIBLE);



                    } else if (passTV.getText().toString().length() == 4 && !passTV.getText().toString().equals(CORRECT_PASS)) {

                        messageTV.setText("wrong pass!");
                        messageTV.setTextColor(getResources().getColor(R.color.wrong_pass));
                        messageTV.setVisibility(View.VISIBLE);
                        counter++;
                        if(attempt > 0)
                        Toast.makeText(MainActivity.this, "you have "+attempt+" attempts left", Toast.LENGTH_SHORT).show();
                        passTV.setText("");
                        attempt--;
                    }

                    if(counter == 3){
                        startTimer();
                    }
                }
            }
        };


    }

    private void startTimer(){
        timer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
               int secenod = (int) (timeLeftInMillis / 1000) % 60;
                String timeFormat = String.format(Locale.getDefault(), "%02d", secenod);
                messageTV.setTextColor(getResources().getColor(R.color.light_gray));
                messageTV.setText("Try again after " + timeFormat + " seconds");
            }

            @Override
            public void onFinish() {
                isTimeRunning = false;
                counter = 0;
                attempt = 2;
                messageTV.setVisibility(View.GONE);
                timeLeftInMillis = MILLI_SECONDS;
            }
        }.start();
        isTimeRunning = true;
    }
}
