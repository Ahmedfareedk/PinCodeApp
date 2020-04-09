package com.example.pincodeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView numZero, numOne, numTwo,
            numThree, numFour, numFive,
            numSix, numSeven, numEight,
            numNine, clearBtn, delBtn,
            passTV, messageTV;
    private ImageView lockImageView;
    private final String CORRECT_PASS = "2332";


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
                if (view == clearBtn) {
                    passTV.setText("");
                    messageTV.setVisibility(View.GONE);
                    lockImageView.setImageResource(R.drawable.ic_locked_black_24dp);
                } else if (view == delBtn) {
                    String currentText = passTV.getText().toString();
                    if (currentText.length() > 0 && currentText.length() < 4) {
                        passTV.setText(currentText.substring(0, currentText.length() - 1));
                    }

                } else {
                    passTV.append(view.getText().toString());
                    if (passTV.getText().toString().equals(CORRECT_PASS)) {
                        messageTV.setText("Welcome");
                        messageTV.setTextColor(getResources().getColor(R.color.right_pass));
                        lockImageView.setImageResource(R.drawable.ic_lock_open_black_24dp);
                        messageTV.setVisibility(View.VISIBLE);
                    } else if (passTV.getText().toString().length() == 4 && !passTV.getText().toString().equals(CORRECT_PASS)) {
                        messageTV.setText("wrong pass!");
                        messageTV.setTextColor(getResources().getColor(R.color.wrong_pass));
                        messageTV.setVisibility(View.VISIBLE);
                    }
                }
            }

        };


    }
}
