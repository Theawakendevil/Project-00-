// TabFragment.java
package com.example.project00;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TabFragment extends Fragment {

    private WebView webView;

    private String url; // URL to load in the WebView

    public TabFragment(String url) {
        this.url = url; // Set the URL from the constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.tab_fragment, container, false);

        // Initialize WebView
        webView = view.findViewById(R.id.webView);

        // Configure WebView settings
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); // Enable JavaScript
        webSettings.setDomStorageEnabled(true); // Enable DOM storage

        // Set WebViewClient to handle page navigation
        webView.setWebViewClient(new WebViewClient());

        // Set WebChromeClient for additional features
        webView.setWebChromeClient(new WebChromeClient());

        // Load the specified URL
        webView.loadUrl(url);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (webView != null) {
            webView.destroy(); // Clean up WebView resources
        }
    }
}￼Enter
