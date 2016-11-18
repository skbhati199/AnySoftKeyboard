package com.anysoftkeyboard.quicktextkeys.ui;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.anysoftkeyboard.ime.InputViewBinder;
import com.anysoftkeyboard.keyboards.AnyKeyboard;
import com.anysoftkeyboard.keyboards.Keyboard;
import com.anysoftkeyboard.keyboards.KeyboardDimens;
import com.anysoftkeyboard.keyboards.views.OnKeyboardActionListener;
import com.menny.android.anysoftkeyboard.R;

public class QuickTextPagerView extends LinearLayout implements InputViewBinder {
    private ViewPager mPager;

    public QuickTextPagerView(Context context) {
        super(context);
    }

    public QuickTextPagerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    public QuickTextPagerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public QuickTextPagerView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mPager = (ViewPager) findViewById(R.id.quick_text_keyboards_pager);
    }

    @NonNull
    @Override
    public KeyboardDimens getThemedKeyboardDimens() {
        return null;
    }

    @Override
    public void onViewNotRequired() {

    }

    @Override
    public boolean setControl(boolean active) {
        return false;
    }

    @Override
    public boolean setShifted(boolean active) {
        return false;
    }

    @Override
    public boolean isShifted() {
        return false;
    }

    @Override
    public boolean setShiftLocked(boolean locked) {
        return false;
    }

    @Override
    public boolean closing() {
        return false;
    }

    @Override
    public void setKeyboard(AnyKeyboard currentKeyboard, String nextAlphabetKeyboard, String nextSymbolsKeyboard) {

    }

    @Override
    public void setOnKeyboardActionListener(OnKeyboardActionListener keyboardActionListener) {
        FrameKeyboardViewClickListener frameKeyboardViewClickListener = new FrameKeyboardViewClickListener(keyboardActionListener);
        frameKeyboardViewClickListener.registerOnViews(this);
    }

    @Override
    public void setKeyboardActionType(int imeOptions) {

    }

    @Override
    public void popTextOutOfKey(CharSequence wordToAnimatePopping) {

    }

    @Override
    public void revertPopTextOutOfKey() {

    }

    @Override
    public void showQuickKeysView(Keyboard.Key key) {

    }

    @Override
    public boolean dismissPopupKeyboard() {
        return false;
    }

    @Override
    public boolean handleBack() {
        return false;
    }
    /* not implementing anything below */

    @Override
    public void openUtilityKeyboard() {}

    public ViewPager getPagerView() {
        return mPager;
    }
}
