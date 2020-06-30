package com.example.ciphertext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText t1,t2;
    RadioButton text,number;
    Button button;
    RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = findViewById(R.id.text1);
        t2 = findViewById(R.id.text2);
        button = findViewById(R.id.button);
        text = findViewById(R.id.text);
        number = findViewById(R.id.number);
        relativeLayout = findViewById(R.id.rl);

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Don't touch Anywhere",Toast.LENGTH_SHORT).show();
            }
        });
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (text.isChecked())
                    {
                        Ceaser C = new Ceaser();
                        String s1 = t1.getText().toString();
                        String s2 = t2.getText().toString();
                        if (s2.equals(""))//encryption condition
                        {
                            String s = t1.getText().toString();
                            String res = C.encryption(s);
                            t2.setText(res);
                        } else if (s1.equals(""))//decryption condition
                        {
                            String s = t2.getText().toString();
                            String res = C.decryption(s);
                            if(res.equals(""))
                                Toast.makeText(MainActivity.this,"Select Appropriate Format..!",Toast.LENGTH_SHORT).show();
                            else
                                t1.setText(res);
                        } else
                            {
                            String s = t1.getText().toString();
                            String res = C.encryption(s);
                            t2.setText(res);
                        }
                    } else if (number.isChecked())
                    {
                        MyEnDe M = new MyEnDe();
                        String s1 = t1.getText().toString();
                        String s2 = t2.getText().toString();
                        if (s2.equals(""))//encryption condition
                        {
                            String s = t1.getText().toString();
                            String res = M.encryption(s);
                            t2.setText(res);
                        } else if (s1.equals(""))
                        {
                            String s = t2.getText().toString();
                            String res = M.decryption(s);
                            if(res.equals("100"))
                                Toast.makeText(MainActivity.this,"Select Appropriate Format..!",Toast.LENGTH_SHORT).show();
                            else
                                t1.setText(res);
                        } else {
                            String s = t1.getText().toString();
                            String res = M.encryption(s);
                            t2.setText(res);
                        }
                    }
                }
            });

    }


    public void clear(View view) {
        t1.setText("");
        t2.setText("");
        Toast.makeText(MainActivity.this,"Clear All....",Toast.LENGTH_SHORT).show();
    }

    public void thanks(View view) {
        Toast.makeText(MainActivity.this,"Thank You....",Toast.LENGTH_SHORT).show();
    }
}
