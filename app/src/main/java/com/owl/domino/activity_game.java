package com.owl.domino;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class activity_game extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout llMain, llScroll;
    private LinearLayout llHand;

    private ScrollView Scroll;
    private RadioGroup rgGravity;
    private EditText etName, etName2;
    private Button btnCreate, btnClear;

    private ArrayList<Domino> dominoesOnBoard = new ArrayList<Domino>(), dominoesInHand = new ArrayList<Domino>();

    private int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        SpawnRandomHand(6);

        llMain = (LinearLayout) findViewById(R.id.llMain);

        Scroll = (ScrollView) findViewById(R.id.Scroll);
        llScroll = (LinearLayout) findViewById(R.id.llScroll);

        llHand = (LinearLayout) findViewById(R.id.llHand);

        rgGravity = (RadioGroup) findViewById(R.id.rgGravity);
        etName = (EditText) findViewById(R.id.etName);
        etName2 = (EditText) findViewById(R.id.etName2);

        btnCreate = (Button) findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(this);

        btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCreate) {
            LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(400, 200);


            int btnGravity = Gravity.TOP;
            int place_ID = 0;

            if (rgGravity.getCheckedRadioButtonId() == R.id.rbLeft) {
                btnGravity = Gravity.TOP;
                place_ID = 0;
            }
            else if (rgGravity.getCheckedRadioButtonId() == R.id.rbCenter) {
                btnGravity = Gravity.CENTER_VERTICAL;
                place_ID = 1;
            }
            else if (rgGravity.getCheckedRadioButtonId() == R.id.rbRight) {
                btnGravity = Gravity.BOTTOM;
                place_ID = 2;
            }

            lParams.gravity = btnGravity;

            Domino domino = new Domino(this);

            dominoesOnBoard.add(domino);

            domino.setText(etName.getText().toString() + "|" + etName2.getText().toString());

            llScroll.addView(domino, lParams);
        }
        else if (v.getId() == R.id.btnClear) {
            llScroll.removeAllViews();
            Toast.makeText(this, "Удалено", Toast.LENGTH_SHORT).show();
        }
    }

    public void SpawnRandomHand(int count)
    {
        LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(350, 170);
        lParams.gravity = Gravity.CENTER_HORIZONTAL;

        for (int i = 0; i < count; i++) {
            Domino domino = new Domino(this);
            int randomUp = ThreadLocalRandom.current().nextInt(0, 6);
            int randomDown = ThreadLocalRandom.current().nextInt(0, 6);
            domino.setText(randomUp + "|" + randomDown);
            dominoesInHand.add(domino);

            //llHand.setOrientation(LinearLayout.HORIZONTAL);
            //llHand.addView(domino, lParams);
        }
    }


    public void onBackButtonClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onSpawnButtonClick(View v) {
        ConstraintLayout.LayoutParams lParams = new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        Button btnew = new Button(this);
        btnew.setBottom(50);
        addContentView(btnew, lParams);
    }
}