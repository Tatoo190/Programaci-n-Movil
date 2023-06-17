package pe.edu.ulima.pm.aa.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.pm.aa.R
import pe.edu.ulima.pm.aa.adapter.FavoritoListAdapter
import pe.edu.ulima.pm.aa.models.Favorito
import pe.edu.ulima.pm.aa.models.FavoritoManager

class FavoritoFragment : Fragment(){
    interface OnProductSelectedListener {
        fun onSelected(favorito : Favorito)
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
        return inflater.inflate(R.layout.fragment_favorito, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rviFav= view.findViewById<RecyclerView>(R.id.rviFavoritos)
        rviFav.adapter = FavoritoListAdapter(FavoritoManager(requireContext()).getInstance(requireContext()).getFavoritos(),this)
        { fv: Favorito ->
            Log.i("ProductsFragment", fv.nombre)
            listener?.onSelected(fv)
        }
    }
}