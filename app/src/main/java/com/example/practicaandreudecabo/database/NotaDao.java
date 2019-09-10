package com.example.practicaandreudecabo.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.practicaandreudecabo.model.Nota;

import java.util.List;

@Dao
public interface NotaDao {
    @Query("SELECT * FROM note")
    List<Nota> getNotes();

    @Query("SELECT * FROM note WHERE id LIKE :uuid")
    Nota getNote(String uuid);

    @Insert
    void addNote(Nota book);

    @Delete
    void deleteNote(Nota book);

    @Update
    void updateNote(Nota book);

}
