package com.example.game_project;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.game_project.databinding.ActivityGame2Binding;
import com.example.game_project.databinding.ActivityMainBinding;

public class GameActivity extends AppCompatActivity {

    static boolean isHalfShown = true;

    static int radiationIntNow = 5000;

    static int radiationInt = 5000;

    ClipDrawable black_radiation;
    ClipDrawable black_human;
    ClipDrawable black_gun;
    ClipDrawable black_money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityGame2Binding binding = ActivityGame2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        black_radiation = (ClipDrawable) binding.radiation.getDrawable();
        black_human = (ClipDrawable) binding.human.getDrawable();
        black_gun = (ClipDrawable) binding.gun.getDrawable();
        black_money = (ClipDrawable) binding.money.getDrawable();
        binding.gunBig.setCardBackgroundColor(Color.TRANSPARENT);
        binding.gunSmall.setCardBackgroundColor(Color.TRANSPARENT);
        binding.radBig.setCardBackgroundColor(Color.TRANSPARENT);
        binding.radSmall.setCardBackgroundColor(Color.TRANSPARENT);
        binding.humBig.setCardBackgroundColor(Color.TRANSPARENT);
        binding.humSmall.setCardBackgroundColor(Color.TRANSPARENT);
        binding.monBig.setCardBackgroundColor(Color.TRANSPARENT);
        binding.monSmall.setCardBackgroundColor(Color.TRANSPARENT);

        Transformation tr = new Transformation();
        tr.start();


        binding.yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isHalfShown) {
                    black_gun.setLevel(10000);
                    binding.gunSmall.setCardBackgroundColor(Color.WHITE);
                    radiationInt = 10000;
                    binding.radSmall.setCardBackgroundColor(Color.WHITE);
                    black_human.setLevel(10000);
                    binding.humSmall.setCardBackgroundColor(Color.WHITE);
                    black_money.setLevel(10000);
                    binding.monSmall.setCardBackgroundColor(Color.WHITE);
                    isHalfShown = false;
                } else {
                    black_gun.setLevel(5000);
                    binding.gunBig.setCardBackgroundColor(Color.WHITE);
                    radiationInt = 5000;
                    binding.radBig.setCardBackgroundColor(Color.WHITE);
                    black_human.setLevel(5000);
                    binding.humBig.setCardBackgroundColor(Color.WHITE);
                    black_money.setLevel(5000);
                    binding.monBig.setCardBackgroundColor(Color.WHITE);
                    isHalfShown = true;
                }
            }
        });
    }


    class Transformation extends Thread {
        @Override
        public void run() {
            super.run();
            while (true) {
                if (radiationIntNow > radiationInt) {
                    radiationIntNow -= 10;
                } else if (radiationIntNow < radiationInt) {
                    radiationIntNow += 10;
                }
                black_radiation.setLevel(radiationIntNow);
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


}