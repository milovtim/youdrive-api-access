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
import youdrive.today.C1733R;
import youdrive.today.fragments.AboutThird;

public class FragmentAboutThirdBinding extends ViewDataBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private OnClickListenerImpl mAndroidViewViewOnCl;
    private OnClickListenerImpl1 mAndroidViewViewOnCl1;
    private OnClickListenerImpl2 mAndroidViewViewOnCl2;
    private OnClickListenerImpl3 mAndroidViewViewOnCl3;
    private OnClickListenerImpl4 mAndroidViewViewOnCl4;
    private long mDirtyFlags;
    private AboutThird mListener;
    private final LinearLayout mboundView0;
    public final TextView tvFarRides;
    public final TextView tvFreeFuel;
    public final TextView tvFreeNight;
    public final TextView tvFreeParking;
    public final TextView tvMinuteTarification;

    public static class OnClickListenerImpl1 implements OnClickListener {
        private AboutThird value;

        public OnClickListenerImpl1 setValue(AboutThird value) {
            this.value = value;
            return value == null ? null : this;
        }

        public void onClick(View arg0) {
            this.value.onFreeNightParking(arg0);
        }
    }

    public static class OnClickListenerImpl2 implements OnClickListener {
        private AboutThird value;

        public OnClickListenerImpl2 setValue(AboutThird value) {
            this.value = value;
            return value == null ? null : this;
        }

        public void onClick(View arg0) {
            this.value.onMinuteTarrification(arg0);
        }
    }

    public static class OnClickListenerImpl3 implements OnClickListener {
        private AboutThird value;

        public OnClickListenerImpl3 setValue(AboutThird value) {
            this.value = value;
            return value == null ? null : this;
        }

        public void onClick(View arg0) {
            this.value.onFarRides(arg0);
        }
    }

    public static class OnClickListenerImpl4 implements OnClickListener {
        private AboutThird value;

        public OnClickListenerImpl4 setValue(AboutThird value) {
            this.value = value;
            return value == null ? null : this;
        }

        public void onClick(View arg0) {
            this.value.onFreeParking(arg0);
        }
    }

    public static class OnClickListenerImpl implements OnClickListener {
        private AboutThird value;

        public OnClickListenerImpl setValue(AboutThird value) {
            this.value = value;
            return value == null ? null : this;
        }

        public void onClick(View arg0) {
            this.value.onFuelIsPayed(arg0);
        }
    }

    static {
        sIncludes = null;
        sViewsWithIds = null;
    }

    public FragmentAboutThirdBinding(DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        this.mDirtyFlags = -1;
        Object[] bindings = ViewDataBinding.mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds);
        this.mboundView0 = (LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.tvFarRides = (TextView) bindings[5];
        this.tvFarRides.setTag(null);
        this.tvFreeFuel = (TextView) bindings[3];
        this.tvFreeFuel.setTag(null);
        this.tvFreeNight = (TextView) bindings[4];
        this.tvFreeNight.setTag(null);
        this.tvFreeParking = (TextView) bindings[2];
        this.tvFreeParking.setTag(null);
        this.tvMinuteTarification = (TextView) bindings[1];
        this.tvMinuteTarification.setTag(null);
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
                setListener((AboutThird) variable);
                return true;
            default:
                return false;
        }
    }

    public void setListener(AboutThird listener) {
        this.mListener = listener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        super.requestRebind();
    }

    public AboutThird getListener() {
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
        AboutThird listener = this.mListener;
        OnClickListener androidViewViewOnCli = null;
        OnClickListener androidViewViewOnCli1 = null;
        OnClickListener androidViewViewOnCli2 = null;
        OnClickListener androidViewViewOnCli3 = null;
        OnClickListener androidViewViewOnCli4 = null;
        if (!((dirtyFlags & 3) == 0 || listener == null)) {
            OnClickListenerImpl onClickListenerImpl;
            OnClickListenerImpl1 onClickListenerImpl1;
            OnClickListenerImpl2 onClickListenerImpl2;
            OnClickListenerImpl3 onClickListenerImpl3;
            OnClickListenerImpl4 onClickListenerImpl4;
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
            if (this.mAndroidViewViewOnCl3 == null) {
                onClickListenerImpl3 = new OnClickListenerImpl3();
                this.mAndroidViewViewOnCl3 = onClickListenerImpl3;
            } else {
                onClickListenerImpl3 = this.mAndroidViewViewOnCl3;
            }
            androidViewViewOnCli3 = onClickListenerImpl3.setValue(listener);
            if (this.mAndroidViewViewOnCl4 == null) {
                onClickListenerImpl4 = new OnClickListenerImpl4();
                this.mAndroidViewViewOnCl4 = onClickListenerImpl4;
            } else {
                onClickListenerImpl4 = this.mAndroidViewViewOnCl4;
            }
            androidViewViewOnCli4 = onClickListenerImpl4.setValue(listener);
        }
        if ((dirtyFlags & 3) != 0) {
            this.tvFarRides.setOnClickListener(androidViewViewOnCli3);
            this.tvFreeFuel.setOnClickListener(androidViewViewOnCli);
            this.tvFreeNight.setOnClickListener(androidViewViewOnCli1);
            this.tvFreeParking.setOnClickListener(androidViewViewOnCli4);
            this.tvMinuteTarification.setOnClickListener(androidViewViewOnCli2);
        }
    }

    public static FragmentAboutThirdBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public static FragmentAboutThirdBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, DataBindingComponent bindingComponent) {
        return (FragmentAboutThirdBinding) DataBindingUtil.inflate(inflater, C1733R.layout.fragment_about_third, root, attachToRoot, bindingComponent);
    }

    public static FragmentAboutThirdBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragmentAboutThirdBinding inflate(LayoutInflater inflater, DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(C1733R.layout.fragment_about_third, null, false), bindingComponent);
    }

    public static FragmentAboutThirdBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    public static FragmentAboutThirdBinding bind(View view, DataBindingComponent bindingComponent) {
        if ("layout/fragment_about_third_0".equals(view.getTag())) {
            return new FragmentAboutThirdBinding(bindingComponent, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
