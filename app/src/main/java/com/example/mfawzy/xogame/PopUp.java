package com.example.mfawzy.xogame;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mfawzy.xogame.R;


/**
 * Created by M.Fawzy on 8/17/2016.
 */
public class PopUp extends DialogFragment implements View.OnClickListener{

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        inflater.inflate(R.layout.popup , container , false);
        String state = getArguments().getString("state");
        String winner = getArguments().getString("winner");
        /*TextView text = (TextView) view.findViewById(R.id.textView6);
        text.setText(winner);
        ImageView img = (ImageView) view.findViewById(R.id.imageView);
        if(state=="winner") {
            img.setBackgroundResource(R.drawable.congrat);
            text.setText(winner+ "Wins");
        }
        else
        {
            img.setBackgroundResource(R.drawable.draw);
            text.setText("NO one Wins");
        }
*/

        return view;
    }


    @Override
    public void onClick(View view) {

    }
}
