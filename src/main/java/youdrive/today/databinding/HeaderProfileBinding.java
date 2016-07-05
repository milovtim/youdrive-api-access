package youdrive.today.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import youdrive.today.C1733R;

public class HeaderProfileBinding extends ViewDataBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    public final ImageView ivProfile;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    public final TextView txtName;

    static {
        sIncludes = null;
        sViewsWithIds = new SparseIntArray();
        sViewsWithIds.put(C1733R.id.ivProfile, 1);
        sViewsWithIds.put(C1733R.id.txtName, 2);
    }

    public HeaderProfileBinding(DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        this.mDirtyFlags = -1;
        Object[] bindings = ViewDataBinding.mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds);
        this.ivProfile = (ImageView) bindings[1];
        this.mboundView0 = (LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.txtName = (TextView) bindings[2];
        setRootTag(root);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1;
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
        return false;
    }

    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    protected void executeBindings() {
        synchronized (this) {
            long dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
    }

    public static HeaderProfileBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public static HeaderProfileBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, DataBindingComponent bindingComponent) {
        return (HeaderProfileBinding) DataBindingUtil.inflate(inflater, C1733R.layout.header_profile, root, attachToRoot, bindingComponent);
    }

    public static HeaderProfileBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    public static HeaderProfileBinding inflate(LayoutInflater inflater, DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(C1733R.layout.header_profile, null, false), bindingComponent);
    }

    public static HeaderProfileBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    public static HeaderProfileBinding bind(View view, DataBindingComponent bindingComponent) {
        if ("layout/header_profile_0".equals(view.getTag())) {
            return new HeaderProfileBinding(bindingComponent, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
