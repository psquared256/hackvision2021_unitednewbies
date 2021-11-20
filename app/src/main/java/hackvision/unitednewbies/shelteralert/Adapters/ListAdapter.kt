package hackvision.unitednewbies.shelteralert.Adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hackvision.unitednewbies.shelteralert.R

class ListAdapter(private val data: List<String>, private val listener: (String) -> Unit) : RecyclerView.Adapter<ListAdapter.ViewHolder>()  {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.list_row, parent, false) as View
        return ViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)

    }

    inner class ViewHolder(private val v: View) : RecyclerView.ViewHolder(v) {
        private val q: TextView = v.findViewById(R.id.q)

        fun bind(item: String) {
            q.text = item
            //a.text = item.a
            val deleteBtn = v.findViewById<ImageView>(R.id.deleteQ)
            deleteBtn.setOnClickListener{ listener(item)  }

        }
    }

}