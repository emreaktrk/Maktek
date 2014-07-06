package akturk.maktek.fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import akturk.maktek.R;
import akturk.maktek.adapter.FreeShuttleServicesListAdapter;
import akturk.maktek.handler.ShuttleXMLParser;

public final class FreeShuttleServicesFragment extends BaseChildFragment {
    public static final int SUB_POSITION = 2;

    private ListView mListView;
    private FreeShuttleServicesListAdapter mAdapter;

    @Override
    protected int getLayoutResourceID() {
        return R.layout.fragment_free_shuttle_services;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ShuttleXMLParser tempParser = new ShuttleXMLParser(getActivity().getBaseContext());
        mAdapter = new FreeShuttleServicesListAdapter(getActivity().getBaseContext(), tempParser.getList());

        mListView = (ListView) view.findViewById(R.id.fragment_free_shuttle_services_listview);
        mListView.setAdapter(mAdapter);
    }
}
