package akturk.maktek.fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import akturk.maktek.R;
import akturk.maktek.adapter.PressReleaseListAdapter;
import akturk.maktek.parser.PressReleaseXMLParser;

public final class PressReleaseFragment extends BaseChildFragment {
    public static final int SUB_POSITION = 0;

    private ListView mListView;

    @Override
    protected int getLayoutResourceID() {
        return R.layout.fragment_press_release;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        PressReleaseXMLParser tempParser = new PressReleaseXMLParser(getActivity().getBaseContext());
        PressReleaseListAdapter tempAdapter = new PressReleaseListAdapter(getActivity().getBaseContext(), tempParser.getList());

        mListView = (ListView) view.findViewById(R.id.fragment_press_release_listview);
        mListView.setAdapter(tempAdapter);
    }
}
