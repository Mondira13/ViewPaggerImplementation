package com.example.enc.viewpagger;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.enc.viewpagger.models.Item;
import com.example.enc.viewpagger.models.SubmitData;
import com.example.enc.viewpagger.viewpagersdk.Service;
import com.example.enc.viewpagger.viewpagersdk.ViewPagerSDK;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements FragmentA.OnFragmentInteractionListener, FragmentC.OnFragmentInteractionListener {

    ViewPager viewPager; // ViewPager allows the user to flip left and right through pages of data.
    private TabLayout tabLayout;
    Service service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        service = ViewPagerSDK.getClient().create(Service.class);
        Call<SubmitData> call = service.retriveValues();

        tabLayout = findViewById(R.id.tabLayout); // TabLayout provides a horizontal layout to display tabs.
  /*      tabLayout.addTab(tabLayout.newTab().setText("View Profile")); // [ All tabs display through
        // TabLayout instance.]  ; [ newTab() method create new tab ] ; [ In TabLayout can change text througt setText() method
        //  & change icon using setIcon() method]
        tabLayout.addTab(tabLayout.newTab().setText("Edit Profile"));
        tabLayout.addTab(tabLayout.newTab().setText("Contact"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL); // Set the gravity to use when laying out the tabs.


*/



        viewPager = findViewById(R.id.viewPager);
//        CustomPagerAdapter customPagerAdapter = new CustomPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        // The above CustomPagerAdapter extends the FragmentStatePagerAdapter. It invokes three
        // Fragments, one for each of its pages. Each of the fragments holds a TextView

        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        // addOnPageChangeListener() methd will be invoked when page selection changes.

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
        });

        call.enqueue(new Callback<SubmitData>() {
            @Override
            public void onResponse(Call<SubmitData> call, Response<SubmitData> response) {

                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        List<Item> retrievedData = response.body().getItems();
                        for (int i = 0; i < retrievedData.size();i++){
                            String tabName = retrievedData.get(i).getName();
                            tabLayout.addTab(tabLayout.newTab().setText(tabName));
                        }

                        viewPager.setAdapter( new CustomPagerAdapter(getSupportFragmentManager(), retrievedData));
                    }
                }
            }
            @Override
            public void onFailure(Call<SubmitData> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failure..!!!", Toast.LENGTH_LONG).show();
                call.cancel();

            }
        });

    }

    @Override
    public void onFragmentInteraction(int number, String message) {

        if(message.isEmpty() || message == null){}
        else {
            viewPager.setCurrentItem(number);
            Fragment currentItem = ((CustomPagerAdapter) viewPager.getAdapter()).getCurrentItem(number);
//            FragmentB fragmentB = (FragmentB) getSupportFragmentManager().findFragmentById(R.id.fragB);
            ((BaseFragment)currentItem).displayReceivedData(number,message);
        }

    }


}
