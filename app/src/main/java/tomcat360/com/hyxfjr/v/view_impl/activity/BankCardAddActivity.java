package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import butterknife.Bind;
import butterknife.OnClick;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.mvp_m.G;
import tomcat360.com.hyxfjr.my_utils.BitmapUtils;
import tomcat360.com.hyxfjr.my_utils.MyPermisssionUtils;
import tomcat360.com.hyxfjr.view.MyToolbar;

import static tomcat360.com.hyxfjr.mvp_m.G.SELECT_CAMER;

public class BankCardAddActivity extends BaseActivity {

    @Bind(R.id.base_toolbar)
    MyToolbar baseToolbar;
    @Bind(R.id.card_number)
    TextView cardNumber;
    @Bind(R.id.iv_take_photo)
    ImageView ivTakePhoto;
    @Bind(R.id.bank_of_deposit)
    TextView bankOfDeposit;
    @Bind(R.id.reserved_phone)
    TextView reservedPhone;
    @Bind(R.id.btn_submit)
    Button btnSubmit;
    @Bind(R.id.iv_card_photo)
    ImageView ivCardPhoto;
    private String filePath = G.getFileRootPath() + "/bankcard.jpg";

    @Override
    public int getLayoutId() {
        return R.layout.activity_bank_card_manager;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        initToolbar("银行卡管理");
    }

    @OnClick({R.id.iv_take_photo})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_take_photo://拍照银行卡
                takePic();
                break;
            default:
                break;
        }
    }

    private void takePic() {
        MyPermisssionUtils.request(this, new MyPermisssionUtils.PermisssionCallback() {
            @Override
            public void isAgree(boolean isAgree) {
                if (isAgree) {
                    takePic(filePath);
                } else {
                    Toast.makeText(BankCardAddActivity.this, "请到设置中同意相关权限", Toast.LENGTH_SHORT).show();
                }
            }
        }, Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    @Override
    public void initTitle() {

    }

    public void takePic(String filePath) {
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            File myCaptureFile = new File(filePath);
            //7.0适配
            Uri uri = FileProvider.getUriForFile(getApplicationContext(),G.GET_PATH_URI, myCaptureFile);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            startActivityForResult(intent, SELECT_CAMER);
        } else {
            Toast.makeText(this, "请确认已经插入SD卡", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == G.SELECT_PICTURE) {

            } else if (requestCode == SELECT_CAMER) { //拍照
                //压缩到600*800像素
                Bitmap bitmap = BitmapUtils.compressBitmap(filePath, 600, 800);
                ivCardPhoto.setImageBitmap(bitmap);
            }
        }

    }
}
