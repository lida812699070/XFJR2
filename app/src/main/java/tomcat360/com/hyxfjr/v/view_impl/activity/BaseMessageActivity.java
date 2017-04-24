package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.Manifest;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.OnClick;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.my_utils.MyPermisssionUtils;
import tomcat360.com.hyxfjr.view.MyToolbar;
import tomcat360.com.hyxfjr.view.mydialog.ProvinceDialogUtils;
import util.ButtonClickUtil;

public class BaseMessageActivity extends BaseActivity {


    @Bind(R.id.base_toolbar)
    MyToolbar baseToolbar;
    @Bind(R.id.tv_live_location)
    TextView tvLiveLocation;
    @Bind(R.id.et_address_detail)
    EditText etAddressDetail;
    @Bind(R.id.et_relative_name)
    EditText etRelativeName;
    @Bind(R.id.et_relative_mobile)
    EditText etRelativeMobile;
    @Bind(R.id.et_friend_name)
    EditText etFriendName;
    @Bind(R.id.et_friends_mobile)
    EditText etFriendsMobile;
    @Bind(R.id.btn_next)
    Button btnNext;

    @Override
    public int getLayoutId() {
        return R.layout.activity_base_message;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        initToolbar("基本资料");
    }

    @OnClick({R.id.btn_next, R.id.tv_live_location, R.id.et_relative_mobile, R.id.et_friends_mobile})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_next: //下一步
                if (ButtonClickUtil.isFastDoubleClick()) return;
                startActivity(new Intent(this, TraderPasswordActivity.class));
                break;
            case R.id.tv_live_location://选择居住地址
                ProvinceDialogUtils.selectAddress(this, tvLiveLocation);
                break;
            case R.id.et_relative_mobile://通讯录选择亲属电话
                selectRelativeMobile(1);
                break;
            case R.id.et_friends_mobile://通讯录选择朋友电话
                selectRelativeMobile(2);
                break;
            default:
                break;
        }
    }

    private void selectRelativeMobile(final int requestCode) {
        MyPermisssionUtils.request(this, new MyPermisssionUtils.PermisssionCallback() {
            @Override
            public void isAgree(boolean isAgree) {
                if (isAgree) {
                    Intent intent = new Intent(Intent.ACTION_PICK,
                            ContactsContract.Contacts.CONTENT_URI);
                    startActivityForResult(intent, requestCode);
                } else {
                    Toast.makeText(BaseMessageActivity.this, "请到设置中同意相关权限", Toast.LENGTH_SHORT).show();
                }

            }
        }, Manifest.permission.READ_CONTACTS);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    Uri contactData = data.getData();
                    Cursor cursor = managedQuery(contactData, null, null, null,
                            null);
                    cursor.moveToFirst();
                    String num = this.getContactPhone(cursor);
                    etRelativeMobile.setText(num);
                }
                break;
            case 2:
                if (resultCode == RESULT_OK) {
                    Uri contactData = data.getData();
                    Cursor cursor = managedQuery(contactData, null, null, null,
                            null);
                    cursor.moveToFirst();
                    String num = this.getContactPhone(cursor);
                    etFriendsMobile.setText(num);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void initTitle() {

    }

    private String getContactPhone(Cursor cursor) {
        // TODO Auto-generated method stub
        int phoneColumn = cursor
                .getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER);
        int phoneNum = cursor.getInt(phoneColumn);
        String result = "";
        if (phoneNum > 0) {
            // 获得联系人的ID号
            int idColumn = cursor.getColumnIndex(ContactsContract.Contacts._ID);
            String contactId = cursor.getString(idColumn);
            // 获得联系人电话的cursor
            Cursor phone = getContentResolver().query(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null,
                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "="
                            + contactId, null, null);
            if (phone.moveToFirst()) {
                for (; !phone.isAfterLast(); phone.moveToNext()) {
                    int index = phone
                            .getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                    int typeindex = phone
                            .getColumnIndex(ContactsContract.CommonDataKinds.Phone.TYPE);
                    int phone_type = phone.getInt(typeindex);
                    String phoneNumber = phone.getString(index);
                    result = phoneNumber;
//                  switch (phone_type) {//此处请看下方注释
//                  case 2:
//                      result = phoneNumber;
//                      break;
//
//                  default:
//                      break;
//                  }
                }
                if (!phone.isClosed()) {
                    phone.close();
                }
            }
        }
        return result;
    }
}
