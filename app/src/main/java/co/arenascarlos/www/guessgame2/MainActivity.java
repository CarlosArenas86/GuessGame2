package co.arenascarlos.www.guessgame2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private int answer;
    private int guess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setInitialLayout();
        // second commit
    }


    private void setInitialLayout() {

        Log.d("1", "Step 1");


        setContentView(R.layout.activity_main);

        Log.d("2", "Step 2");

        Button btn = (Button) findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOtherLayout();
            }
        });

        answer = createRandomNumber();
    }

    private void setOtherLayout() {
        // String message = determineResult();

        setContentView(R.layout.secondlayout);
        Button btn = (Button) findViewById(R.id.Submit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                determineResult();
            }
        });

    }

    private void determineResult() {
        // Compare the current number you retrieved from the user to the answer you randomly generated.

        // If the answer fits what you expected, show winning message.

        //reading from the edit text, convert into string and save in the variable guess.
        guess = Integer.valueOf(((EditText) findViewById(R.id.num)).getText().toString()).intValue();


        TextView alert = (TextView)findViewById(R.id.Alert);

        if  (answer == guess) {
            alert.setText("Congratulations!");
        }
        else if
                (answer < guess) {
            alert.setText("Sorry The number is incorrect try a Lower number");

        }
        else {
            alert.setText("Sorry the number is incorrect try a Higher number");

        }
        clearUserInputEditText();

    }




    public int createRandomNumber() {
        Random randy = new Random();

        int random = new Random().nextInt(10) + 1;

        return random;

        //return randy.nextInt(MainActivity.RandomNumberRange.MAX.getValue()) + MainActivity.RandomNumberRange.MIN.getValue();
    }


    private void clearUserInputEditText() {
        EditText userEditText = (EditText) findViewById(R.id.num);
        userEditText.setText("");
    }
}
