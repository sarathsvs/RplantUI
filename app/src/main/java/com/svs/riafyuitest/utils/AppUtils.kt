package com.svs.riafyuitest.utils

import android.content.Context
import androidx.core.content.ContextCompat
import com.svs.riafyuitest.R
import es.dmoral.toasty.Toasty

class AppUtils(context:Context) {
    var mContext = context

    fun showToasty(msg: String) {
        val drawb = ContextCompat.getDrawable(mContext, R.drawable.ic_clear_white_24dp)
        val colorAccent = ContextCompat.getColor(mContext, R.color.black)
        val colorFont = ContextCompat.getColor(mContext, R.color.white)

        Toasty.Config.getInstance()
            .allowQueue(true)
            .apply()
        Toasty.custom(
            mContext, msg, drawb, colorAccent, colorFont, Toasty.LENGTH_SHORT, false, true
        ).show()
    }

}