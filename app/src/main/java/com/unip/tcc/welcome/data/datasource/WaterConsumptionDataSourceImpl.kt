package com.unip.tcc.welcome.data.datasource

import com.unip.tcc.welcome.data.api.WaterConsumption
import com.unip.tcc.welcome.data.model.WaterConsumptionResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class WaterConsumptionDataSourceImpl(
    private val waterConsumption: WaterConsumption
): WaterConsumptionDataSource {
    override fun getWaterConsumption(): Flow<WaterConsumptionResponse> {
        return flow {
            emit(waterConsumption.waterConsumption())
        }
    }
}