package com.unip.tcc.welcome.domain.repository

import com.unip.tcc.welcome.data.api.WaterConsumption
import com.unip.tcc.welcome.data.datasource.WaterConsumptionDataSource
import com.unip.tcc.welcome.data.model.WaterConsumptionResponse
import com.unip.tcc.welcome.domain.entity.WaterConsumationEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class WaterRepositoryImpl(
    private val waterConsumptionDataSource: WaterConsumptionDataSource
): WaterRepository {
    override fun invoke(): Flow<WaterConsumationEntity> {
        return waterConsumptionDataSource.getWaterConsumption().map {
            WaterConsumationEntity(
                qtdToday = it.qtdToday,
                qtdYesterday = it.qtdYesterday,
                week = it.week)
        }
    }
}