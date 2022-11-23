package com.ktz.keeplinks;

import android.app.Activity;
import android.content.Context;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

public class Utils {

    // change app theme
    public static void setTheme(int theme){
        AppCompatDelegate.setDefaultNightMode(theme);
    }

}
