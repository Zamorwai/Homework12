package com.karome.homework12;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private EditText idIn, destinationIn, departureTimeIn, arrivalTimeIn, ticketPriceIn;
    private String destination, id, departureTime, arrivalTime, ticketPrice;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idIn = findViewById(R.id.idIn);
        destinationIn = findViewById(R.id.destinationIn);
        departureTimeIn = findViewById(R.id.departureTimeIn);
        arrivalTimeIn = findViewById(R.id.arrivalTimeIn);
        ticketPriceIn = findViewById(R.id.ticketPriceIn);

        button = findViewById(R.id.button);
        button.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            id = idIn.getText().toString();
            destination = destinationIn.getText().toString();
            departureTime = departureTimeIn.getText().toString();
            arrivalTime = arrivalTimeIn.getText().toString();
            ticketPrice = ticketPriceIn.getText().toString();


            Ticket ticket = new Ticket(id, destination, departureTime, arrivalTime, ticketPrice);

            Log.d(TAG, "Create SecondActivity");
            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
            intent.putExtra(Ticket.class.getSimpleName(), ticket);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    };
}