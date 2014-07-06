package akturk.maktek.fragment;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import akturk.maktek.R;
import akturk.maktek.adapter.MediaPartnersGridAdapter;

public final class MediaPartnersFragment extends BaseChildFragment {
    public static final int SUB_POSITION = 1;

    private GridView mGridView;
    private MediaPartnersGridAdapter mAdapter;

    @Override
    protected int getLayoutResourceID() {
        return R.layout.fragment_media_partners;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TypedArray tempPartnersIconArray = getResources().obtainTypedArray(R.array.media_partners_icon_array);
        mAdapter = new MediaPartnersGridAdapter(getActivity().getBaseContext(), getPartnerDrawableArray(tempPartnersIconArray));

        mGridView = (GridView) view.findViewById(R.id.fragment_media_partners_gridview);
        mGridView.setAdapter(mAdapter);
    }

    private Drawable[] getPartnerDrawableArray(TypedArray array) {
        Drawable[] tempDrawable = new Drawable[array.length()];
        for (int i = 0; i < array.length(); i++)
            tempDrawable[i] = array.getDrawable(i);

        return tempDrawable;
    }
}
