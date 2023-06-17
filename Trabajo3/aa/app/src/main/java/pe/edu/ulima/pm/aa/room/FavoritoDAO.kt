package pe.edu.ulima.pm.aa.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import pe.edu.ulima.pm.aa.models.Favorito
import pe.edu.ulima.pm.aa.models.Pokemon
@Dao
interface FavoritoDAO {
    @Query("SELECT  * FROM Favorito")
    fun findAll() : List<Favorito>
    @Query("DELETE FROM Favorito")
    fun deleteAll()
    @Query("DELETE FROM Favorito WHERE nombre=:nombre")
    fun eliminaUNO(nombre: String)
    @Insert
    fun insert(favorito: Favorito)
}