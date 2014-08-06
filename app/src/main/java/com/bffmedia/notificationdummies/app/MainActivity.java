package com.bffmedia.notificationdummies.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNotify = (Button) findViewById(R.id.btnNotif);
        btnNotify.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Notifier();
            }
        });

    }

    public void Notifier(){
        /*
        Long rowId = intent.getExtras().getLong(ReminderProvider.COLUMN_ROWID);	→1
        NotificationManager mgr =
                (NotificationManager)getSystemService(NOTIFICATION_SERVICE);	→4
        Intent notificationIntent = new Intent(this, ReminderEditActivity.class);	→6
        notificationIntent.putExtra(ReminderProvider.COLUMN_ROWID, rowId);	→7
        PendingIntent pi = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_ONE_SHOT);	→9
        Notification note=new Notification(android.R.drawable.stat_sys_warning,
                getString(R.string.notify_new_task_message),
                System.currentTimeMillis());	→14
        note.setLatestEventInfo(this, getString(R.string.notify_new_task_title),
                getString(R.string.notify_new_task_message), pi);	→17
        note.defaults |= Notification.DEFAULT_SOUND;	→19
        note.flags |= Notification.FLAG_AUTO_CANCEL;	→20
        // An issue can occur if the user enters more than 2,147,483,647 tasks (the maximum int value).
        // Unlikely, but good to note.
        int id= (int)((long)rowId);	→27
        mgr.notify(id, note);	→28
        */


        NotificationManager mgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Intent notificationIntent = new Intent(this, NotificationActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, notificationIntent, 0);
        Notification note=new Notification(android.R.drawable.stat_sys_warning, "Email", System.currentTimeMillis());
        note.setLatestEventInfo(this, "New email", "New email available",pi);
        note.defaults |= Notification.DEFAULT_SOUND;
        note.flags |= Notification.FLAG_AUTO_CANCEL;
        mgr.notify(1, note);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
