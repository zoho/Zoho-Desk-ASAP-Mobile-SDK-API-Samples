package com.zoho.desk.asap.api.samplaes

import com.zoho.desk.asap.api.ZDPortalCallback
import com.zoho.desk.asap.api.ZDPortalException
import com.zoho.desk.asap.api.ZDPortalTicketsAPI
import com.zoho.desk.asap.api.response.ASAPAttachmentUploadResponse
import com.zoho.desk.asap.api.response.ASAPAttachmentsList
import com.zoho.desk.asap.api.response.LayoutRulesList
import com.zoho.desk.asap.api.response.Ticket
import com.zoho.desk.asap.api.response.TicketComment
import com.zoho.desk.asap.api.response.TicketConversation
import com.zoho.desk.asap.api.response.TicketFieldsList
import com.zoho.desk.asap.api.response.TicketForm
import com.zoho.desk.asap.api.response.TicketResolution
import com.zoho.desk.asap.api.response.TicketTemplate
import com.zoho.desk.asap.api.response.TicketThread
import com.zoho.desk.asap.api.response.TicketThreads
import com.zoho.desk.asap.api.response.TicketsList
import com.zoho.desk.asap.api.response.ValidationRulesList
import org.json.JSONObject
import java.io.File
import java.io.InputStream
import java.util.ArrayList
import java.util.HashMap

class TicketAPISample {

    fun getTicketForms() {
        val params = hashMapOf<String, String>()
        params["departmentId"] = "departmentId"
        params["layoutId"] = "layoutId"
        ZDPortalTicketsAPI.getTicketForm(object : ZDPortalCallback.TicketFormCallback {
            override fun onTicketFormDownloaded(ticketForm: TicketForm?) {
                //Ticket forms downloaded
            }

            override fun onException(e: ZDPortalException) {
                //Ticket forms Exception
            }
        }, params, "multiLayout,providePHIDetails,showIsNested")
    }

    fun getTicketFields() {
        val params = hashMapOf<String, String>()
        params["departmentId"] = "departmentId"
        params["layoutId"] = "layoutId"
        ZDPortalTicketsAPI.getTicketFields(object : ZDPortalCallback.TicketFieldsCallback {
            override fun onTicketFieldsDownloaded(ticketFieldsList: TicketFieldsList?) {
                //Ticket Fields List Downloaded
            }

            override fun onException(e: ZDPortalException) {
                //Ticket Fields List Exception
            }
        }, params, "apiName")
    }

    fun getTicketTemplatesList() {
        val params = hashMapOf<String, String>()
        params["from"] = "1"
        params["limit"] = "50"
        params["departmentId"] = "departmentId"
        params["layoutId"] = "layoutId"
        ZDPortalTicketsAPI.getTemplatesList(object : ZDPortalCallback.TemplatesListCallback {
            override fun onTemplatesListDownloaded(ticketTemplatesList: ArrayList<TicketTemplate>?) {
                //Ticket Template List downloaded
            }

            override fun onException(e: ZDPortalException) {
                //Ticket Template List Exception
            }
        }, params)
    }

    fun getTicketTemplateDetails() {
        ZDPortalTicketsAPI.getTemplateDetails(object : ZDPortalCallback.TemplatesDetailsCallback {
            override fun onTemplateDetailsDownloaded(ticketTemplate: HashMap<String, Any>?) {
                //Ticket Template Downloaded
            }

            override fun onException(e: ZDPortalException) {
                //Ticket Template Exception
            }
        }, "templateId", null)
    }

    fun getTicketValidationRules() {
        val params = hashMapOf<String, String>()
        params["from"] = "1"
        params["limit"] = "50"
        params["activeRulesOnly"] = "true"
        params["departmentId"] = "departmentId"
        params["layoutId"] = "layoutId"
        ZDPortalTicketsAPI.getValidationRules(object : ZDPortalCallback.ValidationRulesCallback {
            override fun onValidationRulesDownloaded(validationRulesList: ValidationRulesList?) {
                //Ticket Validation Rules List
            }

            override fun onException(e: ZDPortalException) {
                //Ticket Validation Rules Exception
            }
        }, params)
    }

    fun getTicketLayoutRules() {
        val params = hashMapOf<String, String>()
        params["from"] = "1"
        params["limit"] = "50"
        params["activeRulesOnly"] = "true"
        params["departmentId"] = "departmentId"
        params["layoutId"] = "layoutId"
        ZDPortalTicketsAPI.getLayoutRules(object : ZDPortalCallback.LayoutRulesCallback {
            override fun onLayoutRulesDownloaded(layoutRulesList: LayoutRulesList?) {
                //Ticket Layouts Rules Downloaded
            }

            override fun onException(e: ZDPortalException) {
                //Ticket Layouts Rules Exception
            }
        }, params)
    }

    fun uploadAttachment() {
        ZDPortalTicketsAPI.uploadAttachment(object : ZDPortalCallback.UploadAttachmentCallback {
            override fun onAttachmentUploaded(attachmentUploadResponse: ASAPAttachmentUploadResponse?) {
                //Attachment Uploaded
            }

            override fun attachProgress(attachmentProgress: Float) {
                //Progress of the uploading attachment
            }

            override fun onException(e: ZDPortalException) {
                //Attachment Upload Exception
            }
        }, File("attachmentPath"), null)
    }

