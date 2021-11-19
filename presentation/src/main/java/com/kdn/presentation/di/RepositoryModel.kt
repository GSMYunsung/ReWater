package com.kdn.presentation.di

import com.kdn.data.datasource.RemoteFirebaseDataSource
import com.kdn.data.repository.RemoteFirebaseRepositoryImpl
import com.kdn.module.repository.FirebaseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModel {
    @Provides
    @Singleton
    fun provideFirebaseRepository(
        remoteFirebaseDataSource: RemoteFirebaseDataSource
    ): FirebaseRepository {
        return RemoteFirebaseRepositoryImpl(
            remoteFirebaseDataSource
        )
    }
}