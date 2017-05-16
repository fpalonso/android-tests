package com.blaxsoftware.androidtests;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * @author fpalonso
 */
public class BoundService extends Service {

    public class ServiceBinder extends Binder {
        public BoundService getService() {
            return BoundService.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new ServiceBinder();
    }

    public void startGreetingActivity() {
        startActivity(new Intent(this, GreetingActivity.class).addFlags(Intent
                .FLAG_ACTIVITY_NEW_TASK));
    }
}
