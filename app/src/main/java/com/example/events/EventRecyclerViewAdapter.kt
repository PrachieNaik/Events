package com.example.events

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
var flag:Boolean=false

class EventRecyclerViewAdapter
    : RecyclerView.Adapter<EventRecyclerViewAdapter.EvenetVH>() {

    val eventList = ArrayList<Event>()

    fun updateList(list: List<Event>) {
        eventList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: EvenetVH, position: Int) {
        var event: Event? = eventList?.get(position)
        holder.bindItems(event)

        if (eventList[position].isChecked)
            flag = true
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EvenetVH {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.event_item, parent, false)
        return EvenetVH(v)
    }

    override fun getItemCount(): Int {
        return eventList.size
    }

    class EvenetVH(itemView: View): RecyclerView.ViewHolder(itemView)  {
        val titleEvent = itemView.findViewById(R.id.titleEvent) as TextView
        val descriptionEvenet = itemView.findViewById(R.id.descriptionEvent) as TextView
        var imageEvent:ImageView?=itemView.findViewById(R.id.imageEvent)
        var checkbox:CheckBox=itemView.findViewById(R.id.checkboxEvent)
        fun bindItems(event: Event?) {

            titleEvent.text = event?.name
            descriptionEvenet.text=event?.description
            Picasso.get().load(event?.image).into(imageEvent)

            checkbox.isChecked = flag

            checkbox.setOnClickListener {
                if (checkbox.isChecked)
                    event?.isChecked = true
            }
        }
    }

}
