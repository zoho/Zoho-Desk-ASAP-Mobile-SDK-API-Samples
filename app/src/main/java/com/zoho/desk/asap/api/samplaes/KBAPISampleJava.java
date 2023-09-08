package com.zoho.desk.asap.api.samplaes;

import com.zoho.desk.asap.api.ZDPortalAPI;
import com.zoho.desk.asap.api.ZDPortalCallback;
import com.zoho.desk.asap.api.ZDPortalException;
import com.zoho.desk.asap.api.ZDPortalKBAPI;
import com.zoho.desk.asap.api.response.KBCategoriesList;
import com.zoho.desk.asap.api.response.KBCategory;

import java.util.HashMap;

public class KBAPISampleJava {
    
    public void getKBRootCategories() {
        HashMap<String, String> params = new HashMap<>();
        params.put("from", "1");
        params.put("limit", "2");
        params.put("hasArticles", "true");
        ZDPortalKBAPI.geRootKBCategories(new ZDPortalCallback.KBCategoriesCallback() {
            @Override
            public void onKBCategoriesDownloaded(KBCategoriesList kbCategoriesList) {
                //Root Categories Exception
            }

            @Override
            public void onException(ZDPortalException e) {
                //Categories data downloaded
            }
        }, params);
    }

    public void getKBRootCategoriesTree() {
        HashMap<String, String> params = new HashMap<>();
        params.put("from", "1");
        params.put("limit", "2");
        params.put("hasArticles", "true");
        ZDPortalKBAPI.getKBCategoriesTree(new ZDPortalCallback.KBCategoryCallback() {
            @Override
            public void onKBCategoryDownloaded(KBCategory category) {
                //Root Categories Exception
            }

            @Override
            public void onException(ZDPortalException e) {
                //Categories data downloaded
            }
        },"RootCategoryId", params);
    }


}
