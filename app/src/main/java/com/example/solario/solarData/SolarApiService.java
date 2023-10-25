package com.example.solario.solarData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import com.example.solario.api.SolarApi;
public interface SolarApiService {

    @GET("buildingInsights:findClosest")
    Call<SolarApi> getSolar(
            @Query("location.latitude") double latitude,
            @Query("location.longitude") double longitude,
            @Query("requiredQuality") String requiredQuality,
            @Query("key") String apiKey
    );
}
