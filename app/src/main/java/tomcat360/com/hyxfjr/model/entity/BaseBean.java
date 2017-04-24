package tomcat360.com.hyxfjr.model.entity;

/**
 * Title:BaseBean
 * Package:com.tomcat360.model.entity
 * Description:TODO
 * Author: llj@tomcat360.com
 * Date: 2017/3/28
 * Version: V1.0.0
 * 版本号修改日期修改人修改内容
 */

public class BaseBean {
    private String code;
    private String msg;
    private int totalPage;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
