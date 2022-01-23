package com.yatochk.wishlistapp.ui.friends

import androidx.recyclerview.widget.RecyclerView
import com.yatochk.wishlistapp.data.friends.Friend
import com.yatochk.wishlistapp.databinding.FriendItemBinding
import com.yatochk.wishlistapp.utils.capitalize

class FriendViewHolder(
    private val binding: FriendItemBinding,
    private val onFriendClickListener: (Friend) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(friend: Friend) {
        binding.name.text = friend.name.capitalize()
        binding.giftCount.text = friend.giftCount.toString()
        binding.root.setOnClickListener {
            onFriendClickListener(friend)
        }
    }
}