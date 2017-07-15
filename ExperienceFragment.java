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

public class ExperienceFragment extends Fragment {

    HashMap<String, Object> map1 = new HashMap<>();
    String current_user;
    String  comp1,comp2,compAddr1,compAddr2,pos1,pos2,from1,to1,from2,to2,resp1,resp2;

    public ExperienceFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_exp,container, false);
        Bundle bundle=getArguments();
        current_user=bundle.getString("current_usermail");
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        rootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    map1 = (HashMap<String, Object>) postSnapshot.getValue();
                    if (map1.get("email").equals(current_user)) {
                        comp1 = (String) map1.get("company1");
                        compAddr1 = (String) map1.get("companyAddr");
                        pos1 = (String) map1.get("pos");
                        resp1=(String) map1.get("resp");
                        from1=(String) map1.get("from4");
                        to1=(String) map1.get("to4");
                        comp2 = (String) map1.get("company1");
                        compAddr2 = (String) map1.get("companyAddr1");
                        pos2 = (String) map1.get("pos1");
                        resp2=(String) map1.get("resp1");
                        from2=(String) map1.get("from5");
                        to2=(String) map1.get("to5");
                        Person p = new Person();
                        p.setCompany(comp1);
                        p.setCompany1(comp2);
                        p.setCompanyAddr(compAddr1);
                        p.setCompanyAddr1(compAddr2);
                        p.setPos(pos1);
                        p.setPos1(pos2);
                        p.setResp(resp1);
                        p.setResp1(resp2);
                        p.setFrom4(from1);
                        p.setFrom5(from2);
                        p.setTo4(to1);
                        p.setTo5(to2);
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
        TextView comp1 = (TextView) getActivity().findViewById(R.id.compText1);
        comp1.setText("Company: "+person.getCompany());
        TextView comp2 = (TextView) getActivity().findViewById(R.id.companyText2);
        comp2.setText("Company: "+person.getCompany1());
        TextView compAddr1 = (TextView) getActivity().findViewById(R.id.compAddrText1);
        compAddr1.setText("Company Address: "+person.getCompanyAddr());
        TextView compAddr2 = (TextView) getActivity().findViewById(R.id.compAddrText2);
        compAddr2.setText("Company Address: "+person.getCompanyAddr1());
        TextView pos1 = (TextView) getActivity().findViewById(R.id.posText1);
        pos1.setText("Position: "+person.getPos());
        TextView pos2 = (TextView) getActivity().findViewById(R.id.posText2);
        pos2.setText("Position: "+person.getPos1());
        TextView resp1 = (TextView) getActivity().findViewById(R.id.respText1);
        resp1.setText("Responsibilities: "+person.getResp());
        TextView resp2 = (TextView) getActivity().findViewById(R.id.respText2);
        resp2.setText("Responsibilities: "+person.getResp1());
        TextView to1 = (TextView) getActivity().findViewById(R.id.toText1);
        to1.setText("End Year: "+person.getTo4());
        TextView to2 = (TextView) getActivity().findViewById(R.id.toText2);
        to2.setText("End Year: "+person.getTo5());
        TextView from1 = (TextView) getActivity().findViewById(R.id.fromText1);
        from1.setText("Start Year: "+person.getFrom4());
        TextView from2 = (TextView) getActivity().findViewById(R.id.fromText2);
        from2.setText("Start Year: "+person.getFrom5());
    }
}
