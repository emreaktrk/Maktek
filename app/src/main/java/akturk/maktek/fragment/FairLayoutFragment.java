package akturk.maktek.fragment;

import android.os.Bundle;
import android.view.View;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.squareup.picasso.Picasso;

import akturk.maktek.R;
import uk.co.senab.photoview.PhotoView;

public class FairLayoutFragment extends BaseFragment {
    public static final int POSITION = 2;

    private PhotoView mImageViewTouch;

    @Override
    protected int getLayoutResourceID() {
        return R.layout.fragment_fair_layout;
    }

    @Override
    protected int getShowcaseTargetResourceID() {
        return ShowcaseView.NO_ID;
    }

    @Override
    protected int getShowcaseTitleResourceID() {
        return ShowcaseView.NO_ID;
    }

    @Override
    protected int getShowcaseDetailResourceID() {
        return ShowcaseView.NO_ID;
    }

    @Override
    protected long getShowcaseSingleShotID() {
        return ShowcaseView.NO_ID;
    }

    @Override
    protected int getActionBarTitle() {
        return R.string.title_fair_layout;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mImageViewTouch = (PhotoView) view.findViewById(R.id.activity_fair_layout_photoview);
        Picasso.with(getActivity().getBaseContext()).load(R.drawable.image_fair_layout).into(mImageViewTouch);
    }
}
