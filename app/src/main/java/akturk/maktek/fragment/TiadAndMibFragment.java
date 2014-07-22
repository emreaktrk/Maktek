package akturk.maktek.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.github.amlcurran.showcaseview.ShowcaseView;

import akturk.maktek.R;
import akturk.maktek.adapter.HomeListAdapter;
import akturk.maktek.parser.TiadAndMibXMLParser;

public final class TiadAndMibFragment extends BaseFragment {
    public static final int POSITION = 7;

    private ListView mListView;

    @Override
    protected int getLayoutResourceID() {
        return R.layout.fragment_tiad_and_mib;
    }

    @Override
    protected int getShowcaseTargetResourceID() {
        return ShowcaseView.NO_ID;
    }

    @Override
    protected int getShowcaseTitleResourceID() {
        return ShowcaseView.NO_ID;
    }

    @Override
    protected int getShowcaseDetailResourceID() {
        return ShowcaseView.NO_ID;
    }

    @Override
    protected long getShowcaseSingleShotID() {
        return ShowcaseView.NO_ID;
    }

    @Override
    protected int getActionBarTitle() {
        return R.string.title_tiad_and_mib;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TiadAndMibXMLParser tempParser = new TiadAndMibXMLParser(getActivity().getBaseContext());
        HomeListAdapter tempAdapter = new HomeListAdapter(getActivity().getBaseContext(), tempParser.getList());

        mListView = (ListView) view.findViewById(R.id.fragment_tiad_and_mib_listview);
        mListView.setAdapter(tempAdapter);
    }
}
