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
import youdrive.today.activities.ThanksActivity;

public class ActivityThanksBinding extends ViewDataBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    public final CircularProgressButton btnOk;
    public final ImageView ivLogo;
    private OnClickListenerImpl mAndroidViewViewOnCl;
    private long mDirtyFlags;
    private ThanksActivity mListener;
    private final RelativeLayout mboundView0;
    public final TextView txtMessage;
    public final TextView txtThanks;

    public static class OnClickListenerImpl implements OnClickListener {
        private ThanksActivity value;

        public OnClickListenerImpl setValue(ThanksActivity value) {
            this.value = value;
            return value == null ? null : this;
        }

        public void onClick(View arg0) {
            this.value.onAuth(arg0);
        }
    }

    static {
        sIncludes = null;
        sViewsWithIds = new SparseIntArray();
        sViewsWithIds.put(C1733R.id.ivLogo, 2);
        sViewsWithIds.put(C1733R.id.txtThanks, 3);
        sViewsWithIds.put(C1733R.id.txtMessage, 4);
    }

    public ActivityThanksBinding(DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        this.mDirtyFlags = -1;
        Object[] bindings = ViewDataBinding.mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds);
        this.btnOk = (CircularProgressButton) bindings[1];
        this.btnOk.setTag(null);
        this.ivLogo = (ImageView) bindings[2];
        this.mboundView0 = (RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.txtMessage = (TextView) bindings[4];
        this.txtThanks = (TextView) bindings[3];
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
                setListener((ThanksActivity) variable);
                return true;
            default:
                return false;
        }
    }

    public void setListener(ThanksActivity listener) {
        this.mListener = listener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        super.requestRebind();
    }

    public ThanksActivity getListener() {
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
        ThanksActivity listener = this.mListener;
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
            this.btnOk.setOnClickListener(androidViewViewOnCli);
        }
    }

    public static ActivityThanksBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public static ActivityThanksBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, DataBindingComponent bindingComponent) {
        return (ActivityThanksBinding) DataBindingUtil.inflate(inflater, C1733R.layout.activity_thanks, root, attachToRoot, bindingComponent);
    }

    public static ActivityThanksBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    public static ActivityThanksBinding inflate(LayoutInflater inflater, DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(C1733R.layout.activity_thanks, null, false), bindingComponent);
    }

    public static ActivityThanksBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    public static ActivityThanksBinding bind(View view, DataBindingComponent bindingComponent) {
        if ("layout/activity_thanks_0".equals(view.getTag())) {
            return new ActivityThanksBinding(bindingComponent, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
