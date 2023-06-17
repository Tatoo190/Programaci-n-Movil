package pe.edu.ulima.pm.aa.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Favorito (
    @PrimaryKey
    @ColumnInfo(name="nombre")
    val nombre: String,
)