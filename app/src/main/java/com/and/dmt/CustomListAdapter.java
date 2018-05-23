package com.and.dmt;

/**
 * Created by user on 11/22/2017.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter<RowItem> {

    Context context;

    public CustomListAdapter(Context context, int resourceId,
                                 List<RowItem> items) {
        super(context, resourceId, items);

        this.context = context;
    }

    /*private view holder class*/
    private class ViewHolder {
        ImageView imgDelete;
        ImageView imgArrow;
        TextView txtTitle;
        TextView txtHint;
        TextView txtValue;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        RowItem rowItem = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.subitem_list_main, null);
            holder = new ViewHolder();

            holder.imgDelete = (ImageView) convertView.findViewById(R.id.SubItemList_Delete);
            holder.imgArrow = (ImageView) convertView.findViewById(R.id.SubItemList_Arrow);
            holder.txtTitle = (TextView) convertView.findViewById(R.id.SubItemList_StrPanel_Title);
            holder.txtHint = (TextView) convertView.findViewById(R.id.SubItemList_StrPanel_Hint);
            holder.txtValue = (TextView) convertView.findViewById(R.id.SubItemList_StrPanel_Value);
            if(rowItem.getDeleteStatus() == true)
                holder.imgDelete.setVisibility(View.VISIBLE);
            else
                holder.imgDelete.setVisibility(View.GONE);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.imgArrow.setImageResource(rowItem.getImgID());
        holder.txtTitle.setText(rowItem.getTitle());
        holder.txtHint.setText(rowItem.getHint());
        holder.txtValue.setText(rowItem.getValue());


        return convertView;
    }
}