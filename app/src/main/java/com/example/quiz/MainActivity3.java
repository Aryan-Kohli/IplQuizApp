package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    TextView scoredis;
    TextView commentline;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0); // 0 is the default value if "score" extra is not found

        TextView scoredis = findViewById(R.id.textView3);
        scoredis.setText(score + " / 10");

        commentline=findViewById(R.id.textView4);
        if(score<5)
        {
            commentline.setText("It seems like you're just warming up! Keep exploring and learning more about IPL to improve your score next time");
        }
        else if(score<8)
        {
            commentline.setText("Not bad! You've got a decent knowledge of IPL. Keep up the good work and aim for a higher score in the future!");
        }
        else {
            commentline.setText("Wow! You're an IPL expert! Your score reflects an impressive understanding of the tournament. Keep shining and enjoy your mastery of IPL trivia!");

        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}