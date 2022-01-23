package com.yatochk.wishlistapp.ui.user.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yatochk.wishlistapp.R
import com.yatochk.wishlistapp.data.Gift
import com.yatochk.wishlistapp.databinding.FragmentGiftAddBinding
import com.yatochk.wishlistapp.domain.AddUserGiftUseCase
import com.yatochk.wishlistapp.ui.BaseFragment
import com.yatochk.wishlistapp.ui.user.gifts.GiftsFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AddGiftFragment : BaseFragment<FragmentGiftAddBinding>() {

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
                editTextName.text.toString(),
                editTextLink.text.toString()
            )
            addUserGiftUseCase.add(gift)
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment, GiftsFragment())
                .commitAllowingStateLoss()
        }
    }

}