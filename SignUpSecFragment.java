package com.example.shwetashahane.finalproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by shwetashahane on 5/12/17.
 */

public class SignUpSecFragment extends Fragment {

    Fragment finalFrag;
    FragmentTransaction fragTransaction;
    EditText univNameText1,gpaText1,skillsText,projText,projNameText,projDescText,techText,orgNameText1;
    Spinner degSpinner1, deptSpinner1 , toSpinner1 , fromSpinner1 ,fromSpinner2,toSpinner2;
    String degree1,dept1,univName1,gpa1,to1,from1,skills,projName1,projDesc1,tech1,orgName1,to2,from2;
    String name,address,phone,email,degree,dept,univName,gpa,to,from,sum,password;
    TextView projLink;

    public SignUpSecFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.next_page_layout, container, false);
        degSpinner1=(Spinner)rootView.findViewById(R.id.deg1Spinner);
        degSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                degree1=degSpinner1.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        deptSpinner1=(Spinner)rootView.findViewById(R.id.dept1Spinner);
        deptSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dept1=deptSpinner1.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        univNameText1=(EditText)rootView.findViewById(R.id.univName1Text);
        univNameText1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    univName1=univNameText1.getText().toString();
                }
            }});
        gpaText1=(EditText)rootView.findViewById(R.id.gpa1Text);
        gpaText1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    gpa1=gpaText1.getText().toString();

                }
            }});

        toSpinner1=(Spinner)rootView.findViewById(R.id.to1Spinner);
        toSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                to1=toSpinner1.getSelectedItem().toString();
                gpaText1.clearFocus();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        fromSpinner1=(Spinner)rootView.findViewById(R.id.from1Spinner);
        fromSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                from1=fromSpinner1.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        skillsText=(EditText)rootView.findViewById(R.id.skillsText);
        skillsText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    skills=skillsText.getText().toString();

                }
            }});
        projText=(EditText)rootView.findViewById(R.id.projNameText);
        projText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    projName1=projText.getText().toString();

                }
            }});
        projDescText=(EditText)rootView.findViewById(R.id.projDescText);
        projDescText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    projDesc1=projDescText.getText().toString();

                }
            }});
        techText=(EditText)rootView.findViewById(R.id.techText);
        techText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    tech1=techText.getText().toString();

                }
            }});
        orgNameText1=(EditText)rootView.findViewById(R.id.orgName1Text);
        orgNameText1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    orgName1=orgNameText1.getText().toString();

                }
            }});

        toSpinner2=(Spinner)rootView.findViewById(R.id.to2Spinner);
        toSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                to2=toSpinner2.getSelectedItem().toString();
                orgNameText1.clearFocus();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        fromSpinner2=(Spinner)rootView.findViewById(R.id.from2Spinner);
        fromSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                from2=fromSpinner2.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Bundle bundle = getArguments();
        name = bundle.getString("name");
        address = bundle.getString("address");
        phone = bundle.getString("phone");
        email = bundle.getString("email");
        password = bundle.getString("password");
        degree = bundle.getString("degree");
        dept = bundle.getString("dept");
        univName = bundle.getString("univName");
        gpa = bundle.getString("gpa");
        to = bundle.getString("to");
        from = bundle.getString("from");
        sum=bundle.getString("summary");
        System.out.println("email n password in SignUpSecFrag "+email+" "+password);

        projLink=(TextView)rootView.findViewById(R.id.projLink);
        projLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("name", name);
                bundle.putString("address", address);
                bundle.putString("phone", phone);
                bundle.putString("email", email);
                bundle.putString("password", password);
                bundle.putString("degree", degree);
                bundle.putString("dept", dept);
                bundle.putString("univName", univName);
                bundle.putString("gpa", gpa);
                bundle.putString("to", to);
                bundle.putString("from", from);
                bundle.putString("summary",sum);
                bundle.putString("deg1", degree1);
                bundle.putString("dept1", dept1);
                bundle.putString("univName1", univName1);
                bundle.putString("gpa1", gpa1);
                bundle.putString("to1", to1);
                bundle.putString("from1", from1);
                bundle.putString("skills", skills);
                bundle.putString("projName1", projName1);
                bundle.putString("projDesc1", projDesc1);
                bundle.putString("tech1", tech1);
                bundle.putString("orgName1", orgName1);
                bundle.putString("to2",to2);
                bundle.putString("from2",from2);
                finalFrag = new SignUpThirdFragment();
                finalFrag.setArguments(bundle);
                fragTransaction = getFragmentManager().beginTransaction();
                fragTransaction.hide(getFragmentManager().findFragmentByTag("SignUpSecFragment"));
                fragTransaction.add(R.id.activity_main_signup, finalFrag, "SignUpThirdFragment");
                fragTransaction.addToBackStack("SignUpThirdFragment");
                fragTransaction.commit();
            }
        });
        return rootView;
    }
}
