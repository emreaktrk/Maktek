package akturk.maktek.fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import akturk.maktek.R;
import akturk.maktek.adapter.FairSalesGroupListAdapter;
import akturk.maktek.handler.FairSalesGroupXMLParser;

public final class FairSalesGroupFragment extends BaseChildFragment {
    public static final int SUB_POSITION = 1;

    private ListView mListView;
    private FairSalesGroupListAdapter mAdapter;

    @Override
    protected int getLayoutResourceID() {
        return R.layout.fragment_fair_sales_group;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FairSalesGroupXMLParser tempParser = new FairSalesGroupXMLParser(getActivity().getBaseContext());
        mAdapter = new FairSalesGroupListAdapter(getActivity().getBaseContext(), tempParser.getList());

        mListView = (ListView) view.findViewById(R.id.fragment_fair_sales_group_listview);
        mListView.setAdapter(mAdapter);
    }
}
