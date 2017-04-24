package tomcat360.com.hyxfjr.net;

import android.content.Context;
import android.content.Intent;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import tomcat360.com.hyxfjr.mvp_m.G;
import tomcat360.com.hyxfjr.mvp_m.ParamNameConstant;
import tomcat360.com.hyxfjr.model.entity.BaseBean;
import tomcat360.com.hyxfjr.v.APP;
import tomcat360.com.hyxfjr.v.view_impl.activity.LoginActivity;

/**
 * Title:RxHttpResult
 * Package:com.tomcat360.net
 * Description:TODO
 * Author: llj@tomcat360.com
 * Date: 2017/3/28
 * Version: V1.0.0
 * 版本号修改日期修改人修改内容
 */

public class RxHttpResult<T extends BaseBean> implements Function<T, Observable<T>> {

    private Context context;

    RxHttpResult(Context context) {
        this.context = context;
    }

    @Override
    public Observable<T> apply(@NonNull final T bean) throws Exception {
        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> e) throws Exception {
                if (G.LOGINOUT_CODE.equals(bean.getCode())) {
                    if (!G.SESSION_BROKEN) {//防止多次弹框
                        G.SESSION_BROKEN = true;//置上标记
                        APP.getInstance().sessionOut();//先掉线不让访问
                        Intent intent = new Intent(context, LoginActivity.class);
                        intent.putExtra(ParamNameConstant.FROM_SESSION_OUT,"1");
                        context.startActivity(intent);
//                        Looper.prepare();
//                        MyToast.toast(G.SESSION_OUT);
//                        Looper.loop();
                    }
                    e.onComplete();// 结束下拉头
                } else {
                    G.SESSION_BROKEN = false;
                    e.onNext(bean);
                    e.onComplete();
                }
            }
        });
    }
}
