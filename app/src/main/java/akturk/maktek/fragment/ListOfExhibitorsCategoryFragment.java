package akturk.maktek.fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.quentindommerc.superlistview.SuperListview;

import java.util.ArrayList;

import akturk.maktek.R;
import akturk.maktek.adapter.CategoryArrayAdapter;
import akturk.maktek.adapter.ListOfExhibitorsCategoryListAdapter;
import akturk.maktek.dialog.ExhibitorDialogFragment;
import akturk.maktek.global.MaktekApplication;
import akturk.maktek.interfaces.OnExhibitorClickListener;
import akturk.maktek.model.Category;
import akturk.maktek.model.Exhibitor;
import akturk.maktek.provider.AgendaIODataProvider;
import akturk.maktek.provider.ExhibitorIODataProvider;

public final class ListOfExhibitorsCategoryFragment extends BaseChildFragment implements OnExhibitorClickListener, AdapterView.OnItemSelectedListener {
    public static final int SUB_POSITION = 1;

    private ArrayList<Exhibitor> mList;
    private ListOfExhibitorsCategoryListAdapter mAdapter;
    private SuperListview mListView;
    private Spinner mSearchView;
    private ExhibitorIODataProvider mExhibitorProvider;
    private AgendaIODataProvider mAgendaProvider;

    @Override
    protected int getLayoutResourceID() {
        return R.layout.fragment_list_of_exhibitors_category;
    }

    @SuppressWarnings("ResourceAsColor")
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CategoryArrayAdapter tempCategoryArrayAdapter = new CategoryArrayAdapter(getActivity().getBaseContext());

        mSearchView = (Spinner) view.findViewById(R.id.fragment_list_of_exhibitors_category_searchview);
        mSearchView.setAdapter(tempCategoryArrayAdapter);
        mSearchView.setSelection(tempCategoryArrayAdapter.getSize());
        mSearchView.setOnItemSelectedListener(this);

        mExhibitorProvider = MaktekApplication.getExhibitorIODataProvider();
        mAgendaProvider = MaktekApplication.getAgendaIODataProvider();

        mList = new ArrayList<Exhibitor>();
        mList.addAll(mExhibitorProvider.read());

        mAdapter = new ListOfExhibitorsCategoryListAdapter(getActivity().getBaseContext(), mList);
        mAdapter.setOnExhibitorClickListener(this);

        mListView = (SuperListview) view.findViewById(R.id.fragment_list_of_exhibitors_category_listview);
        mListView.setAdapter(mAdapter);
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
}
