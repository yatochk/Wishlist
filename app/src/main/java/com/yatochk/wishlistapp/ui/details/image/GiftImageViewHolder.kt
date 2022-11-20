package com.yatochk.wishlistapp.ui.details.image

import androidx.recyclerview.widget.RecyclerView
import com.yatochk.wishlist.common.utils.loadImage
import com.yatochk.wishlistapp.databinding.ItemGiftImageBinding

class GiftImageViewHolder(
    private val binding: ItemGiftImageBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bindItem(item: GiftImageItem) {
        binding.giftImage.loadImage(item.imageUrl)
    }

}