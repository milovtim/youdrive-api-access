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
import com.dd.CircularProgressButton;
import com.rengwuxian.materialedittext.MaterialEditText;
import youdrive.today.C1733R;
import youdrive.today.fragments.PaymentDialogFragment;

public class FragmentPaymentBinding extends ViewDataBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    public final CircularProgressButton btnPay;
    public final MaterialEditText etCardNumber;
    public final MaterialEditText etCvv;
    public final MaterialEditText etExpired;
    public final MaterialEditText etName;
    private OnClickListenerImpl mAndroidViewViewOnCl;
    private long mDirtyFlags;
    private PaymentDialogFragment mListener;
    private final LinearLayout mboundView0;

    public static class OnClickListenerImpl implements OnClickListener {
        private PaymentDialogFragment value;

        public OnClickListenerImpl setValue(PaymentDialogFragment value) {
            this.value = value;
            return value == null ? null : this;
        }

        public void onClick(View arg0) {
            this.value.onPay(arg0);
        }
    }

    static {
        sIncludes = null;
        sViewsWithIds = new SparseIntArray();
        sViewsWithIds.put(C1733R.id.etCardNumber, 2);
        sViewsWithIds.put(C1733R.id.etName, 3);
        sViewsWithIds.put(C1733R.id.etExpired, 4);
        sViewsWithIds.put(C1733R.id.etCvv, 5);
    }

    public FragmentPaymentBinding(DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        this.mDirtyFlags = -1;
        Object[] bindings = ViewDataBinding.mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds);
        this.btnPay = (CircularProgressButton) bindings[1];
        this.btnPay.setTag(null);
        this.etCardNumber = (MaterialEditText) bindings[2];
        this.etCvv = (MaterialEditText) bindings[5];
        this.etExpired = (MaterialEditText) bindings[4];
        this.etName = (MaterialEditText) bindings[3];
        this.mboundView0 = (LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
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
                setListener((PaymentDialogFragment) variable);
                return true;
            default:
                return false;
        }
    }

    public void setListener(PaymentDialogFragment listener) {
        this.mListener = listener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        super.requestRebind();
    }

    public PaymentDialogFragment getListener() {
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
        PaymentDialogFragment listener = this.mListener;
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
            this.btnPay.setOnClickListener(androidViewViewOnCli);
        }
    }

    public static FragmentPaymentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public static FragmentPaymentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, DataBindingComponent bindingComponent) {
        return (FragmentPaymentBinding) DataBindingUtil.inflate(inflater, C1733R.layout.fragment_payment, root, attachToRoot, bindingComponent);
    }

    public static FragmentPaymentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragmentPaymentBinding inflate(LayoutInflater inflater, DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(C1733R.layout.fragment_payment, null, false), bindingComponent);
    }

    public static FragmentPaymentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    public static FragmentPaymentBinding bind(View view, DataBindingComponent bindingComponent) {
        if ("layout/fragment_payment_0".equals(view.getTag())) {
            return new FragmentPaymentBinding(bindingComponent, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
