package com.example.sudoku_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class MenuActivity extends Activity {
    Button buttonJugar, buttonSalir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        buttonJugar = (Button)findViewById(R.id.buttonJugar);
        buttonSalir = (Button)findViewById(R.id.buttonSalir);
        buttonSalir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        buttonJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent i = new Intent(getApplicationContext(), MenuPopup.class);
                startActivity(i);
            }
        });


    }
    public void creditos(View view){
        Intent i = new Intent(getApplicationContext(), creditosActivity.class);
        startActivity(i);
    }
}