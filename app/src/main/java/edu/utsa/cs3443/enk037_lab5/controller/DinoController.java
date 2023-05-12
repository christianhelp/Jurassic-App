package edu.utsa.cs3443.enk037_lab5.controller;

import static edu.utsa.cs3443.enk037_lab5.model.Park.zones;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import java.util.Objects;

import edu.utsa.cs3443.enk037_lab5.DinoActivity;
import edu.utsa.cs3443.enk037_lab5.MainActivity;
import edu.utsa.cs3443.enk037_lab5.R;
import edu.utsa.cs3443.enk037_lab5.model.Dinosaur;

public class DinoController implements View.OnClickListener{
    private DinoActivity dinoActivity;
    public DinoController(DinoActivity dinoActivity){
        this.dinoActivity = dinoActivity;
    }
    @Override
    public void onClick(View view) {

    if (view.getId() == R.id.relocate_btn){
        Dinosaur dino = null;
        String dinoName = dinoActivity.getName();
        String newZone = dinoActivity.getZone();
        System.out.println("DinoName: "+dinoName+"\nZoneName:"+newZone);
        String zoneName = dinoActivity.getCalledZone();
        Toast toast;


        if (zones.containsKey(zoneName)){
            for(int i = 0; i < Objects.requireNonNull(zones.get(zoneName)).getDinosaurs().size(); i++){
                if (Objects.requireNonNull(zones.get(zoneName)).getDinosaurs().get(i).getName().equals(dinoName)){
                    dino = Objects.requireNonNull(zones.get(zoneName)).getDinosaurs().remove(i);
                    System.out.println(dino);
                    break;
                }
            }
            if (dino == null){
                toast = Toast.makeText(view.getContext(),"ERROR! Dino not found!",Toast.LENGTH_SHORT);
                toast.show();
            }
            else{
                Objects.requireNonNull(zones.get(newZone)).getDinosaurs().add(dino);
                System.out.println(zones.get(newZone));
                if (Objects.requireNonNull(zones.get(newZone)).getDinosaurs().size() >= 10){
                    toast = Toast.makeText(view.getContext(),"ADDED! BUT SHOW CAPACITY (10) REACHED",Toast.LENGTH_SHORT);
                    toast.show();
                    toast = Toast.makeText(view.getContext(),"DINO WILL NOT SHOW IN ZONE",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    toast = Toast.makeText(view.getContext(),"Dino was added successfully!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        }
        else{
            toast = Toast.makeText(view.getContext(),"ERROR! Zone not found!",Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    else{
        Intent intent = new Intent(dinoActivity, MainActivity.class);
        intent.putExtra("CREATED",true);
        dinoActivity.startActivity(intent);
    }

    }


    public DinoActivity getDinoActivity() {
        return dinoActivity;
    }

    public void setDinoActivity(DinoActivity dinoActivity) {
        this.dinoActivity = dinoActivity;
    }
}
