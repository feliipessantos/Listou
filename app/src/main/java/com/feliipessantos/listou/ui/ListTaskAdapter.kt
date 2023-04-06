package com.feliipessantos.listou.ui

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.feliipessantos.listou.databinding.ListItemTaskBinding

class ListTaskAdapter(private val context: Context, private val list: MutableList<String>) : BaseAdapter() {
    override fun getCount(): Int = list.size

    override fun getItem(position: Int): Any = list[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding: ListItemTaskBinding = convertView?.let {
            ListItemTaskBinding.bind(it)
        } ?: ListItemTaskBinding.inflate(LayoutInflater.from(context), parent, false)

        binding.textViewItem.text = list[position]

        binding.btRemove.setOnClickListener {
            list.removeAt(position)
            notifyDataSetChanged()
        }

        return binding.root
    }
}