package com.openclassrooms.myfragmentapp.Controllers.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.openclassrooms.myfragmentapp.Controllers.Fragments.BaseFragment;
import com.openclassrooms.myfragmentapp.Controllers.Fragments.DetailFragment;
import com.openclassrooms.myfragmentapp.R;

import butterknife.ButterKnife;
import icepick.Icepick;

public abstract class BaseActivity extends AppCompatActivity {

    protected abstract int getFragmentLayout();

    protected abstract void configureFragment();

    protected abstract void updateFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getFragmentLayout());
        ButterKnife.bind(this);
        this.configureFragment();
        this.updateFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        this.updateFragment();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }

    protected void configureToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void showFragment(BaseFragment fragment, int layout) {

        Log.e("show fragment", " 1 " + fragment.getClass().getName());
        getSupportFragmentManager().beginTransaction()
                .add(layout, fragment)
                .commit();
    }
}
