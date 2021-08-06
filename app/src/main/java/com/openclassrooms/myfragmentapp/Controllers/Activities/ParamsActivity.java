package com.openclassrooms.myfragmentapp.Controllers.Activities;

import com.openclassrooms.myfragmentapp.Controllers.Fragments.ParamsFragment;
import com.openclassrooms.myfragmentapp.R;

public class ParamsActivity extends BaseActivity {

    //FOR DATA
    private ParamsFragment paramsFragment;

    // --------------
    // BASE METHODS
    // --------------

    @Override
    protected int getFragmentLayout() { return R.layout.activity_params; }

    @Override
    protected void configureFragment() {
        this.configureAndShowParamsFragment();
        this.configureToolbar();
    }

    @Override
    protected void updateFragment() {

    }

    // --------------
    // FRAGMENTS
    // --------------

    private void configureAndShowParamsFragment(){
        paramsFragment = (ParamsFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_params);

        if (paramsFragment == null) {
            paramsFragment = new ParamsFragment();
            this.showFragment(paramsFragment, R.id.frame_layout_params);
        }
    }
}
