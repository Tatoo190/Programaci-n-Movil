package pe.edu.ulima.pm.aa.room

import androidx.room.Database
import androidx.room.RoomDatabase
import pe.edu.ulima.pm.aa.models.Pokemon

@Database(entities = [Pokemon::class],version = 1)
abstract class PKAppDatabase : RoomDatabase() {
    abstract fun videogameDAO() : PokemonDAO
}