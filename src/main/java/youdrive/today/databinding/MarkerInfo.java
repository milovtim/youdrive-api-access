package youdrive.today.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import youdrive.today.C1733R;

public class MarkerInfo extends ViewDataBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    public final RelativeLayout rlDiscount;
    public final TextView tvDiscount;
    public final TextView txtColor;
    public final TextView txtModel;
    public final TextView txtNumber;
    public final TextView txtStartUsage;

    static {
        sIncludes = null;
        sViewsWithIds = new SparseIntArray();
        sViewsWithIds.put(C1733R.id.rlDiscount, 1);
        sViewsWithIds.put(C1733R.id.tvDiscount, 2);
        sViewsWithIds.put(C1733R.id.txtModel, 3);
        sViewsWithIds.put(C1733R.id.txtNumber, 4);
        sViewsWithIds.put(C1733R.id.txtColor, 5);
        sViewsWithIds.put(C1733R.id.txtStartUsage, 6);
    }

    public MarkerInfo(DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        this.mDirtyFlags = -1;
        Object[] bindings = ViewDataBinding.mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds);
        this.mboundView0 = (LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.rlDiscount = (RelativeLayout) bindings[1];
        this.tvDiscount = (TextView) bindings[2];
        this.txtColor = (TextView) bindings[5];
        this.txtModel = (TextView) bindings[3];
        this.txtNumber = (TextView) bindings[4];
        this.txtStartUsage = (TextView) bindings[6];
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

    public static MarkerInfo inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public static MarkerInfo inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, DataBindingComponent bindingComponent) {
        return (MarkerInfo) DataBindingUtil.inflate(inflater, C1733R.layout.marker_info, root, attachToRoot, bindingComponent);
    }

    public static MarkerInfo inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    public static MarkerInfo inflate(LayoutInflater inflater, DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(C1733R.layout.marker_info, null, false), bindingComponent);
    }

    public static MarkerInfo bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    public static MarkerInfo bind(View view, DataBindingComponent bindingComponent) {
        if ("layout/marker_info_0".equals(view.getTag())) {
            return new MarkerInfo(bindingComponent, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
