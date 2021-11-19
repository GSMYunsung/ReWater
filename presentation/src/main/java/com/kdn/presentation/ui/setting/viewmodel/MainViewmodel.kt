package com.kdn.presentation.ui.setting.viewmodel

import androidx.lifecycle.ViewModel
import com.kdn.module.usecase.GetPlantStateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewmodel @Inject constructor(
    private val getPlantStateUseCase: GetPlantStateUseCase
) : ViewModel() {

    fun getPlantStateInfo() = getPlantStateUseCase.getPlantState()

}