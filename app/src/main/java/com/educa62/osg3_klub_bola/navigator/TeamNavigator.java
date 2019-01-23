package com.educa62.osg3_klub_bola.navigator;

import com.educa62.osg3_klub_bola.model.Team;
import com.educa62.osg3_klub_bola.model.TeamDetail;

import java.util.List;

public interface TeamNavigator {

    void loadListTeam(List<TeamDetail> listTeam);
    void errorLoadListTeam(String message);
}
