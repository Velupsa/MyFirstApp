package fr.velupsa.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CookieActivity extends AppCompatActivity {

    private TextView points;
    private ImageView cookie;
    private int clicks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cookie);

        this.points = (TextView) findViewById(R.id.points);
        this.cookie = (ImageView) findViewById(R.id.play);

        cookie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicks++;
                points.setText("Points : " + clicks);
            }
        });

    }
}