package com.example.myloginandsignupwitrecyviewandlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myloginandsignupwitrecyviewandlistview.SqlDatatbase.Model;
import com.example.myloginandsignupwitrecyviewandlistview.SqlDatatbase.SqlDatabase1;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    Button btnlogin,btnSignUp;
    Model model;
    SqlDatabase1 db;
    EditText edtName,edtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnlogin=(Button)findViewById(R.id.btnlogin);
        btnSignUp=(Button)findViewById(R.id.btnSignUp);
        edtName=findViewById(R.id.etname);
        edtPassword=findViewById(R.id.etpassword);


        db=new SqlDatabase1(getApplicationContext());

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(intent);

            }
        });


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=edtName.getText().toString();
                String password=edtPassword.getText().toString();


                if (name.isEmpty() && password.isEmpty()  ) {
                    Toast.makeText(LoginActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                List<Model> contacts = db.getAllContacts();

                for (Model cn : contacts) {
                    String log = "Id: " + cn.get_id() + " ,Name: " + cn.getName() + " ,Phone: " +
                            cn.getNumber()+ " ,Password: " + cn.getPasword();
                    // Writing Contacts to log
                    Log.d("aaa", log);

                }

                if (db.checkUser(name, password)) {
                    Intent intent =new Intent(LoginActivity.this,Maindata.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Login Successfull", Toast.LENGTH_LONG).show();


                } else {
                    Toast.makeText(getApplicationContext(), "Wrong Username or Password", Toast.LENGTH_LONG).show();
                }




            }
        });


    }


}