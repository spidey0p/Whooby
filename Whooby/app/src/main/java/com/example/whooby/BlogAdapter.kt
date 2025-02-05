package com.example.whooby

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BlogAdapter(private val mList: List<BlogViewModel> , private  val recyclerView: RecyclerView) : RecyclerView.Adapter<BlogAdapter.ViewHolder>() {

    var mExpandedPosition=-1
    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.expand_cards, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]


        val isExpanded = position == mExpandedPosition
        holder.hiddenView.visibility = if (isExpanded) View.VISIBLE else View.GONE
        holder.itemView.isActivated = isExpanded
        holder.arrow.setOnClickListener{

                mExpandedPosition = if (isExpanded) -1 else position
                notifyItemChanged(position)

        }

        // sets the image to the imageview from our itemHolder class
        holder.imageView.setImageResource(ItemsViewModel.image)

        // sets the text to the textview from our itemHolder class
        holder.textView.text = ItemsViewModel.text

        //sets content
        holder.blogContent.text=ItemsViewModel.content



    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.icon)
        val textView: TextView = itemView.findViewById(R.id.heading)
        val arrow: ImageView = itemView.findViewById(R.id.arrow_button)
        val hiddenView: LinearLayout = itemView.findViewById(R.id.hidden_view)
        var blogContent : TextView = itemView.findViewById(R.id.dtex)
    }
}
