/*
 *
 *  Copyright (c) 2015 SameBits UG. All rights reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.jobesk.nourv.locator.receiver;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.jobesk.nourv.R;
import com.jobesk.nourv.locator.model.NotificationAction;
import com.jobesk.nourv.locator.ui.activity.MainNavigationActivity;
import com.jobesk.nourv.locator.util.Constants;
import com.jobesk.nourv.locator.util.NotificationBuilder;


public class BeaconAlertReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equalsIgnoreCase(Constants.ALARM_NOTIFICATION_SHOW)) {
            NotificationAction notificationAction = intent.getParcelableExtra("NOTIFICATION");
            createNotification(context, context.getString(R.string.action_alarm_text_title),
                    notificationAction.getMessage(), notificationAction.getMessage(),
                    notificationAction.getRingtone(), notificationAction.isVibrate());

        }
    }

    private void createNotification(Context context, String title, String msgText, String msgAlert, String ringtone, boolean isVibrate) {

        PendingIntent notificationIntent = PendingIntent.getActivity(context, 0, new Intent(context, MainNavigationActivity.class), 0);

        NotificationBuilder notificationBuilder = new NotificationBuilder(context);
        notificationBuilder.createNotification(title, ringtone, isVibrate, notificationIntent);

        notificationBuilder.setMessage(msgText);
        notificationBuilder.setTicker(msgAlert);


        notificationBuilder.show(1);

    }
}





