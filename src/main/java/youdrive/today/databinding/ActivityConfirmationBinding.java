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
import youdrive.today.C1733R;
import youdrive.today.activities.ConfirmationActivity;

public class ActivityConfirmationBinding extends ViewDataBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    public final CircularProgressButton btnCancel;
    public final CircularProgressButton btnOk;
    public final ImageView ivLogo;
    private OnClickListenerImpl mAndroidViewViewOnCl;
    private OnClickListenerImpl1 mAndroidViewViewOnCl1;
    private long mDirtyFlags;
    private ConfirmationActivity mListener;
    private final RelativeLayout mboundView0;
    public final TextView txtAlarm;
    public final TextView txtLocationService;

    public static class OnClickListenerImpl1 implements OnClickListener {
        private ConfirmationActivity value;

        public OnClickListenerImpl1 setValue(ConfirmationActivity value) {
            this.value = value;
            return value == null ? null : this;
        }

        public void onClick(View arg0) {
            this.value.onOk(arg0);
        }
    }

    public static class OnClickListenerImpl implements OnClickListener {
        private ConfirmationActivity value;

        public OnClickListenerImpl setValue(ConfirmationActivity value) {
            this.value = value;
            return value == null ? null : this;
        }

        public void onClick(View arg0) {
            this.value.onCancel(arg0);
        }
    }

    static {
        sIncludes = null;
        sViewsWithIds = new SparseIntArray();
        sViewsWithIds.put(C1733R.id.ivLogo, 3);
        sViewsWithIds.put(C1733R.id.txtAlarm, 4);
        sViewsWithIds.put(C1733R.id.txtLocationService, 5);
    }

    public ActivityConfirmationBinding(DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        this.mDirtyFlags = -1;
        Object[] bindings = ViewDataBinding.mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds);
        this.btnCancel = (CircularProgressButton) bindings[2];
        this.btnCancel.setTag(null);
        this.btnOk = (CircularProgressButton) bindings[1];
        this.btnOk.setTag(null);
        this.ivLogo = (ImageView) bindings[3];
        this.mboundView0 = (RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.txtAlarm = (TextView) bindings[4];
        this.txtLocationService = (TextView) bindings[5];
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
                setListener((ConfirmationActivity) variable);
                return true;
            default:
                return false;
        }
    }

    public void setListener(ConfirmationActivity listener) {
        this.mListener = listener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        super.requestRebind();
    }

    public ConfirmationActivity getListener() {
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
        ConfirmationActivity listener = this.mListener;
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
            this.btnCancel.setOnClickListener(androidViewViewOnCli);
            this.btnOk.setOnClickListener(androidViewViewOnCli1);
        }
    }

    public static ActivityConfirmationBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public static ActivityConfirmationBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, DataBindingComponent bindingComponent) {
        return (ActivityConfirmationBinding) DataBindingUtil.inflate(inflater, C1733R.layout.activity_confirmation, root, attachToRoot, bindingComponent);
    }

    public static ActivityConfirmationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    public static ActivityConfirmationBinding inflate(LayoutInflater inflater, DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(C1733R.layout.activity_confirmation, null, false), bindingComponent);
    }

    public static ActivityConfirmationBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    public static ActivityConfirmationBinding bind(View view, DataBindingComponent bindingComponent) {
        if ("layout/activity_confirmation_0".equals(view.getTag())) {
            return new ActivityConfirmationBinding(bindingComponent, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
