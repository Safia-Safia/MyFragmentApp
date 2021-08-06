package com.openclassrooms.myfragmentapp.Controllers.Fragments;

import android.view.View;

import com.openclassrooms.myfragmentapp.R;

import butterknife.OnClick;

public class MainFragment extends BaseFragment implements View.OnClickListener {


    private OnButtonClickedListener mCallback;
    // 1 - Declare our interface that will be implemented by any container activity
    public interface OnButtonClickedListener {
       void onButtonClicked(View view);
    }

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    protected BaseFragment newInstance() {
        return new MainFragment();
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_main;
    }

    @Override
    protected void configureFragment() {

    }

    @Override
    protected void updateFragment() {
        // 4 - Call the method that creating callback after being attached to parent activity
        this.createCallbackToParentActivity();
    }


    @Override
    @OnClick({R.id.fragment_main_button_sad,R.id.fragment_main_button_happy,R.id.fragment_main_button_horrible})
    public void onClick(View v) {
        // 5 - Spread the click to the parent activity
        mCallback.onButtonClicked(v);
    }


    // 3 - Create callback to parent activity
    private void createCallbackToParentActivity(){
        try {
            //Parent activity will automatically subscribe to callback
            mCallback = (OnButtonClickedListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(e.toString()+ " must implement OnButtonClickedListener");
        }
    }
}