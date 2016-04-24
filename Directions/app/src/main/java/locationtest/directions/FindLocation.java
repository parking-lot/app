package locationtest.directions;

/**
 * Some code taken from geographic_story project by Kevin
 */

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

/**
 * Created by Jon on 4/18/2016.
 */
public class FindLocation {
    private GoogleApiClient mClient;

    public FindLocation(final Context appContent){
        mClient = new GoogleApiClient.Builder(appContent)
                .addApi(LocationServices.API)
                .build();
    }

    public void checkLocation(){
        LocationRequest request = LocationRequest.create();
        request.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        request.setInterval(2000);
        LocationServices.FusedLocationApi
                .requestLocationUpdates(mClient, request, new LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {

                    }
                });

    }

    public void startMonitoring(){
        mClient.connect();
    }
    public void stopMonitoring(){
        mClient.disconnect();
    }
}
