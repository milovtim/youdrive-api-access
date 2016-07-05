package youdrive.today.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.dd.CircularProgressButton;
import com.google.android.gms.maps.MapView;
import youdrive.today.C1733R;
import youdrive.today.fragments.AboutFourth;

public class FragmentAboutFourthBinding extends ViewDataBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private OnClickListenerImpl mAndroidViewViewOnCl;
    private OnClickListenerImpl1 mAndroidViewViewOnCl1;
    private long mDirtyFlags;
    private AboutFourth mListener;
    public final MapView map;
    private final LinearLayout mboundView0;
    private final CircularProgressButton mboundView1;
    private final CircularProgressButton mboundView2;
    public final TextView tvFooter;

    public static class OnClickListenerImpl1 implements OnClickListener {
        private AboutFourth value;

        public OnClickListenerImpl1 setValue(AboutFourth value) {
            this.value = value;
            return value == null ? null : this;
        }

        public void onClick(View arg0) {
            this.value.onLogin(arg0);
        }
    }

    public static class OnClickListenerImpl implements OnClickListener {
        private AboutFourth value;

        public OnClickListenerImpl setValue(AboutFourth value) {
            this.value = value;
            return value == null ? null : this;
        }

        public void onClick(View arg0) {
            this.value.onRegister(arg0);
        }
    }

    static {
        sIncludes = null;
        sViewsWithIds = new SparseIntArray();
        sViewsWithIds.put(C1733R.id.map, 3);
        sViewsWithIds.put(C1733R.id.tvFooter, 4);
    }

    public FragmentAboutFourthBinding(DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        this.mDirtyFlags = -1;
        Object[] bindings = ViewDataBinding.mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds);
        this.map = (MapView) bindings[3];
        this.mboundView0 = (LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (CircularProgressButton) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (CircularProgressButton) bindings[2];
        this.mboundView2.setTag(null);
        this.tvFooter = (TextView) bindings[4];
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
                setListener((AboutFourth) variable);
                return true;
            default:
                return false;
        }
    }

    public void setListener(AboutFourth listener) {
        this.mListener = listener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        super.requestRebind();
    }

    public AboutFourth getListener() {
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
        OnClickListener androidViewViewOnCli = null;
        AboutFourth listener = this.mListener;
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
            this.mboundView1.setOnClickListener(androidViewViewOnCli);
            this.mboundView2.setOnClickListener(androidViewViewOnCli1);
        }
    }

    public static FragmentAboutFourthBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public static FragmentAboutFourthBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, DataBindingComponent bindingComponent) {
        return (FragmentAboutFourthBinding) DataBindingUtil.inflate(inflater, C1733R.layout.fragment_about_fourth, root, attachToRoot, bindingComponent);
    }

    public static FragmentAboutFourthBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragmentAboutFourthBinding inflate(LayoutInflater inflater, DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(C1733R.layout.fragment_about_fourth, null, false), bindingComponent);
    }

    public static FragmentAboutFourthBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    public static FragmentAboutFourthBinding bind(View view, DataBindingComponent bindingComponent) {
        if ("layout/fragment_about_fourth_0".equals(view.getTag())) {
            return new FragmentAboutFourthBinding(bindingComponent, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
