package com.example.sellme;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    EditText editText1,editText2;
    Button button ;
    boolean hasChecked=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        editText1=findViewById(R.id.edit1);
        editText2 = findViewById(R.id.edit2);
        button = findViewById(R.id.login);
        final CheckBox checkBox = findViewById(R.id.checkboxid);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = editText1.getText().toString();
                String password = editText2.getText().toString();
               sharedPreferences=getSharedPreferences("FILE",Context.MODE_PRIVATE);
               String x= sharedPreferences.getString("USERNAME","Not Avail");
                String y =  sharedPreferences.getString("PASSWORD","Not Avail");
                SharedPreferences.Editor editor = sharedPreferences.edit() ;

                if ((name.equals(""))|| (password.equals(""))){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    View view = getLayoutInflater().inflate(R.layout.custom_dialog,null);
                    builder.setView(view);
                    final AlertDialog dialog = builder.create();
                    dialog.show();
                    TextView textView = view.findViewById(R.id.okid);
                    textView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                }else if (checkBox.isChecked()){
                        sharedPreferences=getSharedPreferences("FILE" ,Context.MODE_PRIVATE);
                        editor = sharedPreferences.edit();
                        editor.putString("USERNAME",editText1.getText().toString());
                        editor.putString("PASSWORD",editText2.getText().toString());
                        editor.apply();
                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        intent.putExtra("NAME", editText1.getText().toString());
                        startActivity(intent);
                    if (hasChecked==true) {
                        editor.putBoolean("BOX",true);
                        editor.apply();
                    }
                }else{
                    if (name.equals(x)&&password.equals(y)) {
                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(intent);

                            editor.putBoolean("BOX", false);
                            editor.apply();

                        if (checkBox.isChecked()){
                            editText1.setText(""+x);
                            editText2.setText(""+y);
                        }else{
                            editText1.setText("");
                            editText2.setText("");
                        }
                    }else {
                        Toast.makeText(MainActivity.this, "Wrong UserName And Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });



    }



}
