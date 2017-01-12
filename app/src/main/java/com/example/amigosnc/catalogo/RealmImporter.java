package com.example.amigosnc.catalogo;

import android.content.res.Resources;

import java.io.InputStream;

import io.realm.Realm;

/**
 * Created by amigosnc on 24/12/2016.
 */

public class RealmImporter {
    Resources resources;

    public RealmImporter(Resources resources) {
        this.resources = resources;
    }

    public void importFromJson() {
        Realm realm = Realm.getDefaultInstance();

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                InputStream inputStream = resources.openRawResource(R.raw.jsonprodotto);
                try {
                    realm.createAllFromJson(Prodotto.class, inputStream);

                } catch (Exception e) {
                    realm.cancelTransaction();
                }

            }
        });
    }
}

