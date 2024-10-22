package com.example.lab_si;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class myPictureView extends View {
    String imagePath = null;
    public myPictureView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setImagePath(String path) {
        this.imagePath = path;
        invalidate();  // 뷰 다시 그리기
    }
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        if(imagePath != null){

            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            canvas.drawBitmap(bitmap, 0, 0, null);
            bitmap.recycle();
        }
        else {
            // 이미지 로드 실패 로그 추가
            Log.e("myPictureView", "이미지 로딩 실패: " + imagePath);
        }
    }
}