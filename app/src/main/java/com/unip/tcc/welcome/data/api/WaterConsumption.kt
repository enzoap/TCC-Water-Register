package com.unip.tcc.welcome.data.api

import com.unip.tcc.welcome.data.model.WaterConsumptionResponse
import retrofit2.http.GET

internal interface WaterConsumption {

    @GET("consumation")
    suspend fun waterConsumption(): WaterConsumptionResponse


}