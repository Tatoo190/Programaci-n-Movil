package pe.edu.ulima.pm.aa.network

import pe.edu.ulima.pm.aa.models.Ap
import retrofit2.Call
import retrofit2.http.GET

interface APIPokemonService {
    @GET("pokemon")
    fun obtenerListaPokemon(): Call<Ap>
}