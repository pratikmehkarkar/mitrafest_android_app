package org.mitratechfest.shubhampratiktechfest.mitrafest;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;

import android.os.Handler;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Esperanza extends AppCompatActivity implements Animation.AnimationListener {

    private static int SPLASH_TIME_OUT = 2600;
    Animation animMove,faade,fad;
    TextView hed,prm,pre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esperanza);

        ImageView img = (ImageView)findViewById(R.id.imageanim);
        hed = (TextView)findViewById(R.id.head);
        prm = (TextView)findViewById(R.id.present);
        pre = (TextView)findViewById(R.id.prmit);
        Typeface head= Typeface.createFromAsset(getAssets(), "fonts/Follow Glass.ttf");
        hed.setTypeface(head);

        Typeface next= Typeface.createFromAsset(getAssets(), "fonts/Narrow.ttf");
        prm.setTypeface(next);
        pre.setTypeface(next);

        animMove = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide);
        animMove.setAnimationListener(this);
        img.startAnimation(animMove);

        faade = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        faade.setAnimationListener(this);
        hed.setVisibility(View.VISIBLE);
        hed.startAnimation(faade);

        fad = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
        fad.setAnimationListener(this);
        prm.setVisibility(View.VISIBLE);
        pre.setVisibility(View.VISIBLE);
        pre.startAnimation(fad);
        prm.startAnimation(fad);

        new Handler().postDelayed(new Runnable() {

			/*
			 * Showing splash screen with a timer. This will be useful when you
			 * want to show case your app logo / company
			 */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(Esperanza.this,MainActivity.class);
                startActivity(i);

                Esperanza.this.finish();
                // close this activity
            }
        }, SPLASH_TIME_OUT);

    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

        // check for zoom in animation
        if (animation == animMove) {
        }
        if (animation == faade) {
        }

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
