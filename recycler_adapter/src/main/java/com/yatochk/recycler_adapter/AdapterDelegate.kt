package com.yatochk.recycler_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class AdapterDelegate<T, VH : RecyclerView.ViewHolder>(val itemClass: Class<T>) {
    abstract fun onCreateViewHolder(layoutInflater: LayoutInflater, parent: ViewGroup): VH
    abstract fun onBindViewHolder(holder: VH, data: T)
}