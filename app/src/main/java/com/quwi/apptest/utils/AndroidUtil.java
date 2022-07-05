package com.quwi.apptest.utils;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

public class AndroidUtil {

    public static void setTouchableWindow(Window window, Boolean isTouchable) {
        if (isTouchable) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        } else {
            window.addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        }
    }

    public static void hideKeyboard(Activity activity) {
        Object inputsService = activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        InputMethodManager inputManager = (InputMethodManager) inputsService;
        View viewFocused = activity.getCurrentFocus();
        if (viewFocused == null) {
            viewFocused = new View(activity);
        }
        inputManager.hideSoftInputFromWindow(viewFocused.getWindowToken(), 0);
    }

}
