package com.example.amigosnc.catalogo

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import io.realm.OrderedRealmCollection
import io.realm.RealmRecyclerViewAdapter

class ProdottoAdapter : RealmRecyclerViewAdapter<Prodotto, ProdottoAdapter.MyViewHolder>() {

        private var context : Context ?= null

        constructor(context: Context ,ProdottoList: OrderedRealmCollection<Prodotto>) {
            super(context,ProdottoList,true);

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        if (data != null) {
            val prodotto = data!![position]
            holder.id_prod!!.text = prodotto.id
            //            holder.userIdprod.setText(prodotto.getUserId());
            //            holder.title_prod.setText(prodotto.getTitle());
            //            holder.body_prod.setText(prodotto.getBody());
        }
    }

     class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
         val id: String? = null
         val userId: String? = null
         val title: String? = null
         val body: String? = null
         var id_prod: TextView? = null
         val userIdprod: TextView? = null
         val title_prod: TextView? = null
         val body_prod: TextView? = null

        init {
            id_prod = view.findViewById(R.id.id) as TextView
            id_prod = view.findViewById(R.id.user_id) as TextView
            id_prod = view.findViewById(R.id.title) as TextView
            id_prod = view.findViewById(R.id.body) as TextView
        }//costrruttore


    }//MyViewHolder
}//MoviesAdapter