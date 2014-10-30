package com.detroitlabs.fragmentsdemo.viewpager;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.detroitlabs.fragmentsdemo.R;
import com.detroitlabs.fragmentsdemo.models.Queue;
import com.detroitlabs.fragmentsdemo.services.FileReader;
import com.detroitlabs.fragmentsdemo.viewpager.adapters.BroadsidePostPagerAdapter;
import com.detroitlabs.fragmentsdemo.viewpager.transformers.DepthPageTransformer;
import com.detroitlabs.fragmentsdemo.viewpager.transformers.ZoomOutPageTransformer;

/**
 * Created by Terry on 10/28/14.
 */
public class FragmentViewPagerActivity extends FragmentActivity {

    private ViewPager pager;
    private Queue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        pager = (ViewPager) findViewById(R.id.pager);
        queue = FileReader.getLocalQueueData(this);

        BroadsidePostPagerAdapter adapter = new BroadsidePostPagerAdapter(getSupportFragmentManager(), queue.queue);
        pager.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("use Zoom Out Transformer")
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        pager.setPageTransformer(true, new ZoomOutPageTransformer());
                        return false;
                    }
                });
        menu.add("use Depth Transformer")
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        pager.setPageTransformer(true, new DepthPageTransformer());
                        return false;
                    }
                });
        menu.add("use no animation")
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        pager.setPageTransformer(true, null);
                        return false;
                    }
                });
        return super.onCreateOptionsMenu(menu);
    }
}
