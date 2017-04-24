package tomcat360.com.hyxfjr.mvp_presenter.presenter_impl;

import android.content.Context;


import tomcat360.com.hyxfjr.mvp_m.G;
import tomcat360.com.hyxfjr.mvp_m.ParamNameConstant;
import tomcat360.com.hyxfjr.mvp_m.StateConstant;
import tomcat360.com.hyxfjr.mvp_m.model_impl.UserActionModel;
import tomcat360.com.hyxfjr.mvp_m.model_interface.IUserActionModel;
import tomcat360.com.hyxfjr.model.entity.LoginEntity;
import tomcat360.com.hyxfjr.net.MyCallBack;
import tomcat360.com.hyxfjr.mvp_presenter.presenter_interface.ILoginPresenter;
import tomcat360.com.hyxfjr.mvp_v.i.ILoginView;
import util.SPUtils;

/**
 * Title:LoginPresenter
 * Package:com.tomcat360.presenter.presenterImpl
 * Description:TODO
 * Author: wwh@tomcat360.com
 * Date: 16/3/24
 * Version: V1.0.0
 * 版本号修改日期修改人修改内容
 */
public class LoginPresenter implements ILoginPresenter {
	private ILoginView loginView;
	private IUserActionModel loginModel;

	public LoginPresenter(ILoginView loginView) {
		this.loginView = loginView;
		loginModel=new UserActionModel();
	}

	/**
	 * 登录
	 * @param context
	 * @param name
	 * @param password
	 */

	public void onPerformLogin(final Context context, final String name, final String password) {
		loginModel.goLogin(context, name, password, new MyCallBack<LoginEntity>() {
			@Override
			public void onSuccess(LoginEntity loginEntity) {
				if (G.REQUEST_SUCCESS_CODE.equals(loginEntity.getCode())) {
					SPUtils.put(context, ParamNameConstant.SESSION_ID,loginEntity.getData().getSessionId());
					loginSuccess(context, loginEntity, name, password);
					loginView.loginSuccess();
				} else {
					loginView.loginFailed(loginEntity.getMsg());
				}
			}

			@Override
			public void onFailed(String msg) {
				loginView.loginFailed(msg);
			}

			@Override
			public void onFinish() {
			}
		});
	}

	/**
	 * 登录成功，保存状态
	 * @param loginEntity
	 * @param context
	 */
	private void loginSuccess(Context context, LoginEntity loginEntity, String name, String password) {
		LoginEntity.DataEntity entity = loginEntity.getData();
		SPUtils.put(context, ParamNameConstant.ISLOGIN, StateConstant.STATE_ISLOGIN);
		SPUtils.put(context, ParamNameConstant.LOGIN_NAME, name);
		SPUtils.put(context, ParamNameConstant.LOGIN_PWD, password);
		SPUtils.put(context, ParamNameConstant.REALNAMESTATUS, entity.getUser().getRealVerifyStatus());
		SPUtils.put(context, ParamNameConstant.CARDBINDSTATUS, entity.getUser().getCardBindingStatus());
		SPUtils.put(context, ParamNameConstant.USER_ID, entity.getUser().getId());
	}

}
