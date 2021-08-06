package com.openclassrooms.myfragmentapp.Controllers.Activities;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.openclassrooms.myfragmentapp.Controllers.Fragments.DetailFragment;
import com.openclassrooms.myfragmentapp.Controllers.Fragments.MainFragment;
import com.openclassrooms.myfragmentapp.R;

public class MainActivity extends BaseActivity implements MainFragment.OnButtonClickedListener {

    public MainFragment mainFragment;
    private DetailFragment detailFragment;

    @Override
    protected int getFragmentLayout() {
        return  R.layout.activity_main;
    }

    @Override
    protected void configureFragment() {
        this.configureAndShowMainFragment();
        //TODO
        this.configureAndShowDetailFragment();
    }

    @Override
    protected void updateFragment() { }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_params_toolbar) {
            this.showParamsActivity();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // --------------
    // CallBack
    // --------------

    @Override
    public void onButtonClicked(View view) {
        // 1 - Retrieve button tag
        int buttonTag = Integer.parseInt(view.getTag().toString());

        // 2 - Check if DetailFragment is visible (Tablet)
        if (detailFragment != null && detailFragment.isVisible()) {
            // 2.1 - TABLET : Update directly TextView
            detailFragment.updateTextView(buttonTag);
        } else {
            // 2.2 - SMARTPHONE : Pass tag to the new intent that will show DetailActivity (and so DetailFragment)
           this.showDetailActivity(buttonTag);
        }
    }

    // --------------
    // FRAGMENTS
    // --------------
    private void configureAndShowMainFragment() {
        mainFragment = new MainFragment();
        this.showFragment(mainFragment, R.id.frame_layout_main);
    }

    private void configureAndShowDetailFragment(){
        detailFragment = new DetailFragment();
        if (detailFragment == null){
            detailFragment = new DetailFragment();
            this.showFragment(detailFragment, R.id.frame_layout_detail);
        }else if ( findViewById(R.id.frame_layout_detail) != null){
            this.showFragment(detailFragment, R.id.frame_layout_detail);

        }
    }
    // --------------
    // ACTIVITIES
    // --------------

    private void showParamsActivity(){
        Intent i = new Intent(this, ParamsActivity.class);
        startActivity(i);
    }

    private void showDetailActivity(int buttonTag){
        Intent i = new Intent(this, DetailActivity.class);
        i.putExtra(DetailActivity.EXTRA_BUTTON_TAG, buttonTag);
        startActivity(i);
    }


}

