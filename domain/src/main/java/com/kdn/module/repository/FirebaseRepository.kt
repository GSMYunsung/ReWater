package com.kdn.module.repository

import com.google.firebase.database.DatabaseReference
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference

interface FirebaseRepository {
    fun getPlantStateInfo() : DatabaseReference
}