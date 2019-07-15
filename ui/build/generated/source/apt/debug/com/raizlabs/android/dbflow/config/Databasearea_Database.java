package com.raizlabs.android.dbflow.config;

import com.jlkf.donglianrider.ui.view.jdaddressselector.global.Database;
import com.jlkf.donglianrider.ui.view.jdaddressselector.model.City;
import com.jlkf.donglianrider.ui.view.jdaddressselector.model.City_Adapter;
import com.jlkf.donglianrider.ui.view.jdaddressselector.model.County;
import com.jlkf.donglianrider.ui.view.jdaddressselector.model.County_Adapter;
import com.jlkf.donglianrider.ui.view.jdaddressselector.model.Province;
import com.jlkf.donglianrider.ui.view.jdaddressselector.model.Province_Adapter;
import com.jlkf.donglianrider.ui.view.jdaddressselector.model.Street;
import com.jlkf.donglianrider.ui.view.jdaddressselector.model.Street_Adapter;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;

/**
 * This is generated code. Please do not modify */
public final class Databasearea_Database extends DatabaseDefinition {
  public Databasearea_Database(DatabaseHolder holder) {
    holder.putDatabaseForTable(County.class, this);
    holder.putDatabaseForTable(Street.class, this);
    holder.putDatabaseForTable(City.class, this);
    holder.putDatabaseForTable(Province.class, this);
    models.add(County.class);
    modelTableNames.put("County", County.class);
    modelAdapters.put(County.class, new County_Adapter(holder, this));
    models.add(Street.class);
    modelTableNames.put("Street", Street.class);
    modelAdapters.put(Street.class, new Street_Adapter(holder, this));
    models.add(City.class);
    modelTableNames.put("City", City.class);
    modelAdapters.put(City.class, new City_Adapter(holder, this));
    models.add(Province.class);
    modelTableNames.put("Province", Province.class);
    modelAdapters.put(Province.class, new Province_Adapter(holder, this));
  }

  @Override
  public final Class getAssociatedDatabaseClassFile() {
    return Database.class;
  }

  @Override
  public final boolean isForeignKeysSupported() {
    return false;
  }

  @Override
  public final boolean isInMemory() {
    return false;
  }

  @Override
  public final boolean backupEnabled() {
    return false;
  }

  @Override
  public final boolean areConsistencyChecksEnabled() {
    return false;
  }

  @Override
  public final int getDatabaseVersion() {
    return 1;
  }

  @Override
  public final String getDatabaseName() {
    return "area";
  }
}
