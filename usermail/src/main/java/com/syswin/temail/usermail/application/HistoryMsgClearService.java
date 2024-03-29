package com.syswin.temail.usermail.application;

import com.syswin.temail.usermail.infrastructure.domain.IUsermailMsgReplyDB;
import com.syswin.temail.usermail.infrastructure.domain.IUsermailMsgDB;
import java.time.LocalDate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HistoryMsgClearService {

  private final IUsermailMsgDB usermailMsgDB;
  private final IUsermailMsgReplyDB usermailMsgReplyDB;

  public HistoryMsgClearService(IUsermailMsgDB usermailMsgDB, IUsermailMsgReplyDB usermailMsgReplyDB) {
    this.usermailMsgDB = usermailMsgDB;
    this.usermailMsgReplyDB = usermailMsgReplyDB;
  }

  /**
   * 分页清除指定时间的历史数据
   *
   * @param beforeDays 时间
   * @param batchNum 页面大小
   */
  public void deleteHistoryMsg(int beforeDays, int batchNum) {
    LocalDate beforeData = LocalDate.now().minusDays(beforeDays);
    this.deleteMsg(beforeData, batchNum);
    this.deleteMsgReply(beforeData, batchNum);
  }

  private void deleteMsg(LocalDate createTime, int batchNum) {
    log.info("label-deleteHistoryMsg deleteMsg begin, createTime: [{}], batchNum: [{}]", createTime, batchNum);
    int count = 0;
    do {
      count = usermailMsgDB.deleteMsgLessThan(createTime, batchNum);
    } while (count > 0);
    log.info("label-deleteHistoryMsg deleteMsg end, createTime: [{}], batchNum: [{}]", createTime, batchNum);
  }

  private void deleteMsgReply(LocalDate createTime, int batchNum) {
    log.info("label-deleteHistoryMsg deleteMsgReply begin, createTime: [{}], batchNum: [{}]", createTime, batchNum);
    int count = 0;
    do {
      count = usermailMsgReplyDB.deleteMsgReplyLessThan(createTime, batchNum);
    } while (count > 0);
    log.info("label-deleteHistoryMsg deleteMsgReply end, createTime: [{}], batchNum: [{}]", createTime, batchNum);
  }

}
