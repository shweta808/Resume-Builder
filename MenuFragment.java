package com.example.shwetashahane.finalproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by shwetashahane on 5/11/17.
 */

public class MenuFragment extends Fragment {

    Fragment frag;
    FragmentTransaction fragTransaction;
    FirebaseAuth auth;
    FirebaseUser currentUser;
    public MenuFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_menu,container, false);
        auth= FirebaseAuth.getInstance();
        currentUser=auth.getCurrentUser();
        System.out.println("currentUser:"+currentUser.getEmail());
        frag=new ProfileFragment();
        Bundle bundle=new Bundle();
        bundle.putString("current_usermail",currentUser.getEmail());
        frag.setArguments(bundle);
        fragTransaction=getFragmentManager().beginTransaction().add(R.id.container,frag);
        fragTransaction.commit();
        Button profileButton=(Button)rootView.findViewById(R.id.profileButton);
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frag=new ProfileFragment();
                Bundle bundle=new Bundle();
                bundle.putString("current_usermail",currentUser.getEmail());
                frag.setArguments(bundle);
                fragTransaction=getFragmentManager().beginTransaction().replace(R.id.container,frag);
                fragTransaction.commit();
            }
        });
        Button projButton=(Button)rootView.findViewById(R.id.projButton);
        projButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frag=new ProjectFragment();
                Bundle bundle=new Bundle();
                bundle.putString("current_usermail",currentUser.getEmail());
                frag.setArguments(bundle);
                fragTransaction=getFragmentManager().beginTransaction().replace(R.id.container,frag);
                fragTransaction.commit();
            }
        });
        Button expButton=(Button)rootView.findViewById(R.id.expButton);
        expButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frag=new ExperienceFragment();
                Bundle bundle=new Bundle();
                bundle.putString("current_usermail",currentUser.getEmail());
                frag.setArguments(bundle);
                fragTransaction=getFragmentManager().beginTransaction().replace(R.id.container,frag);
                fragTransaction.commit();
            }
        });
        Button eduButton=(Button)rootView.findViewById(R.id.eduButton);
        eduButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frag=new EducationFragment();
                Bundle bundle=new Bundle();
                bundle.putString("current_usermail",currentUser.getEmail());
                frag.setArguments(bundle);
                fragTransaction=getFragmentManager().beginTransaction().replace(R.id.container,frag);
                fragTransaction.commit();
            }
        });
        return rootView;

    }
}
