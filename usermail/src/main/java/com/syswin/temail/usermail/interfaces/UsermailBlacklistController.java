package com.syswin.temail.usermail.interfaces;

import com.syswin.temail.usermail.application.UsermailBlacklistService;
import com.syswin.temail.usermail.core.dto.ResultDTO;
import com.syswin.temail.usermail.domains.UsermailBlacklist;
import com.syswin.temail.usermail.dto.BlacklistDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsermailBlacklistController {

  private final UsermailBlacklistService usermailBlacklistService;

  @Autowired
  public UsermailBlacklistController(UsermailBlacklistService usermailBlacklistService) {
    this.usermailBlacklistService = usermailBlacklistService;
  }

  /**
   * 发送者将接收者加入发送者黑名单列表
   *
   * @param request HttpServletRequest
   * @param blacklistDto 请求参数：发送者{@link BlacklistDTO#getTemailAddress()}，接收者{@link BlacklistDTO#getBlackedAddress()}。
   * @return 返回ResultDTO对象
   * @See ResultDTO
   */
  @ApiOperation(value = "添加黑名单(1000)")
  @PostMapping(value = "/blacklist")
  public ResultDTO createBlacklist(HttpServletRequest request,
      @ApiParam(value = "黑名单关系双方的temail地址", required = true) @RequestBody @Valid BlacklistDTO blacklistDto) {
    usermailBlacklistService
        .save(new UsermailBlacklist(blacklistDto.getTemailAddress(), blacklistDto.getBlackedAddress()));
    return new ResultDTO();
  }

  /**
   * 发送者将接收者从黑名单列表移出
   *
   * @param request HttpServletRequest
   * @param blacklistDto 请求参数：发送者{@link BlacklistDTO#getTemailAddress()}，接收者{@link BlacklistDTO#getBlackedAddress()}。
   * @return 返回ResultDTO对象
   * @See ResultDTO
   */
  @ApiOperation(value = "删除黑名单(1001)")
  @DeleteMapping(value = "/blacklist")
  public ResultDTO removeBlacklist(HttpServletRequest request,
      @ApiParam(value = "黑名单关系双方的temail地址", required = true) @RequestBody @Valid BlacklistDTO blacklistDto) {
    usermailBlacklistService
        .remove(new UsermailBlacklist(blacklistDto.getTemailAddress(), blacklistDto.getBlackedAddress()));
    return new ResultDTO();
  }

  /**
   * 查询发起者拉黑名单列表
   *
   * @param temailAddress 发送者地址
   * @return 返回ResultDTO对象，包含拉黑名单列表。
   * @See ResultDTO
   */
  @ApiOperation(value = "查询发起者拉黑关系列表")
  @GetMapping(value = "/blacklist")
  public ResultDTO findBlacklists(
      @ApiParam(value = "发起者temail地址", required = true) @RequestParam(value = "temailAddress", defaultValue = "") String temailAddress) {
    List<UsermailBlacklist> usermailBlacklists = usermailBlacklistService.findByTemailAddress(temailAddress);
    List<String> blackedAddresses = usermailBlacklists.stream()
        .map(UsermailBlacklist::getBlackedAddress).collect(Collectors.toList());
    ResultDTO resultDto = new ResultDTO();
    resultDto.setData(blackedAddresses);
    return resultDto;
  }

  /**
   * 判断发送者from是否被加入接收者to的黑名单列表，若{@link ResultDTO#getData()}值大于0，则from被加入to黑名单，反之，则不然。
   *
   * @param from 发送者
   * @param to 接收者
   * @return ResultDTO
   * @See ResultDTO
   */
  @ApiOperation(value = "[from]给[to]时，判断是否被[to]加在黑名单中")
  @GetMapping(value = "/inblacklist")
  public ResultDTO isInBlacklists(
      @ApiParam(value = "发起人", required = true) @RequestParam(value = "from", defaultValue = "") String from,
      @ApiParam(value = "收件人", required = true) @RequestParam(value = "to", defaultValue = "") String to) {
    int inBlacklist = usermailBlacklistService.isInBlacklist(from, to);
    ResultDTO resultDto = new ResultDTO();
    resultDto.setData(inBlacklist);
    return resultDto;
  }

}
