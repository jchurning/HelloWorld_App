package com.example.joshchurning.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleButton);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            TextView textView = (TextView) findViewById(R.id.textView);

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    textView.setVisibility(View.VISIBLE);// The toggle is enabled
                } else {
                    textView.setVisibility(View.INVISIBLE); // The toggle is disabled
                }
            }
        });


        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.editText);
                updateTextView(editText.getText().toString()); //Update textView to input text
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                changeTextViewColor(); //Go through color rotation for textView
            }
        });


    }

    public void updateTextView(String toThis) {

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(toThis);   //Update textView

    }


    public void changeTextViewColor() {
        TextView textView = (TextView) findViewById(R.id.textView);
        int color = textView.getCurrentTextColor(); //Get current color of textView
        int newColor = 0;
        switch (color) {
            case 0x8a000000:   //Initial Color
                newColor = 0xffff0000; //New color to red
                break;
            case 0xffff0000: //Red
                newColor = 0xff00ff00; //New color to blue
                break;
            case 0xff00ff00:   //Blue
                newColor = 0xff0000ff; //New color to green
                break;
            case 0xff0000ff: //Green
                newColor = 0x8a000000; //New color back to initial color
                break;
        }
        textView.setTextColor(newColor); //Change color of text
    }
}


