package akturk.maktek.fragment;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import akturk.maktek.R;
import akturk.maktek.adapter.HomeListAdapter;
import akturk.maktek.constant.SingleShotID;
import akturk.maktek.parser.HomeXMLParser;
import akturk.maktek.view.QuickReturnListView;

public final class HomeFragment extends BaseListFragment {
    public static final int POSITION = 0;

    private static final int STATE_ONSCREEN = 0;
    private int mState = STATE_ONSCREEN;
    private static final int STATE_OFFSCREEN = 1;
    private static final int STATE_RETURNING = 2;
    private QuickReturnListView mListView;
    private LinearLayout mQuickReturnView;
    private int mQuickReturnHeight;
    private int mScrollY;
    private int mMinRawY = 0;
    private TranslateAnimation anim;

    @Override
    protected int getLayoutResourceID() {
        return R.layout.fragment_home;
    }

    @Override
    protected int getShowcaseTargetResourceID() {
        return android.R.id.home;
    }

    @Override
    protected int getShowcaseTitleResourceID() {
        return R.string.showcase_title_home;
    }

    @Override
    protected int getShowcaseDetailResourceID() {
        return R.string.showcase_detail_home;
    }

    @Override
    protected long getShowcaseSingleShotID() {
        return SingleShotID.SHOWCASE_SINGLESHOT_HOME;
    }

    @Override
    protected int getActionBarTitle() {
        return R.string.title_home;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mQuickReturnView = (LinearLayout) view.findViewById(R.id.fragment_home_quickreturnview);
        mListView = (QuickReturnListView) getListView();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        HomeXMLParser tempParser = new HomeXMLParser(getActivity().getBaseContext());
        HomeListAdapter tempAdapter = new HomeListAdapter(getActivity().getBaseContext(), tempParser.getList());
        setListHeader(savedInstanceState);
        setListAdapter(tempAdapter);

        mListView.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        mQuickReturnHeight = mQuickReturnView.getHeight();
                        mListView.computeScrollY();
                    }
                }
        );

        mListView.setOnScrollListener(new OnScrollListener() {
            @SuppressLint("NewApi")
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {

                mScrollY = 0;
                int translationY = 0;

                if (mListView.scrollYIsComputed()) {
                    mScrollY = mListView.getComputedScrollY();
                }

                int rawY = mScrollY;

                switch (mState) {
                    case STATE_OFFSCREEN:
                        if (rawY >= mMinRawY) {
                            mMinRawY = rawY;
                        } else {
                            mState = STATE_RETURNING;
                        }
                        translationY = rawY;
                        break;

                    case STATE_ONSCREEN:
                        if (rawY > mQuickReturnHeight) {
                            mState = STATE_OFFSCREEN;
                            mMinRawY = rawY;
                        }
                        translationY = rawY;
                        break;

                    case STATE_RETURNING:

                        translationY = (rawY - mMinRawY) + mQuickReturnHeight;

                        System.out.println(translationY);
                        if (translationY < 0) {
                            translationY = 0;
                            mMinRawY = rawY + mQuickReturnHeight;
                        }

                        if (rawY == 0) {
                            mState = STATE_ONSCREEN;
                            translationY = 0;
                        }

                        if (translationY > mQuickReturnHeight) {
                            mState = STATE_OFFSCREEN;
                            mMinRawY = rawY;
                        }
                        break;
                }

                /** this can be used if the build is below honeycomb **/
                if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.HONEYCOMB) {
                    anim = new TranslateAnimation(0, 0, translationY,
                            translationY);
                    anim.setFillAfter(true);
                    anim.setDuration(0);
                    mQuickReturnView.startAnimation(anim);
                } else {
                    mQuickReturnView.setTranslationY(translationY);
                }

            }

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }
        });
    }

    private void setListHeader(Bundle savedInstanceState) {
        ViewFlipper tempViewFlipper = (ViewFlipper) getLayoutInflater(savedInstanceState).inflate(R.layout.cell_home_header, mListView, false);

        Animation tempInAnimation = (AnimationUtils.loadAnimation(getActivity().getBaseContext(), android.R.anim.slide_in_left));
        tempInAnimation.setDuration(1000);

        Animation tempOutAnimation = (AnimationUtils.loadAnimation(getActivity().getBaseContext(), android.R.anim.slide_out_right));
        tempOutAnimation.setDuration(1000);

        tempViewFlipper.setInAnimation(tempInAnimation);
        tempViewFlipper.setOutAnimation(tempOutAnimation);

        tempViewFlipper.setFlipInterval(4000);
        tempViewFlipper.startFlipping();
        mListView.addHeaderView(tempViewFlipper);
    }
}