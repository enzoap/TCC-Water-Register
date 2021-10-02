package com.unip.tcc.welcome.data.api

import com.unip.tcc.welcome.data.model.WaterConsumptionDayResponse
import com.unip.tcc.welcome.data.model.WaterConsumptionWeekResponse
import com.unip.tcc.welcome.data.model.WaterConsumptionYesterdayResponse
import retrofit2.http.Body
import retrofit2.http.GET

internal interface WaterConsumption {

    @GET("waterconsumption/day")
    suspend fun waterConsumptionDay(): WaterConsumptionDayResponse

    @GET("waterconsumption/week")
    suspend fun waterConsumptionWeek(@Body date: String): WaterConsumptionWeekResponse

    @GET("waterconsumption/yesterday")
    suspend fun waterConsumptionYesterday(@Body date: String): WaterConsumptionYesterdayResponse
}