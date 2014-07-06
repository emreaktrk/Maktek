package akturk.maktek.fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import akturk.maktek.R;
import akturk.maktek.adapter.TuyapOverseasOfficesListAdapter;
import akturk.maktek.handler.TuyapOverseasOfficesXMLParser;

public final class TuyapOverseasOfficesFragment extends BaseChildFragment {
    public static final int SUB_POSITION = 4;

    private ListView mListView;
    private TuyapOverseasOfficesListAdapter mAdapter;

    @Override
    protected int getLayoutResourceID() {
        return R.layout.fragment_tuyap_overseas_offices;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TuyapOverseasOfficesXMLParser tempParser = new TuyapOverseasOfficesXMLParser(getActivity().getBaseContext());
        mAdapter = new TuyapOverseasOfficesListAdapter(getActivity().getBaseContext(), tempParser.getList());

        mListView = (ListView) view.findViewById(R.id.fragment_tuyap_overseas_offices_listview);
        mListView.setAdapter(mAdapter);
    }
}
