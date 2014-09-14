package akturk.maktek.fragment;

import android.os.Bundle;
import android.view.View;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.mobeta.android.dslv.DragSortController;
import com.mobeta.android.dslv.DragSortListView;

import akturk.maktek.R;
import akturk.maktek.adapter.AgendaListAdapter;
import akturk.maktek.dialog.ExhibitorDialogFragment;
import akturk.maktek.global.MaktekApplication;
import akturk.maktek.interfaces.OnDialogFragmentDismissListener;
import akturk.maktek.interfaces.OnExhibitorClickListener;
import akturk.maktek.model.Agenda;
import akturk.maktek.model.Exhibitor;
import akturk.maktek.provider.AgendaIODataProvider;

public final class AgendaFragment extends BaseFragment implements DragSortListView.DropListener, DragSortListView.RemoveListener, OnExhibitorClickListener, OnDialogFragmentDismissListener {
    public static final int POSITION = 3;

    private DragSortListView mListView;
    private AgendaListAdapter mAdapter;
    private AgendaIODataProvider mProvider;
    private DragSortController mController;

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
        return R.string.title_agenda;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mProvider = MaktekApplication.getAgendaIODataProvider();

        mAdapter = new AgendaListAdapter(getActivity().getBaseContext(), mProvider.getList());
        mAdapter.setOnExhibitorClickListener(this);

        mListView = (DragSortListView) view.findViewById(R.id.fragment_agenda_listview);
        setEmptyView();
        setDSLV();
        mListView.setAdapter(mAdapter);
    }

    private void setDSLV() {
        mListView.setDropListener(this);
        mListView.setRemoveListener(this);

        mController = new DragSortController(mListView);
        mController.setRemoveEnabled(true);
        mController.setSortEnabled(true);
        mController.setRemoveMode(DragSortController.FLING_REMOVE);
        mController.setDragInitMode(DragSortController.ON_DOWN);
        mController.setDragHandleId(R.id.cell_agenda_handleview);

        mListView.setFloatViewManager(mController);
        mListView.setOnTouchListener(mController);
        mListView.setDragEnabled(true);
    }

    private void setEmptyView() {
        View tempEmtpyView = getView().findViewById(R.id.fragment_agenda_emptyview);
        mListView.setEmptyView(tempEmtpyView);
    }

    @Override
    public void remove(int position) {
        mProvider.remove(position);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void drop(int from, int to) {
        Agenda tempAgenda = mProvider.getList().get(from);

        mProvider.remove(from);
        mProvider.add(to, tempAgenda);

        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onExhibitorClick(Exhibitor exhibitor) {
        ExhibitorDialogFragment tempDialogFragment = new ExhibitorDialogFragment(exhibitor);
        tempDialogFragment.setOnDialogFragmentDismissListener(this);
        tempDialogFragment.show(getFragmentManager(), null);
    }

    @Override
    public void onDismiss() {
        mAdapter.notifyDataSetChanged();
    }
}