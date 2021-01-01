package com.example.xucan.flowtext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

import java.util.ArrayList;
import java.util.Scanner;

/*
CREATE A PROGRAM TO GET THE FLOW TEXT
 */
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

                Scanner scan = new Scanner((Readable) InputBox);
                int N;
                while(scan.hasNext()){
                    N = scan.nextInt();
                    int mn=0;
                    ArrayList<Integer> v = new ArrayList<Integer>();
                    for (int i=0;i<N;i++){
                        String text = scan.next();
                        v.add(text.length());
                        mn = Math.max(mn, v.get(v.size()-1));
                    }

                    int res = 0, reso = -1;
                    for (int w = mn; ;w++){
                        int[] current = new int[w], next = new int[w];
                           int cs = -1, nline = 1;
                           for(int y = 0; y  < v.size(); y++){
                               if(cs+v.get(y) >= w){
                                   current = next;
                                   next = new int[w];
                                   cs = -1;
                                   nline++;
                               }
                               if(cs > 0 && (cs+1) < w){
                                   next[cs]=Math.max(current[cs-1]+1, Math.max(current[cs]+1,current[cs-1]=1));
                                   if(next[cs] > res){
                                       res = next[cs];
                                       reso = w;
                                   }
                                   cs += v.get(y) + 1;
                               }
                               if(res >= nline)
                                   break;

                           }
                        //some function e.g. findflow()

                        ResultText.setVisibility(View.VISIBLE);
                        ResultText.setText("Total words: 21, Best width: 15, Max flow: 5");
                        ResultBox.setVisibility(View.VISIBLE);
                        ResultBox.setText("Final text && marked maximum flow with red *");
                    }
                }
            }
        });
    }
}
