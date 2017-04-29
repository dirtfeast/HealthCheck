package com.example.android.healthcheck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

// This app presents a series of yes/no questions,
// tabulates the responses in the 'score' variable
// and gives a rating at the end, along with some advice

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Global variable 'score' holds tally of answers
    int score = 10;

    // Global variable 'qNum' hold index of current question number
    int qNum = 0;

    // Global array list of question texts
    ArrayList<String> qText = new ArrayList<String>() {{
        add("1Do you get 8 hours of sleep per day?");
        add("2Do you avoid sugary sodas every day?");
        add("3Do you drink 4 glasses of water every day?");
        add("4Do you avoid sugary sodas every day?");
        add("5Do you avoid sugary sodas every day?");
        add("6Do you avoid sugary sodas every day?");
        add("7Do you avoid sugary sodas every day?");
        add("8Do you avoid sugary sodas every day?");
        add("9Do you avoid sugary sodas every day?");
        add("10Do you avoid sugary sodas every day?");
        add("Please see below for your rating and tips for healthier living.");
    }};


    public void question(View view) {
        if (qNum < 10) {
            displayScore(score);
            displayQNum(qNum);
            displayQ(qNum);
        } else {
            displayScore(score);
            displayQNum(qNum);
            displayQ(qNum);

            // To Do: Disable ratings buttons
            // Display value rating
            // Display list of advice points

        }
    }

    // always() increments score by 1
    public void always(View view) {
        score += 1;
        qNum += 1;
        question(view);
    }

    // never() decrements score by 1
    public void never(View view) {
        score -= 1;
        qNum += 1;
        question(view);
    }

    // sometimes() makes no change to score
    public void sometimes(View view) {
        qNum += 1;
        question(view);
    }

    private void displayScore(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.score_view);
        quantityTextView.setText("" + number);
    }

    private void displayQNum(int number) {
        number += 1;
        TextView quantityTextView = (TextView) findViewById(R.id.qNum_view);
        quantityTextView.setText("" + number + " / 10");
    }

    private void displayQ(int number) {
        String q = qText.get(number);
        TextView quantityTextView = (TextView) findViewById(R.id.q_present);
        quantityTextView.setText(q);

    }

}
