package com.example.responsive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationActivity extends AppCompatActivity {

    private TextInputLayout userName, userPassword, userEmail, userAge;
    private Button regButton;
    private TextView userLogin;
    private FirebaseAuth firebaseAuth;
    private ImageView registerLogo;
    private RadioButton rbMale, rbFemale, rbOther;
    private RadioGroup radioGroup;
    String name, age, email, password, gender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        getSupportActionBar().setTitle("Registration");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        setupUIViews();


        firebaseAuth = FirebaseAuth.getInstance();

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()){
                    //upload data to database

                    String user_email = userEmail.getEditText().getText().toString().trim();
                    String user_password = userPassword.getEditText().getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()){
                                sendEmailVerification();
                                sendUserData();
                            }else{
                                Toast.makeText(RegistrationActivity.this, "Registration Failed!", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
            }
        });

        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrationActivity.this, LoginForm.class));
            }
        });
    }



    private void setupUIViews(){
        userName = (TextInputLayout) findViewById(R.id.etUserName);
        userPassword = (TextInputLayout)findViewById(R.id.etUserPassword);
        userEmail = (TextInputLayout)findViewById(R.id.etUserEmail);
        userAge = (TextInputLayout)findViewById(R.id.etAge);
        regButton = (Button)findViewById(R.id.btnRegister);
        userLogin = (TextView)findViewById(R.id.tvUserLogin);
        registerLogo = (ImageView)findViewById(R.id.regLogo);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        rbMale = (RadioButton)findViewById(R.id.btn_male);
        rbFemale = (RadioButton)findViewById(R.id.btn_female);
        rbOther = (RadioButton)findViewById(R.id.btn_other);

    }



    /** Validating the data of the User if he already put all the details in the Registration Form**/

    private Boolean validate(){
         Boolean result = false;

        name = userName.getEditText().getText().toString();
        password = userPassword.getEditText().getText().toString();
        email = userEmail.getEditText().getText().toString();
        age = userAge.getEditText().getText().toString();
        int checkedId = radioGroup.getCheckedRadioButtonId();


        if(name.isEmpty() || password.isEmpty() || email.isEmpty() || age.isEmpty() || checkedId == -1){
            userName.setError("Field can't be empty");
            userPassword.setError("Field can't be empty");
            userEmail.setError("Field can't be empty");
            userAge.setError("Field can't be empty");
            Toast.makeText(this, "Please enter all the details", Toast.LENGTH_SHORT).show();

        }else{
            userName.setError(null);
            userName.setErrorEnabled(true);
            userEmail.setError(null);
            userEmail.setErrorEnabled(true);
            userPassword.setError(null);
            userPassword.setErrorEnabled(true);
            userAge.setError(null);
            userAge.setErrorEnabled(true);
            findRadioButton(checkedId);
            result = true;
        }
        return result;
    }


    /** When the User register it will send Email Verification to Android Firebase**/

    private void sendEmailVerification(){
        final FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser !=null) {
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()) {
                        sendUserData();
                        Toast.makeText(RegistrationActivity.this, "Successfully Registered, Verification email sent!", Toast.LENGTH_SHORT).show();
                        firebaseAuth.signOut();
                        finish();
                        startActivity(new Intent(RegistrationActivity.this, LoginForm.class));
                    }else{
                        Toast.makeText(RegistrationActivity.this, "Verification mail has'nt been sent!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }


    /** Getting the UserData in Registration Activity then sends it to Android Realtime Database**/

    private void sendUserData(){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference(firebaseAuth.getUid());
        UserProfile userProfile = new UserProfile(name, age, email, password, gender);
        myRef.setValue(userProfile);
    }

    private void findRadioButton(int checkedId) {
        switch (checkedId){
            case R.id.btn_male:
                //If the user pressed the male
                gender = "Male";
                break;
            case R.id.btn_female:
                //If the user pressed the female
                gender = "Female";
                break;
            case R.id.btn_other:
                //If the user pressed the other
                gender = "Other";
                break;
        }
    }


}
