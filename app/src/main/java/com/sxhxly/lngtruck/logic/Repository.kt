package com.sxhxly.lngtruck.logic

import androidx.lifecycle.liveData
import com.sxhxly.lngtruck.logic.model.Place
import com.sxhxly.lngtruck.logic.model.Weather
import com.sxhxly.lngtruck.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import java.lang.RuntimeException
import kotlin.Exception
import kotlin.coroutines.CoroutineContext

object Repository {
    fun searchPlaces(query: String) = fire(Dispatchers.IO) {
            val placeResponse = SunnyWeatherNetwork.searchPlaces(query)
            if (placeResponse.status == "ok") {
                val places = placeResponse.places
                Result.success(places)
            } else {
                Result.failure(RuntimeException("response status if ${placeResponse.status}"))
            }

    }
    fun refreshWeather(lng:String,lat:String) = fire(Dispatchers.IO){
            coroutineScope {
                val deferredRealtime = async {
                    SunnyWeatherNetwork.getRealtimeWeather(lng, lat)
                }
                val deferredDeath = async {
                    SunnyWeatherNetwork.getDailyWeather(lng, lat)
                }
                val realtimeResponse = deferredRealtime.await()
                val dailyResponse = deferredDeath.await()
                if(realtimeResponse.status =="ok"&&dailyResponse.status =="ok"){
                    val weather = Weather(realtimeResponse.result.realtime,
                    dailyResponse.result.daily)
                    Result.success(weather)
                }else{
                    Result.failure(
                        RuntimeException(
                            "realtime response status is ${realtimeResponse.status}"+
                                    "daily response status is ${dailyResponse.status}"
                        )
                    )
                }
            }
    }

    private fun <T> fire(context :CoroutineContext,block:suspend ()->Result<T>)=
        liveData<Result<T>>(context) {
            val result = try {
                block()
            }catch (e:java.lang.Exception){
                Result.failure<T>(e)
            }
            emit(result)
        }
}

