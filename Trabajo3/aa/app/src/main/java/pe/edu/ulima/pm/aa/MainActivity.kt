package pe.edu.ulima.pm.aa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import pe.edu.ulima.pm.aa.fragments.Fragment_detalle
import pe.edu.ulima.pm.aa.fragments.PokemonFragment
import pe.edu.ulima.pm.aa.models.Pokemon

class MainActivity : AppCompatActivity(),PokemonFragment.OnProductSelectedListener{
    private var fragments = mutableListOf<Fragment>()

    private lateinit var eteUsername : String
    var eteURL :Int = 0
    var HP:Int = 0
    var Ataque: Int = 0
    var Defensa:Int = 0
    var DefensaE:Int = 0

    private lateinit var dlaMain : DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listado_pokemones)



        fragments.add(PokemonFragment())
        //fragments.add(Fragment_detalle())

        dlaMain= findViewById<DrawerLayout>(R.id.dlaMain)


        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.flaContent1, fragments[0])
        ft.addToBackStack(null)
        ft.commit()

    }

    override fun onBackPressed() {
        //val ft = supportFragmentManager.beginTransaction()
        //ft.replace(R.id.flaContent1,fragments[0])
        //ft.commit()
        var intent : Intent = Intent()
        intent.setClass(this,LoginActivity::class.java)
        startActivity(intent)
    }

    override fun onSelect(videogame: Pokemon) {
        val urlPartes:List<String> = videogame.url.split("/")
        val id= urlPartes[urlPartes.size-2].toInt()
        //eteUsername = videogame.getName().toString()
        //eteURL =videogame.getId()
        //HP= videogame.getId()*20
        //Ataque = videogame.getId()*5
        //Defensa = videogame.getId()*10
        //DefensaE= (videogame.getId()*10)+5

        eteUsername = videogame.name.toString()
        eteURL =id
        HP= id*20
        Ataque = id*5
        Defensa = id*10
        DefensaE= (id*10)+5
        var intent : Intent = Intent()
        intent.setClass(this, Fragment_detalle::class.java)
        val bundle : Bundle = Bundle()
        //bundle.putString("username",eteUsername.toString())
        intent.putExtra("username",eteUsername)
        intent.putExtra("id",eteURL)
        intent.putExtra("HP",HP)
        intent.putExtra("Ataque",Ataque)
        intent.putExtra("Defensa",Defensa)
        intent.putExtra("Defensa2",DefensaE)
        startActivity(intent)
    }

}