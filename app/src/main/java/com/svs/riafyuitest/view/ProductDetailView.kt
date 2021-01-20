package com.svs.riafyuitest.view

import android.graphics.text.LineBreaker.JUSTIFICATION_MODE_INTER_WORD
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.svs.riafyuitest.R
import com.svs.riafyuitest.app.RiafTest.Companion.gson
import com.svs.riafyuitest.models.RProduct
import kotlinx.android.synthetic.main.activity_product_detail_view.*
import kotlinx.android.synthetic.main.adapter_item_product.view.*

class ProductDetailView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left);
        setContentView(R.layout.activity_product_detail_view)

        val rProduct = gson.fromJson(intent.getStringExtra("rProduct"),RProduct::class.java)
        updateProductView(rProduct)
        initializeClicks()
    }

    private fun updateProductView(rProduct:RProduct){
        tvProductName.text = rProduct._productName
        tvProductPrice.text = "$${rProduct._productPrice}"
        mainImage.setImageDrawable(resources.getDrawable(rProduct._image))

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            tvDesc.justificationMode = JUSTIFICATION_MODE_INTER_WORD
        }
    }

    fun initializeClicks(){
        imgGoBack.setOnClickListener {
            finish()
        }
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_right);
    }

}