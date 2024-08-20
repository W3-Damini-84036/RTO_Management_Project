//package com.sunbeaminfo.project.activity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.RadioButton;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//import com.google.gson.JsonObject;
//import com.sunbeaminfo.project.R;
//import com.sunbeaminfo.project.entity.User;
//import com.sunbeaminfo.project.utils.RetrofitClient;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class RegisterActivity extends AppCompatActivity {
//
//    EditText editFirstName, editLastName, editEmail, editAadharNumber, editBirth, editAge, editBlood, editPassword, editConfirmPassword, editMobile, editAddress, editPincode, editCity, editDistrict, editState, editCountry;
//    RadioButton radioMale, radioFemale;
//    TextView textLogin;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_register);
//
//        editFirstName = findViewById(R.id.editFirstName);
//        editLastName = findViewById(R.id.editLastName);
//        editEmail = findViewById(R.id.editEmail);
//        editAadharNumber = findViewById(R.id.editAadharNumber);
//        editBirth = findViewById(R.id.editBirth);
//        editAge = findViewById(R.id.editAge);
//        editBlood = findViewById(R.id.editBlood);
//        editPassword = findViewById(R.id.editPassword);
//        editConfirmPassword = findViewById(R.id.editConfirmPassword);
//        editMobile = findViewById(R.id.editMobile);
//        editAddress = findViewById(R.id.editAddress);
//        editPincode = findViewById(R.id.editPincode);
//        editCity = findViewById(R.id.editCity);
//        editDistrict = findViewById(R.id.editDistrict);
//        editState = findViewById(R.id.editState);
//        editCountry = findViewById(R.id.editCountry);
//        radioMale = findViewById(R.id.radioMale);
//        radioFemale = findViewById(R.id.radioFemale);
//
//        textLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
//            }
//        });
//    }
//
//    public void register(View view){
//        String password = editPassword.getText().toString();
//        String confirmPassword = editConfirmPassword.getText().toString();
//
//        if(password.equals(confirmPassword)){
//            User user = new User();
//            user.setFirst_name(editFirstName.getText().toString());
//            user.setLast_name(editLastName.getText().toString());
//            user.setEmail(editEmail.getText().toString());
//            user.setAadhar_number(editAadharNumber.getText().toString());
//            user.setDate_of_birth(editBirth.getText().toString());
//            user.setAge(Integer.parseInt(editAge.getText().toString()));
//            user.setBlood_group(editBlood.getText().toString());
//            user.setPassword(editPassword.getText().toString());
//            user.setFirst_name(editConfirmPassword.getText().toString());
//            user.setMobile_number(editMobile.getText().toString());
//            user.setAddress(editAddress.getText().toString());
//            user.setPincode(editPincode.getText().toString());
//            user.setCity(editCity.getText().toString());
//            user.setDistrict(editDistrict.getText().toString());
//            user.setState(editState.getText().toString());
//            user.setCountry(editCountry.getText().toString());
//
//            String gender;
//            if(radioMale.isChecked())
//                gender="Male";
//            else if(radioFemale.isChecked())
//                gender="Female";
//            else
//                gender="";
//
//            RetrofitClient.getInstance().getApi().registerUser(user).enqueue(new Callback<JsonObject>() {
//                @Override
//                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
//                    Toast.makeText(RegisterActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
//                    finish();
//                }
//                @Override
//                public void onFailure(Call<JsonObject> call, Throwable throwable) {
//                    Toast.makeText(RegisterActivity.this, "Something went wrong while registration", Toast.LENGTH_SHORT).show();
//                }
//            });
//        }
//        else
//            Toast.makeText(this, "Passwords does not match", Toast.LENGTH_SHORT).show();
//
//    }
//
//    public void cancel(View view){
//
//        finish();
//    }
//}
////loginLink.setOnClickListener(new View.OnClickListener() {
////    @Override
////    public void onClick(View v) {
////        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
////        startActivity(intent);
////    }
////});
//
//
//
//
//
//
//
//
package com.sunbeaminfo.project.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonObject;
import com.sunbeaminfo.project.R;
import com.sunbeaminfo.project.entity.User;
import com.sunbeaminfo.project.utils.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    EditText editFirstName, editLastName, editEmail, editAadharNumber, editBirth, editAge, editBlood, editPassword, editConfirmPassword, editMobile, editAddress, editPincode, editCity, editDistrict, editState, editCountry;
    RadioButton radioMale, radioFemale;
    TextView textLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initializing the views
        editFirstName = findViewById(R.id.editFirstName);
        editLastName = findViewById(R.id.editLastName);
        editEmail = findViewById(R.id.editEmail);
        editAadharNumber = findViewById(R.id.editAadharNumber);
        editBirth = findViewById(R.id.editBirth);
        editAge = findViewById(R.id.editAge);
        editBlood = findViewById(R.id.editBlood);
        editPassword = findViewById(R.id.editPassword);
        editConfirmPassword = findViewById(R.id.editConfirmPassword);
        editMobile = findViewById(R.id.editMobile);
        editAddress = findViewById(R.id.editAddress);
        editPincode = findViewById(R.id.editPincode);
        editCity = findViewById(R.id.editCity);
        editDistrict = findViewById(R.id.editDistrict);
        editState = findViewById(R.id.editState);
        editCountry = findViewById(R.id.editCountry);
        radioMale = findViewById(R.id.radioMale);
        radioFemale = findViewById(R.id.radioFemale);
        textLogin = findViewById(R.id.textLogin); // Initialize textLogin

        textLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
    }

    public void register(View view) {
        String password = editPassword.getText().toString();
        String confirmPassword = editConfirmPassword.getText().toString();

        if (password.equals(confirmPassword)) {
            User user = new User();
            user.setFirst_name(editFirstName.getText().toString());
            user.setLast_name(editLastName.getText().toString());
            user.setEmail(editEmail.getText().toString());
            user.setAadhar_number(editAadharNumber.getText().toString());
            user.setDate_of_birth(editBirth.getText().toString());
            user.setAge(Integer.parseInt(editAge.getText().toString()));
            user.setBlood_group(editBlood.getText().toString());
            user.setPassword(editPassword.getText().toString());
            user.setMobile_number(editMobile.getText().toString());
            user.setAddress(editAddress.getText().toString());
            user.setPincode(editPincode.getText().toString());
            user.setCity(editCity.getText().toString());
            user.setDistrict(editDistrict.getText().toString());
            user.setState(editState.getText().toString());
            user.setCountry(editCountry.getText().toString());

            String gender;
            if (radioMale.isChecked())
                gender = "Male";
            else if (radioFemale.isChecked())
                gender = "Female";
            else
                gender = "";

            user.setGender(gender); // Set the gender in the User object

            RetrofitClient.getInstance().getApi().registerUser(user).enqueue(new Callback<JsonObject>() {
                @Override
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(RegisterActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                        finish(); // Close the RegisterActivity
                    } else {
                        Toast.makeText(RegisterActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<JsonObject> call, Throwable throwable) {
                    Toast.makeText(RegisterActivity.this, "Something went wrong during registration", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
        }
    }

    public void cancel(View view) {
        finish(); // Close the RegisterActivity
    }
}
