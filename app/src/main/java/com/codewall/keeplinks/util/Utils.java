package com.codewall.keeplinks.util;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.RecyclerView;

public class Utils {

    /** change app theme */
    public static void setTheme(int theme){
        AppCompatDelegate.setDefaultNightMode(theme);
    }

    public static void copyToClipboard(Context context,String text){
        ((ClipboardManager)context.getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard",text));
    }

}
