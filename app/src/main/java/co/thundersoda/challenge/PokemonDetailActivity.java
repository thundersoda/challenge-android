package co.thundersoda.challenge;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.squareup.picasso.Picasso;

import java.util.List;

import co.thundersoda.challenge.model.Attack;
import co.thundersoda.challenge.model.Pokemon;
import co.thundersoda.challenge.model.Resistance;
import co.thundersoda.challenge.model.Weakness;

public class PokemonDetailActivity extends AppCompatActivity {
    String urlImage;
    Context context;
    Pokemon pokemon;
    ImageView preview;
    LinearLayout pokeAttackList, weaknessSection, resistanceSection;
    TextView pokeName, pokeType, pokeAttackTitle, pokeHp, pokeLevel, pokeWeakness, pokeResistance, pokeArtist;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);
        context = PokemonDetailActivity.this;

        //Toolbar setup
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.setTitleTextColor(Color.WHITE);
        getSupportActionBar().setTitle("Details");

        preview = findViewById(R.id.preview);
        pokeHp = findViewById(R.id.pokemon_health);
        pokeName = findViewById(R.id.pokemon_name);
        pokeType = findViewById(R.id.pokemon_type);
        pokeLevel = findViewById(R.id.pokemon_level);
        pokeArtist = findViewById(R.id.pokemon_artist);
        pokeWeakness = findViewById(R.id.pokemon_weakness);
        weaknessSection = findViewById(R.id.weakness_section);
        pokeResistance = findViewById(R.id.pokemon_resistance);
        pokeAttackList = findViewById(R.id.pokemon_attack_list);
        pokeAttackTitle = findViewById(R.id.pokemon_attack_title);
        resistanceSection = findViewById(R.id.resistance_section);

        //Get the pokemon object with attributes
        Intent intent = getIntent();
        if (intent.hasExtra("pokemon")) {
            pokemon = (Pokemon) intent.getSerializableExtra("pokemon");
        }
        
        //With this method we update elements with values from object
        displayData(pokemon);
    }

    public void displayData(Pokemon pokemon) {
        pokeName.setText(pokemon.getName());
        pokeArtist.setText("Artist: " + pokemon.getArtist());
        urlImage = pokemon.getImages().getLarge();

        //Display the types of the specific pokemon
        List<String> type = pokemon.getTypes();
        int arraySize = type.size();

        //Append into string to show in a textview
        StringBuilder sb = new StringBuilder();
        boolean separator = false;
        for (int i = 0; i < arraySize; i++) {
            if (separator)
                sb.append(',');
                sb.append(' ');
            separator = true;
            sb.append(type.get(i));
        }
        //Set the types to the textview
        pokeType.setText(sb.toString());

        //check if weaknesses element is in the JSON
        if (pokemon.getWeaknesses() != null) {
            weaknessSection.setVisibility(View.VISIBLE);
            StringBuilder weaknessBuilder = new StringBuilder();
            for (Weakness weakness : pokemon.getWeaknesses()) {
                weaknessBuilder.append(weakness.getType() + " " + weakness.getValue() + "\n");
            }
            pokeWeakness.setText(weaknessBuilder);
        }

        //check if resistances element is in the JSON
        if (pokemon.getResistances() != null) {
            resistanceSection.setVisibility(View.VISIBLE);
            StringBuilder resistBuilder = new StringBuilder();

            for (Resistance resistance : pokemon.getResistances()) {
                resistBuilder.append(resistance.getType() + " " + resistance.getValue() + "\n");
            }
            pokeResistance.setText(resistBuilder);
        }

        // For the attack moves we add views dinamically based on every object inside the array
        // If the list contains lots of objects this should be changed to a list with custom adapter
        for (Attack attack : pokemon.getAttacks()) {
            //Inflating the view
            View view;
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.attack_item, null);

            //Declaration and set of properties and values
            TextView attackTitle = view.findViewById(R.id.attack_title);
            TextView attackInfo = view.findViewById(R.id.attack_info);
            attackTitle.setText(attack.getName());
            attackInfo.setText(attack.getText());
            pokeAttackList.addView(view);
        }

        // Picasso library to display images
        Picasso.get()
            .load(urlImage)
            .into(preview);
    }
}
