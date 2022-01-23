package com.yatochk.wishlistapp.ui.friends.gifts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.yatochk.wishlistapp.data.gift.Gift
import com.yatochk.wishlistapp.databinding.FriendGiftItemBinding
import com.yatochk.wishlistapp.databinding.GiftItemBinding
import com.yatochk.wishlistapp.ui.friends.FriendViewHolder
import com.yatochk.wishlistapp.ui.user.gifts.GiftDiffUtil

class FriendGiftAdapter(
    private val layoutInflater: LayoutInflater,
    private val openLinkListener: (String) -> Unit
) : ListAdapter<Gift, FriendGiftViewHolder>(GiftDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendGiftViewHolder {
        val binding = FriendGiftItemBinding.inflate(layoutInflater, parent, false)
        return FriendGiftViewHolder(binding, openLinkListener)
    }

    override fun onBindViewHolder(holder: FriendGiftViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
