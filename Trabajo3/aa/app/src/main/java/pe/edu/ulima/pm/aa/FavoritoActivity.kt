package pe.edu.ulima.pm.aa

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import pe.edu.ulima.pm.aa.fragments.FavoritoFragment
import pe.edu.ulima.pm.aa.models.Favorito
import pe.edu.ulima.pm.aa.models.FavoritoManager

class FavoritoActivity: AppCompatActivity(),FavoritoFragment.OnProductSelectedListener{
    private var fragments1 = mutableListOf<Fragment>()

    private lateinit var eteUsername : String
    var eteURL :Int = 0

    private lateinit var dlaMaina : DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listado_favorito)



        fragments1.add(FavoritoFragment())
        //fragments.add(Fragment_detalle())

        dlaMaina= findViewById<DrawerLayout>(R.id.dla)


        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.cont, fragments1[0])
        ft.addToBackStack(null)
        ft.commit()

    }
    override fun onBackPressed() {
        //    val ft = supportFragmentManager.beginTransaction()
        //    ft.replace(R.id.cont,fragments1[0])
        //    ft.commit()
        var intent : Intent = Intent()
        intent.setClass(this,LoginActivity::class.java)
        startActivity(intent)
    }

    override fun onSelected(favorito: Favorito) {

        //FavoritoManager(applicationContext).getInstance(applicationContext).eliminarFavorito(favorito)
        FavoritoManager(applicationContext).getInstance(applicationContext).getDB().favoritoDAO().eliminaUNO(favorito.nombre)
        var intent : Intent = Intent()
        intent.setClass(this, FavoritoActivity::class.java)
        val bundle : Bundle = Bundle()
        //bundle.putString("username",eteUsername.toString())
        startActivity(intent)
    }
}