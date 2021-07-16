package com.vaibhavmojidra.workmanagerperiodicrequestkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.vaibhavmojidra.workmanagerperiodicrequestkotlin.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.startWork.setOnClickListener {
            startPeriodicWork()
        }
    }

    private fun startPeriodicWork() {
        val workManager=WorkManager.getInstance(this)
        val periodicWorkRequest=PeriodicWorkRequest.Builder(MyWorker::class.java,20,TimeUnit.MINUTES).build() // Minimum 15 minutes
        workManager.enqueue(periodicWorkRequest)
    }
}