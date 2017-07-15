package com.example.shwetashahane.finalproject;

/**
 * Created by shwetashahane on 5/12/17.
 */


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by shwetashahane on 3/19/17.
 */

public class CustomListAdapter extends ArrayAdapter<TechSkills> {

    Context context;
    int layoutResourceId;
    ArrayList<TechSkills> data = null;

    public CustomListAdapter(Context context, int layoutResourceId, ArrayList<TechSkills> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        TechSkillHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new TechSkillHolder();
            holder.techName = (TextView) row.findViewById(R.id.progText);
            holder.techImage= (ImageView) row.findViewById(R.id.tech_image);

            row.setTag(holder);
        } else {
            holder = (TechSkillHolder) row.getTag();
        }

        TechSkills skill = data.get(position);
        System.out.println("it came here in CLA");
        holder.techName.setText(skill.getTechName());
        File f = new File("/data/user/0/com.example.shwetashahane.finalproject/", skill.getTechImage());
        Bitmap b = null;
        try {
            b = BitmapFactory.decodeStream(new FileInputStream(f));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        holder.techImage.setImageBitmap(b);
        return row;
    }

    static class TechSkillHolder {
        TextView techName;
        ImageView techImage;
    }
}