package com.omidio.tabsyncedrecyclerviewsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout.HORIZONTAL
import android.widget.LinearLayout.VERTICAL
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import com.omidio.tabsyncedrecyclerview.LinearLayoutManagerWithSmoothScroller
import com.omidio.tabsyncedrecyclerview.TabSyncedRecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        val tabLayout2 = findViewById<TabLayout>(R.id.tab_layout2)

        findViewById<TabSyncedRecyclerView>(R.id.recycler_view_vertical).apply {

            // add the list item decorator
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    VERTICAL
                ).apply { setDrawable(getDrawable(R.drawable.divider)!!) })

            // set the tab layout to be used for syncing up with the scrolling
            setTabLayout(tabLayout)

            // pass the num of items per each tab index
            // our dummy data list size is 30, passing
            // random values that add up to the list size
            setCountItemsByTabIndex(listOf(5, 5, 5, 5, 3, 7))

            // pass our required scroll listener
            addOnScrollListener(TabSyncedScrollListener())

            // pass our required layout manager
            layoutManager =
                LinearLayoutManagerWithSmoothScroller(
                    this@MainActivity,
                    RecyclerView.VERTICAL,
                    false
                )

            // pass our adapter
            adapter = ExampleAdapter(VERTICAL)
        }

        findViewById<TabSyncedRecyclerView>(R.id.recycler_view_horizontal).apply {

            // add the list item decorator
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    HORIZONTAL
                ).apply { setDrawable(getDrawable(R.drawable.divider)!!) })

            // set the tab layout to be used for syncing up with the scrolling
            setTabLayout(tabLayout2)

            // pass the num of items per each tab index
            // our dummy data list size is 30, passing
            // random values that add up to the list size
            setCountItemsByTabIndex(listOf(5, 5, 5, 5, 3, 7))

            // pass our required scroll listener
            addOnScrollListener(TabSyncedScrollListener())

            // pass our required layout manager
            layoutManager =
                LinearLayoutManagerWithSmoothScroller(
                    this@MainActivity,
                    RecyclerView.HORIZONTAL,
                    false
                )

            // pass our adapter
            adapter = ExampleAdapter(HORIZONTAL)
        }
    }
}

class ExampleAdapter(private val orientation: Int) :
    RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        return ExampleViewHolder(
            LayoutInflater.from(parent.context).inflate(
                if (orientation == VERTICAL) R.layout.item else R.layout.item_horizontal,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = 30

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        holder.label.text = "Item in pos:$position"
    }

    inner class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val label: TextView = itemView.findViewById(R.id.item_tv)
    }
}
