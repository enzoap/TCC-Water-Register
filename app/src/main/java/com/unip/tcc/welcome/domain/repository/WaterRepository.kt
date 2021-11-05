package com.unip.tcc.welcome.domain.repository

import com.unip.tcc.welcome.domain.entity.WaterConsumptionEntity
import kotlinx.coroutines.flow.Flow

interface WaterRepository {
    operator fun invoke(): Flow<WaterConsumptionEntity>
}