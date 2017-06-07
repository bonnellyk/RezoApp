package com.rezoapp.rezo.presentation.home.request;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rezoapp.rezo.R;
import com.rezoapp.rezo.presentation.home.discover.DiscoverModel;

public class RequestFragment extends Fragment {

    private RequestModel requestModel;

    public RequestFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.request_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setModel();
    }

    private void setModel() {
        this.requestModel = new RequestModel();
        this.requestModel.setContext(this.getContext());
    }

    public RequestModel getModel() {
        return this.requestModel;
    }
}
