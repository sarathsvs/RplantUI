package com.svs.riafyuitest.view.onboarding.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.svs.riafyuitest.R
import com.svs.riafyuitest.view.onboarding.OnBoardingActivity
import kotlinx.android.synthetic.main.fragment_intro_first.*

class IntroFirst : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_intro_first, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initClicks()

    }

    fun initClicks(){
        imgGoNext.setOnClickListener {
            (context as OnBoardingActivity).openFragmentById("1")
        }
    }

}