package com.moix.wearclass.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.moix.wearclass.R
import com.moix.wearclass.data.TableList

class TableAdapter(private val tableList: List<TableList>) : RecyclerView.Adapter<TableAdapter.TableViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TableViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return TableViewHolder(view)
    }

    override fun getItemCount(): Int = tableList.size ?: 0
    class TableViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val className: TextView = itemView.findViewById(R.id.table_class_name)
    }

    override fun onBindViewHolder(holder: TableAdapter.TableViewHolder, position: Int) {
        val textpos = tableList[position]
        holder.className.text = textpos.className
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "${holder.className.text}", Toast.LENGTH_SHORT)
                .show()
        }
    }
}