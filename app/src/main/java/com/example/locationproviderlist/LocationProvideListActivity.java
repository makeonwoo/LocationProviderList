package com.example.locationproviderlist;

import androidx.appcompat.app.AppCompatActivity;

import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class LocationProvideListActivity extends AppCompatActivity {
    TextView mtextView;
    LocationManager lm;
    List<String> locProvlist;
    Button mbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtextView = findViewById(R.id.textOutput);
        mbutton = findViewById(R.id.button);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lm = (LocationManager) getSystemService(LOCATION_SERVICE);

                locProvlist =lm.getAllProviders();

                String s = "";
                for(String lp : locProvlist){
                    s += "Loc. provider: " +lp +"\n"
                            + "Stats: " +lm.isProviderEnabled(lp)+"\n\n";
                }
                mtextView.setText(s);
            }
        });

    }
}