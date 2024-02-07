package com.zoho.desk.asap.api.samplaes;

import com.zoho.desk.asap.api.ZDPortalCallback;
import com.zoho.desk.asap.api.ZDPortalException;
import com.zoho.desk.asap.api.ZDPortalTicketsAPI;
import com.zoho.desk.asap.api.response.ASAPAttachmentUploadResponse;
import com.zoho.desk.asap.api.response.ASAPAttachmentsList;
import com.zoho.desk.asap.api.response.LayoutRulesList;
import com.zoho.desk.asap.api.response.Ticket;
import com.zoho.desk.asap.api.response.TicketComment;
import com.zoho.desk.asap.api.response.TicketConversation;
import com.zoho.desk.asap.api.response.TicketFieldsList;
import com.zoho.desk.asap.api.response.TicketForm;
import com.zoho.desk.asap.api.response.TicketResolution;
import com.zoho.desk.asap.api.response.TicketThread;
import com.zoho.desk.asap.api.response.TicketThreads;
import com.zoho.desk.asap.api.response.TicketsList;
import com.zoho.desk.asap.api.response.ValidationRulesList;
import org.json.JSONObject;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class TicketAPISampleJava {

    public final void getTicketForms() {
        HashMap<String, String> params = new HashMap<>();
        params.put("departmentId", "departmentId");
        params.put("layoutId", "layoutId");
        ZDPortalTicketsAPI.getTicketForm(new ZDPortalCallback.TicketFormCallback() {
            @Override
            public void onTicketFormDownloaded(TicketForm ticketForm) {
                //Ticket forms downloaded
            }

            @Override
            public void onException(ZDPortalException e) {
                //Ticket forms Exception
            }
        }, params, "multiLayout,providePHIDetails,showIsNested");
    }

    public final void getTicketFields() {
        HashMap<String, String> params = new HashMap<>();
        params.put("departmentId", "departmentId");
        params.put("layoutId", "layoutId");
        ZDPortalTicketsAPI.getTicketFields(new ZDPortalCallback.TicketFieldsCallback() {
            @Override
            public void onTicketFieldsDownloaded(TicketFieldsList ticketFieldsList) {
                //Ticket Fields List Downloaded
            }

            @Override
            public void onException(ZDPortalException e) {
                //Ticket Fields List Exception
            }
        }, params, "apiName");
    }

    public final void getTicketTemplatesList() {
        HashMap<String, String> params = new HashMap<>();
        params.put("from", "1");
        params.put("limit", "50");
        params.put("departmentId", "departmentId");
        params.put("layoutId", "layoutId");
        ZDPortalTicketsAPI.getTemplatesList(new ZDPortalCallback.TemplatesListCallback() {
            @Override
            public void onTemplatesListDownloaded(ArrayList ticketTemplatesList) {
                //Ticket Template List downloaded
            }

            @Override
            public void onException(ZDPortalException e) {
                //Ticket Template List Exception
            }
        }, params);
    }

    public final void getTicketTemplateDetails() {
        ZDPortalTicketsAPI.getTemplateDetails(new ZDPortalCallback.TemplatesDetailsCallback() {
            @Override
            public void onTemplateDetailsDownloaded(HashMap<String, Object> ticketTemplate) {
                //Ticket Template Downloaded
            }

            @Override
            public void onException(ZDPortalException e) {
                //Ticket Template Exception
            }
        }, "templateId", null);
    }

    public final void getTicketValidationRules() {
        HashMap<String, String> params = new HashMap<>();
        params.put("from", "1");
        params.put("limit", "50");
        params.put("activeRulesOnly", "true");
        params.put("departmentId", "departmentId");
        params.put("layoutId", "layoutId");
        ZDPortalTicketsAPI.getValidationRules(new ZDPortalCallback.ValidationRulesCallback() {
            @Override
            public void onValidationRulesDownloaded(ValidationRulesList validationRulesList) {
                //Ticket Validation Rules List
            }

            @Override
            public void onException(ZDPortalException e) {
                //Ticket Validation Rules Exception
            }
        }, params);
    }

    public final void getTicketLayoutRules() {
        HashMap<String, String> params = new HashMap<>();
        params.put("from", "1");
        params.put("limit", "50");
        params.put("activeRulesOnly", "true");
        params.put("departmentId", "departmentId");
        params.put("layoutId", "layoutId");
        ZDPortalTicketsAPI.getLayoutRules(new ZDPortalCallback.LayoutRulesCallback() {
            @Override
            public void onLayoutRulesDownloaded(LayoutRulesList layoutRulesList) {
                //Ticket Layouts Rules Downloaded
            }

            @Override
            public void onException(ZDPortalException e) {
                //Ticket Layouts Rules Exception
            }
        }, params);
    }

    public final void uploadAttachment() {
        ZDPortalTicketsAPI.uploadAttachment(new ZDPortalCallback.UploadAttachmentCallback() {
            @Override
            public void onAttachmentUploaded(ASAPAttachmentUploadResponse attachmentUploadResponse) {
                //Attachment Uploaded
            }

            @Override
            public void attachProgress(float attachmentProgress) {
                //Progress of the uploading attachment
            }

            @Override
            public void onException(ZDPortalException e) {
                //Attachment Upload Exception
            }
        }, new File("attachmentPath"), null);
    }

    public final void createGuestTicket() {
        HashMap<String, Object> ticketData = new HashMap<>();
        ticketData.put("subject", "ticketSubject");
        ticketData.put("departmentId", "departmentId");
        ticketData.put("email", "email");
        ZDPortalTicketsAPI.createGuestTicket(new ZDPortalCallback.CreateGuestTicketCallback() {
            @Override
            public void onGuestTicketCreated(Ticket ticket) {
                //Guest Ticket Details Downloaded
            }

            @Override
            public void onException(ZDPortalException e) {
                //Guest Ticket Details Exception
            }
        }, ticketData, null);
    }

    public final void createTicket() {
        HashMap<String, Object> ticketData = new HashMap<>();
        ticketData.put("subject", "ticketSubject");
        ticketData.put("departmentId", "departmentId");
        ZDPortalTicketsAPI.createTicket(new ZDPortalCallback.CreateTicketCallback() {
            @Override
            public void onTicketCreated(Ticket ticket) {
                //Ticket Details Downloaded
            }

            @Override
            public void onException(ZDPortalException e) {
                //Ticket Details Exception
            }
        }, ticketData, null);
    }

    public final void getTicketsList() {
        HashMap<String, String> params = new HashMap<>();
        params.put("from", "1");
        params.put("limit", "50");
        ZDPortalTicketsAPI.getTicketsList(new ZDPortalCallback.TicketsCallback() {
            @Override
            public void onTicketsListDownloaded(TicketsList ticketList) {
                //Ticket List Downloaded
            }

            @Override
            public void onException(ZDPortalException e) {
                //Ticket List Exception
            }
        }, params);
    }

    public final void searchTickets() {
        HashMap<String, String> params = new HashMap<>();
        params.put("from", "1");
        params.put("limit", "50");
        params.put("searchStr", "searchString");
        ZDPortalTicketsAPI.searchTickets(new ZDPortalCallback.TicketsCallback() {
            @Override
            public void onTicketsListDownloaded(TicketsList ticketList) {
                //Ticket List Downloaded
            }

            @Override
            public void onException(ZDPortalException e) {
                //Ticket List Exception
            }
        }, params);
    }

    public final void getTicketConversation() {
        HashMap<String, String> params = new HashMap<>();
        params.put("from", "1");
        params.put("limit", "50");
        ZDPortalTicketsAPI.getTicketConversation(new ZDPortalCallback.TicketConversationCallback() {
            @Override
            public void onConversationDownloaded(TicketConversation ticketConversation) {
                //Ticket Conversation Downloaded
            }

            @Override
            public void onException(ZDPortalException e) {
                //Ticket Conversation Exception
            }
        }, "ticketId", params, true);
    }

    public final void getTicketThreads() {
        HashMap<String, String> params = new HashMap<>();
        params.put("from", "1");
        params.put("limit", "50");
        ZDPortalTicketsAPI.getTicketThreads(new ZDPortalCallback.ThreadsCallback() {
            @Override
            public void onThreadsDownloaded(TicketThreads ticketThreads) {
                //Ticket Threads Downloaded
            }

            @Override
            public void onException(ZDPortalException e) {
                //Ticket Threads Exception
            }
        }, "ticketId", params);
    }

    public final void getTicketDetails() {
        HashMap<String, String> params = new HashMap<>();
        params.put("include", "products");
        ZDPortalTicketsAPI.getTicketDetails(new ZDPortalCallback.TicketDetailsCallback() {
            @Override
            public void onTicketDetailsCallback(Ticket ticket) {
                //Ticket Details Downloaded
            }

            @Override
            public void onException(ZDPortalException e) {
                //Ticket Details Exception
            }
        }, "ticketId", params);
    }

    public final void getThreadDetails() {
        ZDPortalTicketsAPI.getThreadDetails(new ZDPortalCallback.ThreadDetailsCallback() {
            @Override
            public void onThreadDetailsCallback(TicketThread ticketThread) {
                //Ticket Thread Details Downloaded
            }

            @Override
            public void onException(ZDPortalException e) {
                //Ticket Thread Details Exception
            }
        }, "ticketId", "threadId", null);
    }

    public final void updateThread() {
        HashMap<String, Object> threadData = new HashMap<>();
        threadData.put("content", "threadContent");
        ZDPortalTicketsAPI.updateThread(new ZDPortalCallback.ThreadDetailsCallback() {
            @Override
            public void onThreadDetailsCallback(TicketThread ticketThread) {
                //Updated Ticket Thread Details Downloaded
            }

            @Override
            public void onException(ZDPortalException e) {
                //Ticket Thread Details Exception
            }
        }, "ticketId", "threadId", threadData, null);
    }

    public final void updateTicket() {
        HashMap<String, Object> ticketData = new HashMap<>();
        ticketData.put("phone", "phone");
        ticketData.put("language", "language");
        ZDPortalTicketsAPI.updateTicket(new ZDPortalCallback.TicketDetailsCallback() {
            @Override
            public void onTicketDetailsCallback(Ticket ticket) {
                //Updated Ticket Details Downloaded
            }

            @Override
            public void onException(ZDPortalException e) {
                //Ticket Details Exception
            }
        }, "ticketId", ticketData, null);
    }

    public final void deleteTicketComment() {
        ZDPortalTicketsAPI.deleteTicketComment(new ZDPortalCallback.CommentDeleteCallback() {
            @Override
            public void onCommentDeleted() {
                //Ticket Comment Deleted
            }

            @Override
            public void onException(ZDPortalException e) {
                //Ticket Comment Exception
            }
        }, "ticketId", "commentId", null);
    }

    public final void addThread() {
        HashMap<String, Object> threadData = new HashMap<>();
        threadData.put("content", "threadContent");
        ZDPortalTicketsAPI.addThread(new ZDPortalCallback.ThreadDetailsCallback() {
            @Override
            public void onThreadDetailsCallback(TicketThread ticketThread) {
                //Ticket Thread Details Downloaded
            }

            @Override
            public void onException(ZDPortalException e) {
                //Ticket Thread Details Exception
            }
        }, "ticketId", threadData, null);
    }

    public final void addComment() {
        HashMap<String, Object> commentData = new HashMap<>();
        commentData.put("content", "commentContent");
        ZDPortalTicketsAPI.addComment(new ZDPortalCallback.TicketCommentCallback() {
            @Override
            public void onTicketComment(TicketComment ticketComment) {
                //Ticket Comment Details Downloaded
            }

            @Override
            public void onException(ZDPortalException e) {
                //Ticket Comment Details Exception
            }
        }, "ticketId", commentData, null, true);
    }

    public final void updateComment() {
        HashMap<String, Object> commentData = new HashMap<>();
        commentData.put("content", "commentContent");
        ZDPortalTicketsAPI.updateComment(new ZDPortalCallback.TicketCommentCallback() {
            @Override
            public void onTicketComment(TicketComment ticketComment) {
                //Updated Ticket Comment Details Downloaded
            }

            @Override
            public void onException(ZDPortalException e) {
                //Ticket Comment Details Exception
            }
        }, "ticketId", "commentId", commentData, null, true);
    }

    public final void downloadTicketThreadAttachment() {
        ZDPortalTicketsAPI.downloadTicketThreadAttachment(new ZDPortalCallback.DownloadAttachmentCallback() {
            @Override
            public void onAttachmentDownloaded(InputStream threadAttachment) {
                //Ticket Thread Attachment Downloaded
            }

            @Override
            public void onException(ZDPortalException e) {
                //Ticket Thread Attachment Exception
            }
        }, "ticketId", "threadId", "attachId", null);
    }

    public final void downloadTicketCommentAttachment() {
        ZDPortalTicketsAPI.downloadTicketCommentAttachment(new ZDPortalCallback.DownloadAttachmentCallback() {
            @Override
            public void onAttachmentDownloaded(InputStream commentAttachment) {
                //Ticket Comment Attachment Downloaded
            }

            @Override
            public void onException(ZDPortalException e) {
                //Ticket Comment Attachment Exception
            }
        }, "ticketId", "commentId", "attachId", null);
    }

    public final void downloadTicketAttachment() {
        ZDPortalTicketsAPI.downloadTicketAttachment(new ZDPortalCallback.DownloadAttachmentCallback() {
            @Override
            public void onAttachmentDownloaded(InputStream ticketAttachment) {
                //Ticket Attachment Downloaded
            }

            @Override
            public void onException(ZDPortalException e) {
                //Ticket Attachment Exception
            }
        }, "ticketId", "attachId", null);
    }

    public final void getTicketAttachments() {
        ZDPortalTicketsAPI.getTicketAttachments(new ZDPortalCallback.AttachmentsCallback() {
            @Override
            public void onAttachmentsDownloaded(ASAPAttachmentsList ticketAttachmentsList) {
                //Ticket attachments List Downloaded
            }

            @Override
            public void onException(ZDPortalException e) {
                //Ticket attachments List Exception
            }
        }, "ticketId", null);
    }

    public final void deleteAttachment() {
        ZDPortalTicketsAPI.deleteAttachment(new ZDPortalCallback.AttachmentDeleteCallback() {
            @Override
            public void onAttachmentDeleted() {
                //Attachment Deleted
            }

            @Override
            public void onException(ZDPortalException e) {
                //Attachment Delete Exception
            }
        }, "attachId", null);
    }

    public final void getTicketResolution() {
        ZDPortalTicketsAPI.getTicketResolution(new ZDPortalCallback.TicketResolutionCallback() {
            @Override
            public void onResolutionDownloaded(TicketResolution ticketResolution) {
                //Ticket Resolution Downloaded
            }

            @Override
            public void onException(ZDPortalException e) {
                //Ticket Resolution Exception
            }
        }, "ticketId", null);
    }

    public final void getTicketsCountByFieldValues() {
        HashMap<String, String> params = new HashMap<>();
        params.put("departmentId", "departmentId");
        ZDPortalTicketsAPI.getTicketsCountByFieldValues(new ZDPortalCallback.TicketsCountCallback() {
            @Override
            public void onTicketsCountDownloaded(JSONObject ticketCount) {
                //Tickets Count Downloaded
            }

            @Override
            public void onException(ZDPortalException e) {
                //Tickets Count Downloaded
            }
        }, params);
    }
    
    
}
