package com.yatochk.wishlistapp.ui.friends

import androidx.recyclerview.widget.RecyclerView
import com.yatochk.wishlistapp.data.friends.Friend
import com.yatochk.wishlistapp.databinding.FriendItemBinding

class FriendViewHolder(
    private val binding: FriendItemBinding,
    private val onFriendClickListener: (Friend) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(friend: Friend) {
        binding.name.text = friend.name
        binding.giftCount.text = friend.giftCount.toString()
        onFriendClickListener(friend)
    }
}