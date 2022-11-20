package com.yatochk.wishlistapp.ui.details.reservation

import androidx.recyclerview.widget.RecyclerView
import com.yatochk.wishlistapp.databinding.ItemGiftReservationBinding

class GiftReservationViewHolder(
    private val binding: ItemGiftReservationBinding,
    private val checkListener: (Boolean) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bindItem(item: GiftReservationItem) {
        binding.switchReservation.isChecked = item.isReserved
        binding.switchReservation.setOnCheckedChangeListener { _, isChcked ->
            checkListener(isChcked)
        }
        binding.root.setOnClickListener {
            binding.switchReservation.isChecked = !binding.switchReservation.isChecked
        }
    }

}