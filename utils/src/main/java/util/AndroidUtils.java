package util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.util.DisplayMetrics;

import java.util.List;

/**
 * Title:AndroidUtils
 * Package:util
 * Description:android相关工具类
 * Author: wwh@tomcat360.com
 * Date: 16/4/11
 * Version: V1.0.0
 * 版本号修改日期修改人修改内容
 */
public class AndroidUtils {
	/**
	 * @param
	 * @Title getLocation
	 * @Description 获取地理位置
	 */
	public static String getLocation(Context context) {
		LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
		//获取所有可用的位置提供器
		List<String> providers = locationManager.getProviders(true);
		String locationProvider;
		if (providers.contains(LocationManager.GPS_PROVIDER)) {
			//如果是GPS
			locationProvider = LocationManager.GPS_PROVIDER;
		} else if (providers.contains(LocationManager.NETWORK_PROVIDER)) {
			//如果是Network
			locationProvider = LocationManager.NETWORK_PROVIDER;
		} else {
			return "";
		}
		Location location = null;
		try {
			//获取Location
			location = locationManager.getLastKnownLocation(locationProvider);
			if (location != null) {
				return "latitude:" + location.getLatitude() + ",longitude:" + location.getLongitude();
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		}

		return "";
	}

	public static String getChannel(Context context) {
		ApplicationInfo appInfo = null;
		try {
			appInfo = context.getPackageManager()
					.getApplicationInfo(context.getPackageName(),
							PackageManager.GET_META_DATA);
		} catch (PackageManager.NameNotFoundException e) {
			e.printStackTrace();
		}
		String msg = appInfo.metaData.getString("CHANNEL");
		return msg;
	}

	/**
	 * 获取设备dpi
	 *
	 * @param context
	 * @return
	 */
	public static String getDpi(Context context) {
		String dpi = String.valueOf(context.getResources().getDisplayMetrics().densityDpi);
		return dpi;
	}

	/**
	 * 获取设备分辨率
	 *
	 * @param context
	 * @return
	 */
	public static String getResolution(Activity context) {

		DisplayMetrics displayMetrics = new DisplayMetrics();
		context.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		return displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
	}
}
