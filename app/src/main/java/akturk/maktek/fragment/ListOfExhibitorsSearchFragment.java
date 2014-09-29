package akturk.maktek.fragment;


import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.SearchView;

import com.devspark.appmsg.AppMsg;
import com.quentindommerc.superlistview.SuperListview;

import java.util.ArrayList;

import akturk.maktek.R;
import akturk.maktek.adapter.ListOfExhibitorsSearchListAdapter;
import akturk.maktek.dialog.ExhibitorDialogFragment;
import akturk.maktek.global.MaktekApplication;
import akturk.maktek.helper.AppMsgWrapper;
import akturk.maktek.interfaces.OnExhibitorClickListener;
import akturk.maktek.interfaces.ServiceCallback;
import akturk.maktek.model.Exhibitor;
import akturk.maktek.provider.AgendaIODataProvider;
import akturk.maktek.provider.ExhibitorIODataProvider;
import akturk.maktek.task.ExhibitorAsyncTask;
import akturk.maktek.view.ColoredSearchView;

public final class ListOfExhibitorsSearchFragment extends BaseChildFragment implements SwipeRefreshLayout.OnRefreshListener, ServiceCallback<ArrayList<Exhibitor>>, OnExhibitorClickListener, SearchView.OnQueryTextListener {
    public static final int SUB_POSITION = 0;

    private ArrayList<Exhibitor> mList;
    private ListOfExhibitorsSearchListAdapter mAdapter;
    private SuperListview mListView;
    private ColoredSearchView mSearchView;
    private ExhibitorIODataProvider mExhibitorProvider;
    private AgendaIODataProvider mAgendaProvider;
    private AppMsgWrapper mAppMsgWrapper;
    private ExhibitorAsyncTask mAsyncTask;

    @Override
    protected int getLayoutResourceID() {
        return R.layout.fragment_list_of_exhibitors_search;
    }

    @SuppressWarnings("ResourceAsColor")
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAppMsgWrapper = new AppMsgWrapper(getActivity());

        mSearchView = (ColoredSearchView) view.findViewById(R.id.fragment_list_of_exhibitors_search_searchview);
        mSearchView.setOnQueryTextListener(this);

        mList = new ArrayList<Exhibitor>();
        mAdapter = new ListOfExhibitorsSearchListAdapter(getActivity().getBaseContext(), mList);
        mAdapter.setOnExhibitorClickListener(this);

        mListView = (SuperListview) view.findViewById(R.id.fragment_list_of_exhibitors_search_listview);
        mListView.setRefreshingColor(android.R.color.black, R.color.maktek_secondry_color, android.R.color.black, R.color.maktek_secondry_color);
        mListView.setRefreshListener(this);

        mExhibitorProvider = MaktekApplication.getExhibitorIODataProvider();
        mAgendaProvider = MaktekApplication.getAgendaIODataProvider();

        mAsyncTask = new ExhibitorAsyncTask(getActivity().getBaseContext(), this);
        mAsyncTask.execute();
    }

    @Override
    public void onPause() {
        super.onPause();
        mAsyncTask.cancel(true);
    }

    private void setAdapter() {
        if (mListView.getAdapter() == null)
            mListView.setAdapter(mAdapter);
    }

    private void addIfAbsent(ArrayList<Exhibitor> list) {
        for (Exhibitor tempExhibitor : list)
            if (!mList.contains(tempExhibitor))
                mList.add(tempExhibitor);
    }

    @Override
    public void onRefresh() {
        ExhibitorAsyncTask tempAsyncTask = new ExhibitorAsyncTask(getActivity().getBaseContext(), this);
        tempAsyncTask.execute();
    }

    @Override
    public void onProgress() {
        mAppMsgWrapper.makeText(R.string.text_refreshing, AppMsg.STYLE_CONFIRM);
    }

    @Override
    public void onSuccess(ArrayList<Exhibitor> result) {
        setAdapter();
        addIfAbsent(result);

        mAdapter.notifyDataSetChanged();

        mExhibitorProvider.save(result);

        mAppMsgWrapper.makeText(R.string.text_refreshed, AppMsg.STYLE_INFO);
    }

    @Override
    public void onFailure() {
        mAppMsgWrapper.makeText(R.string.text_failure, AppMsg.STYLE_ALERT);
    }

    @Override
    public void onOffline() {
        setAdapter();

        mList.addAll(mExhibitorProvider.read());
        addIfAbsent(mExhibitorProvider.read());

        mAdapter.notifyDataSetChanged();

        mAppMsgWrapper.makeText(R.string.text_offline, AppMsg.STYLE_ALERT);
    }

    @Override
    public void onExhibitorClick(Exhibitor exhibitor) {
        if (mAgendaProvider.contains(exhibitor))
            exhibitor.setFavourite(true);

        ExhibitorDialogFragment tempDialogFragment = new ExhibitorDialogFragment(exhibitor);
        tempDialogFragment.show(getChildFragmentManager(), null);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        mAdapter.getFilter().filter(newText);
        return true;
    }
}
