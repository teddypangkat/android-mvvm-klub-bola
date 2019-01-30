package id.eudeka.osg3_klub_bola.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.educa62.osg3_klub_bola.R;
import com.educa62.osg3_klub_bola.databinding.ItemRowBinding;
import id.eudeka.osg3_klub_bola.model.TeamDetail;

import java.util.List;

public class TeamBolaAdapter extends RecyclerView.Adapter<TeamBolaAdapter.TeamBolaHolder> {

    private List<TeamDetail> listKlubBola;
    private LayoutInflater layoutInflater;

    public TeamBolaAdapter(List<TeamDetail> listKlubBola) {
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
    public void onBindViewHolder(@NonNull TeamBolaHolder klubBolaHolder, int i) {
          klubBolaHolder.binding.setTeamDetailVM(listKlubBola.get(i));
    }

    @Override
    public int getItemCount() {
        return listKlubBola.size();
    }

    public class TeamBolaHolder extends RecyclerView.ViewHolder {

        private final ItemRowBinding binding;

        public TeamBolaHolder(ItemRowBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.binding = itemRowBinding;
        }
    }

}
