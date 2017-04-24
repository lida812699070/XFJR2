package tomcat360.com.hyxfjr.view.myview;


import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import tomcat360.com.hyxfjr.R;
import tomcat360.com.hyxfjr.model.adapter.AreaAdapter;

import java.util.Map;

import tomcat360.com.hyxfjr.model.entity.AreaBean;
import tomcat360.com.hyxfjr.mvp_presenter.presenter_impl.AddressPickPresenter;
import tomcat360.com.hyxfjr.mvp_presenter.presenter_interface.IAddressPickPresenter;
import tomcat360.com.hyxfjr.v.view_impl.activity.IAddressPickActivity;


/**
 * Title:AddressPickerView
 * Package:com.tomcat360.zjz.erp.activity.selfcenter
 * Description:地址选择view
 * Author: llj@tomcat360.com
 * Date: 2016/10/28
 * Version: V1.0.0
 * 版本号修改日期修改人修改内容
 */

public class AddressPickerView implements IAddressPickActivity {

    private Context mContext;
    private AddressPickerCallBack mCallBack;
    private List<AreaBean.DataEntity> provinceLists = new ArrayList<AreaBean.DataEntity>();// 省列表
    private List<AreaBean.DataEntity> cityLists = new ArrayList<AreaBean.DataEntity>();// 城市列表
    private List<AreaBean.DataEntity> countyLists = new ArrayList<AreaBean.DataEntity>();// 城市列表
    private Map<String, List<AreaBean.DataEntity>> provinceCache = new HashMap<String, List<AreaBean.DataEntity>>();// 省份缓存
    private Map<String, List<AreaBean.DataEntity>> cityCache = new HashMap<String, List<AreaBean.DataEntity>>();// 城市缓存
    private Map<String, List<AreaBean.DataEntity>> countyCache = new HashMap<String, List<AreaBean.DataEntity>>();// 区域缓存
    private AreaBean.DataEntity choisProvince;// 选中的省
    private AreaBean.DataEntity choisCity;// 选中的市
    private AreaBean.DataEntity choisCounty;// 选中的地区
    private AreaBean.DataEntity operateProvince;// 临时的省
    private AreaBean.DataEntity operateCity;// 临时的市
    private AreaBean.DataEntity operateCounty;// 临时的地区
    private AreaAdapter AreaAdapter;
    private AreaAdapter cityAdapter;
    private AreaAdapter areaAdapter;

    protected ListView provinceList;
    protected ListView cityList;
    protected ListView countyList;

    private TextView tvArea;
    private RelativeLayout rlArea;

    private Dialog addressDialog;
    private boolean mHideCountyFlag = false;

    private final int REQUEST_PROVINCE = 1;//请求标志
    private final int REQUEST_CITY = 2;
    private final int REQUEST_AREA = 3;

    private IAddressPickPresenter addressPickPresenter;

    public AddressPickerView(Context context, boolean hideCountyFlag, AddressPickerCallBack callBack) {
        mContext = context;
        mCallBack = callBack;
        mHideCountyFlag = hideCountyFlag;
        addressPickPresenter = new AddressPickPresenter(this);
    }

    /**
     * 获取服务器省份
     */
    public void getProvinceData() {
        if (provinceCache.get("province") != null) {
            refreshProvinces(provinceCache.get("province"));
            return;
        }
        addressPickPresenter.getAddrData(mContext, "0", "", REQUEST_PROVINCE);
    }

    /**
     * 获取省份默认位置
     *
     * @return
     */
    private int getProvincePosition() {
        if (choisProvince != null) {
            for (int i = 0; i < provinceLists.size(); i++) {
                if (choisProvince == provinceLists.get(i)) {
                    return i;
                }
            }

        }
        return 0;
    }

    /**
     * 获取城市默认位置
     *
     * @return
     */
    private int getCityPosition() {
        if (choisCity != null) {
            for (int i = 0; i <= cityLists.size(); i++) {
                if (cityLists.get(i) == choisCity) {
                    return i;
                }
            }
        }
        return 0;
    }

    /**
     * 获取服务器城市
     *
     * @param item
     */
    protected void getCityData(AreaBean.DataEntity item) {
        addressPickPresenter.getAddrData(mContext, item.getCityId() + "", item.getName(), REQUEST_CITY);
    }

