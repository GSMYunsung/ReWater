package com.kdn.data.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.database.DatabaseReference
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.kdn.data.datasource.RemoteFirebaseDataSource
import com.kdn.module.repository.FirebaseRepository
import javax.inject.Inject

class RemoteFirebaseRepositoryImpl @Inject constructor(
    private val fireBaseSource: RemoteFirebaseDataSource
) : FirebaseRepository {
    override fun getPlantStateInfo(): DatabaseReference = fireBaseSource.getPlantStateInfo()

}