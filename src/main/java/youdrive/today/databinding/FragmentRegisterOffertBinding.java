package youdrive.today.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import youdrive.today.C1733R;
import youdrive.today.fragments.RegisterOffertFragment;

public class FragmentRegisterOffertBinding extends ViewDataBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    public final CheckBox checkbox;
    private OnClickListenerImpl mAndroidViewViewOnCl;
    private OnClickListenerImpl1 mAndroidViewViewOnCl1;
    private long mDirtyFlags;
    private RegisterOffertFragment mListener;
    private final RelativeLayout mboundView0;
    private final TextView mboundView2;
    public final ScrollView svAgreement;
    public final TextView tvDogovor;
    public final TextView tvForvard;
    public final TextView tvTitle;

    public static class OnClickListenerImpl1 implements OnClickListener {
        private RegisterOffertFragment value;

        public OnClickListenerImpl1 setValue(RegisterOffertFragment value) {
            this.value = value;
            return value == null ? null : this;
        }

        public void onClick(View arg0) {
            this.value.onForvard(arg0);
        }
    }

    public static class OnClickListenerImpl implements OnClickListener {
        private RegisterOffertFragment value;

        public OnClickListenerImpl setValue(RegisterOffertFragment value) {
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
        sViewsWithIds.put(C1733R.id.tvTitle, 3);
        sViewsWithIds.put(C1733R.id.checkbox, 4);
        sViewsWithIds.put(C1733R.id.svAgreement, 5);
        sViewsWithIds.put(C1733R.id.tvDogovor, 6);
    }

    public FragmentRegisterOffertBinding(DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        this.mDirtyFlags = -1;
        Object[] bindings = ViewDataBinding.mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds);
        this.checkbox = (CheckBox) bindings[4];
        this.mboundView0 = (RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (TextView) bindings[2];
        this.mboundView2.setTag(null);
        this.svAgreement = (ScrollView) bindings[5];
        this.tvDogovor = (TextView) bindings[6];
        this.tvForvard = (TextView) bindings[1];
        this.tvForvard.setTag(null);
        this.tvTitle = (TextView) bindings[3];
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
                setListener((RegisterOffertFragment) variable);
                return true;
            default:
                return false;
        }
    }

    public void setListener(RegisterOffertFragment listener) {
        this.mListener = listener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        super.requestRebind();
    }

    public RegisterOffertFragment getListener() {
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
        RegisterOffertFragment listener = this.mListener;
        OnClickListener androidViewViewOnCli = null;
        OnClickListener androidViewViewOnCli1 = null;
        if (!((dirtyFlags & 3) == 0 || listener == null)) {
            OnClickListenerImpl onClickListenerImpl;
            OnClickListenerImpl1 onClickListenerImpl1;
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
        }
        if ((dirtyFlags & 3) != 0) {
            this.mboundView2.setOnClickListener(androidViewViewOnCli);
            this.tvForvard.setOnClickListener(androidViewViewOnCli1);
        }
    }

    public static FragmentRegisterOffertBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public static FragmentRegisterOffertBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, DataBindingComponent bindingComponent) {
        return (FragmentRegisterOffertBinding) DataBindingUtil.inflate(inflater, C1733R.layout.fragment_register_offert, root, attachToRoot, bindingComponent);
    }

    public static FragmentRegisterOffertBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragmentRegisterOffertBinding inflate(LayoutInflater inflater, DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(C1733R.layout.fragment_register_offert, null, false), bindingComponent);
    }

    public static FragmentRegisterOffertBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    public static FragmentRegisterOffertBinding bind(View view, DataBindingComponent bindingComponent) {
        if ("layout/fragment_register_offert_0".equals(view.getTag())) {
            return new FragmentRegisterOffertBinding(bindingComponent, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
