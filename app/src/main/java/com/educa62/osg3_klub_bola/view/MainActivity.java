package com.educa62.osg3_klub_bola.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.EditText;

import com.educa62.osg3_klub_bola.Injection;
import com.educa62.osg3_klub_bola.R;
import com.educa62.osg3_klub_bola.adapter.TeamBolaAdapter;
import com.educa62.osg3_klub_bola.databinding.ActivityMainBinding;
import com.educa62.osg3_klub_bola.model.Team;
import com.educa62.osg3_klub_bola.model.TeamDetail;
import com.educa62.osg3_klub_bola.navigator.TeamNavigator;
import com.educa62.osg3_klub_bola.viewmodel.TeamViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TeamNavigator {


    private TeamViewModel mTeamViewModel;
    private RecyclerView recTeam;

    private TeamBolaAdapter adapter;
    private List<TeamDetail> dataListTeamBola;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mTeamViewModel = new TeamViewModel(Injection.provideTeamRepository(this), this);
        dataListTeamBola = new ArrayList<>();
        mTeamViewModel.setNavigator(this);
        mTeamViewModel.getListTeam();

        binding.setVm(mTeamViewModel);
        initAdapter();
    }

    @Override
    public void loadListTeam(List<TeamDetail> listTeam) {
        dataListTeamBola.addAll(listTeam);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void errorLoadListTeam(String message) {
        Log.e("ERROR", message);
    }

    private void initAdapter() {
        adapter = new TeamBolaAdapter(dataListTeamBola);
        recTeam = binding.recyclerTeamBola;
        recTeam.setLayoutManager(new LinearLayoutManager(this));
        recTeam.addItemDecoration(new DividerItemDecoration(this,   DividerItemDecoration.VERTICAL));
        recTeam.setAdapter(adapter);
    }
}
