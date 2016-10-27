package com.example.liyy813.record;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button button = (Button) findViewById(R.id.btnMakeList);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, ListActivity.class);
                intent.getClass();
                startActivity(intent);
            }
        });
        TextView nameView = (TextView) findViewById(R.id.printName);
        nameView.setText(getIntent().getExtras().getString("userName"));
    }

}
