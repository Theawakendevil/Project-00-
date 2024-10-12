// MainActivity.java
package com.example.project00;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private FloatingActionButton downloadButton;
    private ArrayList<TabFragment> tabFragments;
    private TabPagerAdapter tabPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize ViewPager and Floating Action Button
        viewPager = findViewById(R.id.viewPager);
        downloadButton = findViewById(R.id.downloadButton);
        tabFragments = new ArrayList<>();

        // Setup the initial tab (example URL)
        addNewTab("https://www.example.com");

        // Floating action button click listener
        downloadButton.setOnClickListener(v -> {
            // Implement download functionality
            Toast.makeText(this, "Download button clicked", Toast.LENGTH_SHORT).show();
            // You can launch a download manager or implement download logic here
        });
    }

    // Method to add a new tab with a specified URL
    private void addNewTab(String url) {
        TabFragment newTab = new TabFragment(url);
        tabFragments.add(newTab);
        updateTabs();
    }

    // Method to update the ViewPager with the latest tab fragments
    private void updateTabs() {
        tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), tabFragments);
        viewPager.setAdapter(tabPagerAdapter);
        viewPager.setCurrentItem(tabFragments.size() - 1); // Open the newly added tab
    }

    // Custom PagerAdapter for managing tab fragments
    private static class TabPagerAdapter extends FragmentPagerAdapter {
        private final ArrayList<TabFragment> fragments;

        public TabPagerAdapter(@NonNull FragmentManager fm, ArrayList<TabFragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}￼Enter
