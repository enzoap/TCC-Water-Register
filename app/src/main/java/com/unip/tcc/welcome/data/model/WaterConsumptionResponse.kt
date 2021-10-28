package com.unip.tcc.welcome.data.model

import com.google.gson.annotations.SerializedName


data class WaterConsumptionResponse(
    @SerializedName("qtyToday")
    val qtdToday: String,
    @SerializedName("qtyYesterday")
    val qtdYesterday: String,
    @SerializedName("week")
    val week: List<Day>
)


data class Day(
    @SerializedName("date")
    val date :String,
    @SerializedName("quantity")
    val quantity: String
)
