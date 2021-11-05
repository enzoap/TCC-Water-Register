package com.unip.tcc.welcome.domain.usecase

import com.unip.tcc.welcome.data.datasource.WaterConsumptionDataSource
import com.unip.tcc.welcome.data.model.WaterConsumptionResponse
import com.unip.tcc.welcome.domain.entity.WaterConsumationEntity
import com.unip.tcc.welcome.domain.repository.WaterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWaterConsumption (
    private val waterRepository: WaterRepository
    ){
    operator fun invoke(): Flow<Flow<WaterConsumationEntity>> {
        return flow {
            emit(waterRepository.invoke())
        }
    }
}