package com.varren.funmusic;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by Peter on 01.02.14.
 */
public class MusicPlayerService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
