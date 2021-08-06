package com.openclassrooms.myfragmentapp.Controllers.Fragments;

import com.openclassrooms.myfragmentapp.R;

public class ParamsFragment extends BaseFragment {

    @Override
    protected BaseFragment newInstance() {
        return new ParamsFragment();
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_params;
    }

    @Override
    protected void configureFragment() {
    }

    @Override
    protected void updateFragment() {
    }

}