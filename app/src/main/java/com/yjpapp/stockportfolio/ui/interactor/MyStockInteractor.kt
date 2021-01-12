package com.yjpapp.stockportfolio.ui.interactor

import android.content.Context
import com.yjpapp.stockportfolio.database.DatabaseController
import com.yjpapp.stockportfolio.database.data.MyStockInfo

class MyStockInteractor {

    companion object {
        @Volatile private var instance: MyStockInteractor? = null
        private lateinit var mContext: Context
        private lateinit var databaseController: DatabaseController
        @JvmStatic
        fun getInstance(context: Context): MyStockInteractor =
                instance ?: synchronized(this) {
                    instance ?: MyStockInteractor().also {
                        instance = it
                        mContext = context
                        databaseController = DatabaseController.getInstance(mContext)
                    }
                }
    }

    fun getAllMyStockList(): ArrayList<MyStockInfo?> {
        return databaseController.getAllMyStockList()
    }
}