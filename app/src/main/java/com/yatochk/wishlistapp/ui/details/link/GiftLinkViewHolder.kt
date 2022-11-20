package com.yatochk.wishlistapp.ui.details.link

import androidx.recyclerview.widget.RecyclerView
import com.yatochk.wishlistapp.databinding.ItemGiftLinkBinding

class GiftLinkViewHolder(
    private val binding: ItemGiftLinkBinding,
    private val linkClickListener: (String) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bindItem(item: GiftLinkItem) {
        binding.price.text = item.price
        binding.containerLink.setOnClickListener {
            linkClickListener(item.link)
        }
    }

}