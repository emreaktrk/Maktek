package akturk.maktek.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.github.amlcurran.showcaseview.ShowcaseView;

import akturk.maktek.R;
import akturk.maktek.adapter.AgendaListAdapter;

public final class AgendaFragment extends BaseFragment {
    public static final int POSITION = 3;

    private ListView mListView;
    private AgendaListAdapter mAdapter;

    @Override
    protected int getLayoutResourceID() {
        return R.layout.fragment_agenda;
    }

    @Override
    protected int getShowcaseTargetResourceID() {
        return ShowcaseView.NO_ID;
    }

    @Override
    protected int getShowcaseTitleResourceID() {
        return R.string.showcase_title_titlestrip;
    }

    @Override
    protected int getShowcaseDetailResourceID() {
        return R.string.showcase_detail_titlestrip;
    }

    @Override
    protected long getShowcaseSingleShotID() {
        return SHOWCASE_SINGLESHOT_TITLESTRIP;
    }

    @Override
    protected int getActionBarTitle() {
        return R.string.title_agenda;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAdapter = new AgendaListAdapter(getActivity().getBaseContext());
        mListView = (ListView) view.findViewById(R.id.fragment_agenda_listview);
    }
}
