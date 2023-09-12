package com.zoho.desk.asap.api.samplaes;

import com.zoho.desk.asap.api.ZDPortalCallback;
import com.zoho.desk.asap.api.ZDPortalException;
import com.zoho.desk.asap.api.ZDPortalKBAPI;
import com.zoho.desk.asap.api.response.ASAPAttachmentsList;
import com.zoho.desk.asap.api.response.ArticleCommentsList;
import com.zoho.desk.asap.api.response.KBArticle;
import com.zoho.desk.asap.api.response.KBArticlesList;
import com.zoho.desk.asap.api.response.KBCategoriesList;
import com.zoho.desk.asap.api.response.KBCategory;
import com.zoho.desk.asap.api.response.KBPrevNextArticlesList;

import java.io.InputStream;
import java.util.HashMap;

public class KBAPISampleJava {
    
    public void getKBRootCategories() {
        HashMap<String, String> params = new HashMap<>();
        params.put("from", "1");
        params.put("limit", "50");
        ZDPortalKBAPI.geRootKBCategories(new ZDPortalCallback.KBCategoriesCallback() {
            @Override
            public void onKBCategoriesDownloaded(KBCategoriesList kbCategoriesList) {
                //Categories data downloaded
            }

            @Override
            public void onException(ZDPortalException e) {
                //Root Categories Exception
            }
        }, params);
    }

    public void getKBRootCategoriesTree() {
        HashMap<String, String> params = new HashMap<>();
        params.put("include", "allArticleCount,sectionsCount");
        ZDPortalKBAPI.getKBCategoriesTree(new ZDPortalCallback.KBCategoryCallback() {
            @Override
            public void onKBCategoryDownloaded(KBCategory category) {
                //Categories data downloaded
            }

            @Override
            public void onException(ZDPortalException e) {
                //Root Categories Exception
            }
        },"RootCategoryId", params);
    }

    public void getKBCategoryWithPermalink(){
        HashMap<String, String> params = new HashMap<>();
        params.put("permalink", "permalink");
        params.put("include", "sectionsCount,allArticleCount,articlesCount");
        ZDPortalKBAPI.getKBCategoryWithPermalink(new ZDPortalCallback.KBCategoryCallback(){

            @Override
            public void onKBCategoryDownloaded(KBCategory kbCategory) {
                //categories data downloaded
            }

            @Override
            public void onException(ZDPortalException exception) {
                //categories Exception
            }
        }, params);
    }

    public void getArticles() {
        HashMap<String, String> params = new HashMap<>();
        params.put("from", "1");
        params.put("limit", "50");
        ZDPortalKBAPI.getArticlesList(new ZDPortalCallback.ArticlesCallback() {
            @Override
            public void onArticlesDownloaded(KBArticlesList kbArticlesList) {
                //Articles data downloaded
            }

            @Override
            public void onException(ZDPortalException exception) {
                //Articles Exception
            }
        }, params);
    }

    public void getArticleDetails() {
        ZDPortalKBAPI.getArticleDetails(new ZDPortalCallback.ArticleDetailsCallback() {
            @Override
            public void onArticleDetailsDownloaded(KBArticle kbArticle) {
                //Article details data downloaded
            }

            @Override
            public void onException(ZDPortalException exception) {
                //Article details Exception
            }
        }, "articleId", "localeCode", null);
    }

    public void getRelatedArticles(){
        HashMap<String, String> params = new HashMap<>();
        params.put("from", "1");
        params.put("limit", "5");
        ZDPortalKBAPI.getRelatedArticles(
            "articleId",
            "localeCode",
            new ZDPortalCallback.ArticlesCallback() {
                @Override
                public void onArticlesDownloaded(KBArticlesList kbArticlesList) {
                    //Related Articles data downloaded
                }
                @Override
                public void onException(ZDPortalException exception) {
                    //Related Articles Exception
                }
            },
            params
        );
    }

    public void getArticleAttachmentList(){
        ZDPortalKBAPI.getArticleAttachments(new ZDPortalCallback.AttachmentsCallback(){
            @Override
            public void onAttachmentsDownloaded(ASAPAttachmentsList attachmentsList) {
                //Article Attachments data downloaded
            }

            @Override
            public void onException(ZDPortalException exception) {
                //Article Attachments Exception
            }
        }, "articleId", "localeCode", null);
    }

