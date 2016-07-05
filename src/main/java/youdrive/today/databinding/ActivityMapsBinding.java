package youdrive.today.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ListView;
import youdrive.today.C1733R;
import youdrive.today.activities.MapsActivity;

public class ActivityMapsBinding extends ViewDataBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    public final ImageButton btnZoomIn;
    public final ImageButton btnZoomOut;
    public final DrawerLayout drawer;
    public final FrameLayout ltContainer;
    public final FrameLayout ltInfo;
    public final FrameLayout ltMap;
    public final ListView lvProfile;
    private OnClickListenerImpl mAndroidViewViewOnCl;
    private OnClickListenerImpl1 mAndroidViewViewOnCl1;
    private OnItemClickListenerI mAndroidWidgetAdapte;
    private long mDirtyFlags;
    private MapsActivity mListener;
    public final Toolbar toolbar;

    public static class OnClickListenerImpl1 implements OnClickListener {
        private MapsActivity value;

        public OnClickListenerImpl1 setValue(MapsActivity value) {
            this.value = value;
            return value == null ? null : this;
        }

        public void onClick(View arg0) {
            this.value.onZoomOut(arg0);
        }
    }

    public static class OnClickListenerImpl implements OnClickListener {
        private MapsActivity value;

        public OnClickListenerImpl setValue(MapsActivity value) {
            this.value = value;
            return value == null ? null : this;
        }

        public void onClick(View arg0) {
            this.value.onZoomIn(arg0);
        }
    }

    public static class OnItemClickListenerI implements OnItemClickListener {
        private MapsActivity value;

        public OnItemClickListenerI setValue(MapsActivity value) {
            this.value = value;
            return value == null ? null : this;
        }

        public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
            this.value.onItemSelected(arg0, arg1, arg2, arg3);
        }
    }

    static {
        sIncludes = null;
        sViewsWithIds = new SparseIntArray();
        sViewsWithIds.put(C1733R.id.toolbar, 4);
        sViewsWithIds.put(C1733R.id.ltMap, 5);
        sViewsWithIds.put(C1733R.id.ltInfo, 6);
        sViewsWithIds.put(C1733R.id.ltContainer, 7);
    }

    public ActivityMapsBinding(DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        this.mDirtyFlags = -1;
        Object[] bindings = ViewDataBinding.mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds);
        this.btnZoomIn = (ImageButton) bindings[1];
        this.btnZoomIn.setTag(null);
        this.btnZoomOut = (ImageButton) bindings[2];
        this.btnZoomOut.setTag(null);
        this.drawer = (DrawerLayout) bindings[0];
        this.drawer.setTag(null);
        this.ltContainer = (FrameLayout) bindings[7];
        this.ltInfo = (FrameLayout) bindings[6];
        this.ltMap = (FrameLayout) bindings[5];
        this.lvProfile = (ListView) bindings[3];
        this.lvProfile.setTag(null);
        this.toolbar = (Toolbar) bindings[4];
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
        OnItemClickListener androidWidgetAdapter = null;
        OnClickListener androidViewViewOnCli1 = null;
        if (!((dirtyFlags & 3) == 0 || listener == null)) {
            OnClickListenerImpl onClickListenerImpl;
            OnItemClickListenerI onItemClickListenerI;
            OnClickListenerImpl1 onClickListenerImpl1;
            if (this.mAndroidViewViewOnCl == null) {
                onClickListenerImpl = new OnClickListenerImpl();
                this.mAndroidViewViewOnCl = onClickListenerImpl;
            } else {
                onClickListenerImpl = this.mAndroidViewViewOnCl;
            }
            androidViewViewOnCli = onClickListenerImpl.setValue(listener);
            if (this.mAndroidWidgetAdapte == null) {
                onItemClickListenerI = new OnItemClickListenerI();
                this.mAndroidWidgetAdapte = onItemClickListenerI;
            } else {
                onItemClickListenerI = this.mAndroidWidgetAdapte;
            }
            androidWidgetAdapter = onItemClickListenerI.setValue(listener);
            if (this.mAndroidViewViewOnCl1 == null) {
                onClickListenerImpl1 = new OnClickListenerImpl1();
                this.mAndroidViewViewOnCl1 = onClickListenerImpl1;
            } else {
                onClickListenerImpl1 = this.mAndroidViewViewOnCl1;
            }
            androidViewViewOnCli1 = onClickListenerImpl1.setValue(listener);
        }
        if ((dirtyFlags & 3) != 0) {
            this.btnZoomIn.setOnClickListener(androidViewViewOnCli);
            this.btnZoomOut.setOnClickListener(androidViewViewOnCli1);
            this.lvProfile.setOnItemClickListener(androidWidgetAdapter);
        }
    }

    public static ActivityMapsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public static ActivityMapsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, DataBindingComponent bindingComponent) {
        return (ActivityMapsBinding) DataBindingUtil.inflate(inflater, C1733R.layout.activity_maps, root, attachToRoot, bindingComponent);
    }

    public static ActivityMapsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    public static ActivityMapsBinding inflate(LayoutInflater inflater, DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(C1733R.layout.activity_maps, null, false), bindingComponent);
    }

    public static ActivityMapsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    public static ActivityMapsBinding bind(View view, DataBindingComponent bindingComponent) {
        if ("layout/activity_maps_0".equals(view.getTag())) {
            return new ActivityMapsBinding(bindingComponent, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
