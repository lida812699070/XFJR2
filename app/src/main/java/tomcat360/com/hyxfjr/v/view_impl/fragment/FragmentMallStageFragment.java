package tomcat360.com.hyxfjr.v.view_impl.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.v.view_impl.activity.InviteFriendsActivity;


public class FragmentMallStageFragment extends BaseFragment {
    @Bind(R.id.base_toolbar)
    Toolbar baseToolbar;
    @Bind(R.id.malll_atage_invite_person)
    TextView malllAtageInvitePerson;
    @Bind(R.id.malll_atage_person_number)
    TextView malllAtagePersonNumber;
    @Bind(R.id.malll_atage_get_money)
    TextView malllAtageGetMoney;
    @Bind(R.id.malll_atage_get_money_number)
    TextView malllAtageGetMoneyNumber;
    @Bind(R.id.malll_atage_red_pake)
    TextView malllAtageRedPake;
    @Bind(R.id.malll_atage_red_pake_number)
    TextView malllAtageRedPakeNumber;
    @Bind(R.id.btn_invitation_ranking)
    ImageView btnInvitationRanking;
    @Bind(R.id.btn_invitation_fast)
    ImageView btnInvitationFast;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_mall_stage, null);
        ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initToolbar();
    }

    @OnClick({R.id.btn_invitation_ranking, R.id.btn_invitation_fast})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_invitation_ranking://邀请排行
                break;
            case R.id.btn_invitation_fast://马上邀请
                startActivity(new Intent(getActivity(), InviteFriendsActivity.class));
                break;
            default:
                break;
        }
    }

    private void initToolbar() {
        baseToolbar.setTitle(getResources().getString(R.string.StagingMall));
        baseToolbar.setTitleTextColor(getResources().getColor(R.color.white));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
