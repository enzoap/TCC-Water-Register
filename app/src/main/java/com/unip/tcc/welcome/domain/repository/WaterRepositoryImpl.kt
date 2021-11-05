package com.unip.tcc.welcome.domain.repository

import com.unip.tcc.welcome.data.datasource.WaterConsumptionDataSource
import com.unip.tcc.welcome.domain.entity.WaterConsumptionEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class WaterRepositoryImpl(
    private val waterConsumptionDataSource: WaterConsumptionDataSource
): WaterRepository {
    override fun invoke(): Flow<WaterConsumptionEntity> {
        return waterConsumptionDataSource.getWaterConsumption().map {
            WaterConsumptionEntity(
                qtdToday = it.qtdToday,
                qtdYesterday = it.qtdYesterday,
                week = it.week)
        }
    }
}