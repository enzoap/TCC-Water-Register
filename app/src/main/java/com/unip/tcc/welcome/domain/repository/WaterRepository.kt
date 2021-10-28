package com.unip.tcc.welcome.domain.repository

import com.unip.tcc.welcome.domain.entity.WaterConsumationEntity
import kotlinx.coroutines.flow.Flow

interface WaterRepository {
    operator fun invoke(): Flow<WaterConsumationEntity>
}