package com.fragment.lazy.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment extends Fragment {
    public final String TAG = this.getClass().getSimpleName();

    protected boolean isVisible;
    private boolean isPrepared;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.e(TAG,"setUserVisibleHint:"+isVisibleToUser);
        Log.e(TAG,"setUserVisibleHint getUserVisibleHint:"+getUserVisibleHint());
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.e(TAG,"onHiddenChanged:"+hidden);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(getLayout(), container, false);
        Log.e(TAG,"onCreateView:");
        isPrepared = true;
        lazyLoad();
        return fragmentView;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e(TAG,"onViewCreated:");
    }

    abstract int getLayout();

    protected void onVisible() {
        lazyLoad();
    }

    protected void lazyLoad() {
        if (!isPrepared || !isVisible) {
            return;
        }

        onLoad();
    }

    protected abstract void onLoad();

    ;

    protected void onInvisible() {
    }


}
