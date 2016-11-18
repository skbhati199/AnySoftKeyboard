package com.anysoftkeyboard.ime;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;

import com.anysoftkeyboard.keyboards.Keyboard;
import com.anysoftkeyboard.quicktextkeys.QuickTextKey;
import com.anysoftkeyboard.quicktextkeys.QuickTextKeyFactory;
import com.anysoftkeyboard.quicktextkeys.ui.QuickTextViewFactory;
import com.menny.android.anysoftkeyboard.R;

public abstract class AnySoftKeyboardWithQuickText extends AnySoftKeyboardClipboard {

    private boolean mDoNotFlipQuickTextKeyAndPopupFunctionality;
    private String mOverrideQuickTextText = null;


    @Override
    protected void onLoadSettingsRequired(SharedPreferences sharedPreferences) {
        super.onLoadSettingsRequired(sharedPreferences);
        mDoNotFlipQuickTextKeyAndPopupFunctionality = sharedPreferences.getBoolean(
                getString(R.string.settings_key_do_not_flip_quick_key_codes_functionality),
                getResources().getBoolean(R.bool.settings_default_do_not_flip_quick_keys_functionality));

        mOverrideQuickTextText = sharedPreferences.getString(getString(R.string.settings_key_emoticon_default_text), null);
    }

    protected void onQuickTextRequested(Keyboard.Key key) {
        if (mDoNotFlipQuickTextKeyAndPopupFunctionality) {
            outputCurrentQuickTextKey(key);
        } else {
            switchToQuickTextKeyboard();
        }
    }

    protected void onQuickTextKeyboardRequested(Keyboard.Key key) {
        if (mDoNotFlipQuickTextKeyAndPopupFunctionality) {
            switchToQuickTextKeyboard();
        } else {
            outputCurrentQuickTextKey(key);
        }
    }

    private void outputCurrentQuickTextKey(Keyboard.Key key) {
        QuickTextKey quickTextKey = QuickTextKeyFactory.getCurrentQuickTextKey(this);
        if (TextUtils.isEmpty(mOverrideQuickTextText))
            onText(key, quickTextKey.getKeyOutputText());
        else
            onText(key, mOverrideQuickTextText);
    }

    private void switchToQuickTextKeyboard() {
        View quickTextsLayout = getInputViewContainer().findViewById(R.id.quick_text_pager_root);
        if (quickTextsLayout == null) {
            quickTextsLayout = QuickTextViewFactory.createQuickTextView(getApplicationContext(), this, )
        }
    }
}
