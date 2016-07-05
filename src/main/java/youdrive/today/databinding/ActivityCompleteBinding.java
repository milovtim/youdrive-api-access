package youdrive.today.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.Toolbar;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.dd.CircularProgressButton;
import youdrive.today.C1733R;
import youdrive.today.activities.CompleteActivity;

public class ActivityCompleteBinding extends ViewDataBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    public final CircularProgressButton btnClose;
    public final ImageView ivLogo;
    public final LinearLayout llDiscount;
    private OnClickListenerImpl mAndroidViewViewOnCl;
    private long mDirtyFlags;
    private CompleteActivity mListener;
    private final LinearLayout mboundView0;
    public final Toolbar toolbar;
    public final TextView txtDiscount;
    public final TextView txtParking;
    public final TextView txtTitleDiscount;
    public final TextView txtTotal;
    public final TextView txtTotalUsage;

    public static class OnClickListenerImpl implements OnClickListener {
        private CompleteActivity value;

        public OnClickListenerImpl setValue(CompleteActivity value) {
            this.value = value;
            return value == null ? null : this;
        }

        public void onClick(View arg0) {
            this.value.onClose(arg0);
        }
    }

    static {
        sIncludes = null;
        sViewsWithIds = new SparseIntArray();
        sViewsWithIds.put(C1733R.id.toolbar, 2);
        sViewsWithIds.put(C1733R.id.ivLogo, 3);
        sViewsWithIds.put(C1733R.id.txtTotalUsage, 4);
        sViewsWithIds.put(C1733R.id.txtParking, 5);
        sViewsWithIds.put(C1733R.id.llDiscount, 6);
        sViewsWithIds.put(C1733R.id.txtTitleDiscount, 7);
        sViewsWithIds.put(C1733R.id.txtDiscount, 8);
        sViewsWithIds.put(C1733R.id.txtTotal, 9);
    }

    public ActivityCompleteBinding(DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        this.mDirtyFlags = -1;
        Object[] bindings = ViewDataBinding.mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds);
        this.btnClose = (CircularProgressButton) bindings[1];
        this.btnClose.setTag(null);
        this.ivLogo = (ImageView) bindings[3];
        this.llDiscount = (LinearLayout) bindings[6];
        this.mboundView0 = (LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.toolbar = (Toolbar) bindings[2];
        this.txtDiscount = (TextView) bindings[8];
        this.txtParking = (TextView) bindings[5];
        this.txtTitleDiscount = (TextView) bindings[7];
        this.txtTotal = (TextView) bindings[9];
        this.txtTotalUsage = (TextView) bindings[4];
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
                setListener((CompleteActivity) variable);
                return true;
            default:
                return false;
        }
    }

    public void setListener(CompleteActivity listener) {
        this.mListener = listener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        super.requestRebind();
    }

    public CompleteActivity getListener() {
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
        CompleteActivity listener = this.mListener;
        OnClickListener androidViewViewOnCli = null;
        if (!((dirtyFlags & 3) == 0 || listener == null)) {
            OnClickListenerImpl onClickListenerImpl;
            if (this.mAndroidViewViewOnCl == null) {
                onClickListenerImpl = new OnClickListenerImpl();
                this.mAndroidViewViewOnCl = onClickListenerImpl;
            } else {
                onClickListenerImpl = this.mAndroidViewViewOnCl;
            }
            androidViewViewOnCli = onClickListenerImpl.setValue(listener);
        }
        if ((dirtyFlags & 3) != 0) {
            this.btnClose.setOnClickListener(androidViewViewOnCli);
        }
    }

    public static ActivityCompleteBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public static ActivityCompleteBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, DataBindingComponent bindingComponent) {
        return (ActivityCompleteBinding) DataBindingUtil.inflate(inflater, C1733R.layout.activity_complete, root, attachToRoot, bindingComponent);
    }

    public static ActivityCompleteBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    public static ActivityCompleteBinding inflate(LayoutInflater inflater, DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(C1733R.layout.activity_complete, null, false), bindingComponent);
    }

    public static ActivityCompleteBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    public static ActivityCompleteBinding bind(View view, DataBindingComponent bindingComponent) {
        if ("layout/activity_complete_0".equals(view.getTag())) {
            return new ActivityCompleteBinding(bindingComponent, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
