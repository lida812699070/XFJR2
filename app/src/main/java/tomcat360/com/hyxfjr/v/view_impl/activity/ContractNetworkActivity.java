package tomcat360.com.hyxfjr.v.view_impl.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;

import butterknife.Bind;
import butterknife.OnClick;
import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.mvp_presenter.presenter_impl.ContractNetworkPresenter;
import tomcat360.com.hyxfjr.mvp_v.i.IContractNetworkView;

public class ContractNetworkActivity extends BaseActivity implements IContractNetworkView {

    @Bind(R.id.toolbar_back)
    ImageView toolbarBack;
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.rl_toolbar)
    RelativeLayout rlToolbar;
    private ContractNetworkPresenter presenter;
    private MapView mMapView;
    private BaiduMap mBaiduMap;
    private LocationClient mLocationClient;
    private LatLng ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SDKInitializer.initialize(getApplicationContext());
        super.onCreate(savedInstanceState);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_contract_network;
    }

    @OnClick({R.id.toolbar_title, R.id.toolbar_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar_title: //进入签约网点列表
                presenter.initCompanyAddresList();
                break;
            case R.id.toolbar_back: //返回键
                finish();
                break;
        }
    }

    @Override
    public void initData() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }

    @Override
    public void initView() {
        presenter = new ContractNetworkPresenter(this);
        mMapView = (MapView) findViewById(R.id.bmapView);
        mBaiduMap = mMapView.getMap();
        initLocation();
        initLocationConfig();
        mLocationClient.start();
    }

    //定位自己当前的位置
    private void initLocation() {
        // 开启定位图层
        mBaiduMap.setMyLocationEnabled(true);
        //这样设置就会有小箭头指定方向
        mBaiduMap.setMyLocationConfigeration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
        mLocationClient = new LocationClient(getApplicationContext());     //声明LocationClient类
        mLocationClient.registerLocationListener(new BDLocationListener() {
            @Override
            public void onReceiveLocation(BDLocation bdLocation) {
                if (bdLocation == null || mMapView == null) {
                    return;
                }
                MyLocationData myLocationData = new MyLocationData.Builder()
                        .accuracy(bdLocation.getRadius())//获取定位半径
                        .direction(100)
                        .latitude(bdLocation.getLatitude())
                        .longitude(bdLocation.getLongitude())
                        .build();
                mBaiduMap.setMyLocationData(myLocationData);
                backLocation(bdLocation);
                /*MapActivity.bdLocation = bdLocation;
                if (isFirstLoc) {
                    isFirstLoc = false;
                    //返回当前初始位置
                    sendLocation = new LatLng(bdLocation.getLatitude(), bdLocation.getLongitude());
                    backLocation(bdLocation);
                }*/
            }

            @Override
            public void onConnectHotSpotMessage(String s, int i) {

            }
        });
    }

    //设置定位服务所需要的服务
    private void initLocationConfig() {
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy
        );//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
        option.setScanSpan(0);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        // option.setLocationMode(LocationClientOption.LocationMode.Battery_Saving);//低功耗模式开启定位
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);//可选，默认false,设置是否使用gps
        option.setLocationNotify(false);//可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
        option.setIsNeedLocationDescribe(false);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(false);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤gps仿真结果，默认需要
        mLocationClient.setLocOption(option);
    }

    //返回定位
    private void backLocation(BDLocation bdLocation) {
        ll = new LatLng(bdLocation.getLatitude(), bdLocation.getLongitude());
        MapStatus.Builder builder = new MapStatus.Builder();
        builder.target(ll).zoom(15);

        mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
    }

    @Override
    public void initTitle() {

    }

    @Override
    public void initCompanyAddresList() {
        //startActivity(new Intent(this, ContractNetworkListActivity.class));
    }
}
