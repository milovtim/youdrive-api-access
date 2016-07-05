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
import com.rengwuxian.materialedittext.MaterialEditText;
import youdrive.today.C1733R;
import youdrive.today.fragments.RegisterProfileFragment;

public class FragmentRegisterProfileBinding extends ViewDataBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    public final MaterialEditText etEmail;
    public final MaterialEditText etMiddleName;
    public final MaterialEditText etName;
    public final MaterialEditText etPassword;
    public final MaterialEditText etPaswordAgain;
    public final MaterialEditText etPhone;
    public final MaterialEditText etPromo;
    public final MaterialEditText etSurname;
    public final ImageView ivEmailHint;
    public final ImageView ivMidleNameHint;
    public final ImageView ivNameHint;
    public final ImageView ivPasswordAgainHint;
    public final ImageView ivPasswordHind;
    public final ImageView ivPhoneHint;
    public final ImageView ivPromoHint;
    public final ImageView ivSurnameHint;
    private OnClickListenerImpl mAndroidViewViewOnCl;
    private OnClickListenerImpl1 mAndroidViewViewOnCl1;
    private OnClickListenerImpl2 mAndroidViewViewOnCl2;
    private OnClickListenerImpl3 mAndroidViewViewOnCl3;
    private OnClickListenerImpl4 mAndroidViewViewOnCl4;
    private OnClickListenerImpl5 mAndroidViewViewOnCl5;
    private OnClickListenerImpl6 mAndroidViewViewOnCl6;
    private OnClickListenerImpl7 mAndroidViewViewOnCl7;
    private OnClickListenerImpl8 mAndroidViewViewOnCl8;
    private long mDirtyFlags;
    private RegisterProfileFragment mListener;
    private final RelativeLayout mboundView0;
    private final TextView mboundView9;
    public final TextView tvForvard;
    public final TextView tvTitle;

    public static class OnClickListenerImpl1 implements OnClickListener {
        private RegisterProfileFragment value;

        public OnClickListenerImpl1 setValue(RegisterProfileFragment value) {
            this.value = value;
            return value == null ? null : this;
        }

        public void onClick(View arg0) {
            this.value.onBack(arg0);
        }
    }

    public static class OnClickListenerImpl2 implements OnClickListener {
        private RegisterProfileFragment value;

        public OnClickListenerImpl2 setValue(RegisterProfileFragment value) {
            this.value = value;
            return value == null ? null : this;
        }

        public void onClick(View arg0) {
            this.value.onPassword(arg0);
        }
    }

    public static class OnClickListenerImpl3 implements OnClickListener {
        private RegisterProfileFragment value;

        public OnClickListenerImpl3 setValue(RegisterProfileFragment value) {
            this.value = value;
            return value == null ? null : this;
        }

        public void onClick(View arg0) {
            this.value.onEmail(arg0);
        }
    }

    public static class OnClickListenerImpl4 implements OnClickListener {
        private RegisterProfileFragment value;

        public OnClickListenerImpl4 setValue(RegisterProfileFragment value) {
            this.value = value;
            return value == null ? null : this;
        }

        public void onClick(View arg0) {
            this.value.onSurName(arg0);
        }
    }

    public static class OnClickListenerImpl5 implements OnClickListener {
        private RegisterProfileFragment value;

        public OnClickListenerImpl5 setValue(RegisterProfileFragment value) {
            this.value = value;
            return value == null ? null : this;
        }

        public void onClick(View arg0) {
            this.value.onPromo(arg0);
        }
    }

    public static class OnClickListenerImpl6 implements OnClickListener {
        private RegisterProfileFragment value;

        public OnClickListenerImpl6 setValue(RegisterProfileFragment value) {
            this.value = value;
            return value == null ? null : this;
        }

        public void onClick(View arg0) {
            this.value.onName(arg0);
        }
    }

    public static class OnClickListenerImpl7 implements OnClickListener {
        private RegisterProfileFragment value;

        public OnClickListenerImpl7 setValue(RegisterProfileFragment value) {
            this.value = value;
            return value == null ? null : this;
        }

        public void onClick(View arg0) {
            this.value.onForvard(arg0);
        }
    }

    public static class OnClickListenerImpl8 implements OnClickListener {
        private RegisterProfileFragment value;

        public OnClickListenerImpl8 setValue(RegisterProfileFragment value) {
            this.value = value;
            return value == null ? null : this;
        }

        public void onClick(View arg0) {
            this.value.onPhone(arg0);
        }
    }

    public static class OnClickListenerImpl implements OnClickListener {
        private RegisterProfileFragment value;

        public OnClickListenerImpl setValue(RegisterProfileFragment value) {
            this.value = value;
            return value == null ? null : this;
        }

        public void onClick(View arg0) {
            this.value.onMiddleName(arg0);
        }
    }

    static {
        sIncludes = null;
        sViewsWithIds = new SparseIntArray();
        sViewsWithIds.put(C1733R.id.tvTitle, 10);
        sViewsWithIds.put(C1733R.id.etEmail, 11);
        sViewsWithIds.put(C1733R.id.etPhone, 12);
        sViewsWithIds.put(C1733R.id.etPassword, 13);
        sViewsWithIds.put(C1733R.id.ivPasswordAgainHint, 14);
        sViewsWithIds.put(C1733R.id.etPaswordAgain, 15);
        sViewsWithIds.put(C1733R.id.etPromo, 16);
        sViewsWithIds.put(C1733R.id.etSurname, 17);
        sViewsWithIds.put(C1733R.id.etName, 18);
        sViewsWithIds.put(C1733R.id.etMiddleName, 19);
    }

    public FragmentRegisterProfileBinding(DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        this.mDirtyFlags = -1;
        Object[] bindings = ViewDataBinding.mapBindings(bindingComponent, root, 20, sIncludes, sViewsWithIds);
        this.etEmail = (MaterialEditText) bindings[11];
        this.etMiddleName = (MaterialEditText) bindings[19];
        this.etName = (MaterialEditText) bindings[18];
        this.etPassword = (MaterialEditText) bindings[13];
        this.etPaswordAgain = (MaterialEditText) bindings[15];
        this.etPhone = (MaterialEditText) bindings[12];
        this.etPromo = (MaterialEditText) bindings[16];
        this.etSurname = (MaterialEditText) bindings[17];
        this.ivEmailHint = (ImageView) bindings[1];
        this.ivEmailHint.setTag(null);
        this.ivMidleNameHint = (ImageView) bindings[7];
        this.ivMidleNameHint.setTag(null);
        this.ivNameHint = (ImageView) bindings[6];
        this.ivNameHint.setTag(null);
        this.ivPasswordAgainHint = (ImageView) bindings[14];
        this.ivPasswordHind = (ImageView) bindings[3];
        this.ivPasswordHind.setTag(null);
        this.ivPhoneHint = (ImageView) bindings[2];
        this.ivPhoneHint.setTag(null);
        this.ivPromoHint = (ImageView) bindings[4];
        this.ivPromoHint.setTag(null);
        this.ivSurnameHint = (ImageView) bindings[5];
        this.ivSurnameHint.setTag(null);
        this.mboundView0 = (RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView9 = (TextView) bindings[9];
        this.mboundView9.setTag(null);
        this.tvForvard = (TextView) bindings[8];
        this.tvForvard.setTag(null);
        this.tvTitle = (TextView) bindings[10];
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
                setListener((RegisterProfileFragment) variable);
                return true;
            default:
                return false;
        }
    }

    public void setListener(RegisterProfileFragment listener) {
        this.mListener = listener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        super.requestRebind();
    }

    public RegisterProfileFragment getListener() {
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
        RegisterProfileFragment listener = this.mListener;
        OnClickListener androidViewViewOnCli = null;
        OnClickListener androidViewViewOnCli1 = null;
        OnClickListener androidViewViewOnCli2 = null;
        OnClickListener androidViewViewOnCli3 = null;
        OnClickListener androidViewViewOnCli4 = null;
        OnClickListener androidViewViewOnCli5 = null;
        OnClickListener androidViewViewOnCli6 = null;
        OnClickListener androidViewViewOnCli7 = null;
        OnClickListener androidViewViewOnCli8 = null;
        if (!((3 & dirtyFlags) == 0 || listener == null)) {
            OnClickListenerImpl onClickListenerImpl;
            OnClickListenerImpl1 onClickListenerImpl1;
            OnClickListenerImpl2 onClickListenerImpl2;
            OnClickListenerImpl3 onClickListenerImpl3;
            OnClickListenerImpl4 onClickListenerImpl4;
            OnClickListenerImpl5 onClickListenerImpl5;
            OnClickListenerImpl6 onClickListenerImpl6;
            OnClickListenerImpl7 onClickListenerImpl7;
            OnClickListenerImpl8 onClickListenerImpl8;
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
            if (this.mAndroidViewViewOnCl5 == null) {
                onClickListenerImpl5 = new OnClickListenerImpl5();
                this.mAndroidViewViewOnCl5 = onClickListenerImpl5;
            } else {
                onClickListenerImpl5 = this.mAndroidViewViewOnCl5;
            }
            androidViewViewOnCli5 = onClickListenerImpl5.setValue(listener);
            if (this.mAndroidViewViewOnCl6 == null) {
                onClickListenerImpl6 = new OnClickListenerImpl6();
                this.mAndroidViewViewOnCl6 = onClickListenerImpl6;
            } else {
                onClickListenerImpl6 = this.mAndroidViewViewOnCl6;
            }
            androidViewViewOnCli6 = onClickListenerImpl6.setValue(listener);
            if (this.mAndroidViewViewOnCl7 == null) {
                onClickListenerImpl7 = new OnClickListenerImpl7();
                this.mAndroidViewViewOnCl7 = onClickListenerImpl7;
            } else {
                onClickListenerImpl7 = this.mAndroidViewViewOnCl7;
            }
            androidViewViewOnCli7 = onClickListenerImpl7.setValue(listener);
            if (this.mAndroidViewViewOnCl8 == null) {
                onClickListenerImpl8 = new OnClickListenerImpl8();
                this.mAndroidViewViewOnCl8 = onClickListenerImpl8;
            } else {
                onClickListenerImpl8 = this.mAndroidViewViewOnCl8;
            }
            androidViewViewOnCli8 = onClickListenerImpl8.setValue(listener);
        }
        if ((3 & dirtyFlags) != 0) {
            this.ivEmailHint.setOnClickListener(androidViewViewOnCli3);
            this.ivMidleNameHint.setOnClickListener(androidViewViewOnCli);
            this.ivNameHint.setOnClickListener(androidViewViewOnCli6);
            this.ivPasswordHind.setOnClickListener(androidViewViewOnCli2);
            this.ivPhoneHint.setOnClickListener(androidViewViewOnCli8);
            this.ivPromoHint.setOnClickListener(androidViewViewOnCli5);
            this.ivSurnameHint.setOnClickListener(androidViewViewOnCli4);
            this.mboundView9.setOnClickListener(androidViewViewOnCli1);
            this.tvForvard.setOnClickListener(androidViewViewOnCli7);
        }
    }

    public static FragmentRegisterProfileBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public static FragmentRegisterProfileBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, DataBindingComponent bindingComponent) {
        return (FragmentRegisterProfileBinding) DataBindingUtil.inflate(inflater, C1733R.layout.fragment_register_profile, root, attachToRoot, bindingComponent);
    }

    public static FragmentRegisterProfileBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    public static FragmentRegisterProfileBinding inflate(LayoutInflater inflater, DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(C1733R.layout.fragment_register_profile, null, false), bindingComponent);
    }

    public static FragmentRegisterProfileBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    public static FragmentRegisterProfileBinding bind(View view, DataBindingComponent bindingComponent) {
        if ("layout/fragment_register_profile_0".equals(view.getTag())) {
            return new FragmentRegisterProfileBinding(bindingComponent, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
