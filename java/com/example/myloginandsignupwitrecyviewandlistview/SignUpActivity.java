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

public class SignUpActivity extends AppCompatActivity {
    Model model;
    SqlDatabase1 dbHandler;
    EditText edtName,edtPassword,edtNumber;
    Button btnLogn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edtName=findViewById(R.id.etname);
        edtPassword=findViewById(R.id.etpassword);
        edtNumber=findViewById(R.id.etnumber);
        btnLogn=findViewById(R.id.btnlogin);

        dbHandler=new SqlDatabase1(getApplicationContext());

        btnLogn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=edtName.getText().toString();
                String password=edtPassword.getText().toString();
                String number=edtNumber.getText().toString();

                if (name.isEmpty() && password.isEmpty() && number.isEmpty() ) {
                    Toast.makeText(SignUpActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }


                dbHandler.addNewCourse(name,password,number);

                // after adding the data we are displaying a toast message.
                Toast.makeText(SignUpActivity.this, "Course has been added.", Toast.LENGTH_SHORT).show();
                edtName.setText("");
                edtPassword.setText("");
                edtNumber.setText("");


                Intent intent=new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

}