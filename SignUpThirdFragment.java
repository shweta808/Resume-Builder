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

public class SignUpThirdFragment extends Fragment {

    Fragment finalFrag;
    FragmentTransaction fragTransaction;
    EditText projText2,projDescText2,techText2,orgNameText2,companyText,compAddrText,posText,respText;
    Spinner fromSpinner3,toSpinner3,fromSpinner4,toSpinner4;
    String degree1,dept1,univName1,gpa1,to1,from1,skills,projName1,projDesc1,tech1,orgName1,to2,from2;
    String projName2,projDesc2,tech2,orgName2,to3,from3,company,companyAddr,pos,resp,to4,from4;
    String name,address,phone,email,degree,dept,univName,gpa,to,from,sum,password;
    TextView expLink;

    public SignUpThirdFragment(){

    }
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.next_next_page_layout, container, false);
        projText2=(EditText)rootView.findViewById(R.id.proj2NameText);
        projText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    projName2=projText2.getText().toString();

                }
            }});
        projDescText2=(EditText)rootView.findViewById(R.id.projDesc2Text);
        projDescText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    projDesc2=projDescText2.getText().toString();

                }
            }});
        techText2=(EditText)rootView.findViewById(R.id.tech2Text);
        techText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    tech2=techText2.getText().toString();

                }
            }});
        orgNameText2=(EditText)rootView.findViewById(R.id.orgNameText2);
        orgNameText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    orgName2=orgNameText2.getText().toString();

                }
            }});

        toSpinner3=(Spinner)rootView.findViewById(R.id.to3Spinner);
        toSpinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                to3=toSpinner3.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        fromSpinner3=(Spinner)rootView.findViewById(R.id.from3Spinner);
        fromSpinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                from3=fromSpinner3.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        companyText=(EditText)rootView.findViewById(R.id.companyText);
        companyText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    company=companyText.getText().toString();

                }
            }});
        compAddrText=(EditText)rootView.findViewById(R.id.compAddrText);
        compAddrText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    companyAddr=compAddrText.getText().toString();

                }
            }});
        posText=(EditText)rootView.findViewById(R.id.posText);
        posText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    pos=posText.getText().toString();

                }
            }});
        respText=(EditText)rootView.findViewById(R.id.respText);
        respText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    resp=respText.getText().toString();

                }
            }});

        toSpinner4=(Spinner)rootView.findViewById(R.id.to4Spinner);
        toSpinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                to4=toSpinner4.getSelectedItem().toString();
                respText.clearFocus();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        fromSpinner4=(Spinner)rootView.findViewById(R.id.from4Spinner);
        fromSpinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                from4=fromSpinner4.getSelectedItem().toString();
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
        degree1=bundle.getString("deg1");
        dept1=bundle.getString("dept1");
        univName1=bundle.getString("univName1");
        gpa1=bundle.getString("gpa1");
        to1=bundle.getString("to1");
        from1=bundle.getString("from1");
        skills=bundle.getString("skills");
        projName1=bundle.getString("projName1");
        projDesc1=bundle.getString("projDesc1");
        tech1=bundle.getString("tech1");
        orgName1=bundle.getString("orgName1");
        to2=bundle.getString("to2");
        from2=bundle.getString("from2");

        System.out.println("email n password in SignUpThirdFrag "+email+" "+password);

        expLink=(TextView)rootView.findViewById(R.id.expLink);
        expLink.setOnClickListener(new View.OnClickListener() {
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
                bundle.putString("projName2", projName2);
                bundle.putString("projDesc2", projDesc2);
                bundle.putString("tech2", tech2);
                bundle.putString("orgName2", orgName2);
                bundle.putString("to3",to3);
                bundle.putString("from3",from3);
                bundle.putString("companyName",company);
                bundle.putString("companyAddr",companyAddr);
                bundle.putString("pos",pos);
                bundle.putString("resp",resp);
                bundle.putString("to4",to4);
                bundle.putString("from4",from4);
                finalFrag = new FinalSignUpActivity();
                finalFrag.setArguments(bundle);
                fragTransaction = getFragmentManager().beginTransaction();
                fragTransaction.hide(getFragmentManager().findFragmentByTag("SignUpThirdFragment"));
                fragTransaction.add(R.id.activity_main_signup, finalFrag, "FinalSignUpActivity");
                fragTransaction.addToBackStack("FinalSignUpActivity");
                fragTransaction.commit();
            }
        });

        return rootView;
    }
}
