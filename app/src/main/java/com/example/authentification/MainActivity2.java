package com.example.authentification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private Button mb1;
    private static final String KEY_NOM = "name_key";
    private static final String KEY_B= "b_key";
    private TextView mTextViewResultat1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mb1 = findViewById(R.id.b1);
        mTextViewResultat1 = findViewById(R.id.textview7);

        Bundle extras= getIntent().getExtras();
        if(extras != null)
        {
            String newString=extras.getString(KEY_NOM);
            mTextViewResultat1.setText("Bienvenu "+newString+"\nvotre mot de passe est correcte.");
        }

        mb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(i);

            }
        });
        if (savedInstanceState != null) {
            String savedB = savedInstanceState.getString(KEY_B);
            mTextViewResultat1.setText(savedB);




        }else{
            Toast.makeText(this, "Nouvelle Inscrire", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putString(KEY_B, mTextViewResultat1.getText().toString());
        super.onSaveInstanceState(savedInstanceState);
    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mTextViewResultat1.setText(savedInstanceState.getString(KEY_B));



    }
}