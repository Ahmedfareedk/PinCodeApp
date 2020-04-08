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
            passTV;
    ImageView lockImageView;


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
                } else if (view == delBtn ) {
                    String currentText = passTV.getText().toString();
                  if(currentText.length() > 0)
                    passTV.setText(currentText.substring(0, currentText.length()-1));

                } else {
                    passTV.append(view.getText().toString());
                }
            }
        };
    }
}
