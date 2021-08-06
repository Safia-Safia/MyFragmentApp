package com.openclassrooms.myfragmentapp.Controllers.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import icepick.Icepick;

public abstract class BaseFragment extends Fragment {

    // 1 - Force developer implement those methods
    protected abstract BaseFragment newInstance();
    protected abstract int getFragmentLayout();
    protected abstract void configureFragment();
    protected abstract void updateFragment();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getFragmentLayout(), container, false);
        //Get textView from layout (don't forget to create ID in fragment_detail.xml)
        ButterKnife.bind(this,view);
        this.configureFragment();
        Log.e("onCreateView ", " 1 " + view);
        this.updateFragment();
        return(view);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
        //Save buttonTag in Bundle when fragment is destroyed
    }

}
