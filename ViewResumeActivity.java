package com.example.shwetashahane.finalproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.icu.text.RelativeDateTimeFormatter;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPatternPainter;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import static com.itextpdf.text.html.HtmlTags.FONT;

/**
 * Created by shwetashahane on 5/8/17.
 */

public class ViewResumeActivity extends AppCompatActivity {

    HashMap<String, Object> map1 = new HashMap<>();
    String profImage;
    FirebaseAuth auth;
    FirebaseUser currentUser;
    DatabaseReference rootRef;
    String address, company,company1,companyAddr,companyAddr1,degree,degree1;
    String dept , dept1 , email , from , from1 ,from2 ,from3 ,from4 ,from5,to,to1,to2,to3,to4,to5;
    String gpa,gpa1,name,org1,org2,password,phone,pos,pos1,profileImage,proj1,proj2,projDesc1,projDesc2;
    String pubDesc,pubLink,pubName,resp,resp1,skills,summary,tech1,tech2,univName,univName1;
    String name12,position,email1;
    TextView emailResume,nameResume,positionResume;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);
        emailResume=(TextView)this.findViewById(R.id.emailTextResume);
        nameResume=(TextView)this.findViewById(R.id.nameTextResume);
        positionResume=(TextView)this.findViewById(R.id.posTextResume);
        auth=FirebaseAuth.getInstance();
        currentUser=auth.getCurrentUser();
        System.out.println("currentUser:"+currentUser.getEmail());
        rootRef = FirebaseDatabase.getInstance().getReference();
        rootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    map1 = (HashMap<String, Object>) postSnapshot.getValue();
                    if(map1.get("email").equals(currentUser.getEmail())) {
                        profImage=(String)map1.get("profileImage");
                        name12=(String)map1.get("name");
                        email1=(String)map1.get("email");
                        position=(String)map1.get("pos");
                        nameResume.setText(name12.toUpperCase());
                        emailResume.setText(email1);
                        positionResume.setText(position.toUpperCase());
                        try {
                            File f = new File("/data/user/0/com.example.shwetashahane.finalproject/app_imageDir", profImage);
                            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
                            ImageView img = (ImageView) findViewById(R.id.profile_image);
                            img.setImageBitmap(b);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                    else
                        System.out.println("no image");

                }
            }

            @Override
            public void onCancelled(DatabaseError firebaseError) {
            }
        });

        TextView logout=(TextView)this.findViewById(R.id.logOutText);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewResumeActivity.this, LoginActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        ImageButton createPDF=(ImageButton)this.findViewById(R.id.createPDFButton);
        createPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    rootRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                map1 = (HashMap<String, Object>) postSnapshot.getValue();
                                if(map1.get("email").equals(currentUser.getEmail())) {
                                    try {
                                        address=(String)map1.get("address");
                                        company=(String)map1.get("company");company1=(String)map1.get("company1");
                                        companyAddr=(String)map1.get("companyAddr");companyAddr1=(String)map1.get("companyAddr1");
                                        degree=(String)map1.get("degree");degree1=(String)map1.get("degree1");
                                        dept=(String)map1.get("dept");dept1=(String)map1.get("dept1");
                                        email=(String)map1.get("email");from=(String)map1.get("from");
                                        from1=(String)map1.get("from1");from2=(String)map1.get("from3");
                                        from3=(String)map1.get("from3");from4=(String)map1.get("from4");
                                        from5=(String)map1.get("from5");gpa=(String)map1.get("gpa");
                                        gpa1=(String)map1.get("gpa1");name=(String)map1.get("name");
                                        org1=(String)map1.get("org1");org2=(String)map1.get("org2");
                                        password=(String)map1.get("password");phone=(String)map1.get("phone");
                                        pos=(String)map1.get("pos");pos1=(String)map1.get("pos1");
                                        profileImage=(String)map1.get("profileImage");proj1=(String)map1.get("proj1");
                                        proj2=(String)map1.get("proj2");projDesc1=(String)map1.get("projDesc1");
                                        projDesc2=(String)map1.get("projDesc2");pubDesc=(String)map1.get("pubDesc");
                                        pubLink=(String)map1.get("pubLink");pubName=(String)map1.get("pubName");
                                        resp=(String)map1.get("resp");resp1=(String)map1.get("resp1");
                                        skills=(String)map1.get("skills");summary=(String)map1.get("summary");
                                        tech1=(String)map1.get("tech1");tech2=(String)map1.get("tech2");
                                        to=(String)map1.get("to");to1=(String)map1.get("to1");
                                        to2=(String)map1.get("to2");to3=(String)map1.get("to3");
                                        to4=(String)map1.get("to4");to5=(String)map1.get("to5");
                                        univName=(String)map1.get("univName");univName1=(String)map1.get("univName1");
                                        //write to Person class
                                        Person p=new Person();
                                        p.setAddress(address);
                                        p.setCompany(company);p.setCompany1(company1);
                                        p.setCompanyAddr(companyAddr);p.setCompanyAddr1(companyAddr1);
                                        p.setDegree(degree);p.setDegree1(degree1);
                                        p.setDept(dept);p.setDept1(dept1);
                                        p.setEmail(email);p.setFrom(from);
                                        p.setFrom1(from1);p.setFrom2(from3);
                                        p.setFrom3(from3);p.setFrom4(from4);
                                        p.setFrom5(from5);p.setGpa(gpa);
                                        p.setGpa1(gpa1);p.setName(name);
                                        p.setOrg1(org1);p.setOrg2(org2);
                                        p.setPassword(password);p.setPhone(phone);
                                        p.setPos(pos);p.setPos1(pos1);
                                        p.setProfileImage(profileImage);p.setProj1(proj1);
                                        p.setProj2(proj2);p.setProjDesc1(projDesc1);
                                        p.setProjDesc2(projDesc2);p.setPubDesc(pubDesc);
                                        p.setPubLink(pubLink);p.setPubName(pubName);
                                        p.setResp(resp);p.setResp1(resp1);
                                        p.setSkills(skills);p.setSummary(summary);
                                        p.setTech1(tech1);p.setTech2(tech2);
                                        p.setTo(to);p.setTo1(to1);
                                        p.setTo2(to2);p.setTo3(to3);
                                        p.setTo4(to4);p.setTo5(to5);
                                        p.setUnivName(univName);p.setUnivName1(univName1);
                                        createPdf(p);
                                    } catch (FileNotFoundException e) {
                                        e.printStackTrace();
                                    } catch (DocumentException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError firebaseError) {
                        }
                    });
            }
        });

        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().add(R.id.menu,new MenuFragment()).commit();
        }



    }

    private void createPdf(Person person) throws FileNotFoundException, DocumentException {

        File pdfFolder = new File("/sdcard/Android/data/com.example.shwetashahane.finalproject/", "ResumeDir");
        if (!pdfFolder.exists()) {
            pdfFolder.mkdir();
           System.out.println( "Pdf Directory created");
        }

        //Create time stamp
        Date date = new Date() ;
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(date);

        File myFile = new File("/sdcard/Android/data/com.example.shwetashahane.finalproject/ResumeDir","Resume_" + timeStamp + ".pdf");

        OutputStream output = new FileOutputStream(myFile);

        //Step 1
        Document document = new Document();

        //Step 2
        PdfWriter.getInstance(document, output);

        //Step 3
        document.open();
        addContets(document,person,myFile);
        System.out.println("name in pdf:"+person.getName());

        //Step 5: Close the document
        document.close();


    }

    public void addContets(Document document,Person p,File myFile) throws DocumentException {
        Font catFont = new Font(Font.FontFamily.COURIER, 18, Font.BOLD);
        Font titleFont = new Font(Font.FontFamily.COURIER, 22, Font.BOLD, BaseColor.BLUE);
        Font subHeadFont = new Font(Font.FontFamily.COURIER, 18, Font.BOLD|Font.UNDERLINE);
        Font eduFont = new Font(Font.FontFamily.COURIER, 18, Font.BOLD);
        Font projFont = new Font(Font.FontFamily.COURIER, 18);
        Font contentFont = new Font(Font.FontFamily.COURIER, 18);
        Font linkFont = new Font(Font.FontFamily.COURIER, 18, Font.UNDERLINE);
        Paragraph prHead = new Paragraph();
        prHead.setFont(titleFont);
        prHead.add(p.getName().toUpperCase());
        prHead.setAlignment(Element.ALIGN_CENTER);
        document.add(prHead);
        Paragraph prPersonalInfo = new Paragraph();
        prPersonalInfo.setFont(catFont);
        prPersonalInfo.add("\n");
        prPersonalInfo.add(p.getAddress()+"| "+p.getPhone()+"| "+p.getEmail());
        prPersonalInfo.add("\n");
        prPersonalInfo.setAlignment(Element.ALIGN_CENTER);
        document.add(prPersonalInfo);
        Paragraph prHeadEdu = new Paragraph();
        prHeadEdu.setFont(subHeadFont);
        //education
        prHeadEdu.add("\n");
        prHeadEdu.add("EDUCATION");
        document.add(prHeadEdu);

        Chunk glue = new Chunk(new VerticalPositionMark());
        Paragraph ph = new Paragraph();
        ph.setFont(eduFont);
        ph.add("\n");
        ph.add(p.getDegree()+": "+p.getDept()+","+p.getUnivName()+","+p.getGpa());
        ph.add(glue);
        ph.add(p.getFrom()+"-"+p.getTo());ph.add("\n");
        document.add(ph);
        Paragraph ph2 = new Paragraph();
        ph2.setFont(eduFont);
        ph2.add(p.getDegree1()+": "+p.getDept1()+","+p.getUnivName1()+","+p.getGpa1());
        ph2.add(glue);
        ph2.add(p.getFrom1()+"-"+p.getTo1());ph.add("\n");
        document.add(ph2);

        prHeadEdu.clear();
        prHeadEdu.add("\n");

        //tech skills

        prHeadEdu.add("TECHNICAL SKILLS");
        document.add(prHeadEdu);
        Paragraph prTECH = new Paragraph();
        prTECH.setFont(contentFont);
        prTECH.add("\n");
        prTECH.add("Programming Skills: "+p.getSkills());
        document.add(prTECH);
        prHeadEdu.clear();
        prHeadEdu.add("\n");

        //academic proj

        prHeadEdu.add("ACADEMIC PROJECTS");
        document.add(prHeadEdu);

        Chunk glue1 = new Chunk(new VerticalPositionMark());
        Paragraph ph3 = new Paragraph();
        ph3.setFont(projFont);
        ph3.add("\n");
        ph3.add(p.getProj1());
        ph3.add(glue1);
        ph3.add(p.getFrom2()+"-"+p.getTo2());
        ph3.add("\n");
        ph3.add(p.getProjDesc1());
        ph3.add("\n");
        ph3.add(p.getTech1());
        ph3.add("\n");

        document.add(ph3);

        Paragraph ph4 = new Paragraph();
        ph4.setFont(projFont);
        ph4.add("\n");
        ph4.add(p.getProj1());
        ph4.add(glue1);
        ph4.add(p.getFrom2()+"-"+p.getTo2());
        ph4.add("\n");
        ph4.add(p.getProjDesc1());
        ph4.add("\n");
        ph4.add(p.getTech1());
        ph4.add("\n");

        document.add(ph4);

        prHeadEdu.clear();
        prHeadEdu.add("\n");

        //exp

        prHeadEdu.add("EXPERIENCE");
        document.add(prHeadEdu);

        Chunk glue2 = new Chunk(new VerticalPositionMark());
        Paragraph ph5 = new Paragraph();
        ph5.setFont(projFont);
        ph5.add("\n");
        ph5.add(p.getCompany()+","+p.getCompanyAddr());
        ph5.add(glue2);
        ph5.add(p.getFrom4()+"-"+p.getTo4());
        ph5.add("\n");
        ph5.add(p.getPos());
        ph5.add("\n");
        ph5.add(p.getResp());
        ph5.add("\n");
        document.add(ph5);

        Paragraph ph6 = new Paragraph();
        ph6.setFont(projFont);
        ph6.add("\n");
        ph6.add(p.getCompany1()+","+p.getCompanyAddr1());
        ph6.add(glue2);
        ph6.add(p.getFrom5()+"-"+p.getTo5());
        ph6.add("\n");
        ph6.add(p.getPos1());
        ph6.add("\n");
        ph6.add(p.getResp1());
        ph6.add("\n");
        document.add(ph6);




        prHeadEdu.clear();
        prHeadEdu.add("\n");

        //publications
        prHeadEdu.add("PUBLICATIONS");
        document.add(prHeadEdu);
        Paragraph prPub = new Paragraph();
        prPub.setFont(linkFont);
        prPub.add("\n");
        prPub.add(p.getPubLink());
        prPub.add("\n");
        document.add(prPub);

        //attatch file as an attachment

        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_SUBJECT,"Resume");
        email.putExtra(Intent.EXTRA_TEXT, "Hello, \n PFA Resume");
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        Uri uri = Uri.fromFile(myFile);
        System.out.print("path of pdf file "+myFile.getAbsolutePath());
        email.putExtra(Intent.EXTRA_STREAM, uri);
        email.setType("message/rfc822");
        startActivity(email);
    }


}
