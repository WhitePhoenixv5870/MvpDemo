package com.jlkf.donglianrider.ui.view.jdaddressselector.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import com.jlkf.donglianrider.ui.view.jdaddressselector.global.Database;

@Table(database = Database.class)
public class Province extends BaseModel {
    @PrimaryKey
    public int id;
    @Column
    public String name;
}