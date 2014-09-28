package akturk.maktek.provider;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

import akturk.maktek.R;

public final class OverlayProvider {
    private static BitmapDescriptor mBitmapDescriptor;

    public static BitmapDescriptor getInstance() {
        if (mBitmapDescriptor == null)
            mBitmapDescriptor = BitmapDescriptorFactory.fromResource(R.drawable.image_map_overlay);

        return mBitmapDescriptor;
    }
}
