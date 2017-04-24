package tomcat360.com.hyxfjr.v.view_impl.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiongbull.jlog.JLog;

import tomcat360.com.hyxfjr.R;


public class FragmentDecorationStageFragment extends BaseFragment  {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_decoration_stage, null);
        return inflate;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        JLog.e("懒加载");
    }


}
