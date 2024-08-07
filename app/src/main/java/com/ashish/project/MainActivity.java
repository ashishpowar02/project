package com.ashish.project;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ashish.project.Admobe.Control;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private TextView numberTextView;
    private Button incrementButton;
    private Button decrementButton;
    private int number = 0;
    private Control control ;
    private LinearLayout banerLout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        numberTextView = findViewById(R.id.numberTextView);
        incrementButton = findViewById(R.id.incrementButton);
        decrementButton = findViewById(R.id.decrementButton);
        FloatingActionButton settingsButton = findViewById(R.id.settingsButton);

       control = new Control(this);
       control.loadBannerAd(R.id.bannnerLayout);


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

        settingsButton.setOnClickListener(view -> {
            Intent intent= new Intent(MainActivity.this,SettingActivity.class);
            startActivity(intent);
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