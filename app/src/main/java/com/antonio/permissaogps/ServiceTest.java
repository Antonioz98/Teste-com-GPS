package com.antonio.permissaogps;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ServiceTest extends Service {

    private List<Worker> threads = new ArrayList<Worker>();

    @androidx.annotation.Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("Script", "onStartCommand()");

        Worker w = new Worker(startId);
        w.start();
        threads.add(w);

        return (super.onStartCommand(intent, flags, startId));
        // START_NOT_STICKY         //não guarda intent
        // START_STICKY             //Padrão
        // START_REDELIVER_INTENT   //Guarda intent
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        for (int i = 0, tam = threads.size(); i < tam; i++) {
            threads.get(i).ativo = false;
        }
    }

    class Worker extends Thread {
        int count = 0;
        int startId;
        boolean ativo = true;

        public Worker(int startId) {
            this.startId = startId;
        }

        public void run() {
            while (ativo && count < 1000) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                count++;
                Log.i("Script", "COUNT: " + count);
            }
            stopSelf(startId);
        }
    }

}
