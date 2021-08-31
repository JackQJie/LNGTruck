package com.sxhxly.lngtruck.logic.dao

import android.content.Context
import android.provider.Settings.System.putString
import androidx.core.content.edit
import com.google.gson.Gson
import com.sxhxly.lngtruck.App
import com.sxhxly.lngtruck.logic.model.Place

object PlaceDao {

    fun savePlace(place: Place) {
        sharedPreferences().edit {
            putString("place", Gson().toJson(place))
        }
    }

    fun getSavedPlace(): Place {
        val placeJson = sharedPreferences().getString("place", "")
        return Gson().fromJson(placeJson, Place::class.java)
    }

    fun isPlaceSaved() = sharedPreferences().contains("place")

    private fun sharedPreferences() =
        App.context.getSharedPreferences("sunny_weather", Context.MODE_PRIVATE)

}