package pe.edu.ulima.pm.aa.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pe.edu.ulima.pm.aa.R
import pe.edu.ulima.pm.aa.models.Pokemon

class PokemonListAdapter (
    private val productsList : List<Pokemon>,
    private val fragment : Fragment,
    private val listener : (Pokemon) -> Unit) :
    RecyclerView.Adapter<PokemonListAdapter.ViewHolder>() {
    //AGREGADO


    class ViewHolder(
        view : View, val listener : (Pokemon) -> Unit,
        val productsList : List<Pokemon>) : RecyclerView.ViewHolder(view), View.OnClickListener {

        val iviProductImage : ImageView
        val tviProductName : TextView
        val tviProductPrice : TextView
        val tviAtaque: TextView
        val tviDefensa:TextView
        val tviDefendaE:TextView

        init {
            iviProductImage = view.findViewById(R.id.imgPokemon)
            tviProductName = view.findViewById(R.id.tviNombrePokemon)
            tviProductPrice = view.findViewById(R.id.tviHP)
            tviAtaque= view.findViewById(R.id.tviAtaque)
            tviDefensa= view.findViewById(R.id.tviDefensa)
            tviDefendaE= view.findViewById(R.id.tviSpecialD)
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            listener(productsList[adapterPosition])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pokemon, parent, false)

        val viewHolder = ViewHolder(view, listener, productsList)
        //agregado

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //holder.tviProductName.text = productsList[position].getName()
        //holder.tviProductPrice.text ="HP :"+ (productsList[position].getId()*20).toString()
        //holder.tviAtaque.text = "Ataque :"+(productsList[position].getId()*5).toString()
        //holder.tviDefensa.text = "Defensa :"+(productsList[position].getId()*10).toString()
        //holder.tviDefendaE.text = "Defensa Especial :"+((productsList[position].getId()*10)+5).toString()

        holder.tviProductName.text = productsList[position].name
        val urlPartes:List<String> = productsList[position].url.split("/")
        val id= urlPartes[urlPartes.size-2].toInt()
        holder.tviProductPrice.text ="HP :"+ (id*20).toString()
        holder.tviAtaque.text = "Ataque :"+(id*5).toString()
        holder.tviDefensa.text = "Defensa :"+(id*10).toString()
        holder.tviDefendaE.text = "Defensa Especial :"+((id*10)+5).toString()
        //val awita=productsList[position].getId()
        val awita=id
        Glide.with(fragment)
            .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$awita.png")
            .fitCenter()
            .into(holder.iviProductImage)

    }

    override fun getItemCount(): Int {
        return productsList.size
    }

}