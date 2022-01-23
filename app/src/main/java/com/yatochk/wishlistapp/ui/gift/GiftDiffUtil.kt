package com.yatochk.wishlistapp.ui.gift

import androidx.recyclerview.widget.DiffUtil
import com.yatochk.wishlistapp.data.Gift


class GiftDiffUtil : DiffUtil.ItemCallback<Gift>() {
    override fun areItemsTheSame(oldItem: Gift, newItem: Gift): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Gift, newItem: Gift): Boolean {
        return oldItem == newItem
    }
}