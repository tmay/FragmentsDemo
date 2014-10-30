package com.detroitlabs.fragmentsdemo.basic.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.detroitlabs.fragmentsdemo.R;
import com.detroitlabs.fragmentsdemo.models.BroadsideItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Terry on 10/27/14.
 */
public class BroadsideItemAdapter extends BaseAdapter {

    private ArrayList<BroadsideItem> queue;
    private Context context;

    public BroadsideItemAdapter(Context context, ArrayList<BroadsideItem> items) {
        this.context = context;
        this.queue = items;
    }

    @Override
    public int getCount() {
        return queue.size();
    }

    @Override
    public BroadsideItem getItem(int i) {
        return queue.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolderItem viewHolder;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.listitem_broadside_item, null);
            viewHolder = new ViewHolderItem();
            viewHolder.emailView = (TextView) view.findViewById(R.id.txt_name);
            viewHolder.gravatarView = (ImageView) view.findViewById(R.id.img_gravatar);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolderItem) view.getTag();
        }

        BroadsideItem item = queue.get(i);
        Picasso.with(context).load(item.gravatar).into(viewHolder.gravatarView);
        //should this be here or the model? hmmm, good question
        String email = (item.email.length() > 0) ? item.email : "<unknown>";
        viewHolder.emailView.setText(email);
        return view;
    }

    public void setQueue(ArrayList<BroadsideItem> queue) {
        this.queue = queue;
        notifyDataSetChanged();
    }

    static class ViewHolderItem {
        ImageView gravatarView;
        TextView emailView;
    }
}
