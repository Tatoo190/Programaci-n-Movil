package pe.edu.ulima.pm.aa.room

import androidx.room.Database
import androidx.room.RoomDatabase
import pe.edu.ulima.pm.aa.models.Favorito
import pe.edu.ulima.pm.aa.models.Pokemon

@Database(entities = [Favorito::class],version = 1)
abstract class FavoritoAppDatabse : RoomDatabase() {
    abstract fun favoritoDAO() : FavoritoDAO
}