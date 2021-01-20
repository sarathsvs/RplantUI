package com.svs.riafyuitest.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.svs.riafyuitest.R
import com.svs.riafyuitest.app.RiafTest
import com.svs.riafyuitest.view.adapters.ProductGridAdapter
import com.svs.riafyuitest.app.RiafTest.Companion.gson
import com.svs.riafyuitest.models.RProduct
import kotlinx.android.synthetic.main.activity_products_list_home.*

class ProductsListHome : AppCompatActivity() {

    lateinit var adapterGridList:ProductGridAdapter
    var listOfProducts :ArrayList<RProduct> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left);

        setContentView(R.layout.activity_products_list_home)
        showGridItems(getDummyProductList())
        initialize()

    }

    
    private fun getDummyProductList():ArrayList<RProduct>{
        listOfProducts.add(RProduct(1,"Wicker Cone","234",R.drawable.product_1,0))
        listOfProducts.add(RProduct(2,"Holy Lit","212",R.drawable.product_2,0))
        listOfProducts.add(RProduct(3,"Moju Plant","256",R.drawable.product_3,10))
        listOfProducts.add(RProduct(4,"Adam's Secret","267",R.drawable.product_4,0))
        listOfProducts.add(RProduct(5,"Wicker Cone","234",R.drawable.product_1,0))
        listOfProducts.add(RProduct(6,"Holy Lit","212",R.drawable.product_2,0))
        listOfProducts.add(RProduct(7,"Moju Plant","256",R.drawable.product_3,0))
        listOfProducts.add(RProduct(8,"Adam's Secret","267",R.drawable.product_4,0))
        listOfProducts.add(RProduct(9,"Wicker Cone","234",R.drawable.product_1,0))
        listOfProducts.add(RProduct(10,"Holy Lit","212",R.drawable.product_2,0))
        listOfProducts.add(RProduct(11,"Moju Plant","256",R.drawable.product_3,0))
        listOfProducts.add(RProduct(12,"Adam's Secret","267",R.drawable.product_4,0))

        return listOfProducts
        
    }

    private fun showGridItems(listOfProducts:ArrayList<RProduct>){

        Log.e("wrere","size : ${listOfProducts.size}")

        rcViewProducts.layoutManager = GridLayoutManager(applicationContext, 2)
        rcViewProducts.isNestedScrollingEnabled = false
        adapterGridList = ProductGridAdapter(listOfProducts, applicationContext
        ) { item: RProduct, position: Int ->
            Unit
            onProductClicked(item, position)
        }
        rcViewProducts.adapter = adapterGridList


    }

    private fun onProductClicked(rProduct: RProduct, position: Int) {
        val intentProduct = Intent(applicationContext,ProductDetailView::class.java)
        intentProduct.putExtra("rProduct",gson.toJson(rProduct))
        startActivity(intentProduct)
    }

    private fun initialize(){
        imgGoBack.setOnClickListener { finish() }
        imgSearch.setOnClickListener { RiafTest.appUtils.showToasty("Search") }
        imgFilter.setOnClickListener { RiafTest.appUtils.showToasty("Filter") }
        clickViewCart.setOnClickListener { RiafTest.appUtils.showToasty("Cart") }
    }

    
}