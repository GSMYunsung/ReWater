package com.kdn.presentation.di
import com.kdn.module.repository.FirebaseRepository
import com.kdn.module.usecase.GetPlantStateUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModel {
    @Provides
    @Singleton
    fun provideCheckUserInfoUseCase(repository: FirebaseRepository) = GetPlantStateUseCase(repository)
}