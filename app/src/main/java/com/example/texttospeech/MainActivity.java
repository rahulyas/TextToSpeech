package com.example.texttospeech;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextToSpeech mTTS;
    Button speak_button;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        speak_button = findViewById(R.id.button);
        editText = findViewById(R.id.edittext);

      mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    mTTS.setLanguage(Locale.ENGLISH);  //set voice language accent
                    mTTS.setPitch(0.7f);               //set voice pitch
                    mTTS.setSpeechRate(0.7f);          //set voice speed
                }
            }
        });


        //speak button click listener
        speak_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTTS.speak(editText.getText().toString(), TextToSpeech.QUEUE_FLUSH, null,null);
            }
        });
    }
}