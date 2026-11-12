package com.example.jhedrickamoguispeta2;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.studyquest.R;

public class MainActivity extends AppCompatActivity {

    private TextView txtSubjectTitle;
    private LinearLayout commentsContainer;
    private ScrollView commentsScroll;
    private EditText inputComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.comment);

        if (findViewById(R.id.main) != null) {
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }

        txtSubjectTitle = findViewById(R.id.txtSubjectTitle);
        commentsContainer = findViewById(R.id.commentsContainer);
        commentsScroll = findViewById(R.id.commentsScroll);
        inputComment = findViewById(R.id.inputComment);
        Button btnSend = findViewById(R.id.btnSend);
        Button btnMath = findViewById(R.id.btnMath);
        Button btnScience = findViewById(R.id.btnScience);
        Button btnEnglish = findViewById(R.id.btnEnglish);

        if (btnMath != null) {
            btnMath.setOnClickListener(v -> selectSubject("Animation"));
        }
        if (btnScience != null) {
            btnScience.setOnClickListener(v -> selectSubject("CLED"));
        }
        if (btnEnglish != null) {
            btnEnglish.setOnClickListener(v -> selectSubject("Media Literacy"));
        }

        if (btnSend != null) {
            btnSend.setOnClickListener(v -> addComment());
        }
    }

    private void selectSubject(String subjectName) {
        if (txtSubjectTitle != null) {
            txtSubjectTitle.setText(subjectName + " Discussion");
        }
        Toast.makeText(this, "Switched to " + subjectName, Toast.LENGTH_SHORT).show();
    }

    private void addComment() {
        if (inputComment == null || commentsContainer == null) return;

        String commentText = inputComment.getText().toString().trim();
        if (commentText.isEmpty()) {
            Toast.makeText(this, "Please enter a comment", Toast.LENGTH_SHORT).show();
            return;
        }

        TextView newComment = new TextView(this);
        newComment.setText("You: " + commentText);
        newComment.setTextColor(Color.parseColor("#20243A"));
        newComment.setTextSize(14);
        newComment.setBackgroundColor(Color.parseColor("#E8EBF3"));
        newComment.setPadding(24, 24, 24, 24);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 12, 0, 12);
        newComment.setLayoutParams(params);

        commentsContainer.addView(newComment);
        inputComment.setText("");

        if (commentsScroll != null) {
            commentsScroll.post(() -> commentsScroll.fullScroll(ScrollView.FOCUS_DOWN));
        }
    }
}
