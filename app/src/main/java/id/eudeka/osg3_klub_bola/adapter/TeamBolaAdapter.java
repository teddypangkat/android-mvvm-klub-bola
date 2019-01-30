package id.eudeka.osg3_klub_bola.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.eudeka.osg3_klub_bola.ClubItemClickListener;
import id.eudeka.osg3_klub_bola.R;
import id.eudeka.osg3_klub_bola.databinding.ItemRowBinding;
import id.eudeka.osg3_klub_bola.model.TeamDetail;

import java.util.List;

public class TeamBolaAdapter extends RecyclerView.Adapter<TeamBolaAdapter.TeamBolaHolder> {

    private ClubItemClickListener clubItemClickListener;
    private List<TeamDetail> listKlubBola;
    private LayoutInflater layoutInflater;

    public TeamBolaAdapter(ClubItemClickListener clubItemClickListener, List<TeamDetail> listKlubBola) {
        this.clubItemClickListener = clubItemClickListener;
        this.listKlubBola = listKlubBola;
    }

    @NonNull
    @Override
    public TeamBolaHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
            ItemRowBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_row, viewGroup, false);
            return new TeamBolaHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final TeamBolaHolder klubBolaHolder, final int i) {
        klubBolaHolder.binding.setTeamDetailVM(listKlubBola.get(i));

        ViewCompat.setTransitionName(klubBolaHolder.binding.itemClubImg, listKlubBola.get(i).getTeamLogo());
        klubBolaHolder.binding.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clubItemClickListener.onClubItemClick(listKlubBola.get(i), klubBolaHolder.binding.itemClubImg);

            }
        });
    }

    @Override
    public int getItemCount() {
        return listKlubBola.size();
    }

    class TeamBolaHolder extends RecyclerView.ViewHolder {

        private final ItemRowBinding binding;

        TeamBolaHolder(ItemRowBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.binding = itemRowBinding;
        }
    }

}
