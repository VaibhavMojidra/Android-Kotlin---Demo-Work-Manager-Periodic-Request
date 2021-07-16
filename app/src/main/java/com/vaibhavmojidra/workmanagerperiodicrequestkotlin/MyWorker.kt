package com.vaibhavmojidra.workmanagerperiodicrequestkotlin

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.text.SimpleDateFormat
import java.util.*

class MyWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {
        val simpleDateFormat=SimpleDateFormat("hh:mm:ss")
        Log.i("MyTag",simpleDateFormat.format(Date()))
        return Result.success()
    }
}