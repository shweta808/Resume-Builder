package com.example.shwetashahane.finalproject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

import static android.app.Activity.RESULT_OK;

/**
 * Created by shwetashahane on 5/10/17.
 */

public class FinalSignUpActivity extends Fragment {

    String name,address,phone,email,password,degree,dept,univName,gpa,to,from,sum;
    String degree1,dept1,univName1,gpa1,to1,from1,skills,projName1,projDesc1,tech1,orgName1,to2,from2;
    String projName2,projDesc2,tech2,orgName2,to3,from3,company,companyAddr,pos,resp,to4,from4;
    String company2,companyAddr2,pos2,resp2,to5,from5,pubName,pubDesc,pubLink,key;
    EditText companyText2,compAddrText2,posText2,respText2,pubNameText,pubDescText,pubLinkText;
    Spinner fromSpinner5,toSpinner5;
    FirebaseAuth auth;
    static final int RESULT_LOAD_IMAGE = 1;
    Button createUser,selectImage;
    Person p=new Person();

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.next3_page_layout, container, false);
        auth=FirebaseAuth.getInstance();
        companyText2=(EditText)rootView.findViewById(R.id.company1Text);
        companyText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    company2=companyText2.getText().toString();

                }
            }});
        compAddrText2=(EditText)rootView.findViewById(R.id.compAddr1Text);
        compAddrText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    companyAddr2=compAddrText2.getText().toString();

                }
            }});
        posText2=(EditText)rootView.findViewById(R.id.pos1Text);
        posText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    pos2=posText2.getText().toString();

                }
            }});
        respText2=(EditText)rootView.findViewById(R.id.resp1Text);
        respText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    resp2=respText2.getText().toString();

                }
            }});

        toSpinner5=(Spinner)rootView.findViewById(R.id.to5Spinner);
        toSpinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                to5=toSpinner5.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        fromSpinner5=(Spinner)rootView.findViewById(R.id.from5Spinner);
        fromSpinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                from5=fromSpinner5.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        pubNameText=(EditText)rootView.findViewById(R.id.pubNameText);
        pubNameText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    pubName=pubNameText.getText().toString();

                }
            }});
        pubDescText=(EditText)rootView.findViewById(R.id.descText);
        pubDescText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    pubDesc=pubDescText.getText().toString();

                }
            }});

        pubLinkText=(EditText)rootView.findViewById(R.id.pubLink);
        pubLinkText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    pubLink=pubLinkText.getText().toString();

                }
            }});

        Bundle bundle=getArguments();
        name = bundle.getString("name");
        System.out.println("name in FinalSignUpActivity "+name);
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
        projName2=bundle.getString("projName2");
        projDesc2=bundle.getString("projDesc2");
        tech2=bundle.getString("tech2");
        orgName2=bundle.getString("orgName2");
        to3=bundle.getString("to3");
        from3=bundle.getString("from3");
        company=bundle.getString("companyName");
        companyAddr=bundle.getString("companyAddr");
        pos=bundle.getString("pos");
        resp=bundle.getString("resp");
        to4=bundle.getString("to4");
        from4=bundle.getString("from4");

        System.out.println("email n password in FinalSignUpActivity "+email+" "+password);

        createUser=(Button)rootView.findViewById(R.id.createUserButton);
        createUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pubLinkText.clearFocus();
                FirebaseDatabase.getInstance().setLogLevel(Logger.Level.DEBUG);
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(Task<AuthResult> task) {
                                if (!task.isSuccessful()) {
                                    System.out.println( "Authentication failed.");
                                }
                                else{
                                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                                    DatabaseReference reference = database.getReference();
                                    p.setDegree1(degree1);
                                    p.setDept1(dept1);
                                    p.setFrom1(from1);
                                    p.setTo1(to1);
                                    p.setUnivName1(univName1);
                                    p.setGpa1(gpa1);
                                    p.setSkills(skills);
                                    p.setProj1(projName1);
                                    p.setProjDesc1(projDesc1);
                                    p.setOrg1(orgName1);
                                    p.setOrg2(orgName2);
                                    p.setTech1(tech1);
                                    p.setTech2(tech2);
                                    p.setTo2(to2);
                                    p.setFrom2(from2);
                                    p.setCompany(company);
                                    p.setCompany1(company2);
                                    p.setCompanyAddr(companyAddr);
                                    p.setCompanyAddr1(companyAddr2);
                                    p.setPos(pos);
                                    p.setPos1(pos2);
                                    p.setResp(resp);
                                    p.setResp1(resp2);
                                    p.setTo3(to3);
                                    p.setFrom3(from3);
                                    p.setTo4(to4);
                                    p.setFrom4(from4);
                                    p.setProj2(projName2);
                                    p.setProjDesc2(projDesc2);
                                    p.setTo5(to5);
                                    p.setFrom5(from5);
                                    p.setName(name);
                                    p.setAddress(address);
                                    p.setPhone(phone);
                                    p.setEmail(email);
                                    p.setPassword(password);
                                    p.setDegree(degree);
                                    p.setDept(dept);
                                    p.setUnivName(univName);
                                    p.setGpa(gpa);
                                    p.setTo(to);
                                    p.setFrom(from);
                                    p.setSummary(sum);
                                    p.setPubName(pubName);
                                    p.setPubDesc(pubDesc);
                                    p.setPubLink(pubLink);
                                    key = reference.push().getKey();
                                    p.setId(key);
                                    String parts[]=p.getEmail().split("@");
                                    p.setProfileImage("profile_"+parts[0]+".jpg");
                                    reference.child(key).setValue(p);
                                    System.out.println( "Registration Successful");
                                    Toast.makeText(getActivity(), "Registration Successful",Toast.LENGTH_LONG).show();
                                    Intent myIntent = new Intent(getActivity(), ViewResumeActivity.class);
                                    getActivity().startActivity(myIntent);
                                }
                            }
                        });

            }});
        selectImage=(Button)rootView.findViewById(R.id.selectImageButton);
        selectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent,RESULT_LOAD_IMAGE);
            }
        });
        return rootView;
    }

    public void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);


        if (resultCode == RESULT_OK && reqCode == RESULT_LOAD_IMAGE) {
            try {
                final Uri imageUri = data.getData();
                final InputStream imageStream = getActivity().getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                String url=saveToInternalStorage(selectedImage);
                System.out.println("where it got saved "+url);
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_LONG).show();
            }

        }else {
            Toast.makeText(getActivity(), "You haven't picked Image",Toast.LENGTH_LONG).show();
        }
    }

    private String saveToInternalStorage(Bitmap bitmapImage){
        ContextWrapper cw = new ContextWrapper(getActivity());
        // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        // Create imageDir
        System.out.println("key in saving photo :"+email);
        String emails[]=email.split("@");
        File mypath=new File(directory,"profile_"+emails[0]+".jpg");
        System.out.println("real path "+mypath.getPath());
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String path=directory.getPath()+"/profile_"+emails[0]+".jpg";
        return path;
    }

}
