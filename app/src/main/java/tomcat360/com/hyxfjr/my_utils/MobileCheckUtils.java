package tomcat360.com.hyxfjr.my_utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lida on 2017/4/21 0021.
 * 检查手机号格式
 */

public class MobileCheckUtils {
    public static boolean isMobileNO(String mobiles) {

        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");

        Matcher m = p.matcher(mobiles);

        return m.matches();

    }
}
