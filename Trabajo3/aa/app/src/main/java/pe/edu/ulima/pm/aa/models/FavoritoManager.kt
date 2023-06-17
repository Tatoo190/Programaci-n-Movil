package pe.edu.ulima.pm.aa.models

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import pe.edu.ulima.pm.aa.room.FavoritoAppDatabse

class FavoritoManager(context: Context):AppCompatActivity(){
    val db= Room.databaseBuilder(context, FavoritoAppDatabse::class.java,"db_favorito").allowMainThreadQueries().build()
    private val mFavoritos = arrayListOf<Favorito>()
    init {
        mFavoritos.add(Favorito("pikachu"))

    }

    companion object {
        private var instance : FavoritoManager? = null
    }

    fun getInstance(context: Context) : FavoritoManager {
        if (instance == null) {
            instance = FavoritoManager(context)
        }
        return instance!!
    }
    fun getDB():FavoritoAppDatabse{
        return db
    }
    fun crearFavorito(nombre: String){
        //mFavoritos.add(Favorito(nombre))
        var pokemoncito= Favorito(nombre)
        db.favoritoDAO().insert(pokemoncito)
    }

    fun eliminarFavorito(nombre: Favorito){
        mFavoritos.remove(nombre)
    }

    fun getFavoritos() : ArrayList<Favorito> {
        return db.favoritoDAO().findAll() as ArrayList<Favorito>
    }
}