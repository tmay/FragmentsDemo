package com.detroitlabs.fragmentsdemo.basic.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.detroitlabs.fragmentsdemo.basic.adapters.BroadsideItemAdapter;
import com.detroitlabs.fragmentsdemo.models.BroadsideItem;
import com.detroitlabs.fragmentsdemo.models.Queue;

import java.util.ArrayList;

/**
 * Created by Terry on 10/27/14.
 */
public class QueueUserListFragment extends android.support.v4.app.ListFragment {

    public static final String QUEUE = "queue";
    public static final String SELECTED_ITEM_INDEX = "selected_item_index";

    public interface OnQueueSelectionListener {
        public void onQueueSelection(BroadsideItem item);
    }

    public static QueueUserListFragment newInstance(Queue queue) {
        QueueUserListFragment fragment = new QueueUserListFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(QUEUE, queue.queue);
        fragment.setArguments(args);
        return fragment;
    }

    private OnQueueSelectionListener listener;
    private BroadsideItemAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ArrayList<BroadsideItem> data = (ArrayList<BroadsideItem>) getArguments().get(QUEUE);
        adapter = new BroadsideItemAdapter(getActivity(), data);
        this.setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }



    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        if (listener != null)
            listener.onQueueSelection(adapter.getItem(position));
    }

    public void setOnQueueSelectionListener(OnQueueSelectionListener listener) {
        this.listener = listener;
    }
}
