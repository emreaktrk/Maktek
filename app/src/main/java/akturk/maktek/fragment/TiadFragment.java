package akturk.maktek.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import akturk.maktek.R;
import akturk.maktek.adapter.TiadListAdapter;
import akturk.maktek.parser.TiadXMLParser;

public class TiadFragment extends BaseChildFragment {
    public static final int SUB_POSITION = 0;

    private ListView mListView;

    @Override
    protected int getLayoutResourceID() {
        return R.layout.fragment_tiad;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TiadXMLParser tempParser = new TiadXMLParser(getActivity().getBaseContext());
        TiadListAdapter tempAdapter = new TiadListAdapter(getActivity().getBaseContext(), tempParser.getList());

        mListView = (ListView) view.findViewById(R.id.fragment_tiad_listview);
        setListHeader(savedInstanceState);
        mListView.setAdapter(tempAdapter);

    }

    private void setListHeader(Bundle savedInstanceState) {
        ImageView tempImageView = (ImageView) getLayoutInflater(savedInstanceState).inflate(R.layout.cell_tiad_and_mib_header, mListView, false);
        tempImageView.setImageResource(R.drawable.image_slide_4);
        mListView.addHeaderView(tempImageView);
    }
}
