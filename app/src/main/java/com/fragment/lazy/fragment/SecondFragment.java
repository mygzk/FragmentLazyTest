package com.fragment.lazy.fragment;


import android.support.v4.app.Fragment;
import android.util.Log;

import com.fragment.lazy.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends BaseFragment {


    public SecondFragment() {
        // Required empty public constructor
    }




    @Override
    int getLayout() {
        return R.layout.fragment_second;
    }

    @Override
    protected void onLoad() {
        Log.e(TAG,"SecondFragment onLoad");
    }
}
