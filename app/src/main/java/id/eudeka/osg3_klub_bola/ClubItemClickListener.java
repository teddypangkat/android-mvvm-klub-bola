package id.eudeka.osg3_klub_bola;

import android.widget.ImageView;

import id.eudeka.osg3_klub_bola.model.TeamDetail;

public interface ClubItemClickListener {
    void onClubItemClick(TeamDetail clubItem, ImageView shareImageView);
}
