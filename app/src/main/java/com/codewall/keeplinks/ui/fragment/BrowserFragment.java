package com.codewall.keeplinks.ui.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;

import com.codewall.keeplinks.R;
import com.codewall.keeplinks.databinding.FragmentBrowserBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BrowserFragment extends Fragment {

    FragmentBrowserBinding binding;

    public BrowserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBrowserBinding.inflate(inflater,container,false);

        {
            FloatingActionButton mainFab = requireActivity().findViewById(R.id.main_fab);
            mainFab.hide();
        }

        {
            //Test Code ;-)
            binding.webView.loadUrl("https://speed.hetzner.de/");
            binding.webView.setWebViewClient(new WebViewClient());
            binding.webView.setWebChromeClient(new WebChromeClient());
            binding.webView.setDownloadListener((url, userAgent, contentDisposition, mimetype, contentLength) -> {
                // Nothing just testing code
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Title");
                StringBuilder str = new StringBuilder();
                str.append("url: ").append(url);
                str.append("\nuserAgent: ").append(userAgent);
                str.append("\ncontentDisposition: ").append(contentDisposition);
                str.append("\nmimeType: ").append(mimetype);
                str.append("\ncontentLength:").append(contentLength / 1024 / 1024);
                builder.setMessage(str.toString());
                AlertDialog dialog = builder.create();
                dialog.show();
            });
        }
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        {
            // To Re-show the FAB when other is opened.
            FloatingActionButton mainFab = requireActivity().findViewById(R.id.main_fab);
            mainFab.show();
        }
    }
}