    fun createGuestTicket() {
        val ticketData = hashMapOf<String, Any>()
        ticketData["subject"] = "ticketSubject"
        ticketData["departmentId"] = "departmentId"
        ticketData["email"] = "email"
        ZDPortalTicketsAPI.createGuestTicket(object : ZDPortalCallback.CreateGuestTicketCallback {
            override fun onGuestTicketCreated(ticket: Ticket?) {
                //Guest Ticket Details Downloaded
            }

            override fun onException(e: ZDPortalException) {
                //Guest Ticket Details Exception
            }
        }, ticketData, null)
    }

    fun createTicket() {
        val ticketData = hashMapOf<String, Any>()
        ticketData["subject"] = "ticketSubject"
        ticketData["departmentId"] = "departmentId"
        ZDPortalTicketsAPI.createTicket(object : ZDPortalCallback.CreateTicketCallback {
            override fun onTicketCreated(ticket: Ticket?) {
                //Ticket Details Downloaded
            }

            override fun onException(e: ZDPortalException) {
                //Ticket Details Exception
            }
        }, ticketData, null)
    }

    fun getTicketsList() {
        val params = hashMapOf<String, String>()
        params["from"] = "1"
        params["limit"] = "50"
        ZDPortalTicketsAPI.getTicketsList(object : ZDPortalCallback.TicketsCallback {
            override fun onTicketsListDownloaded(ticketList: TicketsList?) {
                //Ticket List Downloaded
            }

            override fun onException(e: ZDPortalException) {
                //Ticket List Exception
            }
        }, params)
    }

    fun searchTickets() {
        val params = hashMapOf<String, String>()
        params["from"] = "1"
        params["limit"] = "50"
        params["searchStr"] = "searchString"
        ZDPortalTicketsAPI.searchTickets(object : ZDPortalCallback.TicketsCallback {
            override fun onTicketsListDownloaded(ticketList: TicketsList?) {
                //Ticket List Downloaded
            }

            override fun onException(e: ZDPortalException) {
                //Ticket List Exception
            }
        }, params)
    }

    fun getTicketConversation() {
        val params = hashMapOf<String, String>()
        params["from"] = "1"
        params["limit"] = "50"
        ZDPortalTicketsAPI.getTicketConversation(object : ZDPortalCallback.TicketConversationCallback {
            override fun onConversationDownloaded(ticketConversation: TicketConversation?) {
                //Ticket Conversation Downloaded
            }

            override fun onException(e: ZDPortalException) {
                //Ticket Conversation Exception
            }
        }, "ticketId", params, true)
    }

    fun getTicketThreads() {
        val params = hashMapOf<String, String>()
        params["from"] = "1"
        params["limit"] = "50"
        ZDPortalTicketsAPI.getTicketThreads(object : ZDPortalCallback.ThreadsCallback {
            override fun onThreadsDownloaded(ticketThreads: TicketThreads?) {
                //Ticket Threads Downloaded
            }

            override fun onException(e: ZDPortalException) {
                //Ticket Threads Exception
            }
        }, "ticketId", params)
    }

    fun getTicketDetails() {
        val params = hashMapOf<String, String>()
        params["include"] = "products"
        ZDPortalTicketsAPI.getTicketDetails(object : ZDPortalCallback.TicketDetailsCallback {
            override fun onTicketDetailsCallback(ticket: Ticket?) {
                //Ticket Details Downloaded
            }

            override fun onException(e: ZDPortalException) {
                //Ticket Details Exception
            }
        }, "ticketId", params)
    }

    fun getThreadDetails() {
        ZDPortalTicketsAPI.getThreadDetails(object : ZDPortalCallback.ThreadDetailsCallback {
            override fun onThreadDetailsCallback(ticketThread: TicketThread?) {
                //Ticket Thread Details Downloaded
            }

            override fun onException(e: ZDPortalException) {
                //Ticket Thread Details Exception
            }
        }, "ticketId", "threadId", null)
    }

    fun updateThread() {
        val threadData = hashMapOf<String, Any>()
        threadData["content"] = "threadContent"
        ZDPortalTicketsAPI.updateThread(object : ZDPortalCallback.ThreadDetailsCallback {
            override fun onThreadDetailsCallback(ticketThread: TicketThread?) {
                //Updated Ticket Thread Details Downloaded
            }

            override fun onException(e: ZDPortalException) {
                //Ticket Thread Details Exception
            }
        }, "ticketId", "threadId", threadData, null)
    }

    fun updateTicket() {
        val ticketData = hashMapOf<String, Any>()
        ticketData["phone"] = "phone"
        ticketData["language"] = "language"
        ZDPortalTicketsAPI.updateTicket(object : ZDPortalCallback.TicketDetailsCallback {
            override fun onTicketDetailsCallback(ticket: Ticket?) {
                //Updated Ticket Details Downloaded
            }

            override fun onException(e: ZDPortalException) {
                //Ticket Details Exception
            }
        }, "ticketId", ticketData, null)
    }

