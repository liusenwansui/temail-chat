package com.syswin.temail.usermail.dto;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UsermailMsgReplyDTO implements Serializable {

  @ApiModelProperty(value = "发送者")
  @NotEmpty
  private String from;
  @ApiModelProperty(value = "接收者")
  @NotEmpty
  private String to;
  @ApiModelProperty(value = "加密消息")
  private String msgData;
  @ApiModelProperty(value = "源消息ID")
  @NotEmpty
  private String parentMsgId;
  @ApiModelProperty(value = "加密消息ID")
  @NotEmpty
  private String msgId;
  @ApiModelProperty(value = "消息类型")
  private int type;
  @ApiModelProperty(value = "附件大小")
  private int attachmentSize;
  @ApiModelProperty(value = "msgIds")
  private List<String> msgIds;
  @ApiModelProperty(value = "(int) 1 存收件人收件箱 2 存发件人收件箱")
  private int storeType;

  public UsermailMsgReplyDTO(String msgId, String from, String to, int type, String mssage,
      String parentMsgId, int attachmentSize, List<String> msgIds, int storeType) {
    this.msgId = msgId;
    this.from = from;
    this.to = to;
    this.type = type;
    this.msgData = mssage;
    this.parentMsgId = parentMsgId;
    this.attachmentSize = attachmentSize;
    this.msgIds = msgIds;
    this.storeType = storeType;
  }
}
