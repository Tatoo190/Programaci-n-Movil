package pe.edu.ulima.pm.aa.models

import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import pe.edu.ulima.pm.aa.network.APIPokemonService
import pe.edu.ulima.pm.aa.room.PKAppDatabase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class PokemonManager(context: Context) : AppCompatActivity(){

    val db= Room.databaseBuilder(context,PKAppDatabase::class.java,"db_pokemon").allowMainThreadQueries().build()
    //API_URL = "https://script.google.com/macros/s/AKfycbzb-2sUkdSfChWed2aSLeYkJlEDAe1ZjSF6JNOwYYv-kovcgACIZxXyYz6DDZwyNHhr/"
    val API_URL="https://pokeapi.co/api/v2/"
    @GET("pokemon")
    fun getProductsRetrofit(callbackOK : (List<Pokemon>) -> Unit, callbackError : (String) -> Unit) {
        // Creamos el cliente retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(APIPokemonService::class.java)
        service.obtenerListaPokemon().enqueue(object : Callback<Ap>{
            override fun onResponse(
                call: Call<Ap>,
                response: Response<Ap>
            ) { //GUARDAMOS EN BD LOCAL
                saveIntoRoom(response.body()!!.getResults()!!)
                callbackOK(response.body()!!.getResults()!!)
               /* if(response.isSuccessful){
                    val pokemonRespuesta=response.body()!!
                    val listaPokemon = pokemonRespuesta.getResults()!!
                    val u=listaPokemon.size
                    //listaPokemonAdapter!!.adicionarListaPokemon(listaPokemon)
                    (0..19).forEach { a ->
                        val p= listaPokemon.get(a)

                        Log.i("POKEMONES", p.getId().toString())
                    }
                }else{
                    Log.e("MainActiv", response.errorBody().toString())
                }*/
            }

            override fun onFailure(call: Call<Ap>, t: Throwable) {
                Log.e("MainActv", t.message!!)
            }

        })

    }


    fun getProductsByRoom(callbackOK : (List<Pokemon>) -> Unit, callbackError : (String) -> Unit){

        val videogames :List<Pokemon> = db.videogameDAO().findAll()
        callbackOK(videogames)
    }

    private fun saveIntoRoom(pokemon: ArrayList<Pokemon>) {

        db.videogameDAO().deleteAll()
        pokemon.forEach{
            db.videogameDAO().insert(it)
        }
    }

}