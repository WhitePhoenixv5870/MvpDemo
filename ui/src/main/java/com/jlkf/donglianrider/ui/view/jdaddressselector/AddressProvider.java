package com.jlkf.donglianrider.ui.view.jdaddressselector;

//import com.wxkj.relx.relx.view.jdaddressselector.model.City;
//import com.wxkj.relx.relx.view.jdaddressselector.model.County;
//import com.wxkj.relx.relx.view.jdaddressselector.model.Province;
//import com.wxkj.relx.relx.view.jdaddressselector.model.Street;

import com.jlkf.donglianrider.ui.view.jdaddressselector.model.City;
import com.jlkf.donglianrider.ui.view.jdaddressselector.model.County;
import com.jlkf.donglianrider.ui.view.jdaddressselector.model.Province;
import com.jlkf.donglianrider.ui.view.jdaddressselector.model.Street;

import java.util.List;

public interface AddressProvider {
    void provideProvinces(AddressReceiver<Province> addressReceiver);
    void provideCitiesWith(int provinceId, AddressReceiver<City> addressReceiver);
    void provideCountiesWith(int cityId, AddressReceiver<County> addressReceiver);
    void provideStreetsWith(int countyId, AddressReceiver<Street> addressReceiver);

    interface AddressReceiver<T> {
        void send(List<T> data);
    }
}