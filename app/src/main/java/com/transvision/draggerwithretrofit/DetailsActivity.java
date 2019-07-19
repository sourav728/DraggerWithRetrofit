package com.transvision.draggerwithretrofit;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.transvision.draggerwithretrofit.model.Hero;

import java.util.List;

public class DetailsActivity extends AppCompatActivity {
    ImageView imageView;
    TextView movie, actor, team, created_by, publisher, des, des_underline;
    String name, realname, team_name, firstappearance, createdby, publisher_name, img_url, bio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        initialize();

        name = getIntent().getStringExtra("name");
        realname = getIntent().getStringExtra("realname");
        team_name = getIntent().getStringExtra("team");
        firstappearance = getIntent().getStringExtra("firstappearance");
        createdby = getIntent().getStringExtra("createdby");
        publisher_name = getIntent().getStringExtra("publisher");
        img_url = getIntent().getStringExtra("imageurl");
        bio = getIntent().getStringExtra("bio");

        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.download)
                .error(R.mipmap.ic_launcher_round);
        Glide.with(this).load(img_url).apply(options).into(imageView);
        //setting values into views
        des_underline.setPaintFlags(des_underline.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        movie.setText(name);
        actor.setText(realname);
        team.setText(team_name);
        created_by.setText(createdby);
        publisher.setText(publisher_name);
        des.setText(bio);
    }

    private void initialize() {
        imageView = findViewById(R.id.img_src);
        movie = findViewById(R.id.txt_movie_name);
        actor = findViewById(R.id.txt_actor_name);
        team = findViewById(R.id.txt_team);
        created_by = findViewById(R.id.txt_created_by);
        publisher = findViewById(R.id.txt_publisher);
        des_underline = findViewById(R.id.txt_des_underline);
        des = findViewById(R.id.txt_des);
    }
}
