package com.example.responsive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginForm extends AppCompatActivity {

   private TextInputLayout Email, Password;
   private Button Login;
   private TextView Info;
   private int counter = 3;
   private ImageView loginLogo;
   private TextView userRegistration;
   private FirebaseAuth firebaseAuth;
   private ProgressDialog progressDialog;
   private TextView forgotPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);

        Email = (TextInputLayout) findViewById(R.id.loginUserEmail);
        Password = (TextInputLayout) findViewById(R.id.loginUserPassword);
        Login = (Button) findViewById(R.id.btnLogin);
        Info = (TextView) findViewById(R.id.tvInfo);
        loginLogo = (ImageView)findViewById(R.id.loginLogo);
        userRegistration = (TextView)findViewById(R.id.tvRegister);
        forgotPassword = (TextView)findViewById(R.id.tvForgotPassword);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        FirebaseUser user = firebaseAuth.getCurrentUser();

        if(user != null){
            finish();
            startActivity(new Intent(LoginForm.this, MainActivity.class));
        }

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // If user leave the edit text blank, it will put error and tells that the field can not be empty
                if(checkValidation()){

                    validate(Email.getEditText().getText().toString(), Password.getEditText().getText().toString());

                }



            }
        });

        userRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginForm.this,RegistrationActivity.class));
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginForm.this,ForgotPassword.class));
            }
        });
    }


        /** Validating the User if they already verify their email address and showing if their username and password is incorrect**/

        private void validate(String userName, String userPassword) {

        progressDialog.setMessage("Please wait a few seconds");
        progressDialog.show();



        firebaseAuth.signInWithEmailAndPassword(userName,userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressDialog.dismiss();
                    //Toast.makeText(LoginForm.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    checkEmailVerification();
                }else{
                    Toast.makeText(LoginForm.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    counter --;
                    Info.setText("No of attempts remaining: " + counter);
                    Password.setError("Your password is incorrect");
                    progressDialog.dismiss();
                    if(counter == 0){
                        Login.setEnabled(false);
                    }
                }
            }
        });

    }


        /** Checking if the Email Address is already verify or not, Also showing Text to verify their email before logging in**/

         private void checkEmailVerification() {
            FirebaseUser firebaseUser = firebaseAuth.getInstance().getCurrentUser();
            Boolean emailflag = firebaseUser.isEmailVerified();

            if(emailflag){
                finish();
                startActivity(new Intent(LoginForm.this,MainActivity.class));
            }else{
                Toast.makeText(this, "Verify your email", Toast.LENGTH_SHORT).show();
                firebaseAuth.signOut();
            }

         }

         /** Checking if the user put all the details needed in order to log in**/
         private Boolean checkValidation(){
             Boolean result = false;

             String email = Email.getEditText().getText().toString();
             String password = Password.getEditText().getText().toString();

                if(email.isEmpty() || password.isEmpty()){
                    Email.setError("Field can't be empty");
                    Password.setError("Field can't be empty");
                }else{
                    Email.setError(null);
                    Email.setErrorEnabled(true);
                    Password.setError(null);
                    Password.setErrorEnabled(true);
                    result = true;
                }

                return result;

         }




}
