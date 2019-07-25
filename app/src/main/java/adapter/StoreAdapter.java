package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import model.Store;
import vn.edu.csc.foodnowapp.R;

public class StoreAdapter extends ArrayAdapter<Store> {
    Context context;
    int resource;
    List<Store> objects;

    public class ViewHolder{
        ImageView ivLogo;
        TextView tvName, tvAddress;
    }

    public StoreAdapter(Context context, int resource, List<Store> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }


    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();

        if (convertView == null)
        {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.home_row, parent, false);
            viewHolder.ivLogo = convertView.findViewById(R.id.ivLogo);
            viewHolder.tvName = convertView.findViewById(R.id.tvName);
            viewHolder.tvAddress = convertView.findViewById(R.id.tvAddress);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Store store = objects.get(position);
        viewHolder.ivLogo.setImageResource(store.getLogo());
        viewHolder.tvName.setText(store.getName());
        viewHolder.tvAddress.setText(store.getAddress());

        return convertView;
    }
}
