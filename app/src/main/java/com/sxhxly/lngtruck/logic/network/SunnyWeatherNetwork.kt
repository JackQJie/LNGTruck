package com.sxhxly.lngtruck.logic.network

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import retrofit2.http.Query
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

object SunnyWeatherNetwork {

    private val placeService = ServiceCreator.create(PlaceService::class.java)
    private val weatherService = ServiceCreator.create(WeatherService::class.java)
    suspend fun searchPlaces(query: String) = placeService.searchPlaces(query).await()
    suspend fun getDailyWeather(lng: String, lat: String) =
        weatherService.getDailWeather(lng, lat).await()

    suspend fun getRealtimeWeather(lng: String, lat: String) =
        weatherService.getRealtimeWeather(lng, lat).await()

    private suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) continuation.resume(body)
                    else continuation.resumeWithException(
                        RuntimeException("response body is null")
                    )
                    Log.i("retrofit:",body.toString())

                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                    Log.i("retrofit:",t.toString())
                }

            })
        }
    }

}