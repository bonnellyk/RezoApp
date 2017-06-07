package com.rezoapp.rezo.presentation.home.contact;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.rezoapp.rezo.R;
import com.rezoapp.rezo.presentation.home.profile.ProfileModel;

public class ContactFragment extends Fragment {

    private ContactModel contactModel;

    public ContactFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.contact_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setModel();
    }

    private void setModel() {
        this.contactModel = new ContactModel();
        this.contactModel.setContext(this.getContext());
    }

    public ContactModel getModel() {
        return this.contactModel;
    }

}
