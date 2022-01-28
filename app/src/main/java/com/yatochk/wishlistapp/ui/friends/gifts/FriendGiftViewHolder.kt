package com.yatochk.wishlistapp.ui.friends.gifts

import androidx.recyclerview.widget.RecyclerView
import com.yatochk.wishlist.gifts.api.gift.data.Gift
import com.yatochk.wishlistapp.databinding.FriendGiftItemBinding


class FriendGiftViewHolder(
    private val binding: FriendGiftItemBinding,
    private val openLinkListener: (String) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(gift: Gift) {
        binding.name.text = gift.name
        binding.root.setOnClickListener {
            openLinkListener(gift.link)
        }
    }
}