package com.jlkf.donglianrider.ui.view.jdaddressselector;


//import com.jlkf.donglianrider.ui.view.jdaddressselector.model.City;
//import com.jlkf.donglianrider.ui.view.jdaddressselector.model.County;
//import com.jlkf.donglianrider.ui.view.jdaddressselector.model.Province;
//import com.jlkf.donglianrider.ui.view.jdaddressselector.model.Street;


import com.jlkf.donglianrider.ui.view.jdaddressselector.model.City;
import com.jlkf.donglianrider.ui.view.jdaddressselector.model.County;
import com.jlkf.donglianrider.ui.view.jdaddressselector.model.Province;
import com.jlkf.donglianrider.ui.view.jdaddressselector.model.Street;

public interface OnAddressSelectedListener {
    void onAddressSelected(Province province, City city, County county, Street street);
    void dissmiss();
}
