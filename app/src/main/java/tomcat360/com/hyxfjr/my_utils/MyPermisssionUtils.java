package tomcat360.com.hyxfjr.my_utils;

import android.app.Activity;

import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by lida on 2017/4/23 0023.
 */

public class MyPermisssionUtils {
    public static void request(Activity activity, final PermisssionCallback callBack, String... manifsets) {
        new RxPermissions(activity)
                .request(manifsets)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(@NonNull Boolean aBoolean) throws Exception {
                        callBack.isAgree(aBoolean);
                    }
                });
    }

    public interface PermisssionCallback {
        void isAgree(boolean isAgree);
    }
}