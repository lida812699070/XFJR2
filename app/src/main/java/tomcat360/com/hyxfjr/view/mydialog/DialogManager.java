package tomcat360.com.hyxfjr.view.mydialog;

import android.content.Context;
import android.content.DialogInterface;

/**
 * Title:DialogManager
 * Package:com.tomcat360.view.mydialog
 * Description:TODO
 * Author: wwh@tomcat360.com
 * Date: 16/5/25
 * Version: V1.0.0
 * 版本号修改日期修改人修改内容
 */
public class DialogManager {

    public static void showDialog(Context context, String title, String msg, DialogInterface.OnClickListener listener) {

        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setNegativeButton("取消", null);
        builder.setPositiveButton("确定", listener);
        builder.show();
    }

    public static void showAlertDialog(Context context, String msg) {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(context);
        builder.setTitle("提示");
        builder.setMessage(msg);
        builder.setPositiveButton("确定", null);
        builder.show();
    }

    public static void showAlertDialog(Context context, String msg, DialogInterface.OnClickListener clickListener) {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(context);
        builder.setTitle("提示");
        builder.setMessage(msg);
        builder.setPositiveButton("确定", clickListener);
        builder.show();
    }

    public static void showConfirmDialog(Context context,String msg,DialogInterface.OnClickListener clickListener) {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(context);
//        builder.setTitle("提示");
        builder.setMessage(msg);
        builder.setPositiveButton("确定", clickListener);
        builder.setNegativeButton("取消", null);
        builder.show();
    }
    public static void showConfirmDialogUnCancelable(Context context,String msg,DialogInterface.OnClickListener clickListener) {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(context);
//        builder.setTitle("提示");
        builder.setMessage(msg);
        builder.setCancelable(false);
        builder.setPositiveButton("确定", clickListener);
        builder.show();
    }
    public static void showTelDialog(Context context,String msg,DialogInterface.OnClickListener clickListener) {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(context);
        builder.setTitle("客服电话");
        builder.setMessage(msg);
        builder.setPositiveButton("确定", clickListener);
        builder.setNegativeButton("取消", null);
        builder.show();
    }



	/**
     * 输入6位验证码对话框
     * @param context 上下文
     * @param listener 输入变化监听
     */


    /**
     * 积分规则
     * @param context
     * @param msg
     */
    public static void showScoreRuleDialog(Context context, String msg) {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(context);
        builder.setTitle("积分规则");
        builder.setMessage(msg);
        builder.setPositiveButton("确定", null);
        builder.show();
    }
}
