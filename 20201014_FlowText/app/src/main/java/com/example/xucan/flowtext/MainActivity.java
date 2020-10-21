package com.example.xucan.flowtext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText InputBox = (EditText) findViewById(R.id.InputEditText);
        Button FindSolution = (Button) findViewById(R.id.FindButton);
        final TextView ResultText = (TextView) findViewById(R.id.ResultTextView);
        final EditText ResultBox = (EditText) findViewById(R.id.ResultEditText);

        FindSolution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //some function e.g. findflow()

                ResultText.setVisibility(View.VISIBLE);
                ResultText.setText("Total words: 21, Best width: 15, Max flow: 5");
                ResultBox.setVisibility(View.VISIBLE);
                ResultBox.setText("Final text && marked maximum flow with red *");
            }
        });
    }
}
