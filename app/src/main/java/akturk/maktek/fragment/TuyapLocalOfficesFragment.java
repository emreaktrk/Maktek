package akturk.maktek.fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import akturk.maktek.R;
import akturk.maktek.adapter.TuyapLocalOfficesListAdapter;
import akturk.maktek.handler.TuyapLocalOfficesXMLParser;

public class TuyapLocalOfficesFragment extends BaseChildFragment {
    public static final int SUB_POSITION = 3;

    private ListView mListView;
    private TuyapLocalOfficesListAdapter mAdapter;

    @Override
    protected int getLayoutResourceID() {
        return R.layout.fragment_tuyap_local_offices;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TuyapLocalOfficesXMLParser tempParser = new TuyapLocalOfficesXMLParser(getActivity().getBaseContext());
        mAdapter = new TuyapLocalOfficesListAdapter(getActivity().getBaseContext(), tempParser.getList());

        mListView = (ListView) view.findViewById(R.id.fragment_tuyap_local_offices_listview);
        mListView.setAdapter(mAdapter);
    }
}