    fun deleteTicketComment() {
        ZDPortalTicketsAPI.deleteTicketComment(object : ZDPortalCallback.CommentDeleteCallback {
            override fun onCommentDeleted() {
                //Ticket Comment Deleted
            }

            override fun onException(e: ZDPortalException) {
                //Ticket Comment Exception
            }
        }, "ticketId", "commentId", null)
    }

    fun addThread() {
        val threadData = hashMapOf<String, Any>()
        threadData["content"] = "threadContent"
        ZDPortalTicketsAPI.addThread(object : ZDPortalCallback.ThreadDetailsCallback {
            override fun onThreadDetailsCallback(ticketThread: TicketThread?) {
                //Ticket Thread Details Downloaded
            }

            override fun onException(e: ZDPortalException) {
                //Ticket Thread Details Exception
            }
        }, "ticketId", threadData, null)
    }

    fun addComment() {
        val commentData = hashMapOf<String, Any>()
        commentData["content"] = "commentContent"
        ZDPortalTicketsAPI.addComment(object : ZDPortalCallback.TicketCommentCallback {
            override fun onTicketComment(ticketComment: TicketComment?) {
                //Ticket Comment Details Downloaded
            }

            override fun onException(e: ZDPortalException) {
                //Ticket Comment Details Exception
            }
        }, "ticketId", commentData, null, true)
    }

    fun updateComment() {
        val commentData = hashMapOf<String, Any>()
        commentData["content"] = "commentContent"
        ZDPortalTicketsAPI.updateComment(object : ZDPortalCallback.TicketCommentCallback {
            override fun onTicketComment(ticketComment: TicketComment?) {
                //Updated Ticket Comment Details Downloaded
            }

            override fun onException(e: ZDPortalException) {
                //Ticket Comment Details Exception
            }
        }, "ticketId", "commentId", commentData, null, true)
    }

    fun downloadTicketThreadAttachment() {
        ZDPortalTicketsAPI.downloadTicketThreadAttachment(object : ZDPortalCallback.DownloadAttachmentCallback {
            override fun onAttachmentDownloaded(threadAttachment: InputStream?) {
                //Ticket Thread Attachment Downloaded
            }

            override fun onException(e: ZDPortalException) {
                //Ticket Thread Attachment Exception
            }
        }, "ticketId", "threadId", "attachId", null)
    }

    fun downloadTicketCommentAttachment() {
        ZDPortalTicketsAPI.downloadTicketCommentAttachment(object : ZDPortalCallback.DownloadAttachmentCallback {
            override fun onAttachmentDownloaded(commentAttachment: InputStream?) {
                //Ticket Comment Attachment Downloaded
            }

            override fun onException(e: ZDPortalException) {
                //Ticket Comment Attachment Exception
            }
        }, "ticketId", "commentId", "attachId", null)
    }

    fun downloadTicketAttachment() {
        ZDPortalTicketsAPI.downloadTicketAttachment(object : ZDPortalCallback.DownloadAttachmentCallback {
            override fun onAttachmentDownloaded(ticketAttachment: InputStream?) {
                //Ticket Attachment Downloaded
            }

            override fun onException(e: ZDPortalException) {
                //Ticket Attachment Exception
            }
        }, "ticketId", "attachId", null)
    }

    fun getTicketAttachments() {
        ZDPortalTicketsAPI.getTicketAttachments(object : ZDPortalCallback.AttachmentsCallback {
            override fun onAttachmentsDownloaded(ticketAttachmentsList: ASAPAttachmentsList?) {
                //Ticket attachments List Downloaded
            }

            override fun onException(e: ZDPortalException) {
                //Ticket attachments List Exception
            }
        }, "ticketId", null)
    }

    fun deleteAttachment() {
        ZDPortalTicketsAPI.deleteAttachment(object : ZDPortalCallback.AttachmentDeleteCallback {
            override fun onAttachmentDeleted() {
                //Attachment Deleted
            }

            override fun onException(e: ZDPortalException) {
                //Attachment Delete Exception
            }
        }, "attachId", null)
    }

    fun getTicketResolution() {
        ZDPortalTicketsAPI.getTicketResolution(object : ZDPortalCallback.TicketResolutionCallback {
            override fun onResolutionDownloaded(ticketResolution: TicketResolution?) {
                //Ticket Resolution Downloaded
            }

            override fun onException(e: ZDPortalException) {
                //Ticket Resolution Exception
            }
        }, "ticketId", null)
    }

    fun getTicketsCountByFieldValues() {
        val params = hashMapOf<String, String>()
        params["departmentId"] = "departmentId"
        ZDPortalTicketsAPI.getTicketsCountByFieldValues(object : ZDPortalCallback.TicketsCountCallback {
            override fun onTicketsCountDownloaded(ticketCount: JSONObject?) {
                //Tickets Count Downloaded
            }

            override fun onException(e: ZDPortalException) {
                //Tickets Count Downloaded
            }

        }, params)
    }

}