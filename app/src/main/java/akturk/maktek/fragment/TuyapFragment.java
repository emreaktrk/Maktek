package akturk.maktek.fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import akturk.maktek.R;
import akturk.maktek.adapter.TuyapListAdapter;
import akturk.maktek.parser.TuyapXMLParser;

public final class TuyapFragment extends BaseChildFragment {
    public static final int SUB_POSITION = 0;

    private ListView mListView;
    private TuyapListAdapter mAdapter;

    @Override
    protected int getLayoutResourceID() {
        return R.layout.fragment_tuyap;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TuyapXMLParser tempParser = new TuyapXMLParser(getActivity().getBaseContext());
        mAdapter = new TuyapListAdapter(getActivity().getBaseContext(), tempParser.getList());

        mListView = (ListView) view.findViewById(R.id.fragment_tuyap_listview);
        mListView.setAdapter(mAdapter);
    }
}
