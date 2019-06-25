package com.syswin.temail.usermail.infrastructure.domain.impl;

import static org.assertj.core.api.Assertions.assertThat;

import com.syswin.temail.usermail.domains.UsermailMsgReplyDO;
import com.syswin.temail.usermail.dto.QueryMsgReplyDTO;
import com.syswin.temail.usermail.infrastructure.domain.mapper.UsermailMsgReplyMapper;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsermailMsgReplyImplTest {

    private UsermailMsgReplyRepoImpl usermailMsgReplyRepoImpl;
  private UsermailMsgReplyMapper usermailMsgReplyMapper;

  @Before
  public void setup(){
    this.usermailMsgReplyMapper = Mockito.mock(UsermailMsgReplyMapper.class);
    this.usermailMsgReplyRepoImpl = new UsermailMsgReplyRepoImpl(usermailMsgReplyMapper);
  }

  @Test
  public void insert() {
    UsermailMsgReplyDO usermailMsgReply = new UsermailMsgReplyDO();
    ArgumentCaptor<UsermailMsgReplyDO> usermailMsgReplyCap = ArgumentCaptor.forClass(UsermailMsgReplyDO.class);
    usermailMsgReplyRepoImpl.insert(usermailMsgReply);
    Mockito.verify(usermailMsgReplyMapper).insert(usermailMsgReplyCap.capture());
    assertThat(usermailMsgReplyCap.getValue()).isEqualTo(usermailMsgReply);
  }

  @Test
  public void getMsgReplys() {
    QueryMsgReplyDTO queryMsgReplyDTO = new QueryMsgReplyDTO();
    ArgumentCaptor<QueryMsgReplyDTO> queryMsgReplyDTOCap = ArgumentCaptor.forClass(QueryMsgReplyDTO.class);
    usermailMsgReplyRepoImpl.listMsgReplys(queryMsgReplyDTO);
    Mockito.verify(usermailMsgReplyMapper).listMsgReplys(queryMsgReplyDTOCap.capture());
    assertThat(queryMsgReplyDTOCap.getValue()).isEqualTo(queryMsgReplyDTO);
  }

  @Test
  public void deleteBatchMsgReplyStatus() {
    String ower = "ower";
    ArgumentCaptor<String> owerCap = ArgumentCaptor.forClass(String.class);
    ArgumentCaptor<List<String>> msgIdsCap = ArgumentCaptor.forClass(ArrayList.class);
    List<String> msgIds = new ArrayList<String>();
    usermailMsgReplyRepoImpl.deleteMsgReplysByMsgIds(ower,msgIds);
    Mockito.verify(usermailMsgReplyMapper).deleteMsgReplysByMsgIds(owerCap.capture(),msgIdsCap.capture());
    assertThat(owerCap.getValue()).isEqualTo(ower);
    assertThat(msgIdsCap.getValue()).isEqualTo(msgIds);
  }

  @Test
  public void batchDeleteBySessionId() {
    String ower = "ower";
    String sessionId = "sessionId";
    usermailMsgReplyRepoImpl.deleteMsgReplysBySessionId(sessionId,ower);
    ArgumentCaptor<String> owerCap = ArgumentCaptor.forClass(String.class);
    ArgumentCaptor<String> sessionIdCap = ArgumentCaptor.forClass(String.class);
    Mockito.verify(usermailMsgReplyMapper).deleteMsgReplysBySessionId(sessionIdCap.capture(),owerCap.capture());
    assertThat(owerCap.getValue()).isEqualTo(ower);
    assertThat(sessionIdCap.getValue()).isEqualTo(sessionId);
  }

  @Test
  public void deleteMsgByParentIdAndOwner() {
    String ower = "ower";
    List<String> parentMsgIds = new ArrayList<String>();
    usermailMsgReplyRepoImpl.deleteMsgReplysByParentIds(ower,parentMsgIds);
    ArgumentCaptor<String> owerCap = ArgumentCaptor.forClass(String.class);
    ArgumentCaptor<List<String>> parentMsgIdsCap = ArgumentCaptor.forClass(ArrayList.class);
    Mockito.verify(usermailMsgReplyMapper).deleteMsgReplysByParentIds(owerCap.capture(),parentMsgIdsCap.capture());
    assertThat(owerCap.getValue()).isEqualTo(ower);
    assertThat(parentMsgIdsCap.getValue()).isEqualTo(parentMsgIds);
  }

  @Test
  public void getMsgReplyByCondition() {
    UsermailMsgReplyDO usermailMsgReply = new UsermailMsgReplyDO();
    usermailMsgReplyRepoImpl.selectMsgReplyByCondition(usermailMsgReply);
    ArgumentCaptor<UsermailMsgReplyDO> usermailMsgReplyCap = ArgumentCaptor.forClass(UsermailMsgReplyDO.class);
    Mockito.verify(usermailMsgReplyMapper).selectMsgReplyByCondition(usermailMsgReplyCap.capture());
    assertThat(usermailMsgReplyCap.getValue()).isEqualTo(usermailMsgReply);
  }


}
