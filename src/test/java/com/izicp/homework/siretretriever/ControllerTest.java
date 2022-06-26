package com.izicp.homework.siretretriever;

import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@ExtendWith(MockitoExtension.class)
class ControllerTest {

  @Mock
  private InputNumbersReader inputNumbersReader;

  @InjectMocks
  private Controller controller;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void retrieveCompanyInformation_WithValidInput_ReturnsOk() throws Exception {
    //ARRANGE
    MockHttpServletRequest request = new MockHttpServletRequest();
    RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    when(inputNumbersReader.getSiretNumbersFromInputFile()).thenReturn(
        Collections.singletonList("31302979500017"));

    //ACT
    List<String> companies = controller.retrieveCompanyInformation();

    //ASSERT
    Assertions.assertNotNull(companies);
    Assertions.assertEquals(1, companies.size());
  }
}