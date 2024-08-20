package com.sunbeaminfo.project.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonObject;
import com.sunbeaminfo.project.R;
import com.sunbeaminfo.project.entity.User;
import com.sunbeaminfo.project.utils.Constants;
import com.sunbeaminfo.project.utils.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText editEmail, editPassword;
    TextView textRegister;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getSharedPreferences(Constants.PREFERENCE_FILE_NAME, MODE_PRIVATE);
        boolean isLoggedIn = sharedPreferences.getBoolean(Constants.LOGIN_STATUS, false);
        if (isLoggedIn) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
            return;
        }
        setContentView(R.layout.activity_login);
        textRegister = findViewById(R.id.textRegister);
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        checkBox = findViewById(R.id.checkBox);

        textRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("LoginActivity", "Register text clicked");
                Toast.makeText(LoginActivity.this, "Register text clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }

    public void login(View view) {
        User user = new User();
        user.setEmail(editEmail.getText().toString());
        user.setPassword(editPassword.getText().toString());

        RetrofitClient.getInstance().getApi().loginUser(user).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.body().get("status").getAsString().equals("success")) {
                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    SharedPreferences sharedPreferences = getSharedPreferences(Constants.PREFERENCE_FILE_NAME, MODE_PRIVATE);

                    // it will fetch the user id from the response
                    int id = response.body().getAsJsonObject("data").get(Constants.ID).getAsInt();
                    sharedPreferences.edit().putInt(Constants.ID, id).apply();
                    if (checkBox.isChecked())
                        sharedPreferences.edit().putBoolean(Constants.LOGIN_STATUS, true).apply();
                    else
                        sharedPreferences.edit().putBoolean(Constants.LOGIN_STATUS, false).apply();

                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                } else
                    Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable throwable) {
                Toast.makeText(LoginActivity.this, "Something went wrong at Login", Toast.LENGTH_SHORT).show();
            }
        });
    }
}