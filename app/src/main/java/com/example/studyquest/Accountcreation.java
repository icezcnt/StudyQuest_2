package com.example.studyquest;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Accountcreation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.accountcreation);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.accountcreation), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText editText = findViewById(R.id.etRegisterUser);
        EditText editText1 = findViewById(R.id.etRegisterPass);
        Button registerButton = findViewById(R.id.Register);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = editText.getText().toString().trim();
                if (TextUtils.isEmpty(input)) {
                    editText.setError("This field cannot be empty");
                    return;
                }
                String input1 = editText1.getText().toString().trim();
                if (TextUtils.isEmpty(input1)) {
                    editText1.setError("This field cannot be empty");
                    return;
                }

                Intent Intent = new Intent(Accountcreation.this, Login.class);
                startActivity(Intent);
            }
        });
        TextView login = findViewById(R.id.tvAlreadyHaveAccount);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View v) {
                Intent intent = new Intent(Accountcreation.this, Login.class);
                startActivity(intent);
            }
        });
    }
}