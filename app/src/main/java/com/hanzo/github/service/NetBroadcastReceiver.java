

package com.hanzo.github.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;

import com.hanzo.github.common.AppEventBus;
import com.hanzo.github.common.Event;
import com.hanzo.github.util.NetHelper;


/**
 * Created by ThirtyDegreesRay on 2016/8/25 16:07
 */

public class NetBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, @NonNull Intent intent) {
        String action = intent.getAction();
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(action)) {
            int preNetStatus = NetHelper.INSTANCE.getNetStatus();
            NetHelper.INSTANCE.checkNet();
            int curNetStatus = NetHelper.INSTANCE.getNetStatus();
            AppEventBus.INSTANCE.getEventBus().post(new Event.NetChangedEvent(preNetStatus, curNetStatus));
        }
    }

}
