package com.lucasmarciano.bitcointest.feature.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.lucasmarciano.bitcointest.R
import com.lucasmarciano.bitcointest.base.extensions.isVisible
import com.lucasmarciano.bitcointest.base.extensions.showToast
import com.lucasmarciano.bitcointest.data.model.Response
import com.lucasmarciano.bitcointest.data.model.Transactions
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity(), MainContract.View {

    override val presenter by inject<MainContract.Presenter> { parametersOf(this) }
    private val adapter by lazy { MainAdapter() }

    private var mTransactions: List<Transactions> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.loadTransactions()
        setupViews()
    }

    override fun showLoading() {
        mainViewLoading.isVisible = true
    }

    override fun hideLoading() {
        mainViewLoading.isVisible = false
    }

    override fun onSuccessfulLoad(response: Response) {
        mTransactions = response.values
        adapter.data = mTransactions
    }

    override fun onFailureLoad(message: String) {
        showToast(message)
    }

    private fun setupViews() {
        setSupportActionBar(toolbar as Toolbar)
        toolbar.title = resources.getString(R.string.app_name)
        rvTransactions.layoutManager = LinearLayoutManager(this)
        rvTransactions.adapter = adapter
    }
}
