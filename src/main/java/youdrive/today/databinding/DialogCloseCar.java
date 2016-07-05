package youdrive.today.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import com.dd.CircularProgressButton;
import youdrive.today.C1733R;
import youdrive.today.activities.MapsActivity;

public class DialogCloseCar extends ViewDataBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    public final CircularProgressButton btnCloseOrOpen;
    public final CircularProgressButton btnCloseRent;
    public final CircularProgressButton btnNavigate;
    private OnClickListenerImpl mAndroidViewViewOnCl;
    private OnClickListenerImpl1 mAndroidViewViewOnCl1;
    private OnClickListenerImpl2 mAndroidViewViewOnCl2;
    private long mDirtyFlags;
    private MapsActivity mListener;
    private final ScrollView mboundView0;
    public final TextView txtParking;
    public final TextView txtPerMin;
    public final TextView txtTariff;
    public final TextView txtTotal;
    public final TextView txtTotalUsage;

    public static class OnClickListenerImpl1 implements OnClickListener {
        private MapsActivity value;

        public OnClickListenerImpl1 setValue(MapsActivity value) {
            this.value = value;
            return value == null ? null : this;
        }

        public void onClick(View arg0) {
            this.value.onCloseRent(arg0);
        }
    }

    public static class OnClickListenerImpl2 implements OnClickListener {
        private MapsActivity value;

        public OnClickListenerImpl2 setValue(MapsActivity value) {
            this.value = value;
            return value == null ? null : this;
        }

        public void onClick(View arg0) {
            this.value.onCloseOrOpen(arg0);
        }
    }

    public static class OnClickListenerImpl implements OnClickListener {
        private MapsActivity value;

        public OnClickListenerImpl setValue(MapsActivity value) {
            this.value = value;
            return value == null ? null : this;
        }

        public void onClick(View arg0) {
            this.value.onButtonNavigate(arg0);
        }
    }

    static {
        sIncludes = null;
        sViewsWithIds = new SparseIntArray();
        sViewsWithIds.put(C1733R.id.txtTariff, 4);
        sViewsWithIds.put(C1733R.id.txtPerMin, 5);
        sViewsWithIds.put(C1733R.id.txtTotalUsage, 6);
        sViewsWithIds.put(C1733R.id.txtParking, 7);
        sViewsWithIds.put(C1733R.id.txtTotal, 8);
    }

    public DialogCloseCar(DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        this.mDirtyFlags = -1;
        Object[] bindings = ViewDataBinding.mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds);
        this.btnCloseOrOpen = (CircularProgressButton) bindings[1];
        this.btnCloseOrOpen.setTag(null);
        this.btnCloseRent = (CircularProgressButton) bindings[2];
        this.btnCloseRent.setTag(null);
        this.btnNavigate = (CircularProgressButton) bindings[3];
        this.btnNavigate.setTag(null);
        this.mboundView0 = (ScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.txtParking = (TextView) bindings[7];
        this.txtPerMin = (TextView) bindings[5];
        this.txtTariff = (TextView) bindings[4];
        this.txtTotal = (TextView) bindings[8];
        this.txtTotalUsage = (TextView) bindings[6];
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
                setListener((MapsActivity) variable);
                return true;
            default:
                return false;
        }
    }

    public void setListener(MapsActivity listener) {
        this.mListener = listener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        super.requestRebind();
    }

    public MapsActivity getListener() {
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
        MapsActivity listener = this.mListener;
        OnClickListener androidViewViewOnCli = null;
        OnClickListener androidViewViewOnCli1 = null;
        OnClickListener androidViewViewOnCli2 = null;
        if (!((dirtyFlags & 3) == 0 || listener == null)) {
            OnClickListenerImpl onClickListenerImpl;
            OnClickListenerImpl1 onClickListenerImpl1;
            OnClickListenerImpl2 onClickListenerImpl2;
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
            if (this.mAndroidViewViewOnCl2 == null) {
                onClickListenerImpl2 = new OnClickListenerImpl2();
                this.mAndroidViewViewOnCl2 = onClickListenerImpl2;
            } else {
                onClickListenerImpl2 = this.mAndroidViewViewOnCl2;
            }
            androidViewViewOnCli2 = onClickListenerImpl2.setValue(listener);
        }
        if ((dirtyFlags & 3) != 0) {
            this.btnCloseOrOpen.setOnClickListener(androidViewViewOnCli2);
            this.btnCloseRent.setOnClickListener(androidViewViewOnCli1);
            this.btnNavigate.setOnClickListener(androidViewViewOnCli);
        }
    }

    public static DialogCloseCar inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public static DialogCloseCar inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, DataBindingComponent bindingComponent) {
        return (DialogCloseCar) DataBindingUtil.inflate(inflater, C1733R.layout.popup_close_car, root, attachToRoot, bindingComponent);
    }

    public static DialogCloseCar inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    public static DialogCloseCar inflate(LayoutInflater inflater, DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(C1733R.layout.popup_close_car, null, false), bindingComponent);
    }

    public static DialogCloseCar bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    public static DialogCloseCar bind(View view, DataBindingComponent bindingComponent) {
        if ("layout/popup_close_car_0".equals(view.getTag())) {
            return new DialogCloseCar(bindingComponent, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
