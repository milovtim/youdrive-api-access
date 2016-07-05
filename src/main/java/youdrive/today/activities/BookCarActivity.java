package youdrive.today.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.bumptech.glide.Glide;
import youdrive.today.BaseActivity;
import youdrive.today.C1733R;
import youdrive.today.databinding.ActivityOrderCarBinding;
import youdrive.today.models.Car;

public class BookCarActivity extends BaseActivity {
    private ActivityOrderCarBinding f791b;

    public void bindActivity() {
        this.f791b = (ActivityOrderCarBinding) DataBindingUtil.setContentView(this, C1733R.layout.activity_order_car);
        this.f791b.setListener(this);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Car mCar = (Car) getIntent().getParcelableExtra("car");
        if (mCar != null) {
            this.f791b.txtModel.setText(getString(C1733R.string.car_model, new Object[]{mCar.getModel()}));
            this.f791b.txtColor.setText(getString(C1733R.string.car_color, new Object[]{mCar.getColor()}));
            this.f791b.txtNumber.setText(getString(C1733R.string.car_number, new Object[]{mCar.getNumber()}));
            Glide.with((FragmentActivity) this).load(mCar.getImg()).centerCrop().crossFade().into(this.f791b.imgCar);
        }
    }

    public void onShow(View view) {
        finish();
    }
}
