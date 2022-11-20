package com.yatochk.recycler_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CompositeAdapter(
    private val layoutInflater: LayoutInflater,
    private val delegates: List<AdapterDelegate<Any, RecyclerView.ViewHolder>>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<Any> = emptyList()

    fun submitList(newItems: List<Any>) {
        items = newItems
        notifyDataSetChanged()
    }

    private fun getDelegatesByViewType(viewType: Int): AdapterDelegate<Any, RecyclerView.ViewHolder> {
        return delegates[viewType]
    }

    private fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemViewType(position: Int): Int {
        val itemClass = getItem(position).javaClass
        return delegates.indexOfFirst { itemClass == it.itemClass }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return getDelegatesByViewType(viewType).onCreateViewHolder(layoutInflater, parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val delegates = getDelegatesByViewType(getItemViewType(position))
        delegates.onBindViewHolder(holder, getItem(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class Builder(
        private val layoutInflater: LayoutInflater,
    ) {
        private val delegates = arrayListOf<AdapterDelegate<Any, RecyclerView.ViewHolder>>()

        fun initDelegates(init: Builder.() -> Unit): CompositeAdapter {
            init()
            return CompositeAdapter(layoutInflater, delegates)
        }

        fun addDelegate(delegate: AdapterDelegate<*, out RecyclerView.ViewHolder>): Builder {
            delegates.add(delegate as AdapterDelegate<Any, RecyclerView.ViewHolder>)
            return this
        }
    }
}