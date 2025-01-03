package com.bootcamp.socialmeli.utils;

import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TestConstants {
    public static final String APPLICATION_JSON = "application/json";
    public static final int USER_ID_NOT_EXIST = 50;
    public static final ResultMatcher STATUS_OK = status().isOk();
    public static final ResultMatcher STATUS_NOT_FOUND = status().isNotFound();
    public static final ResultMatcher STATUS_BAD_REQUEST = status().isBadRequest();
    public static final ResultMatcher STATUS_NO_CONTENT = status().isNoContent();
    public static final ResultMatcher STATUS_CREATED = status().isCreated();
    public static final ResultMatcher CONTENT_TYPE_JSON = content().contentType(APPLICATION_JSON);
}
