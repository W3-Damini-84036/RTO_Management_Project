package com.sunbeaminfo.project.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonObject;
import com.sunbeaminfo.project.R;
import com.sunbeaminfo.project.entity.User;
import com.sunbeaminfo.project.utils.Api;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import okhttp3.ResponseBody;

import com.sunbeaminfo.project.utils.Constants;
import com.sunbeaminfo.project.utils.RetrofitClient;
import com.sunbeaminfo.project.entity.Admin;

public class AdminLoginActivity extends AppCompatActivity {
    EditText editEmail, editPassword;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);

//        textRegister.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(AdminLoginActivity.this,RegisterActivity.class));
//            }
//        });
    }

    public void login(View view){
        User user = new User();
        user.setEmail(editEmail.getText().toString());
        user.setPassword(editPassword.getText().toString());

        RetrofitClient.getInstance().getApi().loginUser(user).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if(response.body().get("status").getAsString().equals("success")){
                    Toast.makeText(AdminLoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    SharedPreferences sharedPreferences = getSharedPreferences(Constants.PREFERENCE_FILE_NAME,MODE_PRIVATE);

                    // it will fetch the user id from the response
                    int id = response.body().getAsJsonObject("data").get(Constants.ID).getAsInt();
                    sharedPreferences.edit().putInt(Constants.ID,id).apply();
                    if(checkBox.isChecked())
                        sharedPreferences.edit().putBoolean(Constants.LOGIN_STATUS,true).apply();
                    else
                        sharedPreferences.edit().putBoolean(Constants.LOGIN_STATUS,false).apply();

                    startActivity(new Intent(AdminLoginActivity.this, MainActivity.class));
                    finish();
                }
                else
                    Toast.makeText(AdminLoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable throwable) {
                Toast.makeText(AdminLoginActivity.this, "Something went wrong at Login", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void cancel(View view){
        finish();
    }
}