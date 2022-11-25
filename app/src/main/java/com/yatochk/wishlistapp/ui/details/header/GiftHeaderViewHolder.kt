package com.yatochk.wishlistapp.ui.details.header

import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.yatochk.wishlistapp.databinding.ItemGiftHeaderBinding

class GiftHeaderViewHolder(
    private val binding: ItemGiftHeaderBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bindItem(item: GiftHeaderItem) {
        binding.header.text = item.name
        binding.header.isVisible = item.name.isNotBlank()
        binding.description.text = item.description
        binding.description.isVisible = item.description.isNotBlank()
    }

}