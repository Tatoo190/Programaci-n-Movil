package pe.edu.ulima.pm.aa.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Pokemon(
    @PrimaryKey(autoGenerate = true)
    val idi:Int,
    @ColumnInfo(name="name")
    val name:String,
    @ColumnInfo(name="url")
    val url:String
)