package com.example.sudoku_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Nivel2Activity extends Activity {

    private class Cell {
        int value;
        boolean fixed;
        Button bt;

        public Cell(int initValue, Context THIS){
            value=initValue;
            if (value!=0) fixed=true;
            else fixed=false;
            bt=new Button(THIS);
            bt.setBackgroundResource(R.drawable.casilla1);
            bt.setTextColor(Color.WHITE);
            if (fixed) bt.setText(String.valueOf(value));
            else bt.setTextColor(Color.BLUE);
            bt.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    if (fixed) return;
                    value++;
                    if (value>9) value=1;
                    bt.setText(String.valueOf(value));
                    if (completted()){
                        if (correct()){
                            tv.setTextColor(Color.GREEN);
                            tv.setText("    Has Ganado!!");
                        }else{
                            tv.setTextColor(Color.RED);
                            tv.setText("    Has Perdido!!");
                        }
                    }
                }
            });
        }
    }

    boolean completted(){
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (table[i][j].value==0){
                    return false;
                }
            }
        }
        return true;
    }

    boolean correct (int i1, int j1, int i2, int j2){
        boolean[] seen = new boolean[10];
        for (int i = 1; i <= 9; i++) seen[i] = false;
        for (int i = i1; i < i2; i++){
            for (int j = j1; j < j2; j++){
                int value = table[i][j].value;
                if (value != 0){
                    if (seen[value])return false;
                    seen[value] = true;
                }
            }
        }
        return true;
    }

    boolean correct(){
        for (int i = 0; i < 9; i++){
            if (!correct(i,0,i+1,9)) return false;
        }
        for (int j = 0; j < 9; j++){
            if (!correct(0,j,0,j+1)) return false;
        }
        for (int i = 0;i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (!correct(3*i,3*j,3*i+3,3*j+3)) return false;
            }
        }
        return true;
    }

    Cell[][] table;
    String input;
    TableLayout tl;
    TextView tv;
    LinearLayout linearLayout;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_nivel2);
        Bitmap bmp;
        int width = 500;
        int height = 500;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width,height);
        input=  "2 ? 3 ? 9 ? 8 4 ? " +
                "? ? ? 3 2 ? ? ? ? " +
                "? 7 8 4 6 5 ? 3 ? " +
                "? 5 ? ? 1 ? 7 2 ? " +
                "4 8 ? ? ? ? ? 1 9 " +
                "? 3 2 ? 5 ? ? 8 ? " +
                "? 9 ? 1 4 2 3 5 ? " +
                "? ? ? ? 8 9 ? ? ? " +
                "? 1 4 ? 7 ? 9 ? 2 ";
        String[] split = input.split(" ");
        table = new Cell[9][9];
        tl = new TableLayout(this);
        for (int i = 0; i < 9; i++){
            TableRow tr = new TableRow(this);
            for (int j = 0; j < 9; j++){
                String s = split[i*9+j];
                Character c = s.charAt(0);
                table[i][j] = new Cell(c=='?'?0:c-'0',this);
                tr.addView(table[i][j].bt);
            }
            tl.addView(tr);
        }
        tl.setShrinkAllColumns(true);
        tl.setStretchAllColumns(true);
        tv = new TextView(this);
        imageView = new ImageView(this);
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.logo);
        bmp = Bitmap.createScaledBitmap(bmp,width,height,true);
        imageView.setImageBitmap(bmp);
        layoutParams.gravity= Gravity.CENTER_HORIZONTAL;
        layoutParams.bottomMargin=20;
        layoutParams.topMargin=20;
        imageView.setLayoutParams(layoutParams);
        tv.setLayoutParams(layoutParams);
        tv.setTextSize(20);
        linearLayout = new LinearLayout(this);
        linearLayout.addView(imageView);
        linearLayout.addView(tl);
        linearLayout.addView(tv);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setBackgroundResource(R.drawable.background);
        setContentView(linearLayout);
    }
}