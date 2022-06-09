package com.example.mirzanikolic;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MobileDao {
    @Insert
    void add(Mobile mobile);

    @Delete
    void delete(Mobile mobile);

    @Query("SELECT * FROM mobiles")
    List<Mobile> getAll();

    @Query("SELECT * FROM mobiles WHERE id=:id LIMIT 1")
    Mobile getMobileId(long id);

    @Update
    public void update(Mobile... mobile);
}
