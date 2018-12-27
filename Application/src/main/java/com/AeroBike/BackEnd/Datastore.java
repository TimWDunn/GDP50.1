package com.AeroBike.BackEnd;

import android.location.Location;
import android.os.Environment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Datastore {

    ArrayList<Float> speedMphList;
    ArrayList<Location> locationList;
    File sdCard;

    public Datastore(){
        // access the sd card directory... internal storage is locked to access.

        sdCard = new File(Environment.getExternalStorageDirectory(), "Speed.txt");

        //
        speedMphList = new ArrayList<Float>();
        locationList = new ArrayList<Location>();
    }

    public void AddSpeedData(Float speedMph)
    {
        speedMphList.add(speedMph);

        try
        {
            WriteSpeedToFile(speedMph, "SpeedData.txt");
        }
        catch (IOException ex)
        {
            // do something useful with this exception?
        }
    }

    public void AddLocationData(Location location)
    {
        locationList.add(location);

        try
        {
            WriteLocationToFile(location, "LocationData.txt");
        }
        catch (IOException ex)
        {
            // do something useful with this exception?
        }
    }

    private void WriteSpeedToFile(Float speedMph, String filename) throws IOException
    {
        // this should open the file and append the speed to the end of it

        // write to the SD Card
        FileWriter writer = new FileWriter(sdCard, true);

        writer.write(speedMph.toString());

        writer.close();
    }

    private void WriteLocationToFile(Location location, String filename) throws IOException
    {
        // this should open the file and append the location to the end of it in lat, lng, altm format
        // suggest you look into a library which serializes it to json.
        if (location != null)
        {
            FileWriter writer = new FileWriter(filename, true);
            double lat = location.getLatitude();
            double lng = location.getLongitude();
            double altM = location.getAltitude();
            writer.write(String.format("%.2f, %.2f, %.2f", lat, lng, altM));

            writer.close();
        }

    }
}
