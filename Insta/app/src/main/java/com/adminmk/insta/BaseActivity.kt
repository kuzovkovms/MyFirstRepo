package com.adminmk.insta

import android.content.Intent
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.bottom_navigation_view.*

abstract class BaseActivity(val navNumber: Int) : AppCompatActivity() {
    private val TAG = "BaseActivity"

    fun setupBottomNavigation() {
        bottom_navigation_view.setIconSize(29f,29f)
        bottom_navigation_view.setTextVisibility(false)
        bottom_navigation_view.enableShiftingMode(false)
        bottom_navigation_view.enableItemShiftingMode(false)
        bottom_navigation_view.enableAnimation(false)
        for(i in 0 until bottom_navigation_view.menu.size()) {
            bottom_navigation_view.setIconTintList(i,null)
        }
        bottom_navigation_view.setOnNavigationItemReselectedListener {
            val nextActivity =
                when(it.itemId) {
                    R.id.nav_item_home -> HomeActivity::class.java
                    R.id.nav_item_search -> SearchActivity::class.java
                    R.id.nav_item_share -> ShareActivity::class.java
                    R.id.nav_item_likes -> LikesActivity::class.java
                    R.id.nav_item_profile -> ProfileActivity::class.java
                    else -> { Log.e(TAG,"unknown nav item clicked $it")
                        null
                    }
                }
            if (nextActivity != null) {
                val intent = Intent(this, nextActivity)

                startActivity(intent)
                overridePendingTransition(0, 0)
            }
        }
        bottom_navigation_view.menu.getItem(navNumber).isChecked = true

    }
}