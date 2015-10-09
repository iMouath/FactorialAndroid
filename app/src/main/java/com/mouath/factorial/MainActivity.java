package com.mouath.factorial;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button computebtn;
    EditText Input_txt;
    TextView Output_txt, webpage;
    long input, factorial, i;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        computebtn = (Button)findViewById(R.id.ComputeBtn);
        Input_txt = (EditText)findViewById(R.id.Input_text);
        Output_txt = (TextView)findViewById(R.id.Output);
        webpage = (TextView)findViewById(R.id.webpage_text);


        webpage.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://mouath.com"));
                        startActivity(browserIntent);
                    }
                }
        );

        computebtn.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {

                        if((Input_txt.getText().toString().matches(""))) {
                            Context context = getApplicationContext();
                            CharSequence text = getString(R.string.input_empty);
                            int duration = Toast.LENGTH_SHORT;

                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                    }else {
                            input = Integer.parseInt(Input_txt.getText().toString());
                            factorial = 1;
                            i = input;

                            if (input <= 20) {
                                if (input >= 0) {
                                    while (i >= 1) {
                                        factorial = factorial * i;
                                        i--;
                                    }
                                    Output_txt.setText("The Factorial for " + input + " Is " + factorial);
                                } else {
                                    Context context = getApplicationContext();
                                    CharSequence text = getString(R.string.num_less_0);
                                    int duration = Toast.LENGTH_SHORT;

                                    Toast toast = Toast.makeText(context, text, duration);
                                    toast.show();
                                }
                            } else {
                                Context context = getApplicationContext();
                                CharSequence text = getString(R.string.num_big_12);
                                int duration = Toast.LENGTH_SHORT;

                                Toast toast = Toast.makeText(context, text, duration);
                                toast.show();
                            }

                        }
                    }
                }
        );


    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Handle action bar item clicks here. The action bar will
        //automatically handle clicks on the Home/Up button, so long
        //as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
