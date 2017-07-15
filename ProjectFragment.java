package com.example.shwetashahane.finalproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

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

public class ProjectFragment extends Fragment {

    HashMap<String, Object> map1 = new HashMap<>();
    String current_user;
    String  projName1,projDesc1,tech1,org1,from1,to1,projName2,projDesc2,tech2,org2,from2,to2;
    public ProjectFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_project,container, false);
        Bundle bundle=getArguments();
        current_user=bundle.getString("current_usermail");
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        rootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    map1 = (HashMap<String, Object>) postSnapshot.getValue();
                    if (map1.get("email").equals(current_user)) {
                        projName1 = (String) map1.get("proj1");
                        projDesc1 = (String) map1.get("projDesc1");
                        tech1 = (String) map1.get("tech1");
                        org1=(String) map1.get("org1");
                        from1=(String) map1.get("from2");
                        to1=(String) map1.get("to2");
                        projName2 = (String) map1.get("proj2");
                        projDesc2 = (String) map1.get("projDesc2");
                        tech2 = (String) map1.get("tech2");
                        org2=(String) map1.get("org2");
                        from2=(String) map1.get("from3");
                        to2=(String) map1.get("to3");
                        Person p = new Person();
                        p.setProj1(projName1);
                        p.setProj2(projName2);
                        p.setProjDesc1(projDesc1);
                        p.setProjDesc2(projDesc2);
                        p.setTech1(tech1);
                        p.setTech2(tech2);
                        p.setOrg1(org1);
                        p.setOrg2(org2);
                        p.setFrom2(from1);
                        p.setFrom3(from2);
                        p.setTo2(to1);
                        p.setTo3(to2);
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
        TextView proj1 = (TextView) getActivity().findViewById(R.id.proj1Text);
        proj1.setText("Project: "+person.getProj1());
        TextView proj2 = (TextView) getActivity().findViewById(R.id.proName2);
        proj2.setText("Project: "+person.getProj2());
        TextView projDesc1 = (TextView) getActivity().findViewById(R.id.projDesc1);
        projDesc1.setText("Project Description: "+person.getProjDesc1());
        TextView projDesc2 = (TextView) getActivity().findViewById(R.id.projDesc2);
        projDesc2.setText("Project Description: "+person.getProjDesc2());
        TextView tech1 = (TextView) getActivity().findViewById(R.id.techText1);
        tech1.setText("Technology: "+person.getTech1());
        TextView tech2 = (TextView) getActivity().findViewById(R.id.techText2);
        tech2.setText("Technology: "+person.getTech2());
        TextView org1 = (TextView) getActivity().findViewById(R.id.orgText1);
        org1.setText("Organization Name: "+person.getOrg1());
        TextView org2 = (TextView) getActivity().findViewById(R.id.orgText2);
        org2.setText("Organization Name: "+person.getOrg2());
        TextView to1 = (TextView) getActivity().findViewById(R.id.toText1);
        to1.setText("End Year: "+person.getTo2());
        TextView to2 = (TextView) getActivity().findViewById(R.id.toText2);
        to2.setText("End Year: "+person.getTo3());
        TextView from1 = (TextView) getActivity().findViewById(R.id.fromText1);
        from1.setText("Start Year: "+person.getFrom2());
        TextView from2 = (TextView) getActivity().findViewById(R.id.fromText2);
        from2.setText("Start Year: "+person.getFrom3());
    }
}
