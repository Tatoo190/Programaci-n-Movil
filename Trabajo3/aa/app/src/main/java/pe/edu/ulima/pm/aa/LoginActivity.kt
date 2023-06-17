package pe.edu.ulima.pm.aa

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LoginActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)




        val butContinuar : Button = findViewById(R.id.butContinuar)
        butContinuar.setOnClickListener{_: View ->

            //PASAR AL ACTIVITY MAIN
            var intent : Intent = Intent()
            intent.setClass(this,MainActivity::class.java)
            startActivity(intent)
        }

        val butFavorito : Button = findViewById(R.id.butFavoritos)
        butFavorito.setOnClickListener{_: View ->

            //PASAR AL ACTIVITY MAIN
            var intent : Intent = Intent()
            intent.setClass(this,FavoritoActivity::class.java)
            startActivity(intent)
        }

    }
}