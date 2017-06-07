package com.rezoapp.rezo.presentation.home.discover;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rezoapp.rezo.R;
import com.rezoapp.rezo.presentation.home.contact.ContactModel;

public class DiscoverFragment extends Fragment {

    private DiscoverModel discoverModel;

    public DiscoverFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.discover_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setModel();
    }

    private void setModel() {
        this.discoverModel = new DiscoverModel();
        this.discoverModel.setContext(this.getContext());
    }

    public DiscoverModel getModel() {
        return this.discoverModel;
    }
}
