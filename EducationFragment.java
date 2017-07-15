package com.example.shwetashahane.finalproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

/**
 * Created by shwetashahane on 5/11/17.
 */

public class EducationFragment extends Fragment {

    HashMap<String, Object> map1 = new HashMap<>();
    String current_user;
    String  deg1,deg2,dept1,dept2,univName1,univName2,from1,to1,from2,to2,gpa1,gpa2;

    public EducationFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_edu,container, false);
        Bundle bundle=getArguments();
        current_user=bundle.getString("current_usermail");
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        rootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    map1 = (HashMap<String, Object>) postSnapshot.getValue();
                    if (map1.get("email").equals(current_user)) {
                        deg1 = (String) map1.get("degree");
                        dept1 = (String) map1.get("dept");
                        univName1 = (String) map1.get("univName");
                        gpa1=(String) map1.get("gpa");
                        from1=(String) map1.get("from");
                        to1=(String) map1.get("to");
                        deg2 = (String) map1.get("degree1");
                        dept2 = (String) map1.get("dept1");
                        univName2 = (String) map1.get("univName1");
                        gpa2=(String) map1.get("gpa1");
                        from2=(String) map1.get("from1");
                        to2=(String) map1.get("to1");
                        Person p = new Person();
                        p.setDegree(deg1);
                        p.setDegree1(deg2);
                        p.setDept(dept1);
                        p.setDept1(dept2);
                        p.setUnivName(univName1);
                        p.setUnivName1(univName2);
                        p.setGpa(gpa1);
                        p.setGpa1(gpa2);
                        p.setTo(to1);
                        p.setTo1(to2);
                        p.setFrom(from1);
                        p.setFrom1(from2);
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
        TextView deg1 = (TextView) getActivity().findViewById(R.id.degText1);
        deg1.setText("Degree: "+person.getDegree());
        TextView deg2 = (TextView) getActivity().findViewById(R.id.degText2);
        deg2.setText("Degree: "+person.getDegree1());
        TextView dept1 = (TextView) getActivity().findViewById(R.id.deptText1);
        dept1.setText("Department: "+person.getDept());
        TextView dept2 = (TextView) getActivity().findViewById(R.id.deptText2);
        dept2.setText("Department: "+person.getDept1());
        TextView univName1 = (TextView) getActivity().findViewById(R.id.univName1);
        univName1.setText("University Name: "+person.getUnivName());
        TextView univName2 = (TextView) getActivity().findViewById(R.id.univName2);
        univName2.setText("University Name: "+person.getUnivName1());
        TextView gpa1 = (TextView) getActivity().findViewById(R.id.gpaText1);
        gpa1.setText("GPA: "+person.getGpa());
        TextView gpa2 = (TextView) getActivity().findViewById(R.id.gpaText2);
        gpa2.setText("GPA: "+person.getGpa1());
        TextView to1 = (TextView) getActivity().findViewById(R.id.toText1);
        to1.setText("End Year: "+person.getTo());
        TextView to2 = (TextView) getActivity().findViewById(R.id.toText2);
        to2.setText("End Year: "+person.getTo1());
        TextView from1 = (TextView) getActivity().findViewById(R.id.fromText1);
        from1.setText("Start Year: "+person.getFrom());
        TextView from2 = (TextView) getActivity().findViewById(R.id.fromText2);
        from2.setText("Start Year: "+person.getFrom1());
    }
}
