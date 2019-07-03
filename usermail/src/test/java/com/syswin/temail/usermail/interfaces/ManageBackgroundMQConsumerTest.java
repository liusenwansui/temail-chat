package com.syswin.temail.usermail.interfaces;

import com.syswin.temail.usermail.application.RemoveDomainService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@Ignore
@RunWith(MockitoJUnitRunner.class)
public class ManageBackgroundMQConsumerTest {

  @InjectMocks
  private ManageBackgroundMQConsumer consumer;
  @Mock
  private RemoveDomainService service;
  private String message;

  @Test
  public void consumer() {
    consumer.consumer(message);
    Mockito.verify(service).removeDomain(message);
  }
}