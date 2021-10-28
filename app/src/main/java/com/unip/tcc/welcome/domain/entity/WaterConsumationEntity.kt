package com.unip.tcc.welcome.domain.entity

import com.google.gson.annotations.SerializedName
import com.unip.tcc.welcome.data.model.Day

data class WaterConsumationEntity(
    val qtdToday: String,
    val qtdYesterday: String,
    val week: List<Day>
)

data class Day(
    val date :String,
    val quantity: String
)
