package com.svs.riafyuitest.models

import java.io.Serializable

data class RProduct (
        val _id:Int?=null,
        val _productName:String?=null,
        val _productPrice:String?=null,
        val _image:Int,
        val _discount:Int,
        ):Serializable