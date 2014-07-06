package akturk.maktek.fragment;


import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ArrayAdapter;

import com.quentindommerc.superlistview.SuperListview;

import java.util.ArrayList;

import akturk.maktek.R;
import akturk.maktek.model.Exhibitor;
import akturk.maktek.interfaces.Callback;
import akturk.maktek.task.ExhibitorAsyncTask;

public final class ListOfExhibitorsFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, Callback<ArrayList<Exhibitor>> {
    public static final int POSITION = 1;
    ArrayList<String> lst;
    private SuperListview mListView;
    private ArrayAdapter<String> mAdapter;

    @Override
    protected int getLayoutResourceID() {
        return R.layout.fragment_joiners;
    }

    @Override
    protected int getShowcaseTargetResourceID() {
        return 0;
    }

    @Override
    protected int getActionBarTitle() {
        return R.string.title_list_of_exhibitors;
    }

    @SuppressWarnings("ResourceAsColor")
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lst = new ArrayList<String>();
        lst.add("Deneme");
        lst.add("Deneme1");
        lst.add("Deneme2");
        mAdapter = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_list_item_1, android.R.id.text1, lst);

        mListView = (SuperListview) view.findViewById(R.id.fragment_joiners_listview);
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

    }

    @Override
    public void onSuccess(ArrayList<Exhibitor> result) {
        for (Exhibitor tempExhibitor : result)
            lst.add(tempExhibitor.getID());

        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFailure() {

    }
}
