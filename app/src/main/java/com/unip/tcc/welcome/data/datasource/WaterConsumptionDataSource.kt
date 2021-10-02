package com.unip.tcc.welcome.data.datasource

import com.unip.tcc.welcome.data.model.WaterConsumptionDayResponse
import com.unip.tcc.welcome.data.model.WaterConsumptionWeekResponse
import com.unip.tcc.welcome.data.model.WaterConsumptionYesterdayResponse
import kotlinx.coroutines.flow.Flow

interface WaterConsumptionDataSource {
    fun getWaterConsumptionDay(): Flow<WaterConsumptionDayResponse>
    fun getYesterdayWaterConsumption(date: String): Flow<WaterConsumptionYesterdayResponse>
    fun getWeekWaterConsumption(date: String): Flow<WaterConsumptionWeekResponse>
}