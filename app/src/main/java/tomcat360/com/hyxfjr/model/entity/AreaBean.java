package tomcat360.com.hyxfjr.model.entity;

import java.util.List;

/**
 * Title:AreaBean
 * Package:com.tomcat360.model.entity
 * Description:TODO
 * Author: llj@tomcat360.com
 * Date: 2017/3/7
 * Version: V1.0.0
 * 版本号修改日期修改人修改内容
 */

public class AreaBean extends BaseBean {

    private List<DataEntity> data;

    public List<DataEntity> getData() {
        return data;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public static class DataEntity {
        private String name;
        private int cityId;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCityId() {
            return cityId;
        }

        public void setCityId(int cityId) {
            this.cityId = cityId;
        }
    }
}