    /**
     * 获取服务器地区
     *
     * @param item
     */
    protected void getCountyData(AreaBean.DataEntity item) {
        addressPickPresenter.getAddrData(mContext, item.getCityId() + "", item.getName(), REQUEST_AREA);
    }

    /**
     * 省份ui刷新
     */
    private void refreshProvinces(List<AreaBean.DataEntity> provinces) {
        provinceLists.clear();
        provinceLists.addAll(provinces);
        if (null != provinceLists && provinceLists.size() > 0) {
            int provincePosition = getProvincePosition();//默认位置
            if (cityCache.get(provinceLists.get(provincePosition).getName()) == null) {
                getCityData(provinceLists.get(provincePosition));//服务器获取城市数据
            } else {
                cityLists.clear();
                cityLists.addAll(cityCache.get(provinceLists.get(provincePosition).getName()));//城市缓存获取
            }
            int cityPosition = getCityPosition();//默认位置
            if (cityLists != null && cityLists.size() > 0) {
                if (countyCache.get(cityLists.get(cityPosition).getName()) != null) {//区域缓存获取
                    countyLists.clear();
                    countyLists.addAll(countyCache.get(cityLists.get(cityPosition).getName()));//缓存获取
                }
            }
            selectAddress(mContext, provincePosition, cityPosition);//打开对话框
        }
    }

    /**
     * 城市ui刷新
     *
     * @param cities
     */
    private void refreshCities(List<AreaBean.DataEntity> cities) {
        cityLists.clear();
        cityLists.addAll(cities);
        if (null != cityList) {
            cityList.setVisibility(View.VISIBLE);
        }
        if (operateCity == null) {
            operateCity = cityLists.get(0);
            cityAdapter.setCurrentChoise(0);
            cityList.setSelection(0);
            cityList.smoothScrollToPosition(0);
        } else {
            operateCity = cityLists.get(cityAdapter.getCurrentItem());
        }
        if (cityAdapter != null) {
            cityAdapter.notifyDataSetChanged();
        }
        if (!mHideCountyFlag) {
            updatecountyList();//联动刷新区域
        }

    }

    /**
     * 选择城市，联动刷新区域
     */
    private void updatecountyList() {
        countyLists.clear();
        if (areaAdapter != null) {
            if (choisProvince != operateProvince) {
                getCountyData(cityLists.get(0));
            } else {
                getCountyData(cityLists.get(cityAdapter.getCurrentItem()));
            }
        }
    }

    /**
     * 区域ui更新
     *
     * @param areas
     */
    private void refreshCountys(List<AreaBean.DataEntity> areas) {
        countyLists.clear();
        countyLists.addAll(areas);
        if (null != countyList) {
            countyList.setVisibility(View.VISIBLE);
        }
        if (areaAdapter != null) {
            areaAdapter.notifyDataSetChanged();
        }
    }

