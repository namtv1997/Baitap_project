
package namhenry.com.vn.battap_project.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v4.widget.DrawerLayout
import android.view.Gravity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.actionbar.*
import kotlinx.android.synthetic.main.activity_main.*
import namhenry.com.vn.battap_project.R
import namhenry.com.vn.battap_project.fragment.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        switchFragment(Login())

        onClickEvent()
    }

    fun onClickEvent() {
        tvPointRecentReport.setOnClickListener {
            switchFragment(Points())
            drawerLayout.closeDrawer(Gravity.START)
        }
        tvSettingRecenreport.setOnClickListener {
            switchFragment(Settings())
            drawerLayout.closeDrawer(Gravity.START)
        }
        tvRecentReport.setOnClickListener {
            switchFragment(RencentReport())
            drawerLayout.closeDrawer(Gravity.START)
        }
        tvProfileMain.setOnClickListener {
            switchFragment(EditProfile())
            drawerLayout.closeDrawer(Gravity.START)
        }
        tvSearchFriendsMain.setOnClickListener {
            switchFragment(SearchSetting())
            drawerLayout.closeDrawer(Gravity.START)
        }
    }

    fun checkFragment(fragment: Fragment) {


        if (fragment is Login) {
            titleToolbar.text = "Login"
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)//dung de khoa
            tvLeftToolbar.setOnClickListener { }
            return
        }
        if (fragment is RencentReport) {
            titleToolbar.text = "Recent Report"
            imgLeftToolbar.setOnClickListener {
                drawerLayout.openDrawer(Gravity.START)
            }
            imgLeftToolbar.visibility = View.VISIBLE
            tvLeftToolbar.visibility=View.GONE
            imgLeftToolbar.setImageResource(R.drawable.nav_menu)
            imgRightToolbar.visibility = View.GONE
            tvRightToolbar.visibility = View.VISIBLE
            tvRightToolbar.text = "Send"
            return
        }
        if (fragment is Settings) {
            titleToolbar.text = "Settings"
            tvRightToolbar.text = "Logout"
            return
        }
        if (fragment is Points) {
            titleToolbar.text = "Points"
            imgRightToolbar.visibility = View.VISIBLE
            imgRightToolbar.setImageResource(R.drawable.nav_menu)
            tvRightToolbar.visibility = View.GONE
            return
        }
        if (fragment is DeactivateAccount) {
            titleToolbar.text = "Deactivate Account"
            imgRightToolbar.visibility = View.GONE
            imgLeftToolbar.setImageResource(R.drawable.nav_btn_back)
            tvRightToolbar.visibility = View.GONE
            return
        }
        if (fragment is Login) {
            titleToolbar.text = "Login"
            tvRightToolbar.text = "Forgot?"
            return
        }
        if (fragment is Notifications) {
            titleToolbar.text = "Notification"
            imgLeftToolbar.setImageResource(R.drawable.nav_btn_back)
            tvRightToolbar.text = "Save"
            return
        }
        if (fragment is ChangePassword) {
            titleToolbar.text = "Change Password"
            imgRightToolbar.visibility = View.GONE
            imgLeftToolbar.setImageResource(R.drawable.nav_btn_back)
            tvRightToolbar.visibility = View.GONE
            return
        }
        if (fragment is DistanceIn) {
            titleToolbar.text = "Distance In"
            imgLeftToolbar.setImageResource(R.drawable.nav_btn_back)
            return
        }
        if (fragment is SearchEthnicity) {
            titleToolbar.text = "Search Ethnicity"
            tvLeftToolbar.visibility = View.VISIBLE
            imgLeftToolbar.visibility = View.GONE
            tvLeftToolbar.text = "Cancel"
            tvRightToolbar.text = "Done"
            return
        }
        if (fragment is SearchSetting) {
            imgLeftToolbar.setImageResource(R.drawable.nav_menu)
            titleToolbar.text = "Search Settings"
            imgLeftToolbar.visibility = View.GONE
            tvLeftToolbar.visibility = View.VISIBLE
            tvLeftToolbar.text = "Cancel"
            tvRightToolbar.text = "Search"
            return
        }
        if (fragment is EditProfile) {
            titleToolbar.text = "Edit Profile"
            imgLeftToolbar.visibility = View.GONE
            tvLeftToolbar.visibility = View.VISIBLE
            tvLeftToolbar.text = "Cancel"
            tvRightToolbar.text = "Save"
            return
        }
        if (fragment is TermsOfService) {
            titleToolbar.text = "Terms of Service"
            imgRightToolbar.visibility = View.GONE
            imgLeftToolbar.setImageResource(R.drawable.nav_btn_back)
            tvRightToolbar.visibility = View.GONE
            return
        }

        if (fragment is Points) {
            titleToolbar.text = "Points"
            imgLeftToolbar.setImageResource(R.drawable.nav_menu)
            return
        }
    }

    override fun onBackPressed() {
        try {
            val fragment: Fragment? = supportFragmentManager.findFragmentById(R.id.frameLayoutMain)
            if (fragment is Login) {
                super.onBackPressed()
                System.exit(0)
            } else {
                val nameClass: String = fragment?.javaClass!!.name
                supportFragmentManager.popBackStack(nameClass, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
        } catch (e: Exception) {
            print(e.printStackTrace())
            System.exit(0)
        }
    }

}

fun AppCompatActivity.switchFragment(fragment: Fragment) {
    val name: String = fragment.javaClass.name
    val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
    ft.replace(R.id.frameLayoutMain, fragment)
    ft.addToBackStack(name)
    ft.commit()
}

fun Fragment.switchFragment(fragment: Fragment, replace: Int = R.id.frameLayoutMain) {
    val name: String = fragment.javaClass.name
    val ft: FragmentTransaction = activity!!.supportFragmentManager.beginTransaction()
    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
    ft.replace(replace, fragment)
    ft.addToBackStack(name)
    ft.commit()
}



