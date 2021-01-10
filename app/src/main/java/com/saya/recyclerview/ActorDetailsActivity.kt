package com.saya.recyclerview

import android.location.Address
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.bumptech.glide.Glide
import com.saya.recyclerview.model.Actors
import de.hdodenhof.circleimageview.CircleImageView

class ActorDetailsActivity : AppCompatActivity() {
    private lateinit var imgProfile: CircleImageView
    private lateinit var tvName: TextView
    private lateinit var tvAddress: TextView
    private lateinit var tvSalary: TextView
    private lateinit var tvActorId: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actor_details)

        imgProfile= findViewById(R.id.imgProfile)
        tvName= findViewById(R.id.tvName)
        tvAddress= findViewById(R.id.tvAddress)
        tvSalary= findViewById(R.id.tvSalary)
        tvActorId= findViewById(R.id.tvActorid)

        //Receiving an object from intent
        val intent = intent.getParcelableExtra<Actors>("actor")
        if (intent != null){
            val actorID = intent.actorId
            val actorName = intent.actorName
            val actorAddress = intent.actorAddress
            val actorSalary= intent.actorSalary
            val actorImage = intent.actorImage

            tvActorId.text=actorID.toString()
            tvName.text=actorName
            tvAddress.text = actorAddress
            tvSalary.text=actorSalary.toString()

            Glide.with(this@ActorDetailsActivity)
                .load(actorImage)
                .into(imgProfile)

        }
    }
}