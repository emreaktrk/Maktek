package akturk.maktek.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;

import akturk.maktek.R;
import akturk.maktek.fragment.AgendaFragment;
import akturk.maktek.fragment.ContactFragment;
import akturk.maktek.fragment.HomeFragment;
import akturk.maktek.fragment.NavigationDrawerFragment;
import akturk.maktek.fragment.PressFragment;
import akturk.maktek.fragment.TransportationFragment;
import akturk.maktek.util.CalendarUtil;


public final class HomeActivity extends BaseActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;
    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_home);

        setActionBarTypeface();

        mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {

        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        switch (position) {
            case HomeFragment.POSITION:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new HomeFragment())
                        .commit();
                return;
            case FairLayoutActivity.POSITION:
                Intent tempIntent = new Intent(getApplicationContext(), FairLayoutActivity.class);
                startActivity(tempIntent);
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
        actionBar.setTitle(mTitle);
    }

    public void setActionBarTitle(int resouce) {
        mTitle = getString(resouce);
        setTitle(mTitle);
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
        switch (item.getItemId()) {
            case R.id.menu_calendar:
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
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
