package pe.edu.ulima.pm.aa.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import pe.edu.ulima.pm.aa.models.Pokemon

@Dao
interface PokemonDAO {
    @Query("SELECT  * FROM Pokemon")
    fun findAll() : List<Pokemon>
    @Query("DELETE FROM Pokemon")
    fun deleteAll()
    @Insert
    fun insert(videogame: Pokemon)
}