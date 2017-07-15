package com.example.shwetashahane.finalproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by shwetashahane on 5/11/17.
 */

public class ProfileFragment extends Fragment {

    HashMap<String, Object> map1 = new HashMap<>();
    String profSummary,name,techSkills;
    ListView list;
    ArrayList<TechSkills> skill;
    String current_user;

    public ProfileFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        Bundle bundle=getArguments();
        current_user=bundle.getString("current_usermail");
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        rootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    map1 = (HashMap<String, Object>) postSnapshot.getValue();
                    if (map1.get("email").equals(current_user)) {
                        profSummary = (String) map1.get("summary");
                        name = (String) map1.get("name");
                        techSkills = (String) map1.get("skills");
                        Person p = new Person();
                        p.setName(name);
                        p.setSummary(profSummary);
                        p.setSkills(techSkills);
                        setDetails(p);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError firebaseError) {
            }
        });
        return rootView;
    }


    public void setDetails(Person person) {
        skill=new ArrayList<TechSkills>();
        String name=person.getName();
        String sum=person.getSummary();
        TextView profSummaryText = (TextView) getActivity().findViewById(R.id.summaryTextView);
        profSummaryText.setText(sum);
        String techSkills= person.getSkills();
        String sk[]=techSkills.split(",");
        for(String k:sk) {
            System.out.println("skills " + k);
            TechSkills tech=new TechSkills();
            tech.setTechName(k.replaceAll("\\s+",""));
            if(k.replaceAll("\\s+","").equalsIgnoreCase("java"))
                tech.setTechImage("java.png");
            if(k.replaceAll("\\s+","").equalsIgnoreCase("python"))
                tech.setTechImage("python.png");
            if(k.replaceAll("\\s+","").equalsIgnoreCase("android"))
                tech.setTechImage("android.png");
            if(k.replaceAll("\\s+","").equalsIgnoreCase("html5"))
                tech.setTechImage("html5.png");
            if(k.replaceAll("\\s+","").equalsIgnoreCase("android"))
                tech.setTechImage("android.png");
            if(k.replaceAll("\\s+","").equalsIgnoreCase("html"))
                tech.setTechImage("html.png");
            if(k.replaceAll("\\s+","").equalsIgnoreCase("jquery"))
                tech.setTechImage("jquery.png");
            if(k.replaceAll("\\s+","").equalsIgnoreCase("javascript"))
                tech.setTechImage("js.png");
            if(k.replaceAll("\\s+","").equalsIgnoreCase("nodejs"))
                tech.setTechImage("nodejs.png");
            skill.add(tech);
        }
        for(TechSkills str: skill)
            System.out.println(str.getTechName()+" "+str.getTechImage());
        list = (ListView) getActivity().findViewById(R.id.listView);
        CustomListAdapter adapter = new CustomListAdapter(getContext(), R.layout.row, skill);
        list.setAdapter(adapter);
    }
}