package com.jlsegb.sentinel;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ProfileList extends ArrayAdapter<Profile>{

    private Activity context;
    private List<Profile> profileList;

    public ProfileList(Activity context, List<Profile> profileList) {
        super(context, R.layout.list_layout, profileList);
        this.context = context;
        this.profileList = profileList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewLocation = (TextView) listViewItem.findViewById(R.id.textViewLocation);
        TextView textViewFrequency = (TextView) listViewItem.findViewById(R.id.textViewFrequency);
        TextView textViewBio = (TextView) listViewItem.findViewById(R.id.textViewBio);

        Profile profile = profileList.get(position);

        textViewName.setText(profile.getName1());
        textViewLocation.setText(profile.getLocation());
        textViewFrequency.setText(profile.getFrequency());
        textViewBio.setText(profile.getAboutMe());

        return listViewItem;

    }
}
