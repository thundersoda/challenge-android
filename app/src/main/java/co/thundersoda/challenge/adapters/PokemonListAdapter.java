package co.thundersoda.challenge.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import co.thundersoda.challenge.R;
import co.thundersoda.challenge.interfaces.ClickListener;
import co.thundersoda.challenge.model.Pokemon;

public class PokemonListAdapter extends RecyclerView.Adapter<PokemonListAdapter.ViewHolder> {

    public List<Pokemon> pokemons;
    public static ClickListener clickListener;
    
    public PokemonListAdapter(List<Pokemon> pokemons, ClickListener clickListener) {
        this.pokemons = pokemons;
        this.clickListener = clickListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView pokemonName, pokemonSupertype, pokemonRarity;

        public ViewHolder(View view) {
            super(view);
            pokemonName = view.findViewById(R.id.pokemon_name);
            pokemonRarity = view.findViewById(R.id.pokemon_rarity);
            pokemonSupertype = view.findViewById(R.id.pokemon_supertype);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.didClickOnView(view, getAdapterPosition());
                }
            });
        }

        public TextView getPokemonName() {
            return pokemonName;
        }

        public TextView getPokemonSupertype() {
            return pokemonSupertype;
        }

        public TextView getPokemonRarity() {
            return pokemonRarity;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_item, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Pokemon pokemon = pokemons.get(position);
        holder.getPokemonName().setText(pokemon.getName());
        holder.getPokemonSupertype().setText(pokemon.getSupertype());
        if (pokemon.getRarity() != null) {
            holder.getPokemonRarity().setText("Rarity: " + pokemon.getRarity());
        } else {
            holder.getPokemonRarity().setText("Rarity: Unknown");
        }
    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }
}
