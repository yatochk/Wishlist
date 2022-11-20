package com.yatochk.wishlistapp.ui.details.image

import android.view.LayoutInflater
import android.view.ViewGroup
import com.yatochk.recycler_adapter.AdapterDelegate
import com.yatochk.wishlistapp.databinding.ItemGiftImageBinding

class GiftImageAdapterDelegate : AdapterDelegate<GiftImageItem, GiftImageViewHolder>(
    GiftImageItem::class.java
) {
    override fun onCreateViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup
    ): GiftImageViewHolder {
        return GiftImageViewHolder(ItemGiftImageBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: GiftImageViewHolder, data: GiftImageItem) {
        holder.bindItem(data)
    }
}