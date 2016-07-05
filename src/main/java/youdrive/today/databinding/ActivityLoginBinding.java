package youdrive.today.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dd.CircularProgressButton;
import com.rengwuxian.materialedittext.MaterialEditText;
import youdrive.today.C1733R;
import youdrive.today.activities.LoginActivity;

public class ActivityLoginBinding extends ViewDataBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    public final CircularProgressButton btnLogin;
    public final MaterialEditText etLogin;
    public final MaterialEditText etPassword;
    public final ImageView ivLogo;
    private OnClickListenerImpl mAndroidViewViewOnCl;
    private OnClickListenerImpl1 mAndroidViewViewOnCl1;
    private OnClickListenerImpl2 mAndroidViewViewOnCl2;
    private OnClickListenerImpl3 mAndroidViewViewOnCl3;
    private long mDirtyFlags;
    private LoginActivity mListener;
    private final RelativeLayout mboundView0;
    public final TextView txtAbout;
    public final TextView txtEntrance;
    public final TextView txtQuestion;
    public final TextView txtRegistration;
    public final TextView txtRestore;

    public static class OnClickListenerImpl1 implements OnClickListener {
        private LoginActivity value;

        public OnClickListenerImpl1 setValue(LoginActivity value) {
            this.value = value;
            return value == null ? null : this;
        }

        public void onClick(View arg0) {
            this.value.onAbout(arg0);
        }
    }

    public static class OnClickListenerImpl2 implements OnClickListener {
        private LoginActivity value;

        public OnClickListenerImpl2 setValue(LoginActivity value) {
            this.value = value;
            return value == null ? null : this;
        }

        public void onClick(View arg0) {
            this.value.onRegistration(arg0);
        }
    }

    public static class OnClickListenerImpl3 implements OnClickListener {
        private LoginActivity value;

        public OnClickListenerImpl3 setValue(LoginActivity value) {
            this.value = value;
            return value == null ? null : this;
        }

        public void onClick(View arg0) {
            this.value.onRestore(arg0);
        }
    }

    public static class OnClickListenerImpl implements OnClickListener {
        private LoginActivity value;

        public OnClickListenerImpl setValue(LoginActivity value) {
            this.value = value;
            return value == null ? null : this;
        }

        public void onClick(View arg0) {
            this.value.onLogin(arg0);
        }
    }

    static {
        sIncludes = null;
        sViewsWithIds = new SparseIntArray();
        sViewsWithIds.put(C1733R.id.ivLogo, 5);
        sViewsWithIds.put(C1733R.id.txtEntrance, 6);
        sViewsWithIds.put(C1733R.id.etLogin, 7);
        sViewsWithIds.put(C1733R.id.etPassword, 8);
        sViewsWithIds.put(C1733R.id.txtQuestion, 9);
    }

    public ActivityLoginBinding(DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        this.mDirtyFlags = -1;
        Object[] bindings = ViewDataBinding.mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds);
        this.btnLogin = (CircularProgressButton) bindings[1];
        this.btnLogin.setTag(null);
        this.etLogin = (MaterialEditText) bindings[7];
        this.etPassword = (MaterialEditText) bindings[8];
        this.ivLogo = (ImageView) bindings[5];
        this.mboundView0 = (RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.txtAbout = (TextView) bindings[3];
        this.txtAbout.setTag(null);
        this.txtEntrance = (TextView) bindings[6];
        this.txtQuestion = (TextView) bindings[9];
        this.txtRegistration = (TextView) bindings[4];
        this.txtRegistration.setTag(null);
        this.txtRestore = (TextView) bindings[2];
        this.txtRestore.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int variableId, Object variable) {
        switch (variableId) {
            case C1733R.styleable.View_paddingEnd /*3*/:
                setListener((LoginActivity) variable);
                return true;
            default:
                return false;
        }
    }

    public void setListener(LoginActivity listener) {
        this.mListener = listener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        super.requestRebind();
    }

    public LoginActivity getListener() {
        return this.mListener;
    }

    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    protected void executeBindings() {
        synchronized (this) {
            long dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        LoginActivity listener = this.mListener;
        OnClickListener androidViewViewOnCli = null;
        OnClickListener androidViewViewOnCli1 = null;
        OnClickListener androidViewViewOnCli2 = null;
        OnClickListener androidViewViewOnCli3 = null;
        if (!((dirtyFlags & 3) == 0 || listener == null)) {
            OnClickListenerImpl onClickListenerImpl;
            OnClickListenerImpl1 onClickListenerImpl1;
            OnClickListenerImpl2 onClickListenerImpl2;
            OnClickListenerImpl3 onClickListenerImpl3;
            if (this.mAndroidViewViewOnCl == null) {
                onClickListenerImpl = new OnClickListenerImpl();
                this.mAndroidViewViewOnCl = onClickListenerImpl;
            } else {
                onClickListenerImpl = this.mAndroidViewViewOnCl;
            }
            androidViewViewOnCli = onClickListenerImpl.setValue(listener);
            if (this.mAndroidViewViewOnCl1 == null) {
                onClickListenerImpl1 = new OnClickListenerImpl1();
                this.mAndroidViewViewOnCl1 = onClickListenerImpl1;
            } else {
                onClickListenerImpl1 = this.mAndroidViewViewOnCl1;
            }
            androidViewViewOnCli1 = onClickListenerImpl1.setValue(listener);
            if (this.mAndroidViewViewOnCl2 == null) {
                onClickListenerImpl2 = new OnClickListenerImpl2();
                this.mAndroidViewViewOnCl2 = onClickListenerImpl2;
            } else {
                onClickListenerImpl2 = this.mAndroidViewViewOnCl2;
            }
            androidViewViewOnCli2 = onClickListenerImpl2.setValue(listener);
            if (this.mAndroidViewViewOnCl3 == null) {
                onClickListenerImpl3 = new OnClickListenerImpl3();
                this.mAndroidViewViewOnCl3 = onClickListenerImpl3;
            } else {
                onClickListenerImpl3 = this.mAndroidViewViewOnCl3;
            }
            androidViewViewOnCli3 = onClickListenerImpl3.setValue(listener);
        }
        if ((dirtyFlags & 3) != 0) {
            this.btnLogin.setOnClickListener(androidViewViewOnCli);
            this.txtAbout.setOnClickListener(androidViewViewOnCli1);
            this.txtRegistration.setOnClickListener(androidViewViewOnCli2);
            this.txtRestore.setOnClickListener(androidViewViewOnCli3);
        }
    }

    public static ActivityLoginBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public static ActivityLoginBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, DataBindingComponent bindingComponent) {
        return (ActivityLoginBinding) DataBindingUtil.inflate(inflater, C1733R.layout.activity_login, root, attachToRoot, bindingComponent);
    }

    public static ActivityLoginBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    public static ActivityLoginBinding inflate(LayoutInflater inflater, DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(C1733R.layout.activity_login, null, false), bindingComponent);
    }

    public static ActivityLoginBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    public static ActivityLoginBinding bind(View view, DataBindingComponent bindingComponent) {
        if ("layout/activity_login_0".equals(view.getTag())) {
            return new ActivityLoginBinding(bindingComponent, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
