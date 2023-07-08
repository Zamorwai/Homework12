package com.karome.homework12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "SecondActivity";

    private TextView textView;
    private Button button;
    private Ticket ticket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button2);
        button.setOnClickListener(listener);

        Bundle bundleIntent = getIntent().getExtras();
        if (bundleIntent != null) {
            ticket = (Ticket) bundleIntent.get(Ticket.class.getSimpleName());

            textView.setText("Ваш id " + ticket.getId() + "\n"
                    + "Пункт назначения " + ticket.getDestination() + "\n"
                    + "Ваш поезд отправляется в " + ticket.getDepartureTime() + "\n"
                    + "и прибывает в " + ticket.getArrivalTime() + "\n"
                    + "Цена вашего билета " + ticket.getTicketPrice());
        }
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    };
}