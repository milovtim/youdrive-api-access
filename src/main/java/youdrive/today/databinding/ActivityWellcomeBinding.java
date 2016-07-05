package youdrive.today.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v4.view.ViewPager;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import youdrive.today.C1733R;
import youdrive.today.activities.WellcomeActivity;
import youdrive.today.indicator.viewpagerindicator.CirclePageIndicator;

public class ActivityWellcomeBinding extends ViewDataBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    public final CirclePageIndicator cpIndicator;
    public final FrameLayout flIndicator;
    private OnClickListenerImpl mAndroidViewViewOnCl;
    private long mDirtyFlags;
    private WellcomeActivity mListener;
    private final RelativeLayout mboundView0;
    private final ImageView mboundView1;
    public final ViewPager viewPager;

    public static class OnClickListenerImpl implements OnClickListener {
        private WellcomeActivity value;

        public OnClickListenerImpl setValue(WellcomeActivity value) {
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
        sViewsWithIds.put(C1733R.id.flIndicator, 2);
        sViewsWithIds.put(C1733R.id.cpIndicator, 3);
        sViewsWithIds.put(C1733R.id.viewPager, 4);
    }

    public ActivityWellcomeBinding(DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        this.mDirtyFlags = -1;
        Object[] bindings = ViewDataBinding.mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds);
        this.cpIndicator = (CirclePageIndicator) bindings[3];
        this.flIndicator = (FrameLayout) bindings[2];
        this.mboundView0 = (RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (ImageView) bindings[1];
        this.mboundView1.setTag(null);
        this.viewPager = (ViewPager) bindings[4];
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
                setListener((WellcomeActivity) variable);
                return true;
            default:
                return false;
        }
    }

    public void setListener(WellcomeActivity listener) {
        this.mListener = listener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        super.requestRebind();
    }

    public WellcomeActivity getListener() {
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
        WellcomeActivity listener = this.mListener;
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
            this.mboundView1.setOnClickListener(androidViewViewOnCli);
        }
    }

    public static ActivityWellcomeBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public static ActivityWellcomeBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, DataBindingComponent bindingComponent) {
        return (ActivityWellcomeBinding) DataBindingUtil.inflate(inflater, C1733R.layout.activity_wellcome, root, attachToRoot, bindingComponent);
    }

    public static ActivityWellcomeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    public static ActivityWellcomeBinding inflate(LayoutInflater inflater, DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(C1733R.layout.activity_wellcome, null, false), bindingComponent);
    }

    public static ActivityWellcomeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    public static ActivityWellcomeBinding bind(View view, DataBindingComponent bindingComponent) {
        if ("layout/activity_wellcome_0".equals(view.getTag())) {
            return new ActivityWellcomeBinding(bindingComponent, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
