package com.yatochk.wishlistapp.ui.details.header

import androidx.recyclerview.widget.RecyclerView
import com.yatochk.wishlist.common.utils.loadImage
import com.yatochk.wishlistapp.databinding.ItemGiftHeaderBinding

class GiftHeaderViewHolder(
    private val binding: ItemGiftHeaderBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bindItem(item: GiftHeaderItem) {
        binding.header.text = item.name
        binding.description.text = item.description
    }

}