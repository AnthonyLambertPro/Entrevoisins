package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.button.MaterialButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DataNeighbourActivity extends AppCompatActivity {

    @BindView(R.id.avatar)
    ImageView avatar;
    @BindView(R.id.nameLyt)
    TextInputLayout nameInput;
    @BindView(R.id.phoneNumberLyt)
    TextInputLayout phoneInput;
    @BindView(R.id.addressLyt)
    TextInputLayout addressInput;
    @BindView(R.id.aboutMeLyt)
    TextInputLayout aboutMeInput;

    private  String NEIGHBOUR_INTENT_POSITION = "POSITION";
    private Neighbour mNeighbour;

    private NeighbourApiService mApiService;
    private String mNeighbourImage;
    Intent intent = getIntent();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_neighbour);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mApiService = DI.getNeighbourApiService();
        init();
    }

    private void init() {
      //  mNeighbour = (Neighbour) intent.getSerializableExtra(NEIGHBOUR_INTENT_POSITION);
        mNeighbourImage = getImage();
        Glide.with(this).load(mNeighbourImage).placeholder(R.drawable.ic_account)
                .apply(RequestOptions.circleCropTransform()).into(avatar);


    }

    String getImage() {
        return "https://i.pravatar.cc/150?u="+ System.currentTimeMillis();
    }




    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_neighbour);

        ButterKnife.bind(this);


        // Get list of Neighbour
        mApiService = DI.getNeighbourApiService();

        // Get info Neighbour to display from intent
        Intent intent = getIntent();


            mNeighbour = (Neighbour) intent.getSerializableExtra(NEIGHBOUR_INTENT_POSITION);
        }*/
    }













