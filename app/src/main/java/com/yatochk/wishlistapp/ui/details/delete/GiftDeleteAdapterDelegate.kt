package com.yatochk.wishlistapp.ui.details.delete

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yatochk.recycler_adapter.AdapterDelegate
import com.yatochk.wishlistapp.databinding.ItemGiftDeleteBinding

class GiftDeleteAdapterDelegate(
    private val deleteClickListener: (View) -> Unit
) : AdapterDelegate<GiftDeleteItem, GiftDeleteViewHolder>(GiftDeleteItem::class.java) {
    override fun onCreateViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup
    ): GiftDeleteViewHolder {
        return GiftDeleteViewHolder(
            ItemGiftDeleteBinding.inflate(layoutInflater, parent, false),
            deleteClickListener
        )
    }

    override fun onBindViewHolder(holder: GiftDeleteViewHolder, data: GiftDeleteItem) {
        holder.bindItem(data)
    }

}