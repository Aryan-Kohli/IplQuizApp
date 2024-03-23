package com.example.quiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {

    int score=0;
    TextView scorenum ;
    TextView questiontext;
    String[] questions = {
            "Is Pat Cummins the most expensive player of IPL 2024? 💰",
            "Is Jos Buttler the owner of the Orange Cap in IPL 2023? 🏏🧢",
            "Did SRH win the IPL Trophy in the year 2016? 🏆",
            "Was Rahul Dravid the captain of RCB in 2008? 🏏👑",
            "Does Delhi Capitals have the lowest total in IPL history? 📉",
            "Does Chris Gayle hold the record for the most centuries in IPL? 🏏💯",
            "Has CSK changed only 3 captains until the year 2023? 🔄🏏",
            "Does David Warner have more fifties in IPL? 🏏5️⃣0️⃣",
            "Did KKR win their title only once until 2023? 🏆🔵",
            "Was CSK the winner in IPL 2014? 🏆🟡"
    };

    Boolean[] answers ={false,false,true,true,false,false,true,true,false,false};
    int index=0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);


        scorenum = findViewById(R.id.ScoreNum);
        scorenum.setText(String.valueOf(score));
        questiontext=findViewById(R.id.questionText);
        questiontext.setText(questions[index]);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void yesPressed(View v) {
        if (index >= questions.length) {
            Toast.makeText(this, "Your final score is: " + score, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity3.class);
            intent.putExtra("score",score);
            startActivity(intent);
            findViewById(R.id.yes).setEnabled(false);
            findViewById(R.id.yes).setEnabled(false);
        } else {
            if (answers[index]) {
                score++;
            }
            index++;
            if(index<questions.length)
            {
                questiontext.setText(questions[index]);
            }
            scorenum.setText(String.valueOf(score));
        }
    }

    public void noPressed(View v) {
        if (index >= questions.length) {
            Toast.makeText(this, "Your final score is: " + score, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity3.class);
            intent.putExtra("score",score);
            startActivity(intent);
            findViewById(R.id.yes).setEnabled(false);
            findViewById(R.id.yes).setEnabled(false);

        } else {
            if (!answers[index]) {
                score++;
            }
            index++;
            if(index<questions.length)
            {
                questiontext.setText(questions[index]);
            }
            scorenum.setText(String.valueOf(score));

        }
    }

}