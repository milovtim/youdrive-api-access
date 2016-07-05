package youdrive.today.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dd.CircularProgressButton;
import youdrive.today.C1733R;
import youdrive.today.fragments.RegisterPaymentsFragment;

public class FragmentRegisterPaymentsBinding extends ViewDataBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    public final CircularProgressButton btnLogin;
    private OnClickListenerImpl mAndroidViewViewOnCl;
    private OnClickListenerImpl1 mAndroidViewViewOnCl1;
    private OnClickListenerImpl2 mAndroidViewViewOnCl2;
    private long mDirtyFlags;
    private RegisterPaymentsFragment mListener;
    private final RelativeLayout mboundView0;
    private final TextView mboundView3;
    public final TextView tvPayments;
    public final TextView tvReady;
    public final WebView wvPayment;

    public static class OnClickListenerImpl1 implements OnClickListener {
        private RegisterPaymentsFragment value;

        public OnClickListenerImpl1 setValue(RegisterPaymentsFragment value) {
            this.value = value;
            return value == null ? null : this;
        }

        public void onClick(View arg0) {
            this.value.onCardLink(arg0);
        }
    }

    public static class OnClickListenerImpl2 implements OnClickListener {
        private RegisterPaymentsFragment value;

        public OnClickListenerImpl2 setValue(RegisterPaymentsFragment value) {
            this.value = value;
            return value == null ? null : this;
        }

        public void onClick(View arg0) {
            this.value.onForvard(arg0);
        }
    }

    public static class OnClickListenerImpl implements OnClickListener {
        private RegisterPaymentsFragment value;

        public OnClickListenerImpl setValue(RegisterPaymentsFragment value) {
            this.value = value;
            return value == null ? null : this;
        }

        public void onClick(View arg0) {
            this.value.onBack(arg0);
        }
    }

    static {
        sIncludes = null;
        sViewsWithIds = new SparseIntArray();
        sViewsWithIds.put(C1733R.id.tvPayments, 4);
        sViewsWithIds.put(C1733R.id.wvPayment, 5);
    }

    public FragmentRegisterPaymentsBinding(DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        this.mDirtyFlags = -1;
        Object[] bindings = ViewDataBinding.mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds);
        this.btnLogin = (CircularProgressButton) bindings[1];
        this.btnLogin.setTag(null);
        this.mboundView0 = (RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView3 = (TextView) bindings[3];
        this.mboundView3.setTag(null);
        this.tvPayments = (TextView) bindings[4];
        this.tvReady = (TextView) bindings[2];
        this.tvReady.setTag(null);
        this.wvPayment = (WebView) bindings[5];
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
                setListener((RegisterPaymentsFragment) variable);
                return true;
            default:
                return false;
        }
    }

    public void setListener(RegisterPaymentsFragment listener) {
        this.mListener = listener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        super.requestRebind();
    }

    public RegisterPaymentsFragment getListener() {
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
        RegisterPaymentsFragment listener = this.mListener;
        OnClickListener androidViewViewOnCli = null;
        OnClickListener androidViewViewOnCli1 = null;
        OnClickListener androidViewViewOnCli2 = null;
        if (!((dirtyFlags & 3) == 0 || listener == null)) {
            OnClickListenerImpl onClickListenerImpl;
            OnClickListenerImpl1 onClickListenerImpl1;
            OnClickListenerImpl2 onClickListenerImpl2;
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
        }
        if ((dirtyFlags & 3) != 0) {
            this.btnLogin.setOnClickListener(androidViewViewOnCli1);
            this.mboundView3.setOnClickListener(androidViewViewOnCli);
            this.tvReady.setOnClickListener(androidViewViewOnCli2);
        }
    }

    public static FragmentRegisterPaymentsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public static FragmentRegisterPaymentsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, DataBindingComponent bindingComponent) {
        return (FragmentRegisterPaymentsBinding) DataBindingUtil.inflate(inflater, C1733R.layout.fragment_register_payments, root, attachToRoot, bindingComponent);
    }

    public static FragmentRegisterPaymentsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragmentRegisterPaymentsBinding inflate(LayoutInflater inflater, DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(C1733R.layout.fragment_register_payments, null, false), bindingComponent);
    }

    public static FragmentRegisterPaymentsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    public static FragmentRegisterPaymentsBinding bind(View view, DataBindingComponent bindingComponent) {
        if ("layout/fragment_register_payments_0".equals(view.getTag())) {
            return new FragmentRegisterPaymentsBinding(bindingComponent, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
