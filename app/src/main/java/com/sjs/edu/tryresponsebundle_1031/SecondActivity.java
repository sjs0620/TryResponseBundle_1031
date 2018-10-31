package com.sjs.edu.tryresponsebundle_1031;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editTextSecond;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        bundle = getIntent().getExtras();

        editTextSecond = findViewById(R.id.editTextSecond);
        editTextSecond.setText(bundle.getString("singleName","No Data"));

        Button buttonSecond = findViewById(R.id.buttonSecond);
        buttonSecond.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String text = editTextSecond.getText().toString();
        bundle.putString("singleName",text);
        Intent intent = new Intent(this,ThirdActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent,2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        TextView textViewResult = findViewById(R.id.textView2Result);
        if(data.hasExtra("singleName")){
            if(requestCode == 2){
                textViewResult.setText(data.getStringExtra("singleName"));
            }
        }
    }

    @Override
    public void finish() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("resultValue",editTextSecond.getText().toString());
        intent.putExtras(bundle);
        setResult(1,intent);
        super.finish();
    }
}
