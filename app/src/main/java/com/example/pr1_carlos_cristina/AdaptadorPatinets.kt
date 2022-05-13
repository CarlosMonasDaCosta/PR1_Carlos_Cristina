import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pr1_carlos_cristina.PatinetsVo
import com.example.pr1_carlos_cristina.R



class AdaptadorPatinets(var listaPatinets: ArrayList<PatinetsVo>) :
    RecyclerView.Adapter<AdaptadorPatinets.ViewHolderPatinets>() , View.OnClickListener{

    private var listener: View.OnClickListener? = null
    override fun onClick(view: View){
        if(listener!=null){
            listener!!.onClick(view)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPatinets {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_patinets, null, false)
        view.setOnClickListener(this)
        return ViewHolderPatinets(view)
    }

    override fun onBindViewHolder(holder: ViewHolderPatinets, position: Int) {
        holder.EtiNombre.text = listaPatinets[position].nombre
        holder.EtiInformacion.text = listaPatinets[position].info
        holder.foto.setImageResource(listaPatinets[position].foto)

    }

    override fun getItemCount(): Int {
        return listaPatinets.size
    }

    fun setOnClickListener(listener: View.OnClickListener?){
        this.listener = listener
    }

    inner class ViewHolderPatinets(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var EtiNombre: TextView
        var EtiInformacion: TextView
        var foto: ImageView

        init {
            EtiNombre = itemView.findViewById(R.id.idNombre)
            EtiInformacion = itemView.findViewById(R.id.idInfo)
            foto = itemView.findViewById<View>(R.id.idImagen) as ImageView
        }
    }



}