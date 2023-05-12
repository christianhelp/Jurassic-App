package edu.utsa.cs3443.enk037_lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import edu.utsa.cs3443.enk037_lab5.controller.ZoneController;

public class ZoneActivity extends AppCompatActivity {
    TextView guestNum,dinoNum,zone;
    TextView []nameViews = new TextView[10];
    TextView []infoViews = new TextView[10];

    int[] nameResources = {R.id.dino1Name,R.id.dino2Name,R.id.dino3Name,R.id.dino4Name,R.id.dino5Name,R.id.dino6Name,R.id.dino7Name,R.id.dino8Name,R.id.dino9Name,R.id.dino10Name};
    int[] infoResources = {R.id.dino1Info,R.id.dino2Info,R.id.dino3Info,R.id.dino4Info,R.id.dino5Info,R.id.dino6Info,R.id.dino7Info,R.id.dino8Info,R.id.dino9Info,R.id.dino10Info};
    int[] nameTextToDisplay = {R.string.dino1Name,R.string.dino2Name,R.string.dino3Name,R.string.dino4Name,R.string.dino5Name,R.string.dino6Name,R.string.dino7Name,R.string.dino8Name,R.string.dino9Name,R.string.dino10Name};
    int[] infoTextToDisplay = {R.string.dino1Info,R.string.dino2Info,R.string.dino3Info,R.string.dino4Info,R.string.dino5Info,R.string.dino6Info,R.string.dino7Info,R.string.dino8Info,R.string.dino9Info,R.string.dino10Info};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zone);
        ZoneController zoneController;
        try {
             zoneController = new ZoneController(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Button relocate = findViewById(R.id.button);
        relocate.setOnClickListener(zoneController);

        guestNum = findViewById(R.id.guests);


        dinoNum = findViewById(R.id.dinos);

        zone = findViewById(R.id.zone_name);

        Intent intent = getIntent();


        setInfoText(guestNum,R.string.guest_number,intent.getStringExtra("GUESTNUM"));
        setInfoText(dinoNum,R.string.dino_number,intent.getStringExtra("DINONUM"));
        setInfoText(zone,R.string.zone_name,intent.getStringExtra("ZONE"));

        int length = intent.getIntExtra("SIZE",0);

        for(int i=0;i<length;i++){
            String []dino = intent.getStringArrayExtra("DINO".concat(Integer.toString(i+1)));
            System.out.println(dino[0]);
            nameViews[i] = findViewById(nameResources[i]);
            infoViews[i] = findViewById(infoResources[i]);
            setNameView(nameViews[i],nameTextToDisplay[i], dino[0]);
            setSpecifics(infoViews[i],infoTextToDisplay[i], dino[1],dino[2]);
        }

    }
    public void setInfoText(TextView textView,int ID, String zoneName){
        textView.setText(getString(ID,zoneName));
    }
    public void setNameView(TextView textView, int ID, String name){
        textView.setText(getString(ID,name));
    }
    public void setSpecifics(TextView textView, int ID, String type, String veg){
        textView.setText(getString(ID,type,veg));
    }
    public String getZone(){
        Intent intent = getIntent();
        return intent.getStringExtra("ZONE");
    }
}