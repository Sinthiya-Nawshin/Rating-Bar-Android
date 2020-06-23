package com.example.ratingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.media.Rating;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView titlerate, resultrate;
    Button btnfeedback;
    RatingBar rateStars;
    ImageView charPlace;
    String answervalue;
    Animation charanim, butt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titlerate = findViewById(R.id.titlerate);
        resultrate = findViewById(R.id.resultrate);
        btnfeedback = findViewById(R.id.btnfeedback);
        rateStars = findViewById(R.id.rateStars);
        charPlace = findViewById(R.id.charPlace);

        //load animation
        charanim = AnimationUtils.loadAnimation(this,R.anim.charanim);
        butt = AnimationUtils.loadAnimation(this,R.anim.butt);

        //animate
        charPlace.startAnimation(charanim);
        btnfeedback.startAnimation(butt);


        rateStars.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                answervalue = String.valueOf((int) (rateStars.getRating()));

                if (answervalue.equals("1")) {
                    charPlace.setImageResource(R.drawable.verysad);
                    charPlace.startAnimation(charanim);
                    btnfeedback.startAnimation(butt);
                    resultrate.setText("Very Bad!");
                }
                else if (answervalue.equals("2")) {
                    charPlace.setImageResource(R.drawable.sad);
                    charPlace.startAnimation(charanim);
                    btnfeedback.startAnimation(butt);
                    resultrate.setText("Bad!");
                }
                else if (answervalue.equals("3")) {
                    charPlace.setImageResource(R.drawable.happy);
                    charPlace.startAnimation(charanim);
                    btnfeedback.startAnimation(butt);
                    resultrate.setText("Good!");
                }
                else if (answervalue.equals("4")) {
                    charPlace.setImageResource(R.drawable.vgood);
                    charPlace.startAnimation(charanim);
                    btnfeedback.startAnimation(butt);
                    resultrate.setText("Very Good!");
                }
                else if (answervalue.equals("5")) {
                    charPlace.setImageResource(R.drawable.exc);
                    charPlace.startAnimation(charanim);
                    btnfeedback.startAnimation(butt);
                    resultrate.setText("Excellent!");
                }
                else {
                    Toast.makeText(getApplicationContext(), "No Points!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
