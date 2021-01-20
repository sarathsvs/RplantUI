package com.svs.riafyuitest.view.onboarding.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.svs.riafyuitest.R
import com.svs.riafyuitest.view.ProductsListHome
import com.svs.riafyuitest.view.onboarding.OnBoardingActivity
import kotlinx.android.synthetic.main.fragment_intro_second.*


class IntroSecond :Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_intro_second, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initClicks()
    }

    private fun initClicks(){
        imgGoNext.setOnClickListener {
            startActivity(Intent(context,ProductsListHome::class.java))
            (context as OnBoardingActivity).finish()
        }
    }

}