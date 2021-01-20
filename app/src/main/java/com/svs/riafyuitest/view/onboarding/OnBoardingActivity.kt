package com.svs.riafyuitest.view.onboarding

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.svs.riafyuitest.R
import com.svs.riafyuitest.view.ProductsListHome
import com.svs.riafyuitest.view.onboarding.fragments.IntroFirst
import com.svs.riafyuitest.view.onboarding.fragments.IntroSecond
import kotlinx.android.synthetic.main.activity_main_home.*


class OnBoardingActivity : AppCompatActivity() {
    lateinit var pagerAdapter: PagerAdapter
    var CURRENT_FRAGMENT_ID=0
    lateinit var fragmentList:ArrayList<Fragment>
    var isLastPage=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_home)

        getHomeFragments()
        initSlides()

        initCLicks()

        try{
            val fragId = intent.getStringExtra("fragId")
            openFragmentById(fragId!!)
        }catch (e:Exception){
            e.printStackTrace()
        }

    }

    private fun initCLicks(){

    }

    fun openFragmentById(fragId:String){
        when(fragId.toInt()){
            0->{
                pager.currentItem=0
            }
            1->{
                pager.currentItem=1

            }

        }

    }

    private fun initSlides(){
        pagerAdapter = ScreenSlidePagerAdapter(supportFragmentManager)
        pager.adapter=pagerAdapter
        pager.currentItem=0

        pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }
            override fun onPageSelected(position: Int) {
                CURRENT_FRAGMENT_ID = position

            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })
    }

    inner class ScreenSlidePagerAdapter(fm: FragmentManager?) :
        FragmentStatePagerAdapter(fm!!, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
    {

        override fun getItem(position: Int): Fragment { //return new ScreenSlidePageFragment();
            CURRENT_FRAGMENT_ID = position
            return getHomeFragments()[position]
        }


        override fun getCount(): Int {
            return fragmentList.size
        }
    }


    fun openFragment(fragment: Fragment) {
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.setCustomAnimations(
            R.anim.enter_from_right,
            R.anim.exit_to_left,
            R.anim.enter_from_left,
            R.anim.exit_to_right
        )
        ft.replace(R.id.mainLayout, fragment)
        ft.commit()
    }

    fun getHomeFragments():ArrayList<Fragment>{

        fragmentList = ArrayList()
        fragmentList.add(IntroFirst())
        fragmentList.add(IntroSecond())

        return fragmentList
    }

}
