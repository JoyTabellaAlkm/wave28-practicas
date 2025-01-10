package com.mercadolibre.be_java_hisp_w28_g10.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.be_java_hisp_w28_g10.dto.response.ResponseMessageDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BackOfficeControllerITest {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void getReport_ValidRequestReportUSERS_BY_FOLLOWERSOrdercound_desc_ReturnsCsv() throws Exception {
        // ARRANGE
        String reportName = "USERS_BY_FOLLOWERS";
        String order = "count_desc";
        int top = 2;
        String csvContent = "\"ID\",\"Name\",\"Followers Count\"\n4,Diana,4\n1,Alice,1\n";

        // ACT AND ASSERT
        mockMvc.perform(get("/reports/getReport/{reportName}", reportName)
                        .param("order", order)
                        .param("top", String.valueOf(top)))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/csv"))
                .andExpect(content().string(csvContent))
                .andExpect(result -> {
                    String contentDisposition = result.getResponse().getHeader(HttpHeaders.CONTENT_DISPOSITION);
                    assertTrue(contentDisposition != null && contentDisposition.contains("attachment; filename=" + reportName + ".csv"));
                })
                .andDo(print())
        ;
    }

    @Test
    void getReport_ValidRequestReportUSERS_BY_FOLLOWERSOrdercound_asc_ReturnsCsv() throws Exception {
        // ARRANGE
        String reportName = "USERS_BY_FOLLOWERS";
        String order = "count_asc";
        int top = 3;
        String csvContent = "\"ID\",\"Name\",\"Followers Count\"\n8,Hannah,0\n9,Isaac,0\n10,Jack,0\n";

        // ACT AND ASSERT
        mockMvc.perform(get("/reports/getReport/{reportName}", reportName)
                        .param("order", order)
                        .param("top", String.valueOf(top)))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/csv"))
                .andExpect(content().string(csvContent))
                .andExpect(result -> {
                    String contentDisposition = result.getResponse().getHeader(HttpHeaders.CONTENT_DISPOSITION);
                    assertTrue(contentDisposition != null && contentDisposition.contains("attachment; filename=" + reportName + ".csv"));
                })
                .andDo(print())
        ;
    }

    @Test
    void getReport_ValidRequestReportUSERS_BY_FOLLOWSOrdercount_desc_ReturnsCsv() throws Exception {
        // ARRANGE
        String reportName = "USERS_BY_FOLLOWS";
        String order = "count_desc";
        int top = 1;
        String csvContent = "\"ID\",\"Name\",\"Follows Count\"\n2,Ron,4\n";

        // ACT AND ASSERT
        mockMvc.perform(get("/reports/getReport/{reportName}", reportName)
                        .param("order", order)
                        .param("top", String.valueOf(top)))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/csv"))
                .andExpect(content().string(csvContent))
                .andExpect(result -> {
                    String contentDisposition = result.getResponse().getHeader(HttpHeaders.CONTENT_DISPOSITION);
                    assertTrue(contentDisposition != null && contentDisposition.contains("attachment; filename=" + reportName + ".csv"));
                })
                .andDo(print())
        ;
    }

    @Test
    void getReport_ValidRequestReportUSERS_BY_POSTSOrdercount_asc_ReturnsCsv() throws Exception {
        // ARRANGE
        String reportName = "USERS_BY_POSTS";
        String order = "count_asc";
        int top = 2;
        String csvContent = "\"ID\",\"Name\",\"Posts Count\"\n2,Ron,3\n3,Pepe,3\n";

        // ACT AND ASSERT
        mockMvc.perform(get("/reports/getReport/{reportName}", reportName)
                        .param("order", order)
                        .param("top", String.valueOf(top)))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/csv"))
                .andExpect(content().string(csvContent))
                .andExpect(result -> {
                    String contentDisposition = result.getResponse().getHeader(HttpHeaders.CONTENT_DISPOSITION);
                    assertTrue(contentDisposition != null && contentDisposition.contains("attachment; filename=" + reportName + ".csv"));
                })
                .andDo(print())
        ;
    }

    @Test
    void getReport_ValidRequestReportPOSTS_BY_PRICEOrderprice_asc_ReturnsCsv() throws Exception {
        // ARRANGE
        String reportName = "POSTS_BY_PRICE";
        String order = "price_asc";
        int top = 1;
        String csvContent = "\nCATEGORY,DATE,DISCOUNT,ID,PRICE,PRODUCT_BRAND,PRODUCT_NAME,PRODUCT_TYPE,PROMO\n" +
                "104,2024-06-03,0.0,5,25.0,Belkin,Cargador Inalambrico,Accessories,false\n";

        // ACT AND ASSERT
        mockMvc.perform(get("/reports/getReport/{reportName}", reportName)
                        .param("order", order)
                        .param("top", String.valueOf(top)))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/csv"))
                .andExpect(content().string(csvContent))
                .andExpect(result -> {
                    String contentDisposition = result.getResponse().getHeader(HttpHeaders.CONTENT_DISPOSITION);
                    assertTrue(contentDisposition != null && contentDisposition.contains("attachment; filename=" + reportName + ".csv"));
                })
                .andDo(print())
        ;
    }

    @Test
    void getReport_ValidRequestReportPOSTS_BY_DISCOUNTOrderdiscount_asc_ReturnsCsv() throws Exception {
        // ARRANGE
        String reportName = "POSTS_BY_DISCOUNT";
        String order = "discount_asc";
        int top = 2;
        String csvContent = "\nCATEGORY,DATE,DISCOUNT,ID,PRICE,PRODUCT_BRAND,PRODUCT_NAME,PRODUCT_TYPE,PROMO\n" +
                "105,2024-12-16,0.0,6,99.99,Blue,Microfono USB,Audio,false\n" +
                "108,2024-04-15,0.0,9,300.0,Oculus,Gafas de Realidad Virtual,Gaming,false\n";

        // ACT AND ASSERT
        mockMvc.perform(get("/reports/getReport/{reportName}", reportName)
                        .param("order", order)
                        .param("top", String.valueOf(top)))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/csv"))
                .andExpect(content().string(csvContent))
                .andExpect(result -> {
                    String contentDisposition = result.getResponse().getHeader(HttpHeaders.CONTENT_DISPOSITION);
                    assertTrue(contentDisposition != null && contentDisposition.contains("attachment; filename=" + reportName + ".csv"));
                })
                .andDo(print())
        ;
    }

    @Test
    void getReport_ValidRequestReportPOSTS_BY_DATEOrderdate_desc_ReturnsCsv() throws Exception {
        // ARRANGE
        String reportName = "POSTS_BY_DATE";
        String order = "date_desc";
        int top = 3;
        String csvContent = "\nCATEGORY,DATE,DISCOUNT,ID,PRICE,PRODUCT_BRAND,PRODUCT_NAME,PRODUCT_TYPE,PROMO\n" +
                "101,2024-12-17,0.1,2,120.75,Cooler Master,Teclado Mecanico RGB,Gaming,false\n" +
                "109,2024-12-17,0.15,1,199.99,Crosley,Tocadiscos,Audio,true\n" +
                "105,2024-12-16,0.0,6,99.99,Blue,Microfono USB,Audio,false\n";

        // ACT AND ASSERT
        mockMvc.perform(get("/reports/getReport/{reportName}", reportName)
                        .param("order", order)
                        .param("top", String.valueOf(top)))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/csv"))
                .andExpect(content().string(csvContent))
                .andExpect(result -> {
                    String contentDisposition = result.getResponse().getHeader(HttpHeaders.CONTENT_DISPOSITION);
                    assertTrue(contentDisposition != null && contentDisposition.contains("attachment; filename=" + reportName + ".csv"));
                })
                .andDo(print())
        ;
    }

    @Test
    void getReport_InvalidReportName_ReturnsBadRequest() throws Exception {
        // ARRANGE
        String reportName = "INVALID_REPORT";
        String order = "count_desc";
        int top = 5;
        ResponseMessageDTO expectedResponseMessage = new ResponseMessageDTO("Invalid report name");
        ResultMatcher expectedBody = content().json(objectMapper.writeValueAsString(expectedResponseMessage));


        // ACT AND ASSERT
        mockMvc.perform(get("/reports/getReport/{reportName}", reportName)
                        .param("order", order)
                        .param("top", String.valueOf(top)))
                .andExpect(status().isBadRequest())
                .andExpect(expectedBody)
                .andDo(print())
        ;
    }

    @Test
    void getReport_InvalidOrder_ReturnsBadRequest() throws Exception {
        // ARRANGE
        String reportName = "USERS_BY_FOLLOWERS";
        String order = "invalid_order";
        int top = 5;
        ResponseMessageDTO expectedResponseMessage = new ResponseMessageDTO("Invalid report order or top");
        ResultMatcher expectedBody = content().json(objectMapper.writeValueAsString(expectedResponseMessage));

        // ACT AND ASSERT
        mockMvc.perform(get("/reports/getReport/{reportName}", reportName)
                        .param("order", order)
                        .param("top", String.valueOf(top)))
                .andExpect(status().isBadRequest())
                .andExpect(expectedBody)
                .andDo(print())
        ;
    }

    @Test
    void getReport_TopZero_ReturnsBadRequest() throws Exception {
        // ARRANGE
        String reportName = "USERS_BY_FOLLOWERS";
        String order = "count_desc";
        int top = 0; // Invalid top
        ResponseMessageDTO expectedResponseMessage = new ResponseMessageDTO("Invalid report order or top");
        ResultMatcher expectedBody = content().json(objectMapper.writeValueAsString(expectedResponseMessage));

        // ACT AND ASSERT
        mockMvc.perform(get("/reports/getReport/{reportName}", reportName)
                        .param("order", order)
                        .param("top", String.valueOf(top)))
                .andExpect(status().isBadRequest())
                .andExpect(expectedBody)
                .andDo(print())
        ;
    }
}
