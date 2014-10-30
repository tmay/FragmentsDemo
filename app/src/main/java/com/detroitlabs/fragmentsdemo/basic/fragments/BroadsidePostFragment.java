package com.detroitlabs.fragmentsdemo.basic.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.detroitlabs.fragmentsdemo.R;
import com.detroitlabs.fragmentsdemo.models.BroadsideItem;

/**
 * Created by Terry on 10/27/14.
 */
public class BroadsidePostFragment extends Fragment {

    private static final String BROADSIDE_ITEM = "broadside_item";

    public static BroadsidePostFragment newInstance(BroadsideItem item) {
        BroadsidePostFragment fragment = new BroadsidePostFragment();
        Bundle args = new Bundle();
        args.putParcelable(BROADSIDE_ITEM, item);
        fragment.setArguments(args);
        return fragment;
    }

    private WebView content;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bside_post, container, false);

        content = (WebView) view.findViewById(R.id.web_content);
        content.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);

        setBroadsideItem( (BroadsideItem) getArguments().get(BROADSIDE_ITEM) );
        return view;
    }

    public void setBroadsideItem(BroadsideItem item) {
        if (item == null)
            return;

        content.loadUrl(item.url);
    }
}
