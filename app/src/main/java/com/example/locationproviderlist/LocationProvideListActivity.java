package com.example.locationproviderlist;

import androidx.appcompat.app.AppCompatActivity;

import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class LocationProvideListActivity extends AppCompatActivity {
    TextView mtextView;
    LocationManager lm;
    List<String> locProvlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtextView = findViewById(R.id.textOutput);
        lm = (LocationManager) getSystemService(LOCATION_SERVICE);

        locProvlist =lm.getAllProviders();

        String s = "";
        for(int i = 0;i<locProvlist.size(); i++){
            s += "Loc. provider: " +locProvlist.get(i) +"\n"
                    + "Stats: " +lm.isProviderEnabled(locProvlist.get(i))+"\n\n";
        }
        mtextView.setText(s);
    }
}