package pe.edu.ulima.pm.aa.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.pm.aa.R
import pe.edu.ulima.pm.aa.adapter.PokemonListAdapter
import pe.edu.ulima.pm.aa.models.Pokemon
import pe.edu.ulima.pm.aa.models.PokemonManager

class PokemonFragment : Fragment(){
    interface OnProductSelectedListener {
        fun onSelect(videogame : Pokemon)
    }
    private var listener : OnProductSelectedListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnProductSelectedListener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pokemones, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //GET PRODUCTS BY ROOM -> PRODUCTS BY RETROFIT
        PokemonManager(requireActivity().applicationContext).getProductsByRoom({ vgList : List<Pokemon> ->
            val rviProducts = view.findViewById<RecyclerView>(R.id.rviPokemones)
            rviProducts.adapter = PokemonListAdapter(
                vgList,
                this
            ) { product: Pokemon ->
                listener?.onSelect(product)
            }
        }, { error ->
            Toast.makeText(activity, "Error: " + error, Toast.LENGTH_SHORT).show()
        })


    }
}