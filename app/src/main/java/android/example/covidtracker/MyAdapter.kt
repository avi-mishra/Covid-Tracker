package android.example.covidtracker

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.mylayout.view.*

class MyAdapter(var cases:ArrayList<RVDataClass>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.mylayout,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.d("Tag","${cases.get(position)}")
        holder.itemView.tvStates.text= cases.get(position).state.toString()
        holder.itemView.tvActive.text=cases.get(position).active.toString()
        holder.itemView.tvConfirmed.text= cases.get(position).confirmed.toString()
        holder.itemView.tvRecovered.text=cases.get(position).recovered.toString()
        holder.itemView.tvDeaths.text= cases.get(position).deaths.toString()
    }

    override fun getItemCount(): Int {
       return cases.size
    }
}