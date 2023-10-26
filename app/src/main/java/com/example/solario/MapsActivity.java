package com.example.solario;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.example.solario.api.SolarApi;
import com.example.solario.solarData.RetrofitClient;
import com.example.solario.solarData.SolarApiService;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private final int FINE_PERMISSION_CODE = 1;
    private GoogleMap gMap;
    private SearchView mapSearchView;
    private TextView maxSunshineTV;
    List<Address> addressList;
    FrameLayout map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        map = findViewById(R.id.map);
        mapSearchView = findViewById(R.id.mapSearch);
        maxSunshineTV = findViewById(R.id.maxSunshineTV);

        // Check and request location permission
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, FINE_PERMISSION_CODE);
        }

        mapSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                String location = mapSearchView.getQuery().toString();
                addressList = null;

                if (location != null) {
                    Geocoder geocoder = new Geocoder(MapsActivity.this);
                    try {
                        addressList = geocoder.getFromLocationName(location, 1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (addressList != null && !addressList.isEmpty()) {
                        Address address = addressList.get(0);
                        LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
                        MarkerOptions options = new MarkerOptions().position(latLng).title("Location");
                        options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
                        gMap.addMarker(options);
                        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 30));

                        // Make the API request
                        fetchSolarData(address.getLatitude(), address.getLongitude());
                    } else {
                        // Handle the case when addressList is empty
                        Toast.makeText(MapsActivity.this, "Location not found", Toast.LENGTH_SHORT).show();
                    }
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        mapFragment.getMapAsync(MapsActivity.this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        gMap = googleMap;

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == FINE_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted
            } else {
                // Permission denied, handle as needed
                Toast.makeText(this, "Location permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void fetchSolarData(double latitude, double longitude) {
        String requiredQuality = "HIGH";
        String apiKey = "AIzaSyDkjIAxz-UXC5MORy4NZUyc_yxF0-KYAJ0";

        Log.e("SolarAPI", "Latitude: " + latitude + ", Longitude: " + longitude);

        // Call the Solar API and handle the response
        SolarApiService apiService = RetrofitClient.getClient().create(SolarApiService.class);
        Call<SolarApi> call = apiService.getSolar(latitude, longitude, requiredQuality, apiKey);
        call.enqueue(new Callback<SolarApi>() {
            @Override
            public void onResponse(Call<SolarApi> call, Response<SolarApi> response) {
                if (response.isSuccessful()) {
                    SolarApi solarData = response.body();
                    if (solarData != null) {
                        // Retrieve the data you need
                        String name = solarData.getName();
                        String postalCode = solarData.getPostalCode();
                        float maxSunshineHoursPerYear = solarData.getMaxSunshineHoursPerYear();

                        // Use the retrieved data as needed
                        maxSunshineTV.setText(String.valueOf(maxSunshineHoursPerYear));
                    } else {
                        // Handle the case when the API response does not contain data
                        Toast.makeText(MapsActivity.this, "No solar data available", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Handle the API error
                    // Log the error
                    Log.e("SolarAPI", "API request failed with response code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<SolarApi> call, Throwable t) {
                // Handle the request failure
                // Log the failure
                Log.e("SolarAPI", "API request failed with exception: " + t.getMessage());
            }
        });
    }
}


