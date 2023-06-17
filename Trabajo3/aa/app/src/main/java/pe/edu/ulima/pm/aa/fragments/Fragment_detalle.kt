package pe.edu.ulima.pm.aa.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.bumptech.glide.Glide
import pe.edu.ulima.pm.aa.MainActivity
import pe.edu.ulima.pm.aa.R
import pe.edu.ulima.pm.aa.models.Favorito
import pe.edu.ulima.pm.aa.models.FavoritoManager
import pe.edu.ulima.pm.aa.models.Pokemon
import pe.edu.ulima.pm.aa.room.FavoritoAppDatabse
import pe.edu.ulima.pm.aa.room.PKAppDatabase

class Fragment_detalle: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        var valor = this.intent.extras!!.get("username")
        var url = this.intent.extras!!.get("id")
        var HP = this.intent.extras!!.get("HP")
        var Ataque = this.intent.extras!!.get("Ataque")
        var Defensa = this.intent.extras!!.get("Defensa")
        var Defensa2 = this.intent.extras!!.get("Defensa2")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)
        val tviProductName : TextView
        val tviProductImage: ImageView

        val tviProductPrice : TextView
        val tviAtaque: TextView
        val tviDefensa:TextView
        val tviDefendaE:TextView
        var awita = url
        tviProductImage= findViewById(R.id.imgDetalle)
        Glide.with(this).
        load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$awita.png").into(tviProductImage)


        tviProductPrice = findViewById(R.id.tviHP2)
        tviAtaque= findViewById(R.id.tviAtaque2)
        tviDefensa= findViewById(R.id.tviDefensa2)
        tviDefendaE= findViewById(R.id.tviDefensaEsp2)

        tviProductName= findViewById(R.id.tviPokeDetalle)
        tviProductName.setText(valor.toString())

        tviProductPrice.text ="HP :"+HP.toString()
        tviAtaque.text = "Ataque :"+Ataque.toString()
        tviDefensa.text = "Defensa :"+Defensa.toString()
        tviDefendaE.text = "Defensa Especial :"+Defensa2.toString()
        val butNuevoFavorito : Button = findViewById(R.id.butAgregarFav)
        butNuevoFavorito.setOnClickListener{_: View ->

            //PASAR AL ACTIVITY de favoritos
            var nombre = valor.toString()

            FavoritoManager(applicationContext).getInstance(applicationContext).crearFavorito(nombre)
            //FavoritoManager().getInstance().saveIntoRoom()
            var intent : Intent = Intent()
            intent.setClass(this, MainActivity::class.java)
            startActivity(intent)
        }
    }


}