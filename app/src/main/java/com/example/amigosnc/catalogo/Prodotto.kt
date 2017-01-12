package com.example.amigosnc.catalogo

import io.realm.RealmObject

open class Prodotto : RealmObject {

    //    @PrimaryKey
    var id: String? = null

    var userId: String? = null
    internal var title: String? = null
        set
    var body: String? = null

    constructor() {}

    constructor(id: String, title: String, userId: String, body: String) {
        this.id = id
        this.title = title
        this.userId = userId
        this.body = body
    }

}
