package com.aditya.myreactivesearchform.data.remote.network

import com.aditya.myreactivesearchform.data.remote.response.PlaceResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("mapbox.places/{query}.json")
    suspend fun getCountry(
        @Path("query") query: String,
        @Query("access_token") accessToken: String,
        @Query(value = "autocomplete") autoComplete: Boolean = true
    ): PlaceResponse
}