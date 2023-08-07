package com.example.firebase_logs;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.ktx.Firebase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
Button error , error1 , error2;
EditText edit;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        error= findViewById(R.id.buttonCrash);
        error1= findViewById(R.id.buttonCrash1);
        error2= findViewById(R.id.buttonCrash2);
        edit= findViewById(R.id.edit);

      //  Log.d("logging..", "onCreate: ");
        FirebaseCrashlytics.getInstance().log(" crash message for firebase ..");

        error.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseCrashlytics.getInstance().log(" crash message for firebase .. error");
                String text= null;
                edit.setText(text.toString());
            }
        });
      //  FirebaseCrashlytics.getInstance().log(" crash message for firebase .. error 1 entering ");
        error1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseCrashlytics.getInstance().log(" crash message for firebase ..error1 ");
                String filepath= "sdcard/made-up/filepath/";
                try {
                    File file= new File(filepath);
                    InputStream input = new FileInputStream(file);
                    input.read();
                }
                catch (FileNotFoundException e)
                {
                   FirebaseCrashlytics.getInstance().recordException(new Exception(" file not found exception on error 2 "+ filepath));
                }
                catch (IOException e)
                {
                    FirebaseCrashlytics.getInstance().recordException(new Exception(e.toString()));
                }
            }
        });
     //   FirebaseCrashlytics.getInstance().log(" crash message for firebase .. error 2 entering ");
        error2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseCrashlytics.getInstance().log(" crash message for firebase .. error 2");
                ArrayList <String> list= new ArrayList<>();
                list.add("string 1");
                list.add("string 2");
                list.add("string 3");
                for(int i =0 ; i< list.size();i++)
                {
                    Log.d("logging ..", "onClick:  " + list.get(i));
                }
            }
        });
    }
}

