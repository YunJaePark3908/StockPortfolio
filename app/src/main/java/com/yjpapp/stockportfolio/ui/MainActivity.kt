package com.yjpapp.stockportfolio.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.yjpapp.stockportfolio.R
import com.yjpapp.stockportfolio.preference.PrefKey
import com.yjpapp.stockportfolio.ui.fragment.IncomeNoteFragment
import com.yjpapp.stockportfolio.ui.fragment.MemoListFragment
import com.yjpapp.stockportfolio.ui.fragment.MyStockFragment
import com.yjpapp.stockportfolio.ui.view.MainView
import com.yjpapp.stockportfolio.util.Utils
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity(R.layout.activity_main), MainView {
    companion object {
        const val FRAGMENT_TAG_MY_STOCK = "my_stock"
        const val FRAGMENT_TAG_INCOME_NOTE = "income_note"
        const val FRAGMENT_TAG_MEMO_LIST = "memo_list"
    }

    private val myStockFragment = MyStockFragment()
    private val incomeNoteFragment = IncomeNoteFragment()
    private val memoListFragment = MemoListFragment()
    private var currentFragment: Fragment = myStockFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
        initLayout()
    }

    override fun initData() {
        preferenceController.setPreference(PrefKey.KEY_BACK_BUTTON_APP_CLOSE, "false")
    }

    override fun initLayout() {
        setSupportActionBar(toolbar_IncomeNoteActivity)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        addFragment()
        startFirstFragment()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (currentFragment == memoListFragment) {
            val memoListFragment = supportFragmentManager.findFragmentByTag(FRAGMENT_TAG_MEMO_LIST)
            memoListFragment?.onActivityResult(requestCode, resultCode, data)
        }
    }

    override fun onBackPressed() {
        if (currentFragment == incomeNoteFragment ||
                currentFragment == memoListFragment) {
            super.onBackPressed()
            return
        }
        Utils.runBackPressAppCloseEvent(mContext, this)
    }

    private fun startFirstFragment() {
        if (preferenceController.isExists(PrefKey.KEY_BOTTOM_MENU_SELECTED_POSITION)) {
            when (preferenceController.getPreference(PrefKey.KEY_BOTTOM_MENU_SELECTED_POSITION)) {
                FRAGMENT_TAG_MY_STOCK -> {
                    showMyStock()
                }
                FRAGMENT_TAG_INCOME_NOTE -> {
                    showIncomeNote()
                }
                FRAGMENT_TAG_MEMO_LIST -> {
                    showMemoList()
                }
            }
        } else {
            showMyStock()
        }
    }

    override fun addFragment() {
        supportFragmentManager.beginTransaction()
                .add(R.id.cons_MainActivity_fragment, myStockFragment, FRAGMENT_TAG_MY_STOCK)
                .add(R.id.cons_MainActivity_fragment, incomeNoteFragment, FRAGMENT_TAG_INCOME_NOTE)
                .add(R.id.cons_MainActivity_fragment, memoListFragment, FRAGMENT_TAG_MEMO_LIST)
                .hide(myStockFragment)
                .hide(incomeNoteFragment)
                .hide(memoListFragment)
                .commit()

    }

    override fun showMyStock() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.cons_MainActivity_fragment, myStockFragment, FRAGMENT_TAG_MY_STOCK)
                .show(myStockFragment)
                .commit()
        currentFragment = myStockFragment
        txt_MainActivity_Title.text = getString(R.string.MyStockFragment_Title)
        preferenceController.setPreference(PrefKey.KEY_BOTTOM_MENU_SELECTED_POSITION, FRAGMENT_TAG_MY_STOCK)

    }

    override fun hideMyStock() {
        supportFragmentManager.beginTransaction()
                .hide(myStockFragment)
                .commit()
    }

    override fun showIncomeNote() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.cons_MainActivity_fragment, incomeNoteFragment, FRAGMENT_TAG_INCOME_NOTE)
                .show(incomeNoteFragment)
                .commit()
        currentFragment = incomeNoteFragment
        preferenceController.setPreference(PrefKey.KEY_BOTTOM_MENU_SELECTED_POSITION, FRAGMENT_TAG_INCOME_NOTE)
        txt_MainActivity_Title.text = getString(R.string.IncomeNoteFragment_Title)
    }

    override fun hideIncomeNote() {
        supportFragmentManager.beginTransaction()
                .hide(incomeNoteFragment)
                .commit()
    }

    override fun showMemoList() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.cons_MainActivity_fragment, memoListFragment, FRAGMENT_TAG_MEMO_LIST)
                .show(memoListFragment)
                .commit()
        currentFragment = memoListFragment
        preferenceController.setPreference(PrefKey.KEY_BOTTOM_MENU_SELECTED_POSITION, FRAGMENT_TAG_MEMO_LIST)
        txt_MainActivity_Title.text = getString(R.string.MemoListFragment_Title)
    }

    override fun hideMemoList() {
        supportFragmentManager.beginTransaction()
                .hide(memoListFragment)
                .commit()
    }

    override fun hideCurrentFragment() {
        supportFragmentManager.beginTransaction()
                .hide(currentFragment)
                .commit()
    }

    override fun clickBottomMenu(view: View?) {
        when (view?.id) {
            R.id.lin_MainActivity_BottomMenu_MyStock -> {
                showMyStock()
            }
            R.id.lin_MainActivity_BottomMenu_IncomeNote -> {
                showIncomeNote()
            }
            R.id.lin_MainActivity_BottomMenu_Memo -> {
                showMemoList()
            }
        }
    }
}