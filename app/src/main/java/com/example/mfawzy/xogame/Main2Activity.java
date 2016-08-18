package com.example.mfawzy.xogame;

import android.app.Dialog;
import android.graphics.Typeface;
import android.media.Image;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{


    String player1="player1" , player2="player2";
    int size=3;
    Bundle b ;
    char Array [][];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        b = getIntent().getExtras();
        player1 = b.getString("player1");
        player2 = b.getString("player2");
        size = Integer.parseInt(b.getString("size"));
        if(size>9) size=9;
        Array = new char[size+2][size+2];
       createBoard();
    }

    boolean x=true;
    int i,j;


    private void createBoard()
    {

        for(int ii=0 ; ii<size ; ii++)
        {
            for(int jj=0 ; jj<size ; jj++)
                Array[ii][jj]='#';
        }
        LinearLayout lay = (LinearLayout) findViewById(R.id.vert_layout);
        LinearLayout rowLayout = null;
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.FILL_PARENT,1);
        for( i=0 ; i<size ; i++)
        {
            rowLayout = new LinearLayout(this);
            rowLayout.setWeightSum(size);
            lay.addView(rowLayout , param);
            for( j=0;j<size;j++)
            {
                Button bt = new Button(this);
                bt.setTag(i+"/"+j);
                bt.setOnClickListener(this);
                bt.setBackgroundResource(R.drawable.button_shape);
                if(size<6) bt.setTextSize(40);
                else if(size<8) bt.setTextSize(25);
                else bt.setTextSize(15);
                //bt.setBackgroundColor(getResources().getColor(R.color.grey));
                rowLayout.addView(bt,param);
            }
        }

    }


    public int checkBoard()
    {

        int f=0;
        for(int i=0 ; i<size ; i++)
        {
            int x1=0,x2=0,x3=0,x4=0,o1=0,o2=0,o3=0,o4=0;
            for(int j=0 ; j<size ; j++)
            {
                if(Array[i][j]=='#')f=1;
                if(Array[i][j]=='X') x1++;
                if(Array[i][j]=='O') o1++;
                if(Array[j][i]=='X') x2++;
                if(Array[j][i]=='O') o2++;
                if(Array[j][j]=='X') x3++;
                if(Array[j][j]=='O') o3++;
                if(Array[size-1-j][j]=='X') x4++;
                if(Array[size-1-j][j]=='O') o4++;

                if(x1>=size || x2>=size || x3>=size || x4>=size) return 1;
                if(o1>=size || o2>=size || o3>=size || o4>=size) return 2;


            }
        }
        if(f==0) return -1;
        return 0;
    }

    ArrayList<String> mark = new ArrayList<String>();
    @Override
    public void onClick(View view) {
        Button bt = (Button) view;
        String tag = String.valueOf(view.getTag());
         if(mark.contains(tag)) return;
        mark.add(tag);

        String SS[] = tag.split("/");
        int i = Integer.parseInt(SS[0]);
        int j = Integer.parseInt(SS[1]);

        if(x==true)
        {
            bt.setTextColor(getResources().getColor(R.color.green));
            bt.setText("X");
            Array[i][j]='X';
        }
        else
        {
            bt.setTextColor(getResources().getColor(R.color.red));
            bt.setText("O");
            Array[i][j]='O';
        }
        x = !x;

        final Dialog dialog = new Dialog(this);

        dialog.setContentView(R.layout.popup);
        dialog.setTitle("Game Over");
        ImageView img = (ImageView) dialog.findViewById(R.id.imageView);
        TextView txt = (TextView) dialog.findViewById(R.id.textView6);
        Button playAgainBtn = (Button) dialog.findViewById(R.id.button2);
        Button cancelBtn = (Button) dialog.findViewById(R.id.button3);

        txt.setTypeface(null, Typeface.BOLD_ITALIC);
        int result = checkBoard();
        if(result==1)
        {
            img.setBackgroundResource(R.drawable.congrat);
            txt.setText(player1 + " Wins !");
            dialog.show();


        }
        if(result==2)
        {
            img.setBackgroundResource(R.drawable.congrat);
            txt.setText(player2 + " Wins !");
            dialog.show();

        }
        if(result==-1)
        {
            img.setBackgroundResource(R.drawable.draw);
            txt.setText("No one Wins !");
            dialog.show();
        }


    }

    public void playAgainClick(View view) {
        this.finish();
    }

    public void cancelClick(View view) {
        this.finish();
    }
}
