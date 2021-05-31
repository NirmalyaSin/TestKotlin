package com.testKotlin

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    var ll_signup_topbar_next: LinearLayout? = null
    var txt_signup_topbar_header: TextView? = null
    private var progressDialog: Dialog? = null
    var iv_back: ImageView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        progressDialog = CustomProgressDialog.showDialogForLoading(this)
    }


    private fun viewBindTopbar(activity: Activity) {
        ll_signup_topbar_next = activity.findViewById(R.id.ll_signup_topbar_next)
        txt_signup_topbar_header = activity.findViewById(R.id.txt_signup_topbar_header)
        iv_back = activity.findViewById(R.id.iv_back)
    }

    fun showTopbar(activity: Activity, header: String, showNext: Boolean) {
        viewBindTopbar(activity)
        txt_signup_topbar_header!!.setVisibility(if (header.isEmpty()) View.GONE else View.VISIBLE)
        ll_signup_topbar_next!!.visibility = if (showNext) View.VISIBLE else View.INVISIBLE
        txt_signup_topbar_header!!.text = header
    }

    //PROGRESS BAR
    fun showProgress() {
        if (progressDialog != null) progressDialog!!.show()
    }

    fun hideProgress() {
        if (progressDialog != null && progressDialog!!.isShowing) progressDialog!!.dismiss()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}