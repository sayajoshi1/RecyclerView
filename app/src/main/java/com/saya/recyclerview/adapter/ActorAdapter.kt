package com.saya.recyclerview.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.saya.recyclerview.ActorDetailsActivity
import com.saya.recyclerview.R
import com.saya.recyclerview.model.Actors
import de.hdodenhof.circleimageview.CircleImageView

class ActorAdapter(
    val lstActors: ArrayList<Actors>,
    val context : Context
): RecyclerView.Adapter<ActorAdapter.ActorViewHolder>(){

    //chair banaune
    class ActorViewHolder(view: View): RecyclerView.ViewHolder(view){

        val imgProfile : CircleImageView
        val tvName : TextView
        val tvAddress: TextView
        val tvSalary: TextView

        init {
            imgProfile=view.findViewById(R.id.imgProfile)
            tvName=view.findViewById(R.id.tvName)
            tvAddress=view.findViewById(R.id.tvAddress)
            tvSalary=view.findViewById(R.id.tvSalary)
        }
    }
    //chair ma design populate gara
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.mero_actor_layout, parent,false)
        return ActorViewHolder(view)
    }

    override fun getItemCount(): Int {
        return lstActors.size
    }
//design ma data pupolate gara
    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        val actor= lstActors[position]
    holder.tvName.text=actor.actorName
    holder.tvAddress.text=actor.actorAddress
    holder.tvSalary.text=actor.actorSalary.toString()
   //load image with Glide library
    Glide.with(context)
        .load(actor.actorImage)
        .into(holder.imgProfile)

    //setting Click Listener in recycleviw's item
    holder.imgProfile.setOnClickListener{
        val intent = Intent(context,ActorDetailsActivity:: class.java)
        intent.putExtra("actor",actor)
        context.startActivity(intent)
//        Toast.makeText(context,"${actor.actorName} clicked",Toast.LENGTH_SHORT).show()
    }

}
}