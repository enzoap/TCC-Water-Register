package com.unip.tcc.welcome.data.datasource

import com.unip.tcc.welcome.data.api.WaterConsumption
import com.unip.tcc.welcome.data.model.WaterConsumptionDayResponse
import com.unip.tcc.welcome.data.model.WaterConsumptionWeekResponse
import com.unip.tcc.welcome.data.model.WaterConsumptionYesterdayResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class WaterConsumptionDataSourceImpl(
    private val waterConsumption: WaterConsumption
): WaterConsumptionDataSource {
    override fun getWaterConsumptionDay(): Flow<WaterConsumptionDayResponse> {
        return flow {
            emit(waterConsumption.waterConsumptionDay())
        }
    }

    override fun getYesterdayWaterConsumption(date: String): Flow<WaterConsumptionYesterdayResponse> {
        return flow {
            emit(waterConsumption.waterConsumptionYesterday(date))
        }
    }

    override fun getWeekWaterConsumption(date: String): Flow<WaterConsumptionWeekResponse> {
        return flow {
            emit(waterConsumption.waterConsumptionWeek(date))
        }
    }
}