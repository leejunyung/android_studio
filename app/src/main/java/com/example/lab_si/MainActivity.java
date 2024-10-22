package com.example.lab_si;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private myPictureView myPictureView;
    File[] imageFiles = new File[0];
    String imageFname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 이미지 뷰 참조
        myPictureView = findViewById(R.id.myPictureView1);

        // 권한 요청
        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, MODE_PRIVATE);

        // 디렉토리 설정
        File photosDir = new File("/storage/emulated/0/Pictures/PhotosEditor/");

        // 디렉토리와 파일 여부 로그 출력
        if (!photosDir.exists()) {
            Log.e("MainActivity", "디렉토리가 존재하지 않습니다: " + photosDir.getAbsolutePath());
        }

        if (photosDir.exists() && photosDir.isDirectory()) {
            imageFiles = photosDir.listFiles((dir, name) -> name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png"));

            // 이미지 파일이 있을 경우
            if (imageFiles != null && imageFiles.length > 0) {
                imageFname = imageFiles[0].toString();  // 첫 번째 이미지 경로
                Log.d("MainActivity", "이미지 파일 경로: " + imageFname);  // 로그로 경로 출력
                myPictureView.setImagePath(imageFname);  // 이미지 경로 설정 및 표시
            } else {
                Log.e("MainActivity", "이미지 파일이 없습니다.");
            }
        } else {
            Log.e("MainActivity", "해당 디렉토리가 존재하지 않거나 디렉토리가 아닙니다.");
        }
    }
}