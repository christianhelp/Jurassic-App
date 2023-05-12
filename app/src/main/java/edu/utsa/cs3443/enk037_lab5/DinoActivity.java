package edu.utsa.cs3443.enk037_lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import edu.utsa.cs3443.enk037_lab5.controller.DinoController;

public class DinoActivity extends AppCompatActivity {
    EditText dinoName,zone;
    TextView whichZone;
    String zonename;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dino);
        DinoController dinoController = new DinoController(this);
        dinoName = findViewById(R.id.name_input);
        zone = findViewById(R.id.zone_input);
        Button relocate = findViewById(R.id.relocate_btn);
        Button map = findViewById(R.id.park_map_btn);

        relocate.setOnClickListener(dinoController);
        map.setOnClickListener(dinoController);

        whichZone = findViewById(R.id.zone_name);
        Intent intent = getIntent();
        String zone = intent.getStringExtra("ZONENAME");
        whichZone.setText(getString(R.string.zone_name,zone));

        zonename = intent.getStringExtra("ZONENAME");

    }
    public String getName(){
        return dinoName.getText().toString();
    }
    public String getZone(){
        return zone.getText().toString();
    }
    public String getCalledZone(){
        return zonename;
    }

}