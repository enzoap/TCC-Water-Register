package com.unip.tcc.welcome.data.model

import com.google.gson.annotations.SerializedName

data class WaterConsumptionWeekResponse(
    @SerializedName("day1")
    val day1: Float,
    @SerializedName("day2")
    val day2: Float,
    @SerializedName("day3")
    val day3: Float,
    @SerializedName("day4")
    val day4: Float,
    @SerializedName("day5")
    val day5: Float,
    @SerializedName("day6")
    val day6: Float,
    @SerializedName("day7")
    val day7: Float
)

