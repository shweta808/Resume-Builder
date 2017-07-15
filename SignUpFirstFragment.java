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
 * Created by shwetashahane on 5/10/17.
 */

public class SignUpFirstFragment extends Fragment {

    Fragment finalFrag;
    FragmentTransaction fragTransaction;
    String name,address,phone,email,profile1,profile2,degree,dept,univName,gpa,to,from,sum,pass;
    EditText nameText , addressText , phoneText , emailidText , pofileText1,pofileText2,univNameText,gpaText,summary,password;
    Spinner degSpinner, deptSpinner , toSpinner , fromSpinner;
    public SignUpFirstFragment(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_sign_up, container, false);
        nameText=(EditText)rootView.findViewById(R.id.nameText);
        nameText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    name=nameText.getText().toString();
                    System.out.println("name:"+name);
                }
            }
        });
        addressText=(EditText)rootView.findViewById(R.id.addressText);
        addressText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    address=addressText.getText().toString();
                    System.out.println(address);
                }
            }
        });

        phoneText=(EditText)rootView.findViewById(R.id.phoneText);
        phoneText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    phone=phoneText.getText().toString();
                    System.out.println(phone);
                }
            }
        });

        emailidText=(EditText)rootView.findViewById(R.id.emailText);
        emailidText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    email=emailidText.getText().toString();
                }
            }
        });

        degSpinner=(Spinner)rootView.findViewById(R.id.degreeSpinner);
        degSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                degree=degSpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        deptSpinner=(Spinner)rootView.findViewById(R.id.deptSpinner);
        deptSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dept=deptSpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        univNameText=(EditText)rootView.findViewById(R.id.univText);
        univNameText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    univName=univNameText.getText().toString();
                }
            }});
        gpaText=(EditText)rootView.findViewById(R.id.gpaText);
        gpaText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    gpa=gpaText.getText().toString();

                }
            }});

        toSpinner=(Spinner)rootView.findViewById(R.id.toSpinnerYear);
        toSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                to=toSpinner.getSelectedItem().toString();
                gpaText.clearFocus();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        fromSpinner=(Spinner)rootView.findViewById(R.id.fromSpinnerYear);
        fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                from=fromSpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        summary=(EditText)rootView.findViewById(R.id.profSummaryText);
        summary.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    sum=summary.getText().toString();

                }
            }});

        password=(EditText)rootView.findViewById(R.id.passwordText);
        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    pass=password.getText().toString();
                    if (password.getText().toString().length() < 6) {
                        password.setError("Password must be atleast 6 characters long!");
                    }
                    else{
                        TextView addEduLink=(TextView)rootView.findViewById(R.id.addEduLink);
                        addEduLink.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                Bundle bundle = new Bundle();
                                bundle.putString("name", name);
                                bundle.putString("address", address);
                                bundle.putString("phone", phone);
                                bundle.putString("email", email);
                                bundle.putString("password", pass);
                                bundle.putString("degree", degree);
                                bundle.putString("dept", dept);
                                bundle.putString("univName", univName);
                                bundle.putString("gpa", gpa);
                                bundle.putString("to", to);
                                bundle.putString("from", from);
                                bundle.putString("summary",sum);
                                finalFrag = new SignUpSecFragment();
                                finalFrag.setArguments(bundle);
                                fragTransaction = getFragmentManager().beginTransaction();
                                fragTransaction.hide(getFragmentManager().findFragmentByTag("SignUpFirstFragment"));
                                fragTransaction.add(R.id.activity_main_signup, finalFrag, "SignUpSecFragment");
                                fragTransaction.addToBackStack("SignUpSecFragment");
                                fragTransaction.commit();
                            }
                        });
                    }
                }
        }});

    return rootView;

}
}
