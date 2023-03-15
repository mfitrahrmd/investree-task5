package com.investree.demo;

import com.investree.demo.controller.SaveTransaksiReq;
import com.investree.demo.model.Transaksi;
import com.investree.demo.model.User;
import com.investree.demo.repository.TransaksiRepository;
import com.investree.demo.repository.UserRepository;
import com.investree.demo.view.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class InvestreeApplication implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    TransaksiService transaksiService;

    public static void main(String[] args) {
        SpringApplication.run(InvestreeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        runDatabaseSeed();
    }

    void runDatabaseSeed() {
        userRepository.saveAll(new ArrayList<>(List.of(new User(1l, "mfitrahrmd", "123", true, null, null, null), new User(2l, "mandalorian", "123", true, null, null, null))));
        transaksiService.save(new SaveTransaksiReq(1l, 2l, 10, 100000d, 10d, "berjalan").toTransaksi());
    }
}
