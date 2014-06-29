package akturk.maktek.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import akturk.maktek.R;
import akturk.maktek.adapter.AgendaListAdapter;

public final class AgendaFragment extends BaseFragment {
    public static final int POSITION = 2;

    private ListView mListView;
    private AgendaListAdapter mAdapter;

    @Override
    protected int getLayoutResourceID() {
        return R.layout.fragment_agenda;
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
