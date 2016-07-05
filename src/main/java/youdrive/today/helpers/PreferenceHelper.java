package youdrive.today.helpers;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.Set;
import youdrive.today.C1733R;

public class PreferenceHelper {
    protected static final String INVITE = "youdrive.today.data.INVITE";
    protected static final String IS_FIRST = "youdrive.today.data.ISFIRST";
    protected static final String SESSION_ID = "youdrive.today.data.SESSION_ID";
    protected static final String USER_FILE = "youdrive.today.data.USER_FILE";
    private final SharedPreferences mHelper;

    public PreferenceHelper(Context context) {
        this.mHelper = context.getSharedPreferences(context.getString(C1733R.string.preference_file_key), 0);
    }

    private Editor getEditor() {
        return this.mHelper.edit();
    }

    public void putSession(Set<String> cookies) {
        getEditor().putStringSet(SESSION_ID, cookies).apply();
    }

    public Set<String> getSession() {
        return this.mHelper.getStringSet(SESSION_ID, null);
    }

    public void putUser(String user) {
        getEditor().putString(USER_FILE, user).apply();
    }

    public void logout() {
        getEditor().clear().apply();
    }

    public String getUser() {
        return this.mHelper.getString(USER_FILE, null);
    }

    public void putInvite(boolean b) {
        getEditor().putBoolean(INVITE, b).apply();
    }

    public boolean isInvite() {
        return this.mHelper.getBoolean(INVITE, true);
    }

    public boolean isFirst() {
        return this.mHelper.getBoolean(IS_FIRST, true);
    }

    public void setIsFirst() {
        this.mHelper.edit().putBoolean(IS_FIRST, false).commit();
    }

    public void clear() {
        getEditor().clear().apply();
    }
}
