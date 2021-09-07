package com.tr.imsagesendingtofirestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;


public class Task5Step1SignUpUsingFirebase extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseAuth auth;

    TextView PhoneNo;
   EditText userID,NickName;
   Button SignUp,LOGIN_TAsk5_Step1;

    String userIDConv;

    String nickNameConv;
    String PhoneConv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task5_step1_sign_up_using_firebase);

        LOGIN_TAsk5_Step1=findViewById(R.id.LOGIN_Task5_FOR_STEP1);
        userID = (EditText) findViewById(R.id.UserID);
        NickName = (EditText) findViewById(R.id.NickName);
        PhoneNo = (TextView) findViewById(R.id.PhoneNo);
        SignUp = (Button) findViewById(R.id.Signup);
        auth = FirebaseAuth.getInstance();

      String ConvPhoneAuth=  PhoneAuthentication.editTextMobile.getText().toString();

//        Intent  intent1=getIntent();
//        String ph_No = intent1.getStringExtra("mobile");
//        PhoneNo.setText(ph_No);

        PhoneNo.setText(ConvPhoneAuth);


//        String uID=   intent1.getStringExtra("userid");
//        userID.setText(uID);
//
//        String nk_NM =   intent1.getStringExtra("nickname");
//        NickName.setText(nk_NM);






       SignUp.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {



               userIDConv= userID.getText().toString();
               nickNameConv= NickName.getText().toString();
               PhoneConv=PhoneNo.getText().toString();





               CollectionReference SignupDetails = db.collection("ID_NK");
               UserModel userModel = new UserModel(userIDConv,nickNameConv,PhoneConv);



               SignupDetails.add(userModel).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                   @Override
                   public void onSuccess(DocumentReference documentReference) {
                       Toast.makeText(Task5Step1SignUpUsingFirebase.this, "Data Stored Sucess", Toast.LENGTH_SHORT).show();

//database main value gira na k lia
                       userModel.setUserID(userIDConv);
                       userModel.setNickname(nickNameConv);
                       userModel.setPhone(PhoneConv);





//                       UserModel userModel = new UserModel(userIDConv,nickNameConv);


                       Intent sendDataToTask4SendBird = new Intent(Task5Step1SignUpUsingFirebase.this,Task4SendBird.class);
//intent testing if data goes in database or not while using put extra
                       sendDataToTask4SendBird.putExtra("userid",userIDConv);
                       sendDataToTask4SendBird.putExtra("nickname",nickNameConv);
                       sendDataToTask4SendBird.putExtra("phoneNo",PhoneConv);

                       startActivity(sendDataToTask4SendBird);


                   }
               }).addOnFailureListener(new OnFailureListener() {
                   @Override
                   public void onFailure(@NonNull Exception e) {

                       Toast.makeText(Task5Step1SignUpUsingFirebase.this, "Data Stored Un Sucessfull", Toast.LENGTH_SHORT).show();

                   }
               });





           }
       });


        LOGIN_TAsk5_Step1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToTask4SendBird = new Intent(Task5Step1SignUpUsingFirebase.this,Task4SendBird.class);
                startActivity(goToTask4SendBird);
            }
        });



    }
}