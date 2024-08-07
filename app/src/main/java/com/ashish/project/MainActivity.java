package com.ashish.project;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView numberTextView;
    private Button incrementButton;
    private Button decrementButton;
    private int number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberTextView = findViewById(R.id.numberTextView);
        incrementButton = findViewById(R.id.incrementButton);
        decrementButton = findViewById(R.id.decrementButton);
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementNumber();
            }
        });
        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementNumber();

            }
        });

    }

    private void incrementNumber() {

        if (number < 5) {
            number++;
            numberTextView.setText(String.valueOf(number));
        } else {
//
            //dialog
            noreMoreNumbersDialog();
        }


    }

    private void noreMoreNumbersDialog() {
        // Cratete a cutome dialog
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custon_dialog);


        //set the title and message of the dialog
        TextView title = dialog.findViewById(R.id.dialog_message);
        TextView message = dialog.findViewById(R.id.dialog_message);

        // set the button action to dismiss the dialog
        Button button = dialog.findViewById(R.id.dialog_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                dialog.dismiss();
            }
        });
        // show the dialog
        dialog.show();
    }

    private void decrementNumber() {
        if (number > 0) {
            number--;
        } else {

        }
        numberTextView.setText(String.valueOf(number));
    }
}