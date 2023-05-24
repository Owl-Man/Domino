package com.owl.domino;

import android.content.Context;

public class Domino extends androidx.appcompat.widget.AppCompatButton {
    //private LinearLayout llDomino;
    public Domino(Context context) {
        super(context);
        //setRotation(90);
        setTextSize(24);



        /*llDomino = new LinearLayout(context);
        llDomino.setOrientation(LinearLayout.HORIZONTAL);

        llMain.addView(llDomino);


        int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;
        LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(wrapContent, wrapContent);
        TextView textView = new TextView(context);
        textView.setText("0");

        if (place_ID == 0) textView.setTextAlignment(TextView.TEXT_ALIGNMENT_TEXT_START);
        else if (place_ID == 1) textView.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        else textView.setTextAlignment(TextView.TEXT_ALIGNMENT_TEXT_END);

        llDomino.addView(textView, lParams);*/
    }
}
