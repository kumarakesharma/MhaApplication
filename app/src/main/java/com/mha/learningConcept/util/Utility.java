package com.mha.learningConcept.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.mha.learningConcept.R;
import com.mha.learningConcept.databinding.LayoutCustomToastBinding;

public class Utility {
    public static void showShortToast(Context context, String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

}
