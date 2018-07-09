package com.dingdong

import android.support.design.widget.TabLayout
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dingdong.Adapter.WheelViewAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_one.view.*

class MainActivity : AppCompatActivity() {

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        // Set up the ViewPager with the sections adapter.
        container.adapter = mSectionsPagerAdapter
        container.setOnTouchListener(View.OnTouchListener { v, event -> return@OnTouchListener true })
        //container.setPagingEnabled(false)

        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

    }

    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            return PlaceholderFragment.newInstance(position + 1)
        }

        override fun getCount(): Int {
            return 2
        }
    }


    class PlaceholderFragment : Fragment() {

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View? {
            val rootView = inflater.inflate(R.layout.fragment_one, container, false)
            val entries = ArrayList<Int>()
            var index = 0
            while (index < 31) {
                entries.add(-1)
                index++
            }
            rootView.wheelview_pink.adapter = WheelViewAdapter.MaterialColorAdapter(entries)
            rootView.wheelview_pink.setOnWheelItemSelectedListener(
                    { parent, itemDrawable, position ->
                        Log.e("W Pink Position Data", position.toString() + " " + rootView.wheelview_pink.getAngleForPosition(position) + " " +
                                rootView.wheelview_pink.selectionAngle + " " + rootView.wheelview_pink.angle + " " + rootView.wheelview_pink.rawSelectedPosition)
                    })

            entries.clear()
            index = 0
            while(index < 12){
                entries.add(-1)
                index++
            }
            rootView.wheelview_white.adapter = WheelViewAdapter.MaterialColorAdapter(entries)
            rootView.wheelview_white.setOnWheelItemSelectedListener(
                    { parent, itemDrawable, position ->
                        Log.e("W White Position Data", position.toString() + " " + rootView.wheelview_pink.getAngleForPosition(position) + " " +
                                rootView.wheelview_pink.selectionAngle + " " + rootView.wheelview_pink.angle + " " + rootView.wheelview_pink.rawSelectedPosition)
                    })
            return rootView
        }

        companion object {

            private val ARG_SECTION_NUMBER = "section_number"

            fun newInstance(sectionNumber: Int): PlaceholderFragment {
                val fragment = PlaceholderFragment()
                val args = Bundle()
                args.putInt(ARG_SECTION_NUMBER, sectionNumber)
                fragment.arguments = args
                return fragment
            }
        }
    }
}
