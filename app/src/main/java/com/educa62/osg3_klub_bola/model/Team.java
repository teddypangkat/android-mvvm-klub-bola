package com.educa62.osg3_klub_bola.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Team {

    @SerializedName("teams")
    List<TeamDetail> teams;

    public Team(List<TeamDetail> teams) {
        this.teams = teams;
    }

    public List<TeamDetail> getTeams() {
        return teams;
    }




}
