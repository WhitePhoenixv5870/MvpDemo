package com.jlkf.donglianrider.ui.view.jdaddressselector;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.jlkf.donglianrider.ui.view.jdaddressselector.model.City;
import com.jlkf.donglianrider.ui.view.jdaddressselector.model.County;
import com.jlkf.donglianrider.ui.view.jdaddressselector.model.Province;
import com.jlkf.donglianrider.ui.view.jdaddressselector.model.Street;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;



/**
 * Created by win7 on 2018/12/20.
 *仿京东地址选择器 地区数据工具类 (assets city1,json)
 * 该工具类使用方法 1.new JDAddressSelectorUtils(); 2.setOnAddressSelectedListener
 *
 * 原生第三方使用方法:
 * BottomDialog dialog = new BottomDialog(context);
 * dialog.setOnAddressSelectedListener(listener);
 * dialog.show();
 */

public  class JDAddressSelectorUtils {
    private List<ProvinceBean> options1Items=new ArrayList<>();
    private List<List<CityBean>> options2Items=new ArrayList<>();
    private List<List<List<AreaBean>>> options3Items=new ArrayList<>();
    private JDAddressSelectorUtils mUtils;
    private AddressSelector mSelector;
    private BottomDialog mDialog;

    public JDAddressSelectorUtils(Context context){

        //初始化数据
        getAddressData(context);
    }

