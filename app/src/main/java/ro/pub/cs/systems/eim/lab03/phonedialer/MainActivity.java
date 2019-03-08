package ro.pub.cs.systems.eim.lab03.phonedialer;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private EditText phoneNumberEditText;
    private ImageButton callImageButton;
    private ImageButton hangupImageButton;
    private ImageButton deleteImageButton;
    private Button button_0;
    private Button button_1;
    private Button button_2;
    private Button button_3;
    private Button button_4;
    private Button button_5;
    private Button button_6;
    private Button button_7;
    private Button button_8;
    private Button button_9;
    private Button button_diez;
    private Button button_star;

    final public static int PERMISSION_REQUEST_CALL_PHONE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phoneNumberEditText = (EditText)findViewById(R.id.phoneEditText);
        callImageButton = (ImageButton) findViewById(R.id.call_button);
        callImageButton.setOnClickListener(callButtonClickListener);
        hangupImageButton = (ImageButton) findViewById(R.id.hangup_button);
        hangupImageButton.setOnClickListener(hangupButtonClickListener);
        deleteImageButton = (ImageButton) findViewById(R.id.backspace);
        deleteImageButton.setOnClickListener(deleteButtonClickListener);

        button_0 = (Button) findViewById(R.id.button_0);
        button_0.setOnClickListener(genericButtonClickListener);

        button_1 = (Button) findViewById(R.id.button_1);
        button_1.setOnClickListener(genericButtonClickListener);

        button_2 = (Button) findViewById(R.id.button_2);
        button_2.setOnClickListener(genericButtonClickListener);

        button_3 = (Button) findViewById(R.id.button_3);
        button_3.setOnClickListener(genericButtonClickListener);

        button_4= (Button) findViewById(R.id.button_4);
        button_4.setOnClickListener(genericButtonClickListener);

        button_5 = (Button) findViewById(R.id.button_5);
        button_5.setOnClickListener(genericButtonClickListener);

        button_6 = (Button) findViewById(R.id.button_6);
        button_6.setOnClickListener(genericButtonClickListener);

        button_7 = (Button) findViewById(R.id.button_7);
        button_7.setOnClickListener(genericButtonClickListener);

        button_8 = (Button) findViewById(R.id.button_8);
        button_8.setOnClickListener(genericButtonClickListener);

        button_9 = (Button) findViewById(R.id.button_9);
        button_9.setOnClickListener(genericButtonClickListener);

        button_diez = (Button) findViewById(R.id.button_diez);
        button_diez.setOnClickListener(genericButtonClickListener);

        button_star = (Button) findViewById(R.id.button_star);
        button_star.setOnClickListener(genericButtonClickListener);

    }

    private GenericButtonClickListener genericButtonClickListener = new GenericButtonClickListener();
    private class GenericButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            phoneNumberEditText.setText(phoneNumberEditText.getText().toString() + ((Button)view).getText().toString());
        }
    }
    private DeleteButtonClickListener deleteButtonClickListener = new DeleteButtonClickListener();
    private class DeleteButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String phoneNumber = phoneNumberEditText.getText().toString();
            phoneNumber = phoneNumber.substring(0, phoneNumber.length() - 1);
            phoneNumberEditText.setText(phoneNumber);

        }
    }

    private CallButtonClickListener callButtonClickListener = new CallButtonClickListener();
    private class CallButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                        MainActivity.this,
                        new String[]{Manifest.permission.CALL_PHONE},
                        PERMISSION_REQUEST_CALL_PHONE);
            } else {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + phoneNumberEditText.getText().toString()));
                startActivity(intent);
            }

        }
    }

    private HangUpButtonClickListener hangupButtonClickListener = new HangUpButtonClickListener();
    private class HangUpButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
        finish();

        }
    }

}
