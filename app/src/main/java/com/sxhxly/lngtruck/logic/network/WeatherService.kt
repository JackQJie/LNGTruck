package com.sxhxly.lngtruck.logic.network

import com.sxhxly.lngtruck.App
import com.sxhxly.lngtruck.logic.model.DailyResponse
import com.sxhxly.lngtruck.logic.model.PlaceResponse
import com.sxhxly.lngtruck.logic.model.RealtimeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherService {
    @GET("v2.5/${App.TOKEN}/{lng},{lat}/realtime.json")
    fun getRealtimeWeather(@Path("lng") lng: String, @Path("lat") lat: String):
            Call<RealtimeResponse>

    @GET("v2.5/${App.TOKEN}/{lng},{lat}/daily.json")
    fun getDailWeather(@Path("lng") lng: String, @Path("lat") lat: String):
            Call<DailyResponse>

}