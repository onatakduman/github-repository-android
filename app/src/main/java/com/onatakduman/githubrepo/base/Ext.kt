package com.onatakduman.githubrepo.base

import android.graphics.Bitmap
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.onatakduman.githubrepo.R


fun AppCompatImageView.loadFromUrl(url: String) {
    val transformations = MultiTransformation<Bitmap>(
        CenterCrop()
    )
    val requestOptions = RequestOptions()
    Glide.with(this.context)
        .setDefaultRequestOptions(requestOptions)
        .applyDefaultRequestOptions(RequestOptions.bitmapTransform(transformations))
        .load(url)
        .placeholder(R.drawable.ic_launcher_background)
        .into(this)
}