package me.niamulhasan.tutorial.intentbacktomainactivity;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final int ACITVITY2 = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);     //Set up the button to take to the Activity2 and start an Intent

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,
                        me.niamulhasan.tutorial.intentbacktomainactivity.Activity2.class);  //First parameter is the CURRENT Activity, 2nd parameter is the Activity where to take
                startActivityForResult(intent, ACITVITY2);                                  //Back from another activity Intent doesn't use startActivity method. It uses startActivityForResults() method
                                                                                            // And the 2nd param is needed which is Unique id for the sub Activity
                                                                                            // And an additional override method in 1st depth needed to capture the data back from sub activity
            }
        });
    }


    //This method has to be used to capture the data back from a sub Activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ACITVITY2){
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText(data.getStringExtra("message"));       //Access the data using the key send back from activity2
        }
    }
}
