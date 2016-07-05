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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dd.CircularProgressButton;
import youdrive.today.C1733R;
import youdrive.today.activities.BookCarActivity;

public class ActivityOrderCarBinding extends ViewDataBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    public final CircularProgressButton btnShowOnMap;
    public final ImageView imgCar;
    private OnClickListenerImpl mAndroidViewViewOnCl;
    private long mDirtyFlags;
    private BookCarActivity mListener;
    private final RelativeLayout mboundView0;
    public final Toolbar toolbar;
    public final TextView txtColor;
    public final TextView txtModel;
    public final TextView txtNumber;

    public static class OnClickListenerImpl implements OnClickListener {
        private BookCarActivity value;

        public OnClickListenerImpl setValue(BookCarActivity value) {
            this.value = value;
            return value == null ? null : this;
        }

        public void onClick(View arg0) {
            this.value.onShow(arg0);
        }
    }

    static {
        sIncludes = null;
        sViewsWithIds = new SparseIntArray();
        sViewsWithIds.put(C1733R.id.toolbar, 2);
        sViewsWithIds.put(C1733R.id.imgCar, 3);
        sViewsWithIds.put(C1733R.id.txtModel, 4);
        sViewsWithIds.put(C1733R.id.txtNumber, 5);
        sViewsWithIds.put(C1733R.id.txtColor, 6);
    }

    public ActivityOrderCarBinding(DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        this.mDirtyFlags = -1;
        Object[] bindings = ViewDataBinding.mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds);
        this.btnShowOnMap = (CircularProgressButton) bindings[1];
        this.btnShowOnMap.setTag(null);
        this.imgCar = (ImageView) bindings[3];
        this.mboundView0 = (RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.toolbar = (Toolbar) bindings[2];
        this.txtColor = (TextView) bindings[6];
        this.txtModel = (TextView) bindings[4];
        this.txtNumber = (TextView) bindings[5];
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
                setListener((BookCarActivity) variable);
                return true;
            default:
                return false;
        }
    }

    public void setListener(BookCarActivity listener) {
        this.mListener = listener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        super.requestRebind();
    }

    public BookCarActivity getListener() {
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
        BookCarActivity listener = this.mListener;
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
            this.btnShowOnMap.setOnClickListener(androidViewViewOnCli);
        }
    }

    public static ActivityOrderCarBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public static ActivityOrderCarBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, DataBindingComponent bindingComponent) {
        return (ActivityOrderCarBinding) DataBindingUtil.inflate(inflater, C1733R.layout.activity_order_car, root, attachToRoot, bindingComponent);
    }

    public static ActivityOrderCarBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    public static ActivityOrderCarBinding inflate(LayoutInflater inflater, DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(C1733R.layout.activity_order_car, null, false), bindingComponent);
    }

    public static ActivityOrderCarBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    public static ActivityOrderCarBinding bind(View view, DataBindingComponent bindingComponent) {
        if ("layout/activity_order_car_0".equals(view.getTag())) {
            return new ActivityOrderCarBinding(bindingComponent, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
