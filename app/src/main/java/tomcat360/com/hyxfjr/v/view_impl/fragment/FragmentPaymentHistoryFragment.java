package tomcat360.com.hyxfjr.v.view_impl.fragment;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;

import tomcat360.com.hyxfjr.R;


public class FragmentPaymentHistoryFragment extends Fragment  {


    private String url;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_payment_history, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        url = getArguments().getString("url");
    }

    public static FragmentPaymentHistoryFragment newInstance(String url) {
        Bundle args = new Bundle();
        args.putString("url", url);
        FragmentPaymentHistoryFragment pageFragment = new FragmentPaymentHistoryFragment();
        pageFragment.setArguments(args);
        return pageFragment;
    }

}
