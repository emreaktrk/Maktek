package akturk.maktek.fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import akturk.maktek.R;
import akturk.maktek.adapter.FairMarketingGroupListAdapter;
import akturk.maktek.parser.FairMarketingGroupXMLParser;

public final class FairMarketingGroupFragment extends BaseChildFragment {
    public static final int SUB_POSITION = 2;

    private ListView mListView;
    private FairMarketingGroupListAdapter mAdapter;

    @Override
    protected int getLayoutResourceID() {
        return R.layout.fragment_fair_marketing_group;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FairMarketingGroupXMLParser tempParser = new FairMarketingGroupXMLParser(getActivity().getBaseContext());
        mAdapter = new FairMarketingGroupListAdapter(getActivity().getBaseContext(), tempParser.getList());

        mListView = (ListView) view.findViewById(R.id.fragment_fair_marketing_group_listview);
        mListView.setAdapter(mAdapter);
    }
}
