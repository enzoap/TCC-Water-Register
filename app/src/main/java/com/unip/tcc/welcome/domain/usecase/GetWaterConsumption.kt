package com.unip.tcc.welcome.domain.usecase

import com.unip.tcc.welcome.domain.entity.WaterConsumptionEntity
import com.unip.tcc.welcome.domain.repository.WaterRepository
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow

class GetWaterConsumption (
    private val waterRepository: WaterRepository
    ) {

    operator fun invoke(): Flow<WaterConsumptionEntity> {
        return waterRepository()
    }
}