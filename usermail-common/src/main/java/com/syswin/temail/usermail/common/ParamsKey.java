/*
 * MIT License
 *
 * Copyright (c) 2019 Syswin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.syswin.temail.usermail.common;

public class ParamsKey {

  public interface SessionEventKey {

    String FROM = "from";
    String CDTP_HEADER = "header";
    String PACKET_ID_SUFFIX = "-SCD";
    String X_PACKET_ID = "xPacketId";
    String TO = "to";
    String OWNER = "owner";
    String SESSION_MESSAGE_TYPE = "sessionMessageType";
    String MSGID = "msgid";
    String TO_MSG = "toMsg";
    String SEQ_NO = "seqNo";
    String TIMESTAMP = "timestamp";
    String GROUP_TEMAIL = "groupTemail";
    String TEMAIL = "temail";
    String MESSAGE = "message";
    String DELETE_ALL_MSG = "deleteAllMsg";
    String SESSION_EXT_DATA = "sessionExtData";
    String TEMAIL_DOMAIN = "temailDomain";
    /**
     * 回复父消息id
     */
    String PARENT_MSGID = "parentMsgId";
    String ATTACHMENT_SIZE = "attachmentSize";
    String TRASH_MSG_INFO = "trashMsgInfo";
    String REPLY_MSG_PARENT_ID = "replyMsgParentId";
    String AUTHOR = "author";
    String FILTER = "filter";
  }

  public interface HttpHeaderKey {

    String CDTP_HEADER = "CDTP-header";
    String X_PACKET_ID = "X-PACKET-ID";
  }

  public interface CassandraConstant {

    /**
     * keyspace
     */
    String KEYSPACE_USERMAILAGENT = "usermailagent";
    /**
     * table: usermail
     */
    String TABLE_USERMAIL = "usermail";
    /**
     * table: usermail_msg_reply
     */
    String TABLE_USERMAIL_MSG_REPLY = "usermail_msg_reply";
    /**
     * 主键id
     */
    String ID = "id";
    /**
     * usermail、usermial_msg_reply表 message字段
     */
    String MESSAGE = "message";
  }

  public interface MongoCollectionFields {

    String ID = "id";
    String MSGID = "msgid";
    String SESSIONID = "sessionid";
    String FROM = "from";
    String TO = "to";
    String STATUS = "status";
    String TYPE = "type";
    String OWNER = "owner";
    String SEQNO = "seqNo";
    String AT = "at";
    String TOPIC = "topic";
    String CREATETIME = "createTime";
    String UPDATETIME = "updateTime";
    String LASTREPLYMSGID = "lastReplyMsgId";
    String REPLYCOUNT = "replyCount";
    String AUTHOR = "author";
    String ZIPMSG = "zipMsg";
    String FILTER = "filter";
    String PARENTMSGID = "parentMsgid";
  }

  public interface DbSelector {

    String MONGO_DB = "mongodb";
    String MYSQL_DB = "mysqldb";
  }

}
