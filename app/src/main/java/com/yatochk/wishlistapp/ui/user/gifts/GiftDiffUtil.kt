package com.yatochk.wishlistapp.ui.user.gifts

import androidx.recyclerview.widget.DiffUtil
import com.yatochk.wishlist.gifts.api.gift.data.Gift


class GiftDiffUtil : DiffUtil.ItemCallback<Gift>() {
    override fun areItemsTheSame(oldItem: Gift, newItem: Gift): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Gift, newItem: Gift): Boolean {
        return oldItem == newItem
    }
}