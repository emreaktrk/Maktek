package akturk.maktek.activity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import akturk.maktek.R;
import akturk.maktek.constant.Constants;
import akturk.maktek.model.Exhibitor;
import akturk.maktek.provider.OverlayProvider;

public final class MapActivity extends BaseActivity {
    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private Exhibitor mExhibitor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_map);
        setCustomActionBar();
        setCustomTitle(getString(R.string.title_map));

        mExhibitor = ((Exhibitor) getIntent().getSerializableExtra(Constants.EXHIBITOR));

        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_activity_map)).getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null)
                setUpMap();
        }
    }

    /**
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        LatLngBounds newarkBounds = new LatLngBounds(
                new LatLng(41.02220589124682, 28.619969249828273),       // South west corner
                new LatLng(41.0321127243813, 28.62805879221719));      // North east corner
        GroundOverlayOptions mOverlayOptions = new GroundOverlayOptions().image(OverlayProvider.getInstance()).transparency(0.2f).positionFromBounds(newarkBounds);

        mMap.addGroundOverlay(mOverlayOptions);
        mMap.addMarker(new MarkerOptions().position(new LatLng(mExhibitor.getLatitudeAsDouble(), mExhibitor.getLongitudeAsDouble())).title(mExhibitor.getName()));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(mExhibitor.getLatitudeAsDouble(), mExhibitor.getLongitudeAsDouble()), 16));
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(false);
        mMap.getUiSettings().setZoomControlsEnabled(false);
    }
}
