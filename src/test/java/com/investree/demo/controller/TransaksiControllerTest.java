package com.investree.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;

@SpringBootTest
@AutoConfigureMockMvc
class TransaksiControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void saveInvalidTransaksi() throws Exception {
        var testCases = new ArrayList<>();
        mockMvc.perform(
                        MockMvcRequestBuilders.request(HttpMethod.POST, "/v1/transaksi")
                                .header("Content-Type", "application/json")
                                .content("""
                                        {}
                                        """)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void saveValidTransaksi() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.request(HttpMethod.POST, "/v1/transaksi")
                                .header("Content-Type", "application/json")
                                .content("""
                                        {
                                            "idPeminjam": 1,
                                            "idMeminjam": 2,
                                            "tenor": 10,
                                            "totalPinjaman": 100000,
                                            "bungaPersen": 10,
                                            "status": "berjalan"
                                        }
                                        """)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}