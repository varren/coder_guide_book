package com.varren.matchismo;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void flipCard(View view){
        if(view instanceof Button){
            Button button = (Button)view;
            if(button.isSelected()){
                button.setText(R.string.button_text);
                button.setSelected(false);
            }else{
                button.setText("12");
                button.setSelected(true);
            }
        }
    }
}
