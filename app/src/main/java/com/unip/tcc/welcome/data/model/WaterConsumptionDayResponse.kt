package com.unip.tcc.welcome.data.model

import com.google.gson.annotations.SerializedName


data class WaterConsumptionDayResponse(
    @SerializedName("consumption")
    val consumption: String,
    @SerializedName("message")
    val message: String
)
