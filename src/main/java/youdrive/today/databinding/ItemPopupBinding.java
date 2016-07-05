package youdrive.today.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import youdrive.today.C1733R;

public class ItemPopupBinding extends ViewDataBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    public final TextView tvText;

    static {
        sIncludes = null;
        sViewsWithIds = new SparseIntArray();
        sViewsWithIds.put(C1733R.id.tvText, 1);
    }

    public ItemPopupBinding(DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        this.mDirtyFlags = -1;
        Object[] bindings = ViewDataBinding.mapBindings(bindingComponent, root, 2, sIncludes, sViewsWithIds);
        this.mboundView0 = (LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.tvText = (TextView) bindings[1];
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

    public static ItemPopupBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public static ItemPopupBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, DataBindingComponent bindingComponent) {
        return (ItemPopupBinding) DataBindingUtil.inflate(inflater, C1733R.layout.item_popup, root, attachToRoot, bindingComponent);
    }

    public static ItemPopupBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    public static ItemPopupBinding inflate(LayoutInflater inflater, DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(C1733R.layout.item_popup, null, false), bindingComponent);
    }

    public static ItemPopupBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    public static ItemPopupBinding bind(View view, DataBindingComponent bindingComponent) {
        if ("layout/item_popup_0".equals(view.getTag())) {
            return new ItemPopupBinding(bindingComponent, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
