package com.yatochk.wishlistapp.ui.user.gifts

import androidx.recyclerview.widget.RecyclerView
import com.yatochk.wishlist.common.utils.loadImage
import com.yatochk.wishlist.gifts.api.gift.data.Gift
import com.yatochk.wishlistapp.databinding.GiftItemBinding


class UserGiftViewHolder(
    private val binding: GiftItemBinding,
    private val openLinkListener: (String) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(gift: Gift) {
        binding.name.text = gift.name
        binding.foreground.setOnClickListener {
            openLinkListener(gift.link)
        }
        binding.giftImage.loadImage(gift.imageUrl)
        binding.description.text = gift.description
    }
}