package com.example.authentification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEditText1;
    private EditText mEditText2;
    private TextView mTextViewResultat1;
    private TextView mTextViewResultat2;
    private TextView mTextViewResultat3;
    private Button mButtonConnexion;
    private Button mButtonAnnuler;
    private static final String KEY_DESOLE= "desole_key";
    private static final String KEY_NOMINCORRECT = "nomincorrect_key";
    private static final String KEY_MDPINCORRECT = "mdpincorrect_key";
    private static final String KEY_NOM = "name_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mEditText1 = findViewById(R.id.edittext1);
        mEditText2 = findViewById(R.id.edittext2);
        mTextViewResultat1 = findViewById(R.id.textView1);
        mTextViewResultat2 = findViewById(R.id.textView3);
        mTextViewResultat3 = findViewById(R.id.textView5);
        mButtonConnexion = findViewById(R.id.b1);
        mButtonAnnuler = findViewById(R.id.b2);

        mButtonConnexion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                if((mEditText1.getText().toString().equals("MQL") &&
                            mEditText2.getText().toString().equals("MasterQL"))||
                            (mEditText1.getText().toString().equals("M2I") &&
                                    mEditText2.getText().toString().equals("MasterM2I")) ||
                            (mEditText1.getText().toString().equals("Talay") &&
                                    mEditText2.getText().toString().equals("-tal-123")) ||
                            (mEditText1.getText().toString().equals("Bakkali") &&
                                    mEditText2.getText().toString().equals(".b-a-k-k-a-l-i.")) ||
                            (mEditText1.getText().toString().equals("Torres") &&
                                    mEditText2.getText().toString().equals("123456")))
                    {
                        Intent i = new Intent(MainActivity.this,MainActivity2.class);
                        i.putExtra(KEY_NOM,mEditText1.getText().toString() );

                        startActivity(i);
                    }
                else {
                    if (mEditText1.getText().toString().isEmpty()  ){
                        Toast.makeText(getApplicationContext(), "Entrer votre nom", Toast.LENGTH_SHORT).show();
                    }
                    if (mEditText2.getText().toString().isEmpty()  ){
                        Toast.makeText(getApplicationContext(), "Entrer votre mot de passe", Toast.LENGTH_SHORT).show();
                    }
                    else if ((mEditText1.getText().toString().equals("MQL") &&
                            !mEditText2.getText().toString().equals("MasterQL"))||
                    (mEditText1.getText().toString().equals("M2I") &&
                            !mEditText2.getText().toString().equals("MasterM2I")) ||
                            (mEditText1.getText().toString().equals("Talay") &&
                                    !mEditText2.getText().toString().equals("-tal-123")) ||
                            (mEditText1.getText().toString().equals("Bakkali") &&
                                    !mEditText2.getText().toString().equals(".b-a-k-k-a-l-i.")) ||
                            (mEditText1.getText().toString().equals("Torres") &&
                                    !mEditText2.getText().toString().equals("123456"))){
                        mTextViewResultat1.setText(String.valueOf("Désolé !"));
                        mTextViewResultat3.setText(String.valueOf("Mot de passe incorrect"));}
                        else if ((!mEditText1.getText().toString().equals("MQL") &&
                                mEditText2.getText().toString().equals("MasterQL"))||
                                (!mEditText1.getText().toString().equals("M2I") &&
                                        mEditText2.getText().toString().equals("MasterM2I")) ||
                                (!mEditText1.getText().toString().equals("Talay") &&
                                        mEditText2.getText().toString().equals("-tal-123")) ||
                                (!mEditText1.getText().toString().equals("Bakkali") &&
                                        mEditText2.getText().toString().equals(".b-a-k-k-a-l-i.")) ||
                                (!mEditText1.getText().toString().equals("Torres") &&
                                        mEditText2.getText().toString().equals("123456"))){

                            mTextViewResultat1.setText(String.valueOf("Désolé !"));
                            mTextViewResultat2.setText(String.valueOf("Nom de compte incorrect"));

                    }
                        else {
                        mTextViewResultat1.setText(String.valueOf("Désolé !"));
                        mTextViewResultat2.setText(String.valueOf("Nom de compte incorrect"));
                        mTextViewResultat3.setText(String.valueOf("Mot de passe incorrect"));}



                    }
                }

        });
        mButtonAnnuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText1.setText("");
                mEditText2.setText("");
                mTextViewResultat1.setText("");
                mTextViewResultat2.setText("");
                mTextViewResultat3.setText("");
            }
        });
        if (savedInstanceState != null) {
            String savedDesole = savedInstanceState.getString(KEY_DESOLE);
            mTextViewResultat1.setText(savedDesole);

            String savedNom = savedInstanceState.getString(KEY_NOMINCORRECT);
            mTextViewResultat2.setText(savedNom);

            String savedMdp = savedInstanceState.getString(KEY_MDPINCORRECT);
            mTextViewResultat3.setText(savedMdp);


        }else{
            Toast.makeText(this, "Nouvelle Page", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putString(KEY_DESOLE, mTextViewResultat1.getText().toString());
        savedInstanceState.putString(KEY_NOMINCORRECT, mTextViewResultat2.getText().toString());
        savedInstanceState.putString(KEY_MDPINCORRECT, mTextViewResultat3.getText().toString());


        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mTextViewResultat1.setText(savedInstanceState.getString(KEY_DESOLE));
        mTextViewResultat2.setText(savedInstanceState.getString(KEY_NOMINCORRECT));
        mTextViewResultat3.setText(savedInstanceState.getString(KEY_MDPINCORRECT));


    }
}