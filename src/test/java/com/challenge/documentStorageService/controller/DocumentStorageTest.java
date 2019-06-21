package com.challenge.documentStorageService.controller;

public class DocumentStorageTest {

}

/*
package com.challenge.documentStorageService.controller;

import com.challenge.documentStorageService.service.DocumentStorageService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(DocumentStorage.class)
public class DocumentStorageTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private DocumentStorage documentStorageController;

    @Mock
    private DocumentStorageService documentStorageService;

    @Before
    public void settingUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(documentStorageController).build();
    }
}
*/
