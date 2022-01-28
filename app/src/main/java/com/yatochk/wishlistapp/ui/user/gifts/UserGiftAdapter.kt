package com.yatochk.wishlistapp.ui.user.gifts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.yatochk.wishlist.gifts.api.gift.data.Gift
import com.yatochk.wishlistapp.databinding.GiftItemBinding

class UserGiftAdapter(
    private val layoutInflater: LayoutInflater,
    private val openLinkListener: (String) -> Unit,
    private val deleteListener: (Gift) -> Unit
) : ListAdapter<Gift, UserGiftViewHolder>(GiftDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserGiftViewHolder {
        val binding = GiftItemBinding.inflate(layoutInflater, parent, false)
        return UserGiftViewHolder(binding, openLinkListener, deleteListener)
    }

    override fun onBindViewHolder(holderUser: UserGiftViewHolder, position: Int) {
        holderUser.bind(getItem(position))
    }
}