    public void getAddressData(Context context){
        try {
            InputStreamReader isr = new InputStreamReader(context.getResources().getAssets().open("city1.json"), "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = br.readLine()) != null) {
                builder.append(line);
            }
            br.close();
            isr.close();
            JSONArray array = new JSONArray(builder.toString());         //从JSONObject中取出数组对象

            //省
            for (int i = 0; i < array.length(); i++) {

                JSONArray jsonArray = array.getJSONObject(i).getJSONArray("cities");
                ProvinceBean provinceBean = new ProvinceBean();
                provinceBean.setName(array.getJSONObject(i).getString("areaName"));
                Integer areaId_p = Integer.valueOf(array.getJSONObject(i).getString("areaId"));
                provinceBean.setId(areaId_p);
                options1Items.add(provinceBean);
                List<CityBean> stringList=new ArrayList<>();
                List<List<AreaBean>> listList=new ArrayList<>();
                for (int j = 0; j < jsonArray.length(); j++) {


                    CityBean cityBean = new CityBean();
                    cityBean.setName(jsonArray.getJSONObject(j).getString("areaName"));
                    Integer areaId_c = Integer.valueOf(jsonArray.getJSONObject(j).getString("areaId"));
                    cityBean.setId(areaId_c);
                    cityBean.setProvince_id(areaId_p);
                    stringList.add(cityBean);


                    List<AreaBean> stringListCity=new ArrayList<>();

                    for (int k = 0; k < jsonArray.getJSONObject(j).getJSONArray("counties").length(); k++) {
                        AreaBean areaBean = new AreaBean();
                        areaBean.setName(jsonArray.getJSONObject(j).getJSONArray("counties").getJSONObject(k).getString("areaName"));
                        areaBean.setId(Integer.valueOf(jsonArray.getJSONObject(j).getJSONArray("counties").getJSONObject(k).getString("areaId")));
                        areaBean.setCity_id(areaId_c);
//                        stringListCity.add(jsonArray.getJSONObject(j).getJSONArray("counties").getJSONObject(k).getString("areaName"));
                        stringListCity.add(areaBean);
                    }
                    listList.add(stringListCity);

                }
                options3Items.add(listList);
                options2Items.add(stringList);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setOnAddressSelectedListener(Context context, final OnAddressSelectedListener onAddressSelectedListener){
        mSelector = new AddressSelector(context);
        //改变选中字体颜色
        // selector_text_color_tab
        //
        // R.layout.address_selector
        mSelector.setAddressProvider(new AddressProvider() {
            @Override
            public void provideProvinces(AddressReceiver<Province> addressReceiver) {
//                List<Province> provinces = addressApi.provincesFromDatabase();
                List<Province> provinces = new ArrayList<>();

                for (int i = 0; i < options1Items.size(); i++) {
                    Province province = new Province();
                    options1Items.get(i).getName();
                    options1Items.get(i).getId();
                    Log.d("activity=", "name="+options1Items.get(i).getName()+"                 id="+options1Items.get(i).getId());
                    province.id = options1Items.get(i).getId();
                    province.name = options1Items.get(i).getName();
                    provinces.add(province);
                }
//                province.name = "测试省";
//                province.id = 1;
//                provinces.add(province);
//                List<Province> provinces1 = Collections.singletonList(province);
//                addressReceiver.send();

                addressReceiver.send(provinces);

            }

            @Override
            public void provideCitiesWith(final int provinceId, AddressReceiver<City> addressReceiver) {
//                new Thread(() -> {
//
//
////                    List<City> cities = addressApi.citiesSync(provinceId);
//
//                }).start();
                List<City> cities = new ArrayList<>();
                for (int i = 0; i < options2Items.size(); i++) {
                    List<CityBean> cityBeans = options2Items.get(i);
                    for (int j = 0; j < cityBeans.size(); j++) {
                        int province_id = cityBeans.get(j).getProvince_id();

                        if (provinceId == province_id) {
                            City cityBean = new City();
                            int id = cityBeans.get(j).getId();
                            String name = cityBeans.get(j).getName();

                            cityBean.id=id;
                            cityBean.name=name;
                            cityBean.province_id=province_id;
                            cities.add(cityBean);
                        }
                    }
                }
//                City city = new City();
//                city.name = "测试城市";
//                city.id = 2;
//                city.province_id =provinceId;
//                cities.add(city);
                addressReceiver.send(cities);

            }

            @Override
            public void provideCountiesWith(int cityId, AddressReceiver<County> addressReceiver) {
//                addressApi.counties(cityId)
//                        .subscribeOn(Schedulers.io())
//                        .subscribe(
//                                counties -> addressReceiver.send(counties),
//                                throwable -> addressReceiver.send(null)
//                        );
                List<County> counties = new ArrayList<>();

                for (int i = 0; i < options3Items.size(); i++) {
                    List<List<AreaBean>> lists = options3Items.get(i);
                    for (int j = 0; j < lists.size(); j++) {
                        List<AreaBean> areaBeans = lists.get(j);
                        for (int k = 0; k < areaBeans.size(); k++) {
                            int city_id = areaBeans.get(k).getCity_id();

                            if (city_id == cityId) {
                                County county = new County();
                                county.city_id = cityId;
                                county.name = areaBeans.get(k).getName();
                                county.id = areaBeans.get(k).getId();
                                counties.add(county);
                            }
                        }
                    }
                }

//                County city = new County();
//                city.name = "测试区域";
//                city.id = 2;
//                city.city_id =cityId;
//                counties.add(city);


                addressReceiver.send(counties);
//                County county = new County();
//                county.city_id = cityId;
//                county.id = 3;
//                county.name = "测试用乡镇";
//                addressReceiver.send(Collections.singletonList(county));
            }

            @Override
            public void provideStreetsWith(int countyId, AddressReceiver<Street> addressReceiver) {
                // blahblahblah
//                Street street = new Street();
//                street.county_id = countyId;
//                street.id = 4;
//                street.name = "测试用街道";
                addressReceiver.send(null);
            }
        });


        mSelector.setOnAddressSelectedListener(new OnAddressSelectedListener() {
            @Override
            public void onAddressSelected(Province province, City city, County county, Street street) {
                onAddressSelectedListener.onAddressSelected(province,city,county,street);
//                if (mDialog != null) {
//                    mDialog.dismiss();
//                }
            }

            @Override
            public void dissmiss() {
                if (mDialog != null) {
                    mDialog.dismiss();
                }
            }
        });

        View view1 = mSelector.getView();
        mDialog = new BottomDialog(context);
        mDialog.setContentView(view1);
        mDialog.show();
    }


    class ProvinceBean{
        String name;
        int id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    class CityBean{
        String name;
        int id;
        public int province_id;

        public int getProvince_id() {
            return province_id;
        }

        public void setProvince_id(int province_id) {
            this.province_id = province_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    class AreaBean{
        String name;
        int id;
        public int city_id;

        public int getCity_id() {
            return city_id;
        }

        public void setCity_id(int city_id) {
            this.city_id = city_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
