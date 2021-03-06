package com.hiroyaoooooo.customlistview

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView


class WordCountAdapter(private val activity: Activity, private val items: Array<Pair<String,Int>>) : BaseAdapter() {

    private class ViewHolder(row: View) {
        val wordTextView = row.findViewById(R.id.wordTextView) as TextView
        val countTextView  = row.findViewById(R.id.countTextView) as TextView
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val viewHolder: ViewHolder
        if (convertView == null) {
            val inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.word_count_list_item, convertView)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val item = items[position]
        viewHolder.wordTextView.text = item.first
        viewHolder.countTextView.text = item.second.toString()

        return view
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getCount(): Int {
        return items.size
    }
}