package co.thundersoda.challenge;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import co.thundersoda.challenge.adapters.PokemonListAdapter;
import co.thundersoda.challenge.api.APIClient;
import co.thundersoda.challenge.interfaces.ClickListener;
import co.thundersoda.challenge.model.MonResponse;
import co.thundersoda.challenge.model.Pokemon;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements ClickListener {
    Context context;
    List<Pokemon> pkmnList;
    PokemonListAdapter adapter;
    RecyclerView pokemonListView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;

        //Toolbar setup
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.setTitleTextColor(Color.WHITE);
        getSupportActionBar().setTitle("Pokemon List");

        pokemonListView = findViewById(R.id.pokemonList);
        progressBar = findViewById(R.id.progress_bar);
        getList();
    }

    //method for making a request to the endpoint
    public void getList() {
        Call<MonResponse> call = APIClient.buildApi().getPokemonList();
        call.enqueue(new Callback<MonResponse>() {
            @Override
            public void onResponse(Call<MonResponse> call, Response<MonResponse> response) {
                if (!response.isSuccessful()) {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(context,
                            "Code: " + response.code() + " " + response.message(),
                            Toast.LENGTH_LONG).show();
                } else {
                    progressBar.setVisibility(View.GONE);
                    pokemonListView.setVisibility(View.VISIBLE);
                    MonResponse pokemon = response.body();
                    assert pokemon != null;
                    pkmnList = pokemon.getData();

                    //if the data isnt empty, we populate the items in the recyclerview
                    if (!pkmnList.isEmpty()) {
                        adapter = new PokemonListAdapter(pkmnList, MainActivity.this);
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                        pokemonListView.setLayoutManager(linearLayoutManager);
                        pokemonListView.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
                        pokemonListView.setAdapter(adapter);
                    } else {
                        Toast.makeText(context,
                                "La lista se encuentra vacía.",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                }
            }

            @Override
            public void onFailure(Call<MonResponse> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(context,
                        "Hubo un problema al obtener la lista de pkmn.",
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void didClickOnView(View view, int position) {
        Pokemon pokemon = pkmnList.get(position);
        Intent intent = new Intent(context, PokemonDetailActivity.class);
        intent.putExtra("pokemon", pokemon);
        context.startActivity(intent);
    }
}