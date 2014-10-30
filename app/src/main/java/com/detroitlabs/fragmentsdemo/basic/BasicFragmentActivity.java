package com.detroitlabs.fragmentsdemo.basic;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.FrameLayout;

import com.detroitlabs.fragmentsdemo.R;
import com.detroitlabs.fragmentsdemo.basic.fragments.BroadsidePostFragment;
import com.detroitlabs.fragmentsdemo.basic.fragments.QueueUserListFragment;
import com.detroitlabs.fragmentsdemo.models.BroadsideItem;
import com.detroitlabs.fragmentsdemo.models.Queue;
import com.detroitlabs.fragmentsdemo.services.FileReader;

/**
 * Created by Terry on 10/27/14.
 */
public class BasicFragmentActivity extends FragmentActivity {

    private static final String CURRENT_ITEM = "current_item";
    private Queue queue;
    private boolean isDualPane;
    private BroadsideItem currentItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        if (savedInstanceState != null)
            currentItem = savedInstanceState.getParcelable(CURRENT_ITEM);

        FrameLayout detailContainer = (FrameLayout) findViewById(R.id.detail_container);
        isDualPane = (detailContainer != null);

        queue = FileReader.getLocalQueueData(this);
        showQueueFragment();
        if (isDualPane)
            showBroadsidePost(currentItem);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(CURRENT_ITEM, currentItem);
    }

    private void showQueueFragment() {
        QueueUserListFragment queueUserListFragment = QueueUserListFragment.newInstance(queue);
        queueUserListFragment.setOnQueueSelectionListener(new QueueUserListFragment.OnQueueSelectionListener() {
            @Override
            public void onQueueSelection(BroadsideItem item) {
                showBroadsidePost(item);
            }
        });

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, queueUserListFragment)
                .commit();
    }

    public void showBroadsidePost(BroadsideItem item) {
        currentItem = item;
        if (isDualPane) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_container, BroadsidePostFragment.newInstance(currentItem))
                    .commit();
        } else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, BroadsidePostFragment.newInstance(currentItem))
                    .addToBackStack("list")
                    .commit();
        }
    }
}
