package com.educa62.osg3_klub_bola.data;

import com.educa62.osg3_klub_bola.model.Team;

public interface TeamDataSource {

    void getListTeams(GetTeamsCallback callback);


    interface GetTeamsCallback {
        void onTeamLoaded(Team data);
        void onDataNotAvailable(String errorMessage);
    }


}
