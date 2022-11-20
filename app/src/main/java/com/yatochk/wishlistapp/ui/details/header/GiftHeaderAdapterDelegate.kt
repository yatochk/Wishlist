package com.yatochk.wishlistapp.ui.details.header

import android.view.LayoutInflater
import android.view.ViewGroup
import com.yatochk.recycler_adapter.AdapterDelegate
import com.yatochk.wishlistapp.databinding.ItemGiftHeaderBinding

class GiftHeaderAdapterDelegate : AdapterDelegate<GiftHeaderItem, GiftHeaderViewHolder>(
    GiftHeaderItem::class.java
) {
    override fun onCreateViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup
    ): GiftHeaderViewHolder {
        return GiftHeaderViewHolder(ItemGiftHeaderBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: GiftHeaderViewHolder, data: GiftHeaderItem) {
        holder.bindItem(data)
    }
}