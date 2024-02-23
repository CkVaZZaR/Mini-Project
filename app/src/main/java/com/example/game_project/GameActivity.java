package com.example.game_project;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.game_project.databinding.ActivityGame2Binding;
import com.example.game_project.databinding.ActivityMainBinding;

public class GameActivity extends AppCompatActivity {

    static boolean isHalfShown = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityGame2Binding binding = ActivityGame2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ClipDrawable black_radiation = (ClipDrawable) binding.radiation.getDrawable();
        ClipDrawable black_human = (ClipDrawable) binding.human.getDrawable();
        ClipDrawable black_gun = (ClipDrawable) binding.gun.getDrawable();
        ClipDrawable black_money = (ClipDrawable) binding.money.getDrawable();


        binding.yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isHalfShown) {
                    black_gun.setLevel(10000);
                    black_radiation.setLevel(10000);
                    black_human.setLevel(10000);
                    black_money.setLevel(10000);
                    isHalfShown = false;
                } else {
                    black_gun.setLevel(5000);
                    black_radiation.setLevel(5000);
                    black_human.setLevel(5000);
                    black_money.setLevel(5000);
                    isHalfShown = true;
                }
            }
        });



    }
}