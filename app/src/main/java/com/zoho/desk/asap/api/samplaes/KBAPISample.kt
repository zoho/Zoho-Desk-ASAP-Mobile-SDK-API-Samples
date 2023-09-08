package com.zoho.desk.asap.api.samplaes

import com.zoho.desk.asap.api.ZDPortalCallback.KBCategoriesCallback
import com.zoho.desk.asap.api.ZDPortalCallback.KBCategoryCallback
import com.zoho.desk.asap.api.ZDPortalException
import com.zoho.desk.asap.api.ZDPortalKBAPI
import com.zoho.desk.asap.api.response.KBCategoriesList
import com.zoho.desk.asap.api.response.KBCategory

class KBAPISample {

    fun getKBRootCategories() {
        val params = hashMapOf<String, String>()
        params["from"] = "1"
        params["limit"] = "2"
        params["hasArticles"] = "true"
        ZDPortalKBAPI.geRootKBCategories(object : KBCategoriesCallback {
            override fun onException(exception: ZDPortalException?) {
                //Root Categories Exception
            }

            override fun onKBCategoriesDownloaded(categoriesList: KBCategoriesList?) {
                //Categories data downloaded
            }

        }, params)
    }

    fun getKBRootCategoriesTree() {
        val params = hashMapOf<String, String>()
        params["from"] = "1"
        params["limit"] = "2"
        ZDPortalKBAPI.getKBCategoriesTree(object : KBCategoryCallback {
            override fun onException(exception: ZDPortalException?) {
                //Root Categories Exception
            }

            override fun onKBCategoryDownloaded(p0: KBCategory?) {
                //category data downloaded
            }

        }, "RootCategoryId", params)
    }


}