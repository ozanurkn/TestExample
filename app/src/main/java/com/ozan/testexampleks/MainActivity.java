package com.ozan.testexampleks;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startAnimation();

    }

    private void startAnimation() {
        final TextView text = findViewById(R.id.mainTextView);
        text.animate()
                .scaleY(3f)
                .rotationX(2500)
                .setDuration(3000)
                .setStartDelay(1000)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        text.setVisibility(View.GONE);
                    }
                })
                .start();
    }
}
