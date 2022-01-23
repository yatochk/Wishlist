package com.yatochk.wishlistapp.ui.friends

import androidx.recyclerview.widget.DiffUtil
import com.yatochk.wishlistapp.data.friends.Friend


class FriendDiffUtil : DiffUtil.ItemCallback<Friend>() {
    override fun areItemsTheSame(oldItem: Friend, newItem: Friend): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Friend, newItem: Friend): Boolean {
        return oldItem == newItem
    }
}