package ch.kuepfis.android.mynotecalc;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.ParseException;


public class MainActivity extends ActionBarActivity {
    private double maxValue =100;
    private double reachedValue = maxValue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SeekBar mySeekBar = (SeekBar) findViewById(R.id.seekBar);
        mySeekBar.setOnSeekBarChangeListener(customSeekBarListener);

        final EditText myMaxValue = (EditText) findViewById(R.id.editText2);
        myMaxValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try{
                    maxValue =  Integer.parseInt(myMaxValue.getText().toString());
                    mySeekBar.setMax((int)maxValue);

                }
                catch(NumberFormatException nfe){
                    //Nothing
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private SeekBar.OnSeekBarChangeListener customSeekBarListener =
            new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                    EditText myValue = (EditText) findViewById(R.id.editText);
                    myValue.setText(""+progress);
                    reachedValue = progress;
                    TextView myNote = (TextView) findViewById(R.id.textNote);
                    myNote.setText(""+(reachedValue/maxValue*5+1));

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar){
                    //
                }
                @Override
                public void onStopTrackingTouch(SeekBar seekBar){
                    //
                }

            };



}


