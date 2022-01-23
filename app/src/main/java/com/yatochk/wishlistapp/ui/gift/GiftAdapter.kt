package com.yatochk.wishlistapp.ui.gift

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.yatochk.wishlistapp.data.Gift
import com.yatochk.wishlistapp.databinding.GiftItemBinding

class GiftAdapter(
    private val layoutInflater: LayoutInflater,
    private val openLinkListener: (String) -> Unit
) : ListAdapter<Gift, GiftViewHolder>(GiftDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GiftViewHolder {
        val binding = GiftItemBinding.inflate(layoutInflater, parent, false)
        return GiftViewHolder(binding, openLinkListener)
    }

    override fun onBindViewHolder(holder: GiftViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
