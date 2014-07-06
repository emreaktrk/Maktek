package akturk.maktek.fragment;


import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ArrayAdapter;

import com.devspark.appmsg.AppMsg;
import com.quentindommerc.superlistview.SuperListview;

import java.util.ArrayList;

import akturk.maktek.R;
import akturk.maktek.helper.AppMsgWrapper;
import akturk.maktek.interfaces.Callback;
import akturk.maktek.model.Exhibitor;
import akturk.maktek.task.ExhibitorAsyncTask;

public final class ListOfExhibitorsFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, Callback<ArrayList<Exhibitor>> {
    public static final int POSITION = 1;
    private ArrayList<String> lst;
    private SuperListview mListView;
    private ArrayAdapter<String> mAdapter;
    private AppMsgWrapper mAppMsgWrapper;

    @Override
    protected int getLayoutResourceID() {
        return R.layout.fragment_list_of_exhibitors;
    }

    @Override
    protected int getShowcaseTargetResourceID() {
        return R.id.fragment_list_of_exhibitors_listview;
    }

    @Override
    protected int getShowcaseTitleResourceID() {
        return R.string.showcase_title_pull_down;
    }

    @Override
    protected int getShowcaseDetailResourceID() {
        return R.string.showcase_detail_pull_down;
    }

    @Override
    protected long getShowcaseSingleShotID() {
        return SHOWCASE_SINGLESHOT_PULL_DOWN_TO_REFRESH;
    }

    @Override
    protected int getActionBarTitle() {
        return R.string.title_list_of_exhibitors;
    }

    @SuppressWarnings("ResourceAsColor")
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAppMsgWrapper = new AppMsgWrapper(getActivity());

        lst = new ArrayList<String>();
        lst.add("Deneme");
        lst.add("Deneme1");
        lst.add("Deneme2");
        mAdapter = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_list_item_1, android.R.id.text1, lst);

        mListView = (SuperListview) view.findViewById(R.id.fragment_list_of_exhibitors_listview);
        mListView.setRefreshingColor(android.R.color.black, R.color.maktek_secondry_color, android.R.color.black, R.color.maktek_secondry_color);
        mListView.setRefreshListener(this);
        mListView.setAdapter(mAdapter);
    }

    @Override
    public void onRefresh() {
        ExhibitorAsyncTask tempAsyncTask = new ExhibitorAsyncTask(this);
        tempAsyncTask.execute();
    }

    @Override
    public void onProgress() {
        mAppMsgWrapper.makeText(R.string.text_refreshing, AppMsg.STYLE_CONFIRM, AppMsg.LENGTH_STICKY);
    }

    @Override
    public void onSuccess(ArrayList<Exhibitor> result) {
        for (Exhibitor tempExhibitor : result)
            lst.add(tempExhibitor.getCompany());

        mAdapter.notifyDataSetChanged();
        mAppMsgWrapper.makeText(R.string.text_refreshed, AppMsg.STYLE_INFO, AppMsg.LENGTH_SHORT);
    }

    @Override
    public void onFailure() {
        mAppMsgWrapper.makeText(R.string.text_failure, AppMsg.STYLE_ALERT, AppMsg.LENGTH_SHORT);
    }
}
