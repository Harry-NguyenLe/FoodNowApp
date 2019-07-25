package vn.edu.csc.foodnowapp;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

import model.Store;

public class StoreLactionActivity extends AppCompatActivity {
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_laction);
        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab()
                .setIcon(R.drawable.icon_home)
                .setText("Home"));

        tabLayout.addTab(tabLayout.newTab()
                .setIcon(R.drawable.icon_profile)
                .setText("Profile"));

      /*  tabLayout.addTab(tabLayout.newTab()
                .setIcon(R.drawable.icon_order)
                .setText("Order"));*/
        displayContent(0);

        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                displayContent(tabLayout.getSelectedTabPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void displayContent(int tabPosition) {
        Fragment fragment = null;

        switch (tabPosition) {
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new ProfileFragment();
                break;
           /* case 2:
                fragment = new OrderFragment();
                break;*/

        }
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment);
        fragmentTransaction.commit();
    }

    public void getStoreForFragment(Store store) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, OrderFragment.newInstance(store));
        fragmentTransaction.commit();
    }

    public void backToPreviousScreen() {
        OrderFragment orderFragment = new OrderFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, orderFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
