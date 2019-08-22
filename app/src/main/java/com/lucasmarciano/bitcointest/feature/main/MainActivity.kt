package com.lucasmarciano.bitcointest.feature.main

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.lucasmarciano.bitcointest.R
import com.lucasmarciano.bitcointest.base.extensions.convertTimestampToDate
import com.lucasmarciano.bitcointest.base.extensions.isVisible
import com.lucasmarciano.bitcointest.base.extensions.showToast
import com.lucasmarciano.bitcointest.base.utils.Logger
import com.lucasmarciano.bitcointest.data.model.Response
import com.lucasmarciano.bitcointest.data.model.Transactions
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_card.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity(), MainContract.View {
    private val TAG = Logger.getTag()
    private val KEY_LIST = "key_list_transaction"
    private val KEY_OBJECT = "key_main_transaction"

    override val presenter by inject<MainContract.Presenter> { parametersOf(this) }
    private val adapter by lazy { MainAdapter() }

    private var mTransactions: MutableList<Transactions> = mutableListOf()
    private var mTransactionMain: Transactions = Transactions()

    override fun onCreate(savedInstanceState: Bundle?) {
        if (Logger.DEBUG) Log.d(TAG, "onCreate")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar as Toolbar)
        toolbar.title = resources.getString(R.string.app_name)

        if (savedInstanceState != null) {
            mTransactions = savedInstanceState.getParcelableArrayList(KEY_LIST)!!
            mTransactionMain = savedInstanceState.getParcelable(KEY_OBJECT)!!
            adapter.data = mTransactions
            hideLoading()
        } else {
            presenter.loadTransactions()
        }
    }

    override fun onResume() {
        if (Logger.DEBUG) Log.d(TAG, "onResume")

        super.onResume()
        setupViews()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        if (Logger.DEBUG) Log.d(TAG, "onSaveInstanceState")

        outState.putParcelableArrayList(KEY_LIST, ArrayList(mTransactions))
        outState.putParcelable(KEY_OBJECT, mTransactionMain)
        super.onSaveInstanceState(outState)
    }

    override fun showLoading() {
        if (Logger.DEBUG) Log.d(TAG, "showLoading")

        mainViewLoading.isVisible = true
    }

    override fun hideLoading() {
        if (Logger.DEBUG) Log.d(TAG, "hideLoading")

        mainViewLoading.isVisible = false
    }

    override fun onSuccessfulLoad(response: Response) {
        if (Logger.DEBUG) Log.d(TAG, "onSuccessfulLoad")

        mTransactions = response.values
        calcDifferences()
        mTransactionMain = mTransactions[0]
        mTransactions.removeAt(0)
        setupViews()
    }

    override fun onFailureLoad(message: String) {
        if (Logger.DEBUG) Log.d(TAG, message)

        showToast(message)
        cvMain.isVisible = false
    }

    private fun setupViews() {
        if (Logger.DEBUG) Log.d(TAG, "setupViews")

        if (mTransactions.size > 0) {
            cvMain.isVisible = true
            rvTransactions.layoutManager = LinearLayoutManager(this)
            setupMainCard()
            adapter.data = mTransactions
            rvTransactions.adapter = adapter
        } else {
            cvMain.isVisible = false
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setupMainCard() {
        if (Logger.DEBUG) Log.d(TAG, "setupMainCard")

        tvMainDate.text = mTransactionMain.data.convertTimestampToDate()
        tvMainValue.text = "${mTransactionMain.value}%"
    }

    private fun calcDifferences() {
        if (Logger.DEBUG) Log.d(TAG, "calcDifferences")

        mTransactions.forEachIndexed { index, current ->
            if (mTransactions.size > index + 1)
                mTransactions[index].difference = current.value - mTransactions[index + 1].value
        }
    }
}
