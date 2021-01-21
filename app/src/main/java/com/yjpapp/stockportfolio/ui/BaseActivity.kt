package com.yjpapp.stockportfolio.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.yjpapp.stockportfolio.BuildConfig
import com.yjpapp.stockportfolio.database.DatabaseController
import com.yjpapp.stockportfolio.preference.PreferenceController

/**
 * @author Yun Jae-park
 * @since 2020.12
 */
abstract class BaseActivity<VB: ViewBinding>: AppCompatActivity() {
    lateinit var mContext: Context
    lateinit var databaseController: DatabaseController
    lateinit var preferenceController: PreferenceController
    lateinit var binding: VB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        databaseController = DatabaseController.getInstance(mContext)
        preferenceController = PreferenceController.getInstance(mContext)

        binding = getViewBinding()
        setContentView(binding.root)
    }

    abstract fun initData()
    abstract fun initLayout()

    fun logcat(msg: String){
        if(BuildConfig.LOG_CAT) Log.d(javaClass.simpleName, msg)
    }

    abstract fun getViewBinding(): VB
}