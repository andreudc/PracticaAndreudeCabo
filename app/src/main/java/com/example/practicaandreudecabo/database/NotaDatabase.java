package com.example.practicaandreudecabo.database;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.practicaandreudecabo.model.Nota;



@Database(entities = {Nota.class}, version=1)
public abstract class NotaDatabase extends RoomDatabase {
    public abstract NotaDao getNoteDao();

}