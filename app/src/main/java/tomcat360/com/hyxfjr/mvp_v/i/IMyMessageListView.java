package tomcat360.com.hyxfjr.mvp_v.i;

/**
 * Created by Administrator on 2017/4/19 0019.
 */

public interface IMyMessageListView {
    void editMessage();

    void isShowCheckBox(boolean mIsEditStatus);

    void delete();

    void markAll();

    void setLlBottomVisable(boolean mIsEditStatus);

    void setIsEdit(boolean mIsEditStatus);
}
