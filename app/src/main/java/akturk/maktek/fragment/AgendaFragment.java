package akturk.maktek.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import akturk.maktek.R;

public final class AgendaFragment extends BaseFragment {
    public static final int POSITION = 2;
    private ListView mListView;

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
        mListView = (ListView) view.findViewById(R.id.fragment_agenda_listview);
    }
}
