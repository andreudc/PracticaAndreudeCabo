package com.example.practicaandreudecabo.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity(tableName = "note")
public class Nota {
    @PrimaryKey
    @NonNull
    private String id;
    @ColumnInfo(name = "content")
    private String message;

    public Nota() {
        id = UUID.randomUUID().toString();
    }
    public Nota(String message) {
        id = UUID.randomUUID().toString();
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
