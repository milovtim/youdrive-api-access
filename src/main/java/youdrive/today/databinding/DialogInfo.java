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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dd.CircularProgressButton;
import java.util.concurrent.TimeUnit;
import youdrive.today.C1733R;
import youdrive.today.activities.MapsActivity;
import youdrive.today.helpers.AppUtils;
import youdrive.today.models.Car;
import youdrive.today.models.Tariff;

public class DialogInfo extends ViewDataBinding {
    private static final IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    public final CircularProgressButton btnBook;
    private MapsActivity mActivity;
    private OnClickListenerImpl mAndroidViewViewOnCl;
    private Car mCar;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final TextView mboundView10;
    private final RelativeLayout mboundView9;
    public final TextView txtDistance;
    public final TextView txtFuel;
    public final TextView txtModel;
    public final TextView txtNumber;
    public final TextView txtTaxDrive;
    public final TextView txtTaxPark;
    public final TextView txtTimeTo;
    public final TextView txtType;

    public static class OnClickListenerImpl implements OnClickListener {
        private MapsActivity value;

        public OnClickListenerImpl setValue(MapsActivity value) {
            this.value = value;
            return value == null ? null : this;
        }

        public void onClick(View arg0) {
            this.value.onBookClicked(arg0);
        }
    }

    static {
        sIncludes = null;
        sViewsWithIds = null;
    }

    public DialogInfo(DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        this.mDirtyFlags = -1;
        Object[] bindings = ViewDataBinding.mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds);
        this.btnBook = (CircularProgressButton) bindings[11];
        this.btnBook.setTag(null);
        this.mboundView0 = (LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView10 = (TextView) bindings[10];
        this.mboundView10.setTag(null);
        this.mboundView9 = (RelativeLayout) bindings[9];
        this.mboundView9.setTag(null);
        this.txtDistance = (TextView) bindings[2];
        this.txtDistance.setTag(null);
        this.txtFuel = (TextView) bindings[8];
        this.txtFuel.setTag(null);
        this.txtModel = (TextView) bindings[1];
        this.txtModel.setTag(null);
        this.txtNumber = (TextView) bindings[5];
        this.txtNumber.setTag(null);
        this.txtTaxDrive = (TextView) bindings[6];
        this.txtTaxDrive.setTag(null);
        this.txtTaxPark = (TextView) bindings[7];
        this.txtTaxPark.setTag(null);
        this.txtTimeTo = (TextView) bindings[3];
        this.txtTimeTo.setTag(null);
        this.txtType = (TextView) bindings[4];
        this.txtType.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4;
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
            case C1733R.styleable.View_android_focusable /*1*/:
                setActivity((MapsActivity) variable);
                return true;
            case C1733R.styleable.View_paddingStart /*2*/:
                setCar((Car) variable);
                return true;
            default:
                return false;
        }
    }

    public void setCar(Car car) {
        this.mCar = car;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        super.requestRebind();
    }

    public Car getCar() {
        return this.mCar;
    }

    public void setActivity(MapsActivity activity) {
        this.mActivity = activity;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        super.requestRebind();
    }

    public MapsActivity getActivity() {
        return this.mActivity;
    }

    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    protected void executeBindings() {
        synchronized (this) {
            long dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Car car = this.mCar;
        String SECONDSTimeUnitToMin = null;
        int parkingTariffCar = 0;
        int carGetDiscountCar = 0;
        Tariff tariffCar = null;
        String transmissionCar = null;
        boolean NumberCarObjectnull = false;
        int usageTariffCar = 0;
        String idCar = null;
        String AppUtilsToKmAppUtils = null;
        int walktimeCar = 0;
        Integer fuelCar = null;
        OnClickListener androidViewViewOnCli = null;
        String activityConvertRubPe = null;
        MapsActivity activity = this.mActivity;
        String modelCar = null;
        String activityConvertRubPe1 = null;
        String StringCarGetDiscount = null;
        String fuelCarString = null;
        String NumberCarObjectnullS = null;
        int CarGetDiscountCarInt1 = 0;
        boolean FuelCarObjectnull = false;
        int distanceCar = 0;
        String numberCar = null;
        String FuelCarObjectnullAnd = null;
        if ((7 & dirtyFlags) != 0) {
            if ((5 & dirtyFlags) != 0) {
                if (car != null) {
                    carGetDiscountCar = car.getDiscount();
                    transmissionCar = car.getTransmission();
                    idCar = car.getId();
                    walktimeCar = car.getWalktime();
                    fuelCar = car.getFuel();
                    modelCar = car.getModel();
                    distanceCar = car.getDistance();
                    numberCar = car.getNumber();
                }
                boolean CarGetDiscountCarInt = carGetDiscountCar == 0;
                String StringCarGetDiscount1 = "-" + carGetDiscountCar;
                long SECONDSTimeUnitToMin1 = TimeUnit.SECONDS.toMinutes((long) walktimeCar);
                FuelCarObjectnull = fuelCar == null;
                AppUtilsToKmAppUtils = AppUtils.toKm(distanceCar);
                NumberCarObjectnull = numberCar == null;
                if ((5 & dirtyFlags) != 0) {
                    if (CarGetDiscountCarInt) {
                        dirtyFlags |= 64;
                    } else {
                        dirtyFlags |= 32;
                    }
                }
                if ((5 & dirtyFlags) != 0) {
                    if (FuelCarObjectnull) {
                        dirtyFlags |= 256;
                    } else {
                        dirtyFlags |= 128;
                    }
                }
                if ((5 & dirtyFlags) != 0) {
                    if (NumberCarObjectnull) {
                        dirtyFlags |= 16;
                    } else {
                        dirtyFlags |= 8;
                    }
                }
                CarGetDiscountCarInt1 = CarGetDiscountCarInt ? 8 : 0;
                StringCarGetDiscount = StringCarGetDiscount1 + "%";
                SECONDSTimeUnitToMin = SECONDSTimeUnitToMin1 + " \u043c\u0438\u043d.";
            }
            if (car != null) {
                tariffCar = car.getTariff();
            }
            if (tariffCar != null) {
                parkingTariffCar = tariffCar.getParking();
                usageTariffCar = tariffCar.getUsage();
            }
            if (activity != null) {
                activityConvertRubPe1 = activity.convertRubPerMin((long) parkingTariffCar);
                activityConvertRubPe = activity.convertRubPerMin((long) usageTariffCar);
            }
            if (!((6 & dirtyFlags) == 0 || activity == null)) {
                OnClickListenerImpl onClickListenerImpl;
                if (this.mAndroidViewViewOnCl == null) {
                    onClickListenerImpl = new OnClickListenerImpl();
                    this.mAndroidViewViewOnCl = onClickListenerImpl;
                } else {
                    onClickListenerImpl = this.mAndroidViewViewOnCl;
                }
                androidViewViewOnCli = onClickListenerImpl.setValue(activity);
            }
        }
        if ((128 & dirtyFlags) != 0) {
            fuelCarString = fuelCar + " %";
        }
        if ((5 & dirtyFlags) != 0) {
            NumberCarObjectnullS = NumberCarObjectnull ? "-" : numberCar;
        }
        if ((5 & dirtyFlags) != 0) {
            if (FuelCarObjectnull) {
                FuelCarObjectnullAnd = getRoot().getResources().getString(C1733R.string.unknown);
            } else {
                FuelCarObjectnullAnd = fuelCarString;
            }
        }
        if ((6 & dirtyFlags) != 0) {
            this.btnBook.setOnClickListener(androidViewViewOnCli);
        }
        if ((5 & dirtyFlags) != 0) {
            this.btnBook.setTag(idCar);
            this.mboundView10.setText(StringCarGetDiscount);
            this.mboundView9.setVisibility(CarGetDiscountCarInt1);
            this.txtDistance.setText(AppUtilsToKmAppUtils);
            this.txtFuel.setText(FuelCarObjectnullAnd);
            this.txtModel.setText(modelCar);
            this.txtNumber.setText(NumberCarObjectnullS);
            this.txtTimeTo.setText(SECONDSTimeUnitToMin);
            this.txtType.setText(transmissionCar);
        }
        if ((7 & dirtyFlags) != 0) {
            this.txtTaxDrive.setText(activityConvertRubPe);
            this.txtTaxPark.setText(activityConvertRubPe1);
        }
    }

    public static DialogInfo inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public static DialogInfo inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, DataBindingComponent bindingComponent) {
        return (DialogInfo) DataBindingUtil.inflate(inflater, C1733R.layout.dialog_info_contents, root, attachToRoot, bindingComponent);
    }

    public static DialogInfo inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    public static DialogInfo inflate(LayoutInflater inflater, DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(C1733R.layout.dialog_info_contents, null, false), bindingComponent);
    }

    public static DialogInfo bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    public static DialogInfo bind(View view, DataBindingComponent bindingComponent) {
        if ("layout/dialog_info_contents_0".equals(view.getTag())) {
            return new DialogInfo(bindingComponent, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
