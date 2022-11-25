package com.yatochk.wishlistapp.ui.details

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import androidx.core.view.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.yatochk.recycler_adapter.CompositeAdapter
import com.yatochk.wishlist.common.ui.BaseActivity
import com.yatochk.wishlist.common.utils.dpToPixel
import com.yatochk.wishlist.common.utils.loadImage
import com.yatochk.wishlist.gifts.api.gift.data.Gift
import com.yatochk.wishlistapp.databinding.ActivityGiftDetailsBinding
import com.yatochk.wishlistapp.domain.RemoveUserGiftUseCase
import com.yatochk.wishlistapp.ui.details.header.GiftHeaderAdapterDelegate
import com.yatochk.wishlistapp.ui.details.link.GiftLinkAdapterDelegate
import com.yatochk.wishlistapp.ui.details.reservation.GiftReservationAdapterDelegate
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class GiftDetailsActivity : BaseActivity<ActivityGiftDetailsBinding>() {

    companion object {
        private const val GIFT_EXTRA = "gift_key"

        fun newIntent(context: Context, gift: Gift): Intent {
            return Intent(context, GiftDetailsActivity::class.java).apply {
                putExtra(GIFT_EXTRA, gift)
            }
        }
    }

    @Inject
    lateinit var removeUserGiftUseCase: RemoveUserGiftUseCase

    @Inject
    lateinit var giftDetailsUseCaseFactory: GetGiftDetailsUseCaseFactory

    private val gift: Gift? get() = intent?.getSerializableExtra(GIFT_EXTRA) as? Gift

    private val giftDetailsUseCase by lazy { giftDetailsUseCaseFactory.create(gift) }

    private val adapter by lazy { createRecyclerAdapter() }

    override fun getViewBinding(inflater: LayoutInflater): ActivityGiftDetailsBinding {
        return ActivityGiftDetailsBinding.inflate(inflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding?.apply {
            setupNoLimitStatusBar()
            setupRecycler()
            initViews()
            initImage(gift)
        }
        updateItems(giftDetailsUseCase.getDetailsItems())
    }

    private fun ActivityGiftDetailsBinding.initImage(gift: Gift?) {
        if (gift != null && gift.imageUrl.isNotBlank()) {
            giftImage.isVisible = true
            giftImage.loadImage(gift.imageUrl)
            toolbar.minimumHeight = dpToPixel(156f)
        } else {
            giftImage.isVisible = false
            toolbar.minimumHeight = dpToPixel(56f)
        }
    }

    private fun ActivityGiftDetailsBinding.initViews() {
        buttonEdit.setOnClickListener(::onClickEdit)
        buttonDelete.setOnClickListener(::onClickDelete)
    }

    private fun ActivityGiftDetailsBinding.setupRecycler() {
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this@GiftDetailsActivity)
    }

    private fun ActivityGiftDetailsBinding.setupNoLimitStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
        root.applyInsets()
    }

    private fun View.applyInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(this) { _, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
            binding?.toolbar?.updatePadding(
                top = insets.top,
                left = insets.left,
                right = insets.right
            )
            binding?.scrim?.updateLayoutParams {
                height = insets.top + dpToPixel(56f)
            }
            WindowInsetsCompat.CONSUMED
        }
    }

    private fun updateItems(items: List<Any>) {
        adapter.submitList(items)
    }

    private fun createRecyclerAdapter() = CompositeAdapter.Builder(layoutInflater).initDelegates {
        addDelegate(GiftHeaderAdapterDelegate())
        addDelegate(GiftLinkAdapterDelegate(::onClickLink))
        addDelegate(GiftReservationAdapterDelegate(::onReservation))
    }

    private fun onReservation(isChecked: Boolean) {

    }

    private fun onClickEdit(view: View) {

    }

    private fun onClickDelete(view: View) {
        showConfirmDelete()
    }

    private fun onClickLink(link: String) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(link)))
    }

    private fun showConfirmDelete() {
        MaterialAlertDialogBuilder(this)
            .setTitle("Удаление подарка")
            .setPositiveButton("Удалить") { _, _ ->
                gift?.let { removeUserGiftUseCase.remove(it) }
                finish()
            }
            .setNegativeButton("Отменить") { dialogInterface, _ ->
                dialogInterface.dismiss()
            }
            .show()
    }

}