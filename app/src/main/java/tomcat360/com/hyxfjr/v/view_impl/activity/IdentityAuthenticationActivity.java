package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tbruyelle.rxpermissions2.RxPermissions;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.mvp_m.G;
import tomcat360.com.hyxfjr.my_utils.BitmapUtils;
import tomcat360.com.hyxfjr.my_utils.MyPermisssionUtils;
import tomcat360.com.hyxfjr.view.MyToolbar;
import util.ButtonClickUtil;

public class IdentityAuthenticationActivity extends BaseActivity {


    @Bind(R.id.base_toolbar)
    MyToolbar baseToolbar;
    @Bind(R.id.et_id_name)
    EditText etIdName;
    @Bind(R.id.et_id_number)
    EditText etIdNumber;
    @Bind(R.id.tv_title_front)
    TextView tvTitleFront;
    @Bind(R.id.tv_hint_front)
    TextView tvHintFront;
    @Bind(R.id.id_front_right_value)
    ImageView idFrontRightValue;
    @Bind(R.id.iv_front_right)
    TextView ivFrontRight;
    @Bind(R.id.tv_title_reversed_front)
    TextView tvTitleReversedFront;
    @Bind(R.id.tv_hint_reversed_front)
    TextView tvHintReversedFront;
    @Bind(R.id.id_reversed_front_right_value)
    ImageView idReversedFrontRightValue;
    @Bind(R.id.iv_reversed_right)
    TextView ivReversedRight;
    @Bind(R.id.iv_bank_card_number)
    ImageView ivBankCardNumber;
    @Bind(R.id.et_bank_of_deposit)
    EditText etBankOfDeposit;
    @Bind(R.id.et_mobile_number)
    EditText etMobileNumber;
    @Bind(R.id.checkbox_agree)
    CheckBox checkboxAgree;
    @Bind(R.id.btn_next)
    Button btnNext;
    private String idFrontPicPath = G.getFileRootPath() + "/idFrontPic.jpg";
    private String idFrontReversedPicPath = G.getFileRootPath() + "/idFrontReversedPic.jpg";

    @Override
    public int getLayoutId() {
        return R.layout.activity_identity_authentication;
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.btn_next, R.id.iv_front_right, R.id.iv_reversed_right})
    public void onClick(View view) {
        if (ButtonClickUtil.isFastDoubleClick()) return;
        switch (view.getId()) {
            case R.id.btn_next://下一步
                //startActivity(new Intent(this, IdentityAuthenticationResultDialog.class));
                if (checkboxAgree.isChecked()) {
                    startActivity(new Intent(this, FaceRecognitionActivity.class));
                }
                break;
            case R.id.iv_front_right://身份证正面照
                takeFrontPic(idFrontPicPath, 1);//
                break;
            case R.id.iv_reversed_right://身份证反面照
                takeFrontPic(idFrontReversedPicPath, 2);//
                break;
            default:
                break;
        }
    }

    private void takeFrontPic(final String filePath, final int requestCode) {
        MyPermisssionUtils.request(this, new MyPermisssionUtils.PermisssionCallback() {
            @Override
            public void isAgree(boolean isAgree) {
                if (isAgree) {
                    takePic(filePath, requestCode);
                } else {
                    Toast.makeText(IdentityAuthenticationActivity.this, "请到设置中同意相关权限", Toast.LENGTH_SHORT).show();
                }
            }
        }, Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    public void takePic(String filePath, int requestCode) {
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            File myCaptureFile = new File(filePath);
            //7.0适配
            Uri uri = FileProvider.getUriForFile(getApplicationContext(), G.GET_PATH_URI, myCaptureFile);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            startActivityForResult(intent, requestCode);
        } else {
            Toast.makeText(this, "请确认已经插入SD卡", Toast.LENGTH_LONG).show();
        }
    }

    @OnCheckedChanged(R.id.checkbox_agree)//是否同意选择框
    public void checkChange(CompoundButton view, boolean isChecked) {
        if (isChecked) {
            btnNext.setBackgroundColor(getResources().getColor(R.color.guestPaint_color_wrong));
        } else {
            btnNext.setBackgroundColor(Color.GRAY);
        }
    }

    @Override
    public void initView() {
        initToolbar("身份认证");
    }

    @Override
    public void initTitle() {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) { //正面照
                //压缩到600*800像素
                Bitmap bitmap = BitmapUtils.compressBitmap(idFrontPicPath, 600, 800);
                idFrontRightValue.setImageBitmap(bitmap);
                ivFrontRight.setText("重新上传");
                tvHintFront.setVisibility(View.GONE);
            } else if (requestCode == 2) {
                //压缩到600*800像素
                Bitmap bitmap = BitmapUtils.compressBitmap(idFrontReversedPicPath, 600, 800);
                idReversedFrontRightValue.setImageBitmap(bitmap);
                ivReversedRight.setText("重新上传");
                tvHintReversedFront.setVisibility(View.GONE);
            }
        }

    }

}
