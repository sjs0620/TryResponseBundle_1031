package com.sjs.edu.tryresponsebundle_1031;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Bundle bundle = new Bundle();
        bundle = getIntent().getExtras();
        ((EditText)findViewById(R.id.editTextThird)).setText(bundle.getString("singleName","No Data"));

        ((Button)findViewById(R.id.buttonThird)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, FirstActivity.class);
        startActivity(intent);
    }

    @Override
    public void finish() {
        Bundle bundle = new Bundle();
        bundle.putString("singleName",((EditText)findViewById(R.id.editTextThird)).getText().toString());
        Intent intent = new Intent();
        intent.putExtras(bundle);
        setResult(Activity.RESULT_OK,intent);
        super.finish();
    }
}
