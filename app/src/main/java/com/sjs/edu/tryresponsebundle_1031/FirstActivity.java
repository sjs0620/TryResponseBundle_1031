package com.sjs.edu.tryresponsebundle_1031;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Button buttonFirst = findViewById(R.id.buttonFirst);
        buttonFirst.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
       EditText editTextFirst = findViewById(R.id.editTextFirst);
       String text = editTextFirst.getText().toString();
       Bundle bundle = new Bundle();
       bundle.putString("singleName",text);
       Intent intent = new Intent(this, SecondActivity.class);
       intent.putExtras(bundle);
       startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(data.hasExtra("resultValue")){
            if(resultCode == 1 ) {
                TextView textViewResult = findViewById(R.id.textView1Result);
                textViewResult.setText(data.getStringExtra("resultValue"));
            }
        }
    }
}
