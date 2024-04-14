package com.itproger.eighthprak;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWorker extends Worker {
    public final String TAG = "LOGGER_TAG";

    public WorkerParameters workerParameters;
    public MyWorker(@NonNull Context context, @NonNull WorkerParameters
            workerParams) {
        super(context, workerParams);

        workerParameters = workerParams;
    }
    @NonNull
    @Override
    public Result doWork() {
        Log.v(TAG, "Work is in progress");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.v(TAG, "Work finished with result " + workerParameters.getInputData().getString("key"));
        return Worker.Result.success();
    }
}