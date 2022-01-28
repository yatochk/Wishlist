package com.yatochk.wishlistapp.ui.user.gifts

import androidx.recyclerview.widget.RecyclerView
import com.yatochk.wishlist.gifts.api.gift.data.Gift
import com.yatochk.wishlistapp.databinding.GiftItemBinding


class UserGiftViewHolder(
    private val binding: GiftItemBinding,
    private val openLinkListener: (String) -> Unit,
    private val deleteListener: (Gift) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(gift: Gift) {
        binding.name.text = gift.name
        binding.root.setOnClickListener {
            openLinkListener(gift.link)
        }
        binding.delete.setOnClickListener {
            deleteListener(gift)
        }
    }
}