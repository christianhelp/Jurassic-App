package edu.utsa.cs3443.enk037_lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import java.io.IOException;

import edu.utsa.cs3443.enk037_lab5.controller.MainController;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainController mainController;
        Intent intent = getIntent();
        boolean created = intent.getBooleanExtra("CREATED",false);
        System.out.println(created);
        if (created){
            try {
                mainController = new MainController(this,true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            try {
                mainController = new MainController(this,false);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        ImageButton TR = findViewById(R.id.B);
        TR.setOnClickListener(mainController);

        ImageButton TY = findViewById(R.id.G);
        TY.setOnClickListener(mainController);

        ImageButton RE = findViewById(R.id.D);
        RE.setOnClickListener(mainController);

        ImageButton D = findViewById(R.id.RE);
        D.setOnClickListener(mainController);

        ImageButton G = findViewById(R.id.TY);
        G.setOnClickListener(mainController);

        ImageButton B = findViewById(R.id.TR);
        B.setOnClickListener(mainController);

        ImageButton X = findViewById(R.id.X);
        X.setOnClickListener(mainController);


    }
}