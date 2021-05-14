package com.example.sudoku_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

public class MenuPopup extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_popup);
        getActionBar().hide();
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width), (int)(height));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);
    }

    public void Nivel1(View v){
        Intent intent = new Intent(this,Nivel1Activity.class);
        startActivity(intent);
    }

    public void Nivel2(View v){
        Intent intent = new Intent(this,Nivel2Activity.class);
        startActivity(intent);
    }

    public void Nivel3(View v){
        Intent intent = new Intent(this,Nivel3Activity.class);
        startActivity(intent);
    }

    public void Salir(View v){
        finish();
    }
}