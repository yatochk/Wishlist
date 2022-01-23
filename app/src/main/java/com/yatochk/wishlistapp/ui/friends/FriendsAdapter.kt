package com.yatochk.wishlistapp.ui.friends

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.yatochk.wishlistapp.data.friends.Friend
import com.yatochk.wishlistapp.databinding.FriendItemBinding

class FriendsAdapter(
    private val layoutInflater: LayoutInflater,
    private val onFriendClickListener: (Friend) -> Unit
) : ListAdapter<Friend, FriendViewHolder>(FriendDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        val binding = FriendItemBinding.inflate(layoutInflater, parent, false)
        return FriendViewHolder(binding, onFriendClickListener)
    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}