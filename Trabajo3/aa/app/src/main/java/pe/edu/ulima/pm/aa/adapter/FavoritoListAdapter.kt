package pe.edu.ulima.pm.aa.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.pm.aa.R
import pe.edu.ulima.pm.aa.models.Favorito

class FavoritoListAdapter(
    private val productsList : List<Favorito>,
    private val fragment : Fragment,
    private val listener : (Favorito) -> Unit) :
    RecyclerView.Adapter<FavoritoListAdapter.ViewHolder>(){

    class ViewHolder(
        view : View, val listener : (Favorito) -> Unit,
        val productsList : List<Favorito>) : RecyclerView.ViewHolder(view), View.OnClickListener {

        val tviProductName : TextView


        init {

            tviProductName = view.findViewById(R.id.tviFavorito)

            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            listener(productsList[adapterPosition])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_favorito, parent, false)

        val viewHolder = ViewHolder(view, listener, productsList)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tviProductName.text = productsList[position].nombre


    }

    override fun getItemCount(): Int {
        return productsList.size
    }
}