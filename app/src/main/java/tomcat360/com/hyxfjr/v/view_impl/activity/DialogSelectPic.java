package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jiongbull.jlog.JLog;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.io.File;

import butterknife.Bind;
import butterknife.OnClick;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.mvp_m.G;
import tomcat360.com.hyxfjr.mvp_presenter.presenter_impl.DialogSelectPicPresenter;
import tomcat360.com.hyxfjr.mvp_v.i.IDialogSelectPicView;
import tomcat360.com.hyxfjr.my_utils.MyPermisssionUtils;
import util.FileUtils;

import static tomcat360.com.hyxfjr.mvp_m.G.SELECT_CAMER;

public class DialogSelectPic extends BaseActivity implements IDialogSelectPicView {

    @Bind(R.id.select_pic_cancel)
    LinearLayout selectPicCancel;
    @Bind(R.id.take_pic)
    TextView takePic;
    @Bind(R.id.select_pic)
    TextView selectPic;
    @Bind(R.id.rl_bg)
    RelativeLayout rlBg;
    private DialogSelectPicPresenter dialogSelectPicPresenter;
    private File myCaptureFile;
    private String filePath = G.getFileRootPath() + "/head.jpg";

    @OnClick({R.id.select_pic_cancel, R.id.take_pic, R.id.select_pic, R.id.rl_bg})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.take_pic://拍照
                dialogSelectPicPresenter.takePic();
                break;
            case R.id.select_pic://选择图片
                dialogSelectPicPresenter.selectPicBySD();
                JLog.e("选择照片");
                break;
            default:
                finish();
                break;
        }
    }

    @Override
    protected boolean isSteep() {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_dialog_select_pic;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        dialogSelectPicPresenter = new DialogSelectPicPresenter(this);

    }

    @Override
    public void initTitle() {

    }


    @Override
    public void takePic() {
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            myCaptureFile = new File(filePath);
            //7.0适配
            Uri uri = FileProvider.getUriForFile(getApplicationContext(), G.GET_PATH_URI, myCaptureFile);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            startActivityForResult(intent, SELECT_CAMER);
        } else {
            Toast.makeText(this, "请确认已经插入SD卡", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void checkCameraPermission() {
        MyPermisssionUtils.request(this, new MyPermisssionUtils.PermisssionCallback() {
            @Override
            public void isAgree(boolean isAgree) {
                if (isAgree) {
                    takePic();
                } else {
                    Toast.makeText(DialogSelectPic.this, "请到设置中同意相关权限", Toast.LENGTH_SHORT).show();
                }
            }
        }, Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    public void selectPicBySD() {
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            intent.setType("image/*");
            startActivityForResult(Intent.createChooser(intent, "选择图片"), G.SELECT_PICTURE);
        } else {
            Toast.makeText(this, "请确认已经插入SD卡", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void checkSDPermission() {
        new RxPermissions(this)
                .request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(@NonNull Boolean aBoolean) throws Exception {
                        if (aBoolean) {
                            selectPicBySD();
                        } else {
                            Toast.makeText(DialogSelectPic.this, "请到权限设置中同意相关权限", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == G.SELECT_PICTURE) {
                //选择图片
                Uri uri = data.getData();
                String path = FileUtils.getPath(this, uri);
                Intent intent = new Intent(this, MyCutImageActivity.class);
                intent.putExtra(G.IMAGE_PATH, path);
                startActivity(intent);
                finish();
            } else if (requestCode == SELECT_CAMER) {
                //拍照
                Intent intent = new Intent(this, MyCutImageActivity.class);
                intent.putExtra(G.IMAGE_PATH, filePath);
                startActivity(intent);
                finish();
            }

        }

    }

    /**
     * 裁剪图片方法实现
     *
     * @param uri
     */
    public void startPhotoZoom(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        //下面这个crop=true是设置在开启的Intent中设置显示的VIEW可裁剪
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("scale", true);// 去黑边
        intent.putExtra("scaleUpIfNeeded", true);// 去黑边
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 3);
    }
}
