package com.unip.tcc.welcome.data.datasource

import com.unip.tcc.welcome.data.model.WaterConsumptionResponse
import kotlinx.coroutines.flow.Flow

interface WaterConsumptionDataSource {
    fun getWaterConsumption(): Flow<WaterConsumptionResponse>
}