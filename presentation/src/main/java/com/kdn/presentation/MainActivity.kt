package com.kdn.presentation

import android.annotation.SuppressLint
import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainActivity : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}