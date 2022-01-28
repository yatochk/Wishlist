package com.yatochk.wishlistapp.ui.user.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yatochk.wishlist.common.ui.BaseFragment
import com.yatochk.wishlist.gifts.api.gift.data.Gift
import com.yatochk.wishlistapp.R
import com.yatochk.wishlistapp.databinding.FragmentGiftAddBinding
import com.yatochk.wishlistapp.domain.AddUserGiftUseCase
import com.yatochk.wishlistapp.ui.user.gifts.UserGiftsFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AddGiftFragment : BaseFragment<FragmentGiftAddBinding>() {

    companion object {
        fun newInstance() = AddGiftFragment()
    }

    @Inject
    lateinit var addUserGiftUseCase: AddUserGiftUseCase

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentGiftAddBinding {
        return FragmentGiftAddBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.listenButton()
    }

    private fun FragmentGiftAddBinding.listenButton() {
        createGift.setOnClickListener {
            val gift = Gift(
                name = editTextName.text.toString(),
                description = "А тут у нас лежит очень длинное описание подарка, что угодно сюда напишем, лишь бы влезало нормально",
                link = editTextLink.text.toString(),
                imageUrl = "https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/ipad-pro-12-11-select-202104_GEO_RU_FMT_WHH?wid=2000&hei=2000&fmt=jpeg&qlt=80&.v=1617865134000"
            )
            addUserGiftUseCase.add(gift)
            parentFragmentManager.beginTransaction()
                .replace(R.id.contentFragment, UserGiftsFragment())
                .commitAllowingStateLoss()
        }
    }

}