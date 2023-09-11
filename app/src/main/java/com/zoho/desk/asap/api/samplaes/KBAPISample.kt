package com.zoho.desk.asap.api.samplaes

import com.zoho.desk.asap.api.ZDPortalCallback.ArticleCommentsCallback
import com.zoho.desk.asap.api.ZDPortalCallback.ArticleDetailsCallback
import com.zoho.desk.asap.api.ZDPortalCallback.ArticleFeedbackCallback
import com.zoho.desk.asap.api.ZDPortalCallback.ArticleUpdateVoteCallback
import com.zoho.desk.asap.api.ZDPortalCallback.ArticlesCallback
import com.zoho.desk.asap.api.ZDPortalCallback.AttachmentsCallback
import com.zoho.desk.asap.api.ZDPortalCallback.DownloadAttachmentCallback
import com.zoho.desk.asap.api.ZDPortalCallback.KBCategoriesCallback
import com.zoho.desk.asap.api.ZDPortalCallback.KBCategoryCallback
import com.zoho.desk.asap.api.ZDPortalCallback.KBPrevNextArticlesCallback
import com.zoho.desk.asap.api.ZDPortalException
import com.zoho.desk.asap.api.ZDPortalKBAPI
import com.zoho.desk.asap.api.response.ASAPAttachmentsList
import com.zoho.desk.asap.api.response.ArticleCommentsList
import com.zoho.desk.asap.api.response.KBArticle
import com.zoho.desk.asap.api.response.KBArticlesList
import com.zoho.desk.asap.api.response.KBCategoriesList
import com.zoho.desk.asap.api.response.KBCategory
import com.zoho.desk.asap.api.response.KBPrevNextArticlesList
import java.io.InputStream

class KBAPISample {

    fun getKBRootCategories() {
        val params = hashMapOf<String, String>()
        params["from"] = "1"
        params["limit"] = "2"
        params["locale"] = "localeCode"
        params["sortBy"] = "name"
//        params["sortBy"] = "order"
        params["searchValue"] = "searchValue"
        params["departmentId"] = "departmentId"
        params["hasArticles"] = "true"
        params["include"] = "allArticleCount,sectionsCount"
        ZDPortalKBAPI.geRootKBCategories(object : KBCategoriesCallback {
            override fun onKBCategoriesDownloaded(kbCategoriesList: KBCategoriesList) {
                //Categories data downloaded
            }

            override fun onException(e: ZDPortalException) {
                //Root Categories Exception
            }
        }, params)
    }

    fun getKBRootCategoriesTree() {
        val params = HashMap<String, String>()
        params["locale"] = "localeCode"
        params["sortBy"] = "name"
//        params["sortBy"] = "order"
        params["hasArticles"] = "true"
        params["include"] = "allArticleCount,sectionsCount"
        ZDPortalKBAPI.getKBCategoriesTree(object : KBCategoryCallback {
            override fun onKBCategoryDownloaded(category: KBCategory) {
                //Categories data downloaded
            }

            override fun onException(e: ZDPortalException) {
                //Root Categories Exception
            }
        }, "RootCategoryId", params)
    }

    fun getKBCategoryWithPermalink() {
        val params = HashMap<String, String>()
        params["permalink"] = "permalink"
        params["locale"] = "localeCode"
        params["departmentId"] = "departmentId"
        params["hasArticles"] = "false"
        params["include"] = "sectionsCount,allArticleCount,articlesCount"
        ZDPortalKBAPI.getKBCategoryWithPermalink(object : KBCategoryCallback {
            override fun onKBCategoryDownloaded(kbCategory: KBCategory) {
                //categories data downloaded
            }

            override fun onException(exception: ZDPortalException) {
                //categories Exception
            }
        }, params)
    }

    fun getArticles() {
        val params = HashMap<String, String>()
        params["categoryId"] = "categoryId"
        params["from"] = "1"
        params["limit"] = "50"
        params["locale"] = "localeCode"
        params["includeChildCategoryArticles"] = "true"
        params["sortBy"] = "-likeCount"
//        params["sortBy"] = "-createdTime"
        params["tag"] = "TagName"
        ZDPortalKBAPI.getArticlesList(object : ArticlesCallback {
            override fun onArticlesDownloaded(kbArticlesList: KBArticlesList) {
                //Articles data downloaded
            }

            override fun onException(exception: ZDPortalException) {
                //Articles Exception
            }
        }, params)
    }

    fun getArticleDetails() {
        ZDPortalKBAPI.getArticleDetails(object : ArticleDetailsCallback {
            override fun onArticleDetailsDownloaded(kbArticle: KBArticle) {
                //Article details data downloaded
            }

            override fun onException(exception: ZDPortalException) {
                //Article details Exception
            }
        }, "articleId", "localeCode", null)
    }

