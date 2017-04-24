package tomcat360.com.hyxfjr.mvp_presenter.presenter_interface;

import android.content.Context;

/**
 * Title:ILoginPresenter
 * Package:com.tomcat360.presenter.presenterInterface
 * Description:TODO
 * Author: wwh@tomcat360.com
 * Date: 16/3/24
 * Version: V1.0.0
 * 版本号修改日期修改人修改内容
 */
public interface ILoginPresenter {
	void onPerformLogin(Context context, String name, String password);
}
