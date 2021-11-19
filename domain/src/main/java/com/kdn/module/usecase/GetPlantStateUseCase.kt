package com.kdn.module.usecase

import com.kdn.module.repository.FirebaseRepository
import javax.inject.Inject

class GetPlantStateUseCase @Inject constructor(
    private val firebaseRepository : FirebaseRepository
){
    fun getPlantState() = firebaseRepository.getPlantStateInfo()
}