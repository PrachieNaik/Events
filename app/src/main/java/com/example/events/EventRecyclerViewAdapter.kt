package com.example.events

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class EventRecyclerViewAdapter
    : RecyclerView.Adapter<EventRecyclerViewAdapter.EventVH>() {

    val eventList = ArrayList<Event>()

    fun updateList(list:List<Event>) {
        eventList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: EventVH, position: Int) {
        var event: Event? = eventList?.get(position)

        holder.bindItems(event)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventVH {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.event_item, parent, false)
        return EventVH(v)
    }

    override fun getItemCount(): Int {
        return eventList.size
    }

    class EventVH(itemView: View): RecyclerView.ViewHolder(itemView)  {
        val titleEvent = itemView.findViewById(R.id.titleEvent) as TextView
        val descriptionEvenet = itemView.findViewById(R.id.descriptionEvent) as TextView
        var imageEvent:ImageView?=itemView.findViewById(R.id.imageEvent)
        var checkbox:CheckBox=itemView.findViewById(R.id.checkboxEvent)
        fun bindItems(event: Event?) {

            titleEvent.text = event?.name
            descriptionEvenet.text=event?.description
            Picasso.get().load(event?.image).into(imageEvent)

            checkbox.isChecked = event!!.isChecked

            checkbox.setOnClickListener {
                event?.isChecked = checkbox.isChecked
            }
        }
    }

}
