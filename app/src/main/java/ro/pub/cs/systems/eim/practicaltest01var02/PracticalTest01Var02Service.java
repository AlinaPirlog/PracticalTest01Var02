package ro.pub.cs.systems.eim.practicaltest01var02;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class PracticalTest01Var02Service extends Service {
    public PracticalTest01Var02Service() {
    }

    private ProcessingThread processingThread = null;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int suma = intent.getIntExtra("sum", -1);
        int dif = intent.getIntExtra("dif", -1);
        processingThread = new ProcessingThread(this, suma, dif);
        processingThread.start();
        return Service.START_REDELIVER_INTENT;
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
