package edu.utsa.cs3443.enk037_lab5.controller;

import android.content.Intent;
import android.view.View;

import java.io.IOException;

import edu.utsa.cs3443.enk037_lab5.DinoActivity;
import edu.utsa.cs3443.enk037_lab5.MainActivity;
import edu.utsa.cs3443.enk037_lab5.ZoneActivity;
import edu.utsa.cs3443.enk037_lab5.model.Park;

public class ZoneController implements View.OnClickListener{
    private MainActivity mainActivity;
    private ZoneActivity zoneActivity;
    private Park park;
    private boolean readBefore;
    public ZoneController(MainActivity mainActivity, boolean readBefore) throws IOException {
        this.mainActivity = mainActivity;
        this.readBefore = readBefore;
        if (!readBefore){
            this.park = new Park("Jurrasic Park",mainActivity);
        }
    }
    public ZoneController(ZoneActivity zoneActivity) throws IOException {
        this.zoneActivity = zoneActivity;
    }

    public MainActivity getMainActivity() {
        return mainActivity;
    }

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(zoneActivity, DinoActivity.class);
        intent.putExtra("ZONENAME",zoneActivity.getZone());
        zoneActivity.startActivity(intent);
    }

    public ZoneActivity getZoneActivity() {
        return zoneActivity;
    }

    public void setZoneActivity(ZoneActivity zoneActivity) {
        this.zoneActivity = zoneActivity;
    }

    public Park getPark() {
        return park;
    }

    public void setPark(Park park) {
        this.park = park;
    }

    public boolean isReadBefore() {
        return readBefore;
    }

    public void setReadBefore(boolean readBefore) {
        this.readBefore = readBefore;
    }
}
