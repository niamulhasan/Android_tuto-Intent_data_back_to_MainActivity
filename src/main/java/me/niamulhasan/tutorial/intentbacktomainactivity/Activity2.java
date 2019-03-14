package me.niamulhasan.tutorial.intentbacktomainactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        final EditText editText = (EditText) findViewById(R.id.editText);
        Button button = (Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = editText.getText().toString().trim();

                Intent intent = new Intent();               //Creating the intent to send back data to the MainActivity
                intent.putExtra("message", message);   //Binding data to send via intent. first param is key, 2nd is the data
                setResult(RESULT_OK, intent);               //setting result with a message, 1st param is the message
                Activity2.this.finish();                    //Closing the activity and fo to the previous one
            }
        });
    }
}
