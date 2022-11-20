package com.yatochk.wishlistapp.ui.details.reservation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.yatochk.recycler_adapter.AdapterDelegate
import com.yatochk.wishlistapp.databinding.ItemGiftReservationBinding

class GiftReservationAdapterDelegate(
    private val checkListener: (Boolean) -> Unit
) : AdapterDelegate<GiftReservationItem, GiftReservationViewHolder>(
    GiftReservationItem::class.java
) {
    override fun onCreateViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup
    ): GiftReservationViewHolder {
        return GiftReservationViewHolder(
            ItemGiftReservationBinding.inflate(layoutInflater, parent, false),
            checkListener
        )
    }

    override fun onBindViewHolder(holder: GiftReservationViewHolder, data: GiftReservationItem) {
        holder.bindItem(data)
    }

}