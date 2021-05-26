package com.example.ecommoblie_app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Post extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 1;
    private Button btn_choose, btn_upload;
    EditText edt_fileName;
    ImageView imgPost;
    Uri imgUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        init();
    }

    public void init() {
        btn_choose = findViewById(R.id.btn_choose_file);
        btn_upload = findViewById(R.id.btn_upload_file);
        edt_fileName = findViewById(R.id.edt_file_name);
        imgPost = findViewById(R.id.imagePost);

        btn_choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imgUri = data.getData();

        }
    }

    public void openFilechoose() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);


    }
}















