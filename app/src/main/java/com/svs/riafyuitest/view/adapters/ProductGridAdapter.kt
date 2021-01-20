package com.svs.riafyuitest.view.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.svs.riafyuitest.R
import com.svs.riafyuitest.models.RProduct
import kotlinx.android.synthetic.main.adapter_item_product.view.*


class ProductGridAdapter(
        var listDummyData: ArrayList<RProduct>, val mContext: Context,
        val listener: (RProduct, Int) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_NORMAL) {
            
            return DefaultViewHOlder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.adapter_item_product,
                    parent,
                    false
                )
            )
        }else {
            return LoadingLayout(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.adapter_item_product,
                    parent,
                    false
                )
            )
        }

    }

    override fun getItemCount(): Int {
        return listDummyData.size
        //return 1
    }

    override fun getItemViewType(position: Int): Int {

        return TYPE_NORMAL

    }




    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(holder){
            is LoadingLayout -> {
                holder.bind(listDummyData[position], mContext, listener)
            }
            is DefaultViewHOlder -> {
                holder.bind(listDummyData[position], mContext, listener)
            }

        }

    }


   inner class DefaultViewHOlder(itemView: View) : RecyclerView.ViewHolder(itemView){
        @SuppressLint("SetTextI18n")
        fun bind(rProduct: RProduct, mContext: Context, listener: (RProduct, Int) -> Unit)= with(
            itemView
        ) {

            tvProductName.text = rProduct._productName
            tvProductPrice.text = "$${rProduct._productPrice}"
            productImage.setImageDrawable(resources.getDrawable(rProduct._image))
            if(rProduct._discount>0){
                tvDescountPercentage.text = "-${rProduct._discount}%"
                tvDescountPercentage.visibility=View.VISIBLE
            }

            itemView.setOnClickListener {
                listener(rProduct, 0)
            }
        }
    }
    inner class LoadingLayout(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(chat: RProduct, mContext: Context, listener: (RProduct, Int) -> Unit)= with(
            itemView
        ) {
         //   tvMsgContent.text =chat.message
           // tvTime.text =chat.time
        }

    }



    fun updateList(list: ArrayList<RProduct>){
        this.listDummyData=list
        notifyDataSetChanged()
    }
    
    companion object{
        const val TYPE_NORMAL=1
        const val TYPE_LOADING=2
        const val TYPE_MESSAGE=3
    }

}