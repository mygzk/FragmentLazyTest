package com.fragment.lazy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.fragment.lazy.fragment.FirstFragment;
import com.fragment.lazy.fragment.SecondFragment;
import com.fragment.lazy.fragment.ThirdFragment;

public class RadioGroupFragmentActivity extends AppCompatActivity {


    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initview();
    }

    private void initview() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_first:
                        initFragment(R.id.rb_first);
                        break;
                    case R.id.rb_second:
                        initFragment(R.id.rb_second);
                        break;
                    case R.id.rb_third:
                        initFragment(R.id.rb_third);
                        break;
                }
            }
        });
        rg.check(R.id.rb_first);
    }


    private FirstFragment firstFragment;
    private SecondFragment secondFragment;
    private ThirdFragment thirdFragment;

    private void initFragment(int id) {
        FragmentManager manager = getSupportFragmentManager();

        transaction = manager.beginTransaction();
        switch (id) {
            case R.id.rb_first:
                if (firstFragment != null) {
                    transaction.remove(firstFragment);
                    firstFragment = null;
                }

                if (firstFragment == null) {
                    firstFragment = new FirstFragment();
                    transaction.add(R.id.container, firstFragment);
                }
                showFragment(firstFragment);
                break;
            case R.id.rb_second:
                if (secondFragment == null) {
                    secondFragment = new SecondFragment();
                    transaction.add(R.id.container, secondFragment);
                }
                showFragment(secondFragment);
                break;
            case R.id.rb_third:
                if (thirdFragment == null) {
                    thirdFragment = new ThirdFragment();
                    transaction.add(R.id.container, thirdFragment);
                }
                showFragment(thirdFragment);
                break;


        }

        transaction.commit();
    }


    private void showFragment(Fragment fragment) {
        if (fragment == null) {
            return;
        }
        if (firstFragment != null && fragment != firstFragment) {
            transaction.hide(firstFragment);
        }
        if (secondFragment != null && fragment != secondFragment) {
            transaction.hide(secondFragment);
        }
        if (thirdFragment != null && fragment != thirdFragment) {
            transaction.hide(thirdFragment);
        }
        transaction.show(fragment);


    }


}
