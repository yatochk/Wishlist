package com.yatochk.wishlistapp.ui.details.link

import android.view.LayoutInflater
import android.view.ViewGroup
import com.yatochk.recycler_adapter.AdapterDelegate
import com.yatochk.wishlistapp.databinding.ItemGiftLinkBinding

class GiftLinkAdapterDelegate(
    private val linkClickListener: (String) -> Unit
) : AdapterDelegate<GiftLinkItem, GiftLinkViewHolder>(
    GiftLinkItem::class.java
) {
    override fun onCreateViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup
    ): GiftLinkViewHolder {
        return GiftLinkViewHolder(
            ItemGiftLinkBinding.inflate(layoutInflater, parent, false),
            linkClickListener
        )
    }

    override fun onBindViewHolder(holder: GiftLinkViewHolder, data: GiftLinkItem) {
        holder.bindItem(data)
    }
}