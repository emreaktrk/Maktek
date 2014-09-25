package akturk.maktek.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import akturk.maktek.R;
import akturk.maktek.adapter.MibListAdapter;
import akturk.maktek.parser.MibXMLParser;

public class MibFragment extends BaseChildFragment {
    public static final int SUB_POSITION = 1;

    private ListView mListView;

    @Override
    protected int getLayoutResourceID() {
        return R.layout.fragment_mib;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MibXMLParser tempParser = new MibXMLParser(getActivity().getBaseContext());
        MibListAdapter tempAdapter = new MibListAdapter(getActivity().getBaseContext(), tempParser.getList());

        mListView = (ListView) view.findViewById(R.id.fragment_mib_listview);
        mListView.setAdapter(tempAdapter);
    }

    private void setListHeader(Bundle savedInstanceState) {
        ImageView tempImageView = (ImageView) getLayoutInflater(savedInstanceState).inflate(R.layout.cell_tiad_and_mib_header, mListView, false);
        tempImageView.setImageResource(R.drawable.image_slide_5);
        mListView.addHeaderView(tempImageView);
    }
}
