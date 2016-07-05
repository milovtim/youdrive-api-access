package youdrive.today.adapters;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import java.util.List;
import youdrive.today.databinding.ItemProfileBinding;
import youdrive.today.models.Menu;

public class ProfileAdapter extends ArrayAdapter<Menu> {
    private final Context mContext;
    private final List<Menu> mObjects;
    private final int mResource;

    static class ItemHolder {
        ItemProfileBinding binding;

        public ItemHolder(View view) {
            this.binding = (ItemProfileBinding) DataBindingUtil.bind(view);
        }
    }

    public ProfileAdapter(Context context, int resource, List<Menu> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
        this.mObjects = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ItemHolder holder;
        View row = convertView;
        if (row == null) {
            row = ((Activity) this.mContext).getLayoutInflater().inflate(this.mResource, parent, false);
            holder = new ItemHolder(row);
            row.setTag(holder);
        } else {
            holder = (ItemHolder) row.getTag();
        }
        Menu item = (Menu) this.mObjects.get(position);
        holder.binding.txtTitle.setText(item.title);
        holder.binding.ivIcon.setImageResource(item.icon);
        return row;
    }
}
