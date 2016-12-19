package com.example.administrator.practicaltraining;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;

public class CaptureActivity extends Activity implements View.OnClickListener {

    private static final String IMAGE_UNSPECIFIED = "image/*";
    private static final int PHOTO_RESOULT = 4;

    private Button album, camera;
    private ImageView display;

    private static final String TAG = "MyActivity";

    private static final int ALBUM_REQUEST_CODE = 1;
    private static final int CAMERA_REQUEST_CODE = 2;
    private static final int CROP_REQUEST_CODE = 4;

    private Uri imageUri;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture);

        init();
    }

    private void init() {
        album = (Button) findViewById(R.id.ablum_btn);
        camera = (Button) findViewById(R.id.camera_btn);

        display = (ImageView) findViewById(R.id.display_iv);

        album.setOnClickListener(this);
        camera.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.ablum_btn:
                Log.i(TAG, "相册");
                Intent intent = new Intent(Intent.ACTION_PICK, null);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, IMAGE_UNSPECIFIED);
                startActivityForResult(intent, ALBUM_REQUEST_CODE);
                break;
            case R.id.camera_btn:
                Log.i(TAG, "相机");
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(Environment.
                        getExternalStorageDirectory(), "temp.jpg")));
                startActivityForResult(intent, CAMERA_REQUEST_CODE);
                break;
        }
    }

    /**
     * 开始裁剪
     *
     * @param uri
     */
    private void startCrop(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");//调用Android系统自带的一个图片剪裁页面,
        intent.setDataAndType(uri, IMAGE_UNSPECIFIED);
        intent.putExtra("crop", "true");//进行修剪
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 300);
        intent.putExtra("outputY", 500);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, CROP_REQUEST_CODE);
    }

    /**
     * 判断sdcard卡是否可用
     *
     * @return 布尔类型 true 可用 false 不可用
     */
    private boolean isSDCardCanUser() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode) {
            case ALBUM_REQUEST_CODE:
                Log.i(TAG, "相册，开始裁剪");
                Log.i(TAG, "相册 [ " + data + " ]");
                if (data == null) {
                    return;
                }
                startCrop(data.getData());
                break;
            case CAMERA_REQUEST_CODE:
                Log.i(TAG, "相机, 开始裁剪");
                File picture = new File(Environment.getExternalStorageDirectory()
                        + "/temp.jpg");
                startCrop(Uri.fromFile(picture));
                break;
            case CROP_REQUEST_CODE:
                Log.i(TAG, "相册裁剪成功");
                Log.i(TAG, "裁剪以后 [ " + data + " ]");
                if (data == null) {
                    // TODO 如果之前以后有设置过显示之前设置的图片 否则显示默认的图片
                    return;
                }
                Bundle extras = data.getExtras();
                if (extras != null) {
                    Bitmap photo = extras.getParcelable("data");
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    photo.compress(Bitmap.CompressFormat.JPEG, 75, stream);// (0-100)压缩文件
                    //此处可以把Bitmap保存到sd卡中，具体请看：http://www.cnblogs.com/linjiqin/archive/2011/12/28/2304940.html
                    display.setImageBitmap(photo); //把图片显示在ImageView控件上
                }
                break;
            default:
                break;
        }
    }

        /**
         * 检查设备是否存在SDCard的工具方法
         */
    public static boolean hasSdcard() {
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            // 有存储的SDCard
            return true;
        } else {
            return false;
        }
    }
}




