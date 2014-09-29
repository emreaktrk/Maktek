package akturk.maktek.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.CalendarContract;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import akturk.maktek.R;
import akturk.maktek.fragment.AboutTuyapFragment;
import akturk.maktek.fragment.AgendaFragment;
import akturk.maktek.fragment.ContactFragment;
import akturk.maktek.fragment.FairLayoutFragment;
import akturk.maktek.fragment.HomeFragment;
import akturk.maktek.fragment.ListOfExhibitorsFragment;
import akturk.maktek.fragment.NavigationDrawerFragment;
import akturk.maktek.fragment.PressFragment;
import akturk.maktek.fragment.TiadAndMibFragment;
import akturk.maktek.fragment.TransportationFragment;
import akturk.maktek.util.CalendarUtil;


public final class HomeActivity extends BaseActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks {
    private int mCurrentPosition = -1;

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;
    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    /**
     * Holds the flag for double press to exit.
     */
    private boolean isDoublePressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCustomActionBar();
        setContentView(R.layout.layout_home);

        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();

        mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById(R.id.navigation_drawer);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        if (mCurrentPosition == position)
            return;

        mCurrentPosition = position;

        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        switch (position) {
            case HomeFragment.POSITION:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new HomeFragment())
                        .commit();
                return;
            case ListOfExhibitorsFragment.POSITION:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new ListOfExhibitorsFragment())
                        .commit();
                return;
            case FairLayoutFragment.POSITION:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new FairLayoutFragment())
                        .commit();
                return;
            case AgendaFragment.POSITION:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new AgendaFragment())
                        .commit();
                return;
            case PressFragment.POSITION:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new PressFragment())
                        .commit();
                return;
            case TransportationFragment.POSITION:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new TransportationFragment())
                        .commit();
                return;
            case AboutTuyapFragment.POSITION:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new AboutTuyapFragment())
                        .commit();
                return;
            case TiadAndMibFragment.POSITION:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new TiadAndMibFragment())
                        .commit();
                return;
            case ContactFragment.POSITION:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new ContactFragment())
                        .commit();
                return;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        setCustomTitle(mTitle);
    }

    public void setActionBarTitle(int resouce) {
        mTitle = getString(resouce);
        setCustomTitle(mTitle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.home, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (isDoublePressed) {
            super.onBackPressed();
            return;
        }

        isDoublePressed = true;
        Toast.makeText(getBaseContext(), R.string.text_exit, Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                isDoublePressed = false;
            }
        }, 2000);
    }

    private void setCalendar() {
        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, CalendarUtil.getBeginTime().getTimeInMillis())
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, CalendarUtil.getEndTime().getTimeInMillis())
                .putExtra(CalendarContract.Events.TITLE, getString(R.string.event_title))
                .putExtra(CalendarContract.Events.DESCRIPTION, getString(R.string.event_description))
                .putExtra(CalendarContract.Events.EVENT_LOCATION, getString(R.string.event_location))
                .putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY)
                .putExtra(CalendarContract.Events.ALL_DAY, true)
                .putExtra(Intent.EXTRA_EMAIL, getString(R.string.event_email));
        startActivity(intent);
    }
}
