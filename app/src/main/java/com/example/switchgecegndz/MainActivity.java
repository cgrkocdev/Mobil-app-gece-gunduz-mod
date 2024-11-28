package com.example.switchgecegndz;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Switch sw;
    ConstraintLayout cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        init();
        changecontrol();



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void changecontrol(){
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (sw.isChecked())
                {
                    sw.setText("Gece Modu");
                    cl.setBackgroundColor(Color.parseColor("#000000"));
                    tv.setTextColor(Color.parseColor("#ffffff"));
                    sw.setTextColor(Color.parseColor("#ffffff"));
                }
                else {
                    sw.setText("Gündüz Modu");
                    cl.setBackgroundColor(Color.parseColor("#ffffff"));
                    sw.setTextColor(Color.parseColor("#000000"));
                    tv.setTextColor(Color.parseColor("#000000"));
                }
            }
        });
    }

    public  void init()
    {
        sw = findViewById(R.id.switch1);
        tv =findViewById (R.id.textView);
        cl = findViewById(R.id.lay);
    }
}