    public void likeArticle(){
        ZDPortalKBAPI.likeArticle(new ZDPortalCallback.ArticleUpdateVoteCallback() {
            @Override
            public void onArticleUpdated() {
                //Article Liked Successfully
            }

            @Override
            public void onException(ZDPortalException exception) {
                //Article Liked Exception
            }
        }, "articleId", "localeCode", null);
    }

    public void dislikeArticle(){
        ZDPortalKBAPI.dislikeArticle(new ZDPortalCallback.ArticleUpdateVoteCallback() {
            @Override
            public void onArticleUpdated() {
                //Article Disliked Successfully
            }

            @Override
            public void onException(ZDPortalException exception) {
                //Article Dislike Exception
            }
        }, "articleId", "localeCode", null);
    }

    public void feedbackArticle(){
        HashMap<String, String> feedbackContent = new HashMap<>();
        feedbackContent.put("email", "userEmail");
        feedbackContent.put("feedback", "feedbackContent");
        ZDPortalKBAPI.articleFeedback(new ZDPortalCallback.ArticleFeedbackCallback() {
            @Override
            public void onFeedbackPosted() {
                //Article Feedback posted
            }

            @Override
            public void onException(ZDPortalException exception) {
                //Article Feedback Exception
            }
        }, "articleId", "localeCode", feedbackContent, null);
    }

    public void getArticleAttachmentContent(){
        ZDPortalKBAPI.downloadArticleAttachment(new ZDPortalCallback.DownloadAttachmentCallback(){
            @Override
            public void onAttachmentDownloaded(InputStream stream) {
                //Article Attachment content downloaded
            }

            @Override
            public void onException(ZDPortalException exception) {
                //Article Attachment Exception
            }
        }, "articleId", "localeCode", "attachmentId", null);
    }

    public void searchArticles() {
        HashMap<String, String> params = new HashMap<>();
        params.put("searchStr", "searchString");
        ZDPortalKBAPI.searchArticles(new ZDPortalCallback.ArticlesCallback() {
            @Override
            public void onArticlesDownloaded(KBArticlesList kbArticlesList) {
                //Categories data downloaded
            }

            @Override
            public void onException(ZDPortalException exception) {
                //Root Categories Exception
            }
        }, false, params);
    }

    public void getArticleDetailsByPermalink(){
        HashMap<String, String> params = new HashMap<>();
        params.put("permalink", "permalink");
        ZDPortalKBAPI.getArticleDetailsWithPermalink(new ZDPortalCallback.ArticleDetailsCallback() {
            @Override
            public void onArticleDetailsDownloaded(KBArticle kbArticle) {
                //Article data downloaded
            }

            @Override
            public void onException(ZDPortalException exception) {
                //Article Exception
            }
        }, params);
    }

    public void getArticleComments(){
        HashMap<String, String> params = new HashMap<>();
        params.put("from", "1");
        params.put("limit", "5");
        ZDPortalKBAPI.getArticleComments(new ZDPortalCallback.ArticleCommentsCallback() {
            @Override
            public void onCommentsDownloaded(ArticleCommentsList commentsList) {
                //Article comments data downloaded
            }

            @Override
            public void onException(ZDPortalException exception) {
                //Article comments Exception
            }
        }, "articleId", "localeCode", params);
    }

    public void getPreviousNextArticles(){
        HashMap<String, String> params = new HashMap<>();
        params.put("from", "1");
        params.put("limit", "5");
        ZDPortalKBAPI.getPrevNextArticles(
            "articleId",
            "localeCode",
            new ZDPortalCallback.KBPrevNextArticlesCallback() {
                @Override
                public void onArticlesDownloaded(KBPrevNextArticlesList kbArticlesList) {
                    //Previous Next Articles data downloaded
                }

                @Override
                public void onException(ZDPortalException exception) {
                    //Previous Next Articles Exception
                }
            },
            params
        );
    }

    public void getArticlesByTag(){
        HashMap<String, String> params = new HashMap<>();
        params.put("tag", "tag name");
        ZDPortalKBAPI.articlesSearchByTag(
            new ZDPortalCallback.ArticlesCallback() {
                @Override
                public void onArticlesDownloaded(KBArticlesList kbArticlesList) {
                    //Articles data downloaded
                }

                @Override
                public void onException(ZDPortalException exception) {
                    //Articles Exception
                }
            },
            params
        );
    }

}
