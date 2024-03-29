package com.jlkf.donglianrider.ui.view.jdaddressselector;

import android.content.Context;

import com.jlkf.donglianrider.ui.view.jdaddressselector.model.City;
import com.jlkf.donglianrider.ui.view.jdaddressselector.model.City_Table;
import com.jlkf.donglianrider.ui.view.jdaddressselector.model.County_Table;
import com.jlkf.donglianrider.ui.view.jdaddressselector.model.Street_Table;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.list.FlowQueryList;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;

//import com.jlkf.donglianrider.ui.view.jdaddressselector.model.City_Table;
import com.jlkf.donglianrider.ui.view.jdaddressselector.model.County;
//import com.jlkf.donglianrider.ui.view.jdaddressselector.model.County_Table;
import com.jlkf.donglianrider.ui.view.jdaddressselector.model.Province;
import com.jlkf.donglianrider.ui.view.jdaddressselector.model.Street;
//import com.jlkf.donglianrider.ui.view.jdaddressselector.model.Street_Table;

//import com.jlkf.donglianrider.ui.view.jdaddressselector.model.City;
//import com.jlkf.donglianrider.ui.view.jdaddressselector.model.County;
//import com.jlkf.donglianrider.ui.view.jdaddressselector.model.Province;
//import com.jlkf.donglianrider.ui.view.jdaddressselector.model.Street;


public class DefaultAddressProvider implements AddressProvider {
    public DefaultAddressProvider(Context context) {
        FlowManager.init(new FlowConfig.Builder(context.getApplicationContext()).build());
    }

    @Override
    public void provideProvinces(final AddressReceiver<Province> addressReceiver) {
        final FlowQueryList<Province> provinceQueryList = SQLite.select()
                .from(Province.class)
                .flowQueryList();
        addressReceiver.send(new ArrayList<>(provinceQueryList));
    }

    @Override
    public void provideCitiesWith(int provinceId, final AddressReceiver<City> addressReceiver) {
        final FlowQueryList<City> cityQueryList = SQLite.select()
                .from(City.class)
                .where(City_Table.province_id.eq(provinceId))
                .flowQueryList();
        addressReceiver.send(new ArrayList<>(cityQueryList));
    }

    @Override
    public void provideCountiesWith(int cityId, final AddressReceiver<County> addressReceiver) {
        final FlowQueryList<County> countyQueryList = SQLite.select()
                .from(County.class)
                .where(County_Table.city_id.eq(cityId))
                .flowQueryList();
        addressReceiver.send(new ArrayList<>(countyQueryList));
    }

    @Override
    public void provideStreetsWith(int countyId, final AddressReceiver<Street> addressReceiver) {
        final FlowQueryList<Street> streetQueryList = SQLite.select()
                .from(Street.class)
                .where(Street_Table.county_id.eq(countyId))
                .flowQueryList();
        addressReceiver.send(new ArrayList<>(streetQueryList));
    }
}
