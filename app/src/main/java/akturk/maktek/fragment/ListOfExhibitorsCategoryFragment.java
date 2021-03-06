package akturk.maktek.fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.quentindommerc.superlistview.SuperListview;

import java.util.ArrayList;

import akturk.maktek.R;
import akturk.maktek.adapter.CategoryListAdapter;
import akturk.maktek.adapter.ListOfExhibitorsCategoryListAdapter;
import akturk.maktek.dialog.ExhibitorDialogFragment;
import akturk.maktek.global.MaktekApplication;
import akturk.maktek.interfaces.OnExhibitorClickListener;
import akturk.maktek.interfaces.ServiceCallback;
import akturk.maktek.model.Category;
import akturk.maktek.model.Exhibitor;
import akturk.maktek.provider.AgendaIODataProvider;
import akturk.maktek.provider.ExhibitorIODataProvider;
import akturk.maktek.task.ExhibitorAsyncTask;

public final class ListOfExhibitorsCategoryFragment extends BaseChildFragment implements OnExhibitorClickListener, AdapterView.OnItemSelectedListener, ServiceCallback<ArrayList<Exhibitor>> {
    public static final int SUB_POSITION = 1;

    private ArrayList<Exhibitor> mList;
    private ListOfExhibitorsCategoryListAdapter mAdapter;
    private SuperListview mListView;
    private Spinner mSearchView;
    private ExhibitorIODataProvider mExhibitorProvider;
    private AgendaIODataProvider mAgendaProvider;
    private ExhibitorAsyncTask mAsyncTask;

    @Override
    protected int getLayoutResourceID() {
        return R.layout.fragment_list_of_exhibitors_category;
    }

    @SuppressWarnings("ResourceAsColor")
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CategoryListAdapter tempCategoryListAdapter = new CategoryListAdapter(getActivity().getBaseContext());

        mSearchView = (Spinner) view.findViewById(R.id.fragment_list_of_exhibitors_category_searchview);
        mSearchView.setAdapter(tempCategoryListAdapter);
        mSearchView.setSelection(tempCategoryListAdapter.getSize());
        mSearchView.setOnItemSelectedListener(this);

        mExhibitorProvider = MaktekApplication.getExhibitorIODataProvider();
        mAgendaProvider = MaktekApplication.getAgendaIODataProvider();

        mList = new ArrayList<Exhibitor>();

        mAdapter = new ListOfExhibitorsCategoryListAdapter(getActivity().getBaseContext(), mList);
        mAdapter.setOnExhibitorClickListener(this);

        mListView = (SuperListview) view.findViewById(R.id.fragment_list_of_exhibitors_category_listview);
        mListView.setAdapter(mAdapter);

        mAsyncTask = new ExhibitorAsyncTask(getActivity().getBaseContext(), this);
        mAsyncTask.execute();
    }

    @Override
    public void onPause() {
        super.onPause();
        mAsyncTask.cancel(true);
    }

    @Override
    public void onExhibitorClick(Exhibitor exhibitor) {
        if (mAgendaProvider.contains(exhibitor))
            exhibitor.setFavourite(true);

        ExhibitorDialogFragment tempDialogFragment = new ExhibitorDialogFragment(exhibitor);
        tempDialogFragment.show(getChildFragmentManager(), null);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        Category tempCategory = Category.getInstance(position);
        mAdapter.getFilter().filter(tempCategory.getName(getActivity().getBaseContext()));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    @Override
    public void onProgress() {

    }

    @Override
    public void onSuccess(ArrayList<Exhibitor> result) {
        mList.addAll(result);
        mAdapter.notifyDataSetChanged();
        mAdapter.getFilter().filter(Category.ALL.getName(getActivity().getBaseContext()));
    }

    @Override
    public void onFailure() {

    }

    @Override
    public void onOffline() {
        mList.addAll(mExhibitorProvider.read());
        mAdapter.notifyDataSetChanged();
        mAdapter.getFilter().filter(Category.ALL.getName(getActivity().getBaseContext()));
    }
}
