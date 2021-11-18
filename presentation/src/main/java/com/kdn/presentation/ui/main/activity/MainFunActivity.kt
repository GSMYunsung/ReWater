package com.kdn.presentation.ui.main.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kdn.presentation.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

@SuppressLint("MissingSuperCall")
class MainFunActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fun)
    }
}