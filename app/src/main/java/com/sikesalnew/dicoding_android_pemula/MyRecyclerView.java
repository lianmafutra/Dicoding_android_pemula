package com.sikesalnew.dicoding_android_pemula;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.sikesalnew.dicoding_android_pemula.Adapter.CardViewHeroAdapter;
import com.sikesalnew.dicoding_android_pemula.Adapter.GridHeroAdapter;
import com.sikesalnew.dicoding_android_pemula.Adapter.ListHeroAdapter;
import com.sikesalnew.dicoding_android_pemula.Model.Hero;

import java.util.ArrayList;

public class MyRecyclerView extends AppCompatActivity {

    private RecyclerView rvHeroes;
    private ArrayList<Hero> list = new ArrayList<>();
    ListHeroAdapter listHeroAdapter;
    CardViewHeroAdapter cardViewHeroAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_recycler_view);
        rvHeroes = findViewById(R.id.rv_hero);
        rvHeroes.setHasFixedSize(true);
        list.addAll(HeroesData.getlistdata());
        showRecyclerList();
    }


    private void showRecyclerList() {
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
         listHeroAdapter = new ListHeroAdapter(list);
        rvHeroes.setAdapter(listHeroAdapter);

        listHeroAdapter.setOnItemClickCallback(new ListHeroAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Hero data) {
                showSelectedHero(data);
            }
        });
    }

    private void showSelectedHero(Hero hero) {
        Toast.makeText(this, "Kamu memilih " + hero.getName(), Toast.LENGTH_SHORT).show();
    }


    private void showRecyclerGrid() {
        rvHeroes.setLayoutManager(new GridLayoutManager(this, 2));
        GridHeroAdapter gridHeroAdapter = new GridHeroAdapter(list);
        rvHeroes.setAdapter(gridHeroAdapter);
    }

    private void showRecyclerCardView() {
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        cardViewHeroAdapter = new CardViewHeroAdapter(list);
        rvHeroes.setAdapter(cardViewHeroAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_list:
                showRecyclerList();
                break;

            case R.id.action_grid:
                showRecyclerGrid();
                break;

            case R.id.action_cardview:
                showRecyclerCardView();
                break;
        }

    }
}
