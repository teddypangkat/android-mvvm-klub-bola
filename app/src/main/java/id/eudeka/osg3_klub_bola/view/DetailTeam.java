package id.eudeka.osg3_klub_bola.view;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Callback;

import id.eudeka.osg3_klub_bola.R;
import id.eudeka.osg3_klub_bola.model.TeamDetail;

public class DetailTeam extends AppCompatActivity {

    private ImageView imageClub;
    private TextView textViewName, textViewDescription;
    private TeamDetail teamDetail;
    private Bundle extras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_team);
        supportPostponeEnterTransition();

        extras = getIntent().getExtras();
        teamDetail = (TeamDetail) extras.getSerializable(MainActivity.KEY_TEAM_DETAIL);

        imageClub = (ImageView) findViewById(R.id.club_img_detail);
        textViewName = (TextView) findViewById(R.id.club_name_detail);
        textViewDescription = (TextView) findViewById(R.id.club_description_detail);

        setClub();

        //untuk membuat tombol back button pada toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Detail Team");

    }

    private void setClub() {
        String imageUrl = teamDetail.getTeamLogo();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String imageTransitionName = extras.getString(MainActivity.KEY_TEAM_DETAIL_TRANSITION_NAME);
            imageClub.setTransitionName(imageTransitionName);
        }
        Picasso.get()
                .load(imageUrl)
                .noFade()
                .into(imageClub, new Callback() {
                    @Override
                    public void onSuccess() {
                        supportStartPostponedEnterTransition();
                    }

                    @Override
                    public void onError(Exception e) {
                        supportStartPostponedEnterTransition();
                    }
                });

        textViewName.setText(teamDetail.getTeamName());
        textViewDescription.setText(teamDetail.getTeamDescription());
    }

    //membuat animasi shared element ketika melakukan tombol back
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                supportFinishAfterTransition();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}