package com.openclassrooms.myfragmentapp.Controllers.Activities;

import com.openclassrooms.myfragmentapp.Controllers.Fragments.DetailFragment;
import com.openclassrooms.myfragmentapp.R;


public class DetailActivity extends BaseActivity {

    //Create static variable to identify Intent
    public static final String EXTRA_BUTTON_TAG = "com.openclassrooms.myfragmentapp.Controllers.Activities.DetailActivity.EXTRA_BUTTON_TAG";

    //Declare detail fragment
    private DetailFragment detailFragment;

    @Override
    protected int getFragmentLayout() {
        return R.layout.activity_detail;
    }

    @Override
    protected void configureFragment() {
        this.configureAndShowDetailFragment();
        this.updateDetailFragmentTextViewWithIntentTag();
    }

    @Override
    protected void updateFragment() {
        this.updateDetailFragmentTextViewWithIntentTag();
    }


    // --------------
    // FRAGMENTS
    // --------------

    private void configureAndShowDetailFragment(){
        // Get FragmentManager (Support) and Try to find existing instance of fragment in FrameLayout container
        detailFragment =new DetailFragment();
        this.showFragment(detailFragment, R.id.frame_layout_detail);
    }

    // --------------
    // UPDATE UI
    // --------------

    //Update DetailFragment with tag passed from Intent
    private void updateDetailFragmentTextViewWithIntentTag(){
        //Get button's tag from intent
        detailFragment.buttonTag = getIntent().getIntExtra(EXTRA_BUTTON_TAG, 0);
    }
}