    fun getRelatedArticles() {
        val params = HashMap<String, String>()
        params["from"] = "1"
        params["limit"] = "5"
        params["locale"] = "localeCode"
        ZDPortalKBAPI.getRelatedArticles(
            "articleId",
            "localeCode",
            object : ArticlesCallback {
                override fun onArticlesDownloaded(kbArticlesList: KBArticlesList) {
                    //Related Articles data downloaded
                }

                override fun onException(exception: ZDPortalException) {
                    //Related Articles Exception
                }
            },
            params
        )
    }

    fun getArticleAttachmentList() {
        ZDPortalKBAPI.getArticleAttachments(object : AttachmentsCallback {
            override fun onAttachmentsDownloaded(attachmentsList: ASAPAttachmentsList) {
                //Article Attachments data downloaded
            }

            override fun onException(exception: ZDPortalException) {
                //Article Attachments Exception
            }
        }, "articleId", "localeCode", null)
    }

    fun likeArticle() {
        ZDPortalKBAPI.likeArticle(object : ArticleUpdateVoteCallback {
            override fun onArticleUpdated() {
                //Article Liked Successfully
            }

            override fun onException(exception: ZDPortalException) {
                //Article Liked Exception
            }
        }, "articleId", "localeCode", null)
    }

    fun dislikeArticle() {
        ZDPortalKBAPI.dislikeArticle(object : ArticleUpdateVoteCallback {
            override fun onArticleUpdated() {
                //Article Disliked Successfully
            }

            override fun onException(exception: ZDPortalException) {
                //Article Dislike Exception
            }
        }, "articleId", "localeCode", null)
    }

    fun feedbackArticle() {
        val feedbackContent = HashMap<String, String>()
        feedbackContent["email"] = "userEmail"
        feedbackContent["feedback"] = "feedbackContent"
        ZDPortalKBAPI.articleFeedback(object : ArticleFeedbackCallback {
            override fun onFeedbackPosted() {
                //Article Feedback posted
            }

            override fun onException(exception: ZDPortalException) {
                //Article Feedback Exception
            }
        }, "articleId", "localeCode", feedbackContent, null)
    }

    fun getArticleAttachmentContent() {
        ZDPortalKBAPI.downloadArticleAttachment(object : DownloadAttachmentCallback {
            override fun onAttachmentDownloaded(stream: InputStream) {
                //Article Attachment content downloaded
            }

            override fun onException(exception: ZDPortalException) {
                //Article Attachment Exception
            }
        }, "articleId", "localeCode", "attachmentId", null)
    }

    fun searchArticles() {
        val params = HashMap<String, String>()
        params["searchStr"] = "searchString"
        params["from"] = "1"
        params["limit"] = "50"
        params["locale"] = "localeCode"
        params["departmentId"] = "deptId"
        params["categoryId"] = "categoryId"
        ZDPortalKBAPI.searchArticles(object : ArticlesCallback {
            override fun onArticlesDownloaded(kbArticlesList: KBArticlesList) {
                //Categories data downloaded
            }

            override fun onException(exception: ZDPortalException) {
                //Root Categories Exception
            }
        }, false, params)
    }

    fun getArticleDetailsByPermalink() {
        val params = HashMap<String, String>()
        params["permalink"] = "permalink"
        ZDPortalKBAPI.getArticleDetailsWithPermalink(object : ArticleDetailsCallback {
            override fun onArticleDetailsDownloaded(kbArticle: KBArticle) {
                //Article data downloaded
            }

            override fun onException(exception: ZDPortalException) {
                //Article Exception
            }
        }, params)
    }

    fun getArticleComments() {
        val params = HashMap<String, String>()
        params["from"] = "1"
        params["limit"] = "5"
        params["sortBy"] = "-commentedTime"
        ZDPortalKBAPI.getArticleComments(object : ArticleCommentsCallback {
            override fun onCommentsDownloaded(commentsList: ArticleCommentsList) {
                //Article comments data downloaded
            }

            override fun onException(exception: ZDPortalException) {
                //Article comments Exception
            }
        }, "articleId", "localeCode", params)
    }

    fun getPreviousNextArticles() {
        val params = HashMap<String, String>()
        params["from"] = "1"
        params["limit"] = "5"
        ZDPortalKBAPI.getPrevNextArticles(
            "articleId",
            "localeCode",
            object : KBPrevNextArticlesCallback {
                override fun onArticlesDownloaded(kbArticlesList: KBPrevNextArticlesList) {
                    //Previous Next Articles data downloaded
                }

                override fun onException(exception: ZDPortalException) {
                    //Previous Next Articles Exception
                }
            },
            params
        )
    }

    fun getArticlesByTag() {
        val params = HashMap<String, String>()
        params["categoryId"] = "categoryId"
        params["tag"] = "tag name"
        params["from"] = "1"
        params["limit"] = "5"
        params["locale"] = "localeCode"
        ZDPortalKBAPI.articlesSearchByTag(
            object : ArticlesCallback {
                override fun onArticlesDownloaded(kbArticlesList: KBArticlesList) {
                    //Articles data downloaded
                }

                override fun onException(exception: ZDPortalException) {
                    //Articles Exception
                }
            },
            params
        )
    }

}