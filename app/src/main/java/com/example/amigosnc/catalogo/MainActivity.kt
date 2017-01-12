package com.example.amigosnc.catalogo


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log

import io.realm.Realm
import io.realm.RealmResults

class MainActivity : AppCompatActivity() {

    private var movieList: RealmResults<Prodotto>? = null
    private var recyclerView: RecyclerView? = null
    private var mAdapter: ProdottoAdapter? = null
    private var realm: Realm? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        realm = Realm.getDefaultInstance()
        recyclerView = findViewById(R.id.my_recycler_view) as RecyclerView
        Log.e("Main", "prova")

        var i: Long = 0
        while (i < realm!!.where(Prodotto::class.java).count()) {
            realm!!.where(Prodotto::class.java).contains("titla", "")
            i++
        }

        setAdapter()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (realm != null && !realm!!.isClosed) {
            realm!!.close()
        }
    }

    fun setAdapter() {
        val mLayoutManager = GridLayoutManager(applicationContext, 2)
        recyclerView!!.layoutManager = mLayoutManager
        recyclerView!!.itemAnimator = DefaultItemAnimator()
        movieList = realm!!.where(Prodotto::class.java).findAllAsync()
        mAdapter = ProdottoAdapter(this, realm!!.where(Prodotto::class.java).findAll())
        recyclerView!!.adapter = mAdapter
    }


}//MainActivity