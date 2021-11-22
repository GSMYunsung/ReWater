package com.kdn.presentation

import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
data class SaveDataClass(
    var size : String = "",
    var tree : String = "",
    var Ieast_temperature : String = "",
    var alarm_o_clock : String = "",
    var alram_minutes : String = "",
    var battery : String = "",
    var current_humidity : String = "",
    var desired_humidity : String = "",
    var if_output : Boolean = false,
    var maximum_temperature : String = "",
    var output : String = "",
    var output_time : String = "",
    var volume : String = ""
)

{
    @Exclude
    fun toMap() : Map<String,Any?>{
        return mapOf(
            "Ieast_temperature" to Ieast_temperature,
            "alarm_o_clock" to alarm_o_clock,
            "alram_minutes" to alram_minutes,
            "battery" to battery,
            "current_humidity" to current_humidity,
            "desired_humidity" to desired_humidity,
            "if_output" to if_output,
            "maximum_temperature" to maximum_temperature,
            "output" to output,
            "output_time" to output_time,
            "size" to size,
            "tree" to tree,
            "volume" to volume
        )
    }

}