    /**
     * 地区选择对话框
     *
     * @param context
     */
    private void selectAddress(Context context, int provincePosition, int cityPosition) {
        if (null == provinceLists || provinceLists.size() == 0) {
            Toast.makeText(context, "未获取到省份", Toast.LENGTH_SHORT).show();
            return;
        }
        addressDialog = new Dialog(mContext);
        Window cityWindow = addressDialog.getWindow();
        cityWindow.setWindowAnimations(R.style.PopupAnimation);
        cityWindow.setBackgroundDrawable(new ColorDrawable(0));
        cityWindow.setContentView(R.layout.dialog_select_address_bak);
        cityWindow.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        cityWindow.setGravity(Gravity.TOP);
        addressDialog.setCancelable(true);
        provinceList = (ListView) addressDialog.findViewById(R.id.province_listView);
        provinceList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        cityList = (ListView) addressDialog.findViewById(R.id.city_listView);
        countyList = (ListView) addressDialog.findViewById(R.id.area_listView);
        tvArea = (TextView) addressDialog.findViewById(R.id.tv_area);
        rlArea = (RelativeLayout) addressDialog.findViewById(R.id.rl_area);
        if (mHideCountyFlag) {
            tvArea.setVisibility(View.GONE);
            rlArea.setVisibility(View.GONE);
        }
        AreaAdapter = new AreaAdapter(context);
        cityAdapter = new AreaAdapter(context);
        areaAdapter = new AreaAdapter(context);

        AreaAdapter.setDatas(provinceLists);
        AreaAdapter.setCurrentChoise(provincePosition);//设置默认位置
        cityAdapter.setDatas(cityLists);
        cityAdapter.setCurrentChoise(cityPosition);//设置默认位置
        areaAdapter.setDatas(countyLists);

        provinceList.setAdapter(AreaAdapter);
        provinceList.setSelection(provincePosition);//滚动到默认位置
        cityList.setAdapter(cityAdapter);
        cityList.setSelection(cityPosition);//滚动到默认位置
        countyList.setAdapter(areaAdapter);

        provinceList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AreaAdapter.setCurrentChoise(position);
                AreaAdapter.notifyDataSetChanged();
                String provinceName = provinceLists.get((int) id).getName();
                if (operateProvince != provinceLists.get((int) id)) {
                    operateProvince = provinceLists.get((int) id);
                    // 重置
                    operateCity = null;
                    operateCounty = null;
                }
                List<AreaBean.DataEntity> cityInProvince = cityCache.get(provinceName);
                if (cityInProvince != null) {
                    refreshCities(cityInProvince);//缓存中取
                } else {
                    getCityData(provinceLists.get((int) id));//服务器取
                }

            }
        });
        if (!mHideCountyFlag) {
            cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    cityAdapter.setCurrentChoise(position);
                    cityAdapter.notifyDataSetChanged();
                    operateCity = cityLists.get((int) id);
                    String cityName = cityLists.get((int) id).getName();
                    List<AreaBean.DataEntity> areaInCity = countyCache.get(cityName);
                    if (areaInCity != null) {
                        refreshCountys(areaInCity);//缓存中取
                    } else {
                        getCountyData(cityLists.get((int) id));//服务器取
                    }
                }

            });
            countyList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    operateCounty = countyLists.get((int) id);
                    updateAddress();//更新地址
                    addressDialog.dismiss();
                }
            });
        } else {
            cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    cityAdapter.setCurrentChoise(position);
                    cityAdapter.notifyDataSetChanged();
                    operateCity = cityLists.get((int) id);
                    updateAddress();//更新地址
                    addressDialog.dismiss();
                }

            });
        }


        addressDialog.show();
    }

    /**
     * 选择完区域更新地址ui
     */
    protected void updateAddress() {
        choisProvince = operateProvince;
        choisCity = operateCity;
        choisCounty = operateCounty;
        String addressStr = choisProvince.getName() + choisCity.getName() + (mHideCountyFlag ? "" : choisCounty.getName());
        mCallBack.updateAddress(addressStr);
    }

    public AreaBean.DataEntity getChoisCity() {
        return choisCity;
    }

    public AreaBean.DataEntity getChoisProvince() {
        return choisProvince;
    }

    public AreaBean.DataEntity getChoisCounty() {
        return choisCounty;
    }

    @Override
    public void getAddrSuc(AreaBean bean, String parentName, int type) {
        if (type == REQUEST_PROVINCE) { // 省
            List<AreaBean.DataEntity> provinces = new ArrayList<AreaBean.DataEntity>();
            for (AreaBean.DataEntity entity : bean.getData()) {
                provinces.add(entity);
            }
            if (provinces.size() > 0) {
                provinceCache.put("province", provinces);
            }
            operateProvince = provinces.get(0);
            refreshProvinces(provinces);
        } else if (type == REQUEST_CITY) { // 城市
            List<AreaBean.DataEntity> cities = new ArrayList<AreaBean.DataEntity>();
            for (AreaBean.DataEntity entity : bean.getData()) {
                cities.add(entity);
            }
            if (cities.size() > 0) {
                cityCache.put(parentName, cities);//放入缓存
                refreshCities(cities);//刷新界面
            } else {
                cityList.setVisibility(View.INVISIBLE);
            }
        } else { // 地区
            List<AreaBean.DataEntity> areas = new ArrayList<AreaBean.DataEntity>();
            for (AreaBean.DataEntity entity : bean.getData()) {
                areas.add(entity);
            }
            if (areas.size() > 0) {
                countyCache.put(parentName, areas);//放入缓存
                refreshCountys(areas);//刷新界面
            }
        }
    }

    @Override
    public void showMessage(String str) {

    }

    public interface AddressPickerCallBack {
        void updateAddress(String address);
    }
}
