package com.example.pr1_carlos_cristina

import AdaptadorPatinets
import android.R.*
import android.content.Intent
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Patinets_disponibles.newInstance] factory method to
 * create an instance of this fragment.
 */
class Patinets_disponibles : Fragment(){

    val ARG_PARAM1 = "param1"
    val ARG_PARAM2 = "param2"

    private var param1: String? = null
    private var param2: String? = null



    var listaPatinets: ArrayList<PatinetsVo>? = null
    var recyclerPatinets: RecyclerView? = null





    @JvmName("newInstance1")
    fun newInstance(param1: String?, param2: String?): Patinets_disponibles? {
        val fragment = Patinets_disponibles()
        val args = Bundle()
        args.putString(ARG_PARAM1, param1)
        args.putString(ARG_PARAM2, param2)
        fragment.setArguments(args)
        return fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    private fun llenarPatinets() {
        listaPatinets!!.add(PatinetsVo("Scotter1", "info", R.drawable.patin_e1))
        listaPatinets!!.add(PatinetsVo("Scooter2", "info", R.drawable.patin_e2))
        listaPatinets!!.add(PatinetsVo("Scooter3", "info", R.drawable.patin_e1))
        listaPatinets!!.add(PatinetsVo("Scooter4", "info", R.drawable.patin_e1))
        listaPatinets!!.add(PatinetsVo("Scooter5", "info", R.drawable.patin_e1))
        listaPatinets!!.add(PatinetsVo("Scooter6", "info", R.drawable.patin_e1))
        listaPatinets!!.add(PatinetsVo("Scooter7", "info", R.drawable.patin_e1))
        listaPatinets!!.add(PatinetsVo("Scooter8", "info", R.drawable.patin_e1))
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var root = view
        root = inflater.inflate(R.layout.fragment_patinets_disponibles,container,false)
        listaPatinets = ArrayList()
        recyclerPatinets = root.findViewById<View>(R.id.RecyclerId) as RecyclerView
        recyclerPatinets!!.layoutManager = LinearLayoutManager(context)
        llenarPatinets()
        val adapter = AdaptadorPatinets(listaPatinets!!)

        recyclerPatinets?.let {
            it.setAdapter(adapter)
        }

        adapter.setOnClickListener { view ->
            var intent: Intent
            intent = Intent(context,Detail::class.java)

            intent.putExtra("CLAVE",listaPatinets!!.
            get(recyclerPatinets!!.getChildAdapterPosition(view)).nombre)

            intent.putExtra("IMAGEN",listaPatinets!!.
            get(recyclerPatinets!!.getChildAdapterPosition(view)).foto)

            context?.startActivity(intent)

        }


        // Inflate the layout for this fragment
        return root
    }





    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentVerde.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Patinets_disponibles().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}