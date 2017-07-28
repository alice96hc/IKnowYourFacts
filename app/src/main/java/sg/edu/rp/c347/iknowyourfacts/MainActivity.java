package sg.edu.rp.c347.iknowyourfacts;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btn;
    ArrayList<Fragment> al;
    MyFragmentPagerAdapter adapter;
    ViewPager vPager;
    AlarmManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vPager = (ViewPager) findViewById(R.id.viewPager1);
        btn = (Button) findViewById(R.id.button);

        FragmentManager fm = getSupportFragmentManager();

        //prepare the collection of Fragments
        al = new ArrayList<Fragment>();
        al.add(new Frag1());
        al.add(new Frag2());
        al.add(new Frag3());

        //adapter preparation
        adapter = new MyFragmentPagerAdapter(fm, al);
        //setting adapter to the UI
        vPager.setAdapter(adapter);

        Intent intent = new Intent(this, AlarmReceiverActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(
                this, 12345, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.SECOND, 300);

                //Create a new PendingIntent and add it to the AlarmManager
                Intent intent = new Intent(MainActivity.this, AlarmReceiverActivity.class);
                int reqCode = 12345;
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, reqCode, intent, PendingIntent.FLAG_CANCEL_CURRENT);

                //get AlarmManager instance
                am = (AlarmManager) getSystemService(Activity.ALARM_SERVICE);

                //set the alarm
                am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.previous) {
            if (vPager.getCurrentItem() > 0) {
                int previousPage = vPager.getCurrentItem() - 1;
                vPager.setCurrentItem(previousPage, true);
            }
            return true;
        } else if (id == R.id.random) {
            Random random = new Random();
            System.out.println(random.nextInt(2));
            return true;
        } else {
            int max = vPager.getChildCount();
            if (vPager.getCurrentItem() < max - 1) {
                int nextPage = vPager.getCurrentItem() + 1;
                vPager.setCurrentItem(nextPage, true);
            }
        }

        return super.onOptionsItemSelected(item);
    }

}
