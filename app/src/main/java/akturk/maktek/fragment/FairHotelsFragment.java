package akturk.maktek.fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import akturk.maktek.R;
import akturk.maktek.adapter.FairHotelsListAdapter;
import akturk.maktek.parser.FairHotelsXMLParser;

public final class FairHotelsFragment extends BaseChildFragment {
    public static final int SUB_POSITION = 1;

    private ListView mListView;
    private FairHotelsListAdapter mAdapter;

    @Override
    protected int getLayoutResourceID() {
        return R.layout.fragment_fair_hotels;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FairHotelsXMLParser tempParser = new FairHotelsXMLParser(getActivity().getBaseContext());
        mAdapter = new FairHotelsListAdapter(getActivity().getBaseContext(), tempParser.getList());

        mListView = (ListView) view.findViewById(R.id.fragment_fair_hotels_listview);
        mListView.setAdapter(mAdapter);
    }
}
