package com.yatochk.wishlistapp.ui.user.gifts

import androidx.recyclerview.widget.RecyclerView
import com.yatochk.wishlistapp.data.gift.Gift
import com.yatochk.wishlistapp.databinding.GiftItemBinding


class GiftViewHolder(
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