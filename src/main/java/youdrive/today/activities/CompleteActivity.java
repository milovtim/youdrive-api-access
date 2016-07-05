package youdrive.today.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import youdrive.today.BaseActivity;
import youdrive.today.C1733R;
import youdrive.today.databinding.ActivityCompleteBinding;
import youdrive.today.models.Check;

public class CompleteActivity extends BaseActivity {
    private ActivityCompleteBinding f792b;

    public void bindActivity() {
        this.f792b = (ActivityCompleteBinding) DataBindingUtil.setContentView(this, C1733R.layout.activity_complete);
        this.f792b.setListener(this);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Check check = (Check) getIntent().getParcelableExtra("check");
        if (check != null) {
            this.f792b.txtTotalUsage.setText(convertRub(check.getUsageWeekendCost() + check.getUsageWorkdayCost()));
            this.f792b.txtParking.setText(convertRub(check.getParkingCost()));
            this.f792b.txtTotal.setText(convertRub((check.getParkingCost() + check.getUsageWorkdayCost()) + check.getUsageWeekendCost()));
            if (check.getDiscountPercent() == 0 || check.getDiscountPrice() == 0) {
                this.f792b.llDiscount.setVisibility(8);
                return;
            }
            this.f792b.llDiscount.setVisibility(0);
            this.f792b.txtDiscount.setText("-" + convertRub(check.getDiscountPrice()));
            this.f792b.txtTitleDiscount.setText(getString(C1733R.string.discount) + " " + check.getDiscountPercent() + "%:");
        }
    }

    public void onClose(View view) {
        finish();
    }

    private String convertRub(long kopeck) {
        return String.format("%.2f", new Object[]{Float.valueOf(((float) kopeck) / 100.0f)}) + " \u0440\u0443\u0431.";
    }
}
