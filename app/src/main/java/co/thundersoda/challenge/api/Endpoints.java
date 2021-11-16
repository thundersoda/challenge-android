package co.thundersoda.challenge.api;

import co.thundersoda.challenge.model.MonResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Endpoints {

    public static final String BASE_URL = "https://api.pokemontcg.io/v2/";

    @GET("cards?subtype=Basic")
    Call<MonResponse> getPokemonList();

}
