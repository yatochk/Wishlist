package com.yatochk.wishlistapp.ui.details

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import androidx.core.view.updatePadding
import androidx.recyclerview.widget.LinearLayoutManager
import com.yatochk.recycler_adapter.CompositeAdapter
import com.yatochk.wishlist.common.ui.BaseActivity
import com.yatochk.wishlist.common.utils.dpToPixel
import com.yatochk.wishlist.common.utils.loadImage
import com.yatochk.wishlist.gifts.api.gift.data.Gift
import com.yatochk.wishlistapp.databinding.ActivityGiftDetailsBinding
import com.yatochk.wishlistapp.ui.details.header.GiftHeaderAdapterDelegate
import com.yatochk.wishlistapp.ui.details.header.GiftHeaderItem
import com.yatochk.wishlistapp.ui.details.image.GiftImageAdapterDelegate
import com.yatochk.wishlistapp.ui.details.link.GiftLinkAdapterDelegate
import com.yatochk.wishlistapp.ui.details.link.GiftLinkItem


class GiftDetailsActivity : BaseActivity<ActivityGiftDetailsBinding>() {

    companion object {
        private const val GIFT_EXTRA = "gift_key"

        fun newIntent(context: Context, gift: Gift): Intent {
            return Intent(context, GiftDetailsActivity::class.java).apply {
                putExtra(GIFT_EXTRA, gift)
            }
        }
    }

    private val gift: Gift? get() = intent?.getSerializableExtra(GIFT_EXTRA) as? Gift

    private val adapter by lazy { createRecyclerAdapter() }

    override fun getViewBinding(inflater: LayoutInflater): ActivityGiftDetailsBinding {
        return ActivityGiftDetailsBinding.inflate(inflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupNoLimitStatusBar()
        binding?.recycler?.adapter = adapter
        binding?.recycler?.layoutManager = LinearLayoutManager(this)
        binding?.buttonDelete?.setOnClickListener(::onClickDelete)
        gift?.let {
            binding?.giftImage?.loadImage(it.imageUrl)
            updateItems(
                listOf(
                    GiftHeaderItem(
                        name = it.name,
                        description = it.description
                    ),
                    GiftLinkItem(
                        price = it.price,
                        link = it.link
                    ),
                )
            )
        }
    }

    private fun setupNoLimitStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
        binding?.root?.applyInsets()
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
                height = insets.top + dpToPixel(56f).toInt()
            }
            WindowInsetsCompat.CONSUMED
        }
    }

    private fun updateItems(items: List<Any>) {
        adapter.submitList(items)
    }

    private fun createRecyclerAdapter() = CompositeAdapter.Builder(layoutInflater).initDelegates {
        addDelegate(GiftImageAdapterDelegate())
        addDelegate(GiftHeaderAdapterDelegate())
        addDelegate(GiftLinkAdapterDelegate(::onClickLink))
    }

    private fun onClickDelete(view: View) {

    }

    private fun onClickLink(link: String) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(link)))
    }

}