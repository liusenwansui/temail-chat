package com.syswin.temail.usermail.infrastructure.domain.mapper;


import com.syswin.temail.usermail.domains.UsermailMsgReply;
import com.syswin.temail.usermail.dto.QueryMsgReplyDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsermailMsgReplyMapper {

  /**
   * @param record 回复消息信息
   * @description 新增回复消息
   */
  int insert(UsermailMsgReply record);

  /**
   * @param dto 查询消息条件
   * @description 查询指定消息的回复消息列表
   */
  List<UsermailMsgReply> getMsgReplys(QueryMsgReplyDTO dto);

  /**
   * @param owner 消息拥有者
   * @param msgIds 消息id列表
   * @description 根据msgId批量删除回复消息
   */
  int deleteBatchMsgReplyStatus(@Param("owner") String owner, @Param("msgIds") List<String> msgIds);

  /**
   * @param sessionId 会话id
   * @param owner 拥有者
   * @description 根据sessionId批量删除回复消息
   */
  int batchDeleteBySessionId(@Param("sessionid") String sessionId, @Param("owner") String owner);

  /**
   * @param owner 拥有者
   * @param parentMsgIds 父消息id列表
   * @description 根据父消息删除回复消息
   */
  int deleteMsgByParentIdAndOwner(@Param("owner") String owner, @Param("parentMsgIds") List<String> parentMsgIds);

  /**
   * @param usermailMsgReply 查询回复消息列表条件
   * @description 根据条件查询回复消息列表
   */
  UsermailMsgReply getMsgReplyByCondition(UsermailMsgReply usermailMsgReply);

  /**
   * @param owner 拥有者
   * @param msgid 消息id
   * @param status 消息状态
   * @description 回复消息阅后即焚
   */
  int destoryAfterRead(@Param("owner") String owner, @Param("msgid") String msgid, @Param("status") int status);

  /**
   * @param owner 拥有者
   * @param parentMsgIds 父消息id列表
   * @param status 消息状态
   * @description 根据父消息批量修改消息状态
   */
  int batchUpdateByParentMsgIds(@Param("owner") String owner, @Param("parentMsgIds") List<String> parentMsgIds,
      @Param("status") int status);

  /**
   * @param owner 拥有者
   * @param status 消息状态
   * @description 根据用户和消息状态批量删除消息
   */
  int batchDeleteByStatus(@Param("owner") String owner, @Param("status") int status);

  /**
   * @param parentMsgid 父消息id
   * @param owner 拥有者
   * @param status 消息状态
   * @description 获取最近一条回复消息
   */
  UsermailMsgReply getLastUsermailReply(@Param("parentMsgid") String parentMsgid, @Param("owner") String owner,
      @Param("status") int status);

  /**
   * @param usermailMsgReply 撤回的消息信息
   * @description 撤回用户回复的消息
   */
  int revertUsermailReply(UsermailMsgReply usermailMsgReply);
}