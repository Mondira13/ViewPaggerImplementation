package com.example.enc.viewpagger;


import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements FragmentA.OnFragmentInteractionListener, FragmentB.OnFragmentInteractionListener, FragmentC.OnFragmentInteractionListener {

    ViewPager viewPager; // ViewPager allows the user to flip left and right through pages of data.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TabLayout tabLayout = findViewById(R.id.tabLayout); // TabLayout provides a horizontal layout to display tabs.
        tabLayout.addTab(tabLayout.newTab().setText("View Profile")); // [ All tabs display through
        // TabLayout instance.]  ; [ newTab() method create new tab ] ; [ In TabLayout can change text througt setText() method
        //  & change icon using setIcon() method]
        tabLayout.addTab(tabLayout.newTab().setText("Edit Profile"));
        tabLayout.addTab(tabLayout.newTab().setText("Contact"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL); // Set the gravity to use when laying out the tabs.

        viewPager = findViewById(R.id.viewPager);
        CustomPagerAdapter customPagerAdapter = new CustomPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        // The above CustomPagerAdapter extends the FragmentStatePagerAdapter. It invokes three
        // Fragments, one for each of its pages. Each of the fragments holds a TextView

        viewPager.setAdapter(customPagerAdapter); // set customPagerAdapter object in viewPager
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        // addOnPageChangeListener() methd will be invoked when page selection changes.

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
