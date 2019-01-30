package id.eudeka.osg3_klub_bola.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import id.eudeka.osg3_klub_bola.Injection;
import id.eudeka.osg3_klub_bola.R;
import id.eudeka.osg3_klub_bola.adapter.TeamBolaAdapter;
import id.eudeka.osg3_klub_bola.databinding.ActivityMainBinding;

import id.eudeka.osg3_klub_bola.model.TeamDetail;
import id.eudeka.osg3_klub_bola.navigator.TeamNavigator;
import id.eudeka.osg3_klub_bola.viewmodel.TeamViewModel;

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
