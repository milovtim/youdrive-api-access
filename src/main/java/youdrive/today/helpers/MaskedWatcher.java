package youdrive.today.helpers;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView.BufferType;
import me.zhanghai.android.materialprogressbar.BuildConfig;

public class MaskedWatcher implements TextWatcher {
    private boolean mAcceptOnlyNumbers;
    private char mCharRepresentation;
    private final EditText mEditText;
    private boolean mIsUpdating;
    private final String mMask;
    private String mPhone;

    public MaskedWatcher(EditText editText, String mask) {
        this.mPhone = BuildConfig.FLAVOR;
        if (mask == null) {
            throw new RuntimeException("Mask can't be null");
        } else if (editText == null) {
            throw new RuntimeException("EditText can't be null");
        } else {
            this.mEditText = editText;
            this.mMask = mask;
            this.mIsUpdating = false;
            editText.addTextChangedListener(this);
            this.mCharRepresentation = '#';
            if (editText.getEditableText() == null) {
                editText.setTextKeepState(BuildConfig.FLAVOR, BufferType.EDITABLE);
            }
        }
    }

    public boolean acceptOnlyNumbers() {
        return this.mAcceptOnlyNumbers;
    }

    public void setAcceptOnlyNumbers(boolean acceptOnlyNumbers) {
        this.mAcceptOnlyNumbers = acceptOnlyNumbers;
    }

    public char getCharRepresentation() {
        return this.mCharRepresentation;
    }

    public void setCharRepresentation(char charRepresentation) {
        this.mCharRepresentation = charRepresentation;
    }

    public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
        if (this.mIsUpdating) {
            this.mIsUpdating = false;
            return;
        }
        CharSequence insertedSequence = charSequence.subSequence(start, count + start);
        if (this.mAcceptOnlyNumbers && !isNumeric(insertedSequence)) {
            delete(start, start + count);
        } else if (charSequence.length() > this.mMask.length()) {
            delete(start, start + count);
        } else {
            int length = this.mEditText.length();
            for (int i = 0; i < length; i++) {
                char m = this.mMask.charAt(i);
                char e = this.mEditText.getText().charAt(i);
                if (!(m == this.mCharRepresentation || m == e)) {
                    this.mIsUpdating = true;
                    this.mEditText.getEditableText().insert(i, String.valueOf(m));
                }
            }
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
    }

    public void afterTextChanged(Editable editable) {
    }

    private void delete(int start, int end) {
        this.mIsUpdating = true;
        this.mEditText.setTextKeepState(this.mEditText.getText().delete(start, end), BufferType.EDITABLE);
    }

    private boolean isNumeric(CharSequence charSequence) {
        return TextUtils.isEmpty(charSequence) || TextUtils.isDigitsOnly(charSequence);
    }

    public String getPhone() {
        return this.mEditText.getText().toString().replace(" ", BuildConfig.FLAVOR).replace("(", BuildConfig.FLAVOR).replace(")", BuildConfig.FLAVOR);
    }
}
