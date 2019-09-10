package com.example.practicaandreudecabo.controller;

import android.content.Context;

import androidx.room.Room;

import com.example.practicaandreudecabo.database.NotaDao;
import com.example.practicaandreudecabo.database.NotaDatabase;
import com.example.practicaandreudecabo.model.Nota;

import java.util.List;

public class NotaController {

    private static NotaController controller;
    private NotaDao mNotaDao;

    private NotaController(Context context) {
        Context appContext = context.getApplicationContext();
        NotaDatabase database = Room.databaseBuilder(appContext, NotaDatabase.class, "nota")
                .allowMainThreadQueries().build();
        mNotaDao = database.getNoteDao();
    }

    public static NotaController get(Context context) {
        if (controller == null) {
            controller = new NotaController(context);
        }
        return controller;
    }

    public List<Nota> getNotas() {
        return mNotaDao.getNotes();
    }

    public Nota getNota(String id) {
        return mNotaDao.getNote(id);
    }

    public void addNota(Nota nota) {
        mNotaDao.addNote(nota);
    }

    public void updateNota(Nota nota) {
        mNotaDao.updateNote(nota);
    }

    public void deleteNota(Nota nota) {
        mNotaDao.deleteNote(nota);
    }
}