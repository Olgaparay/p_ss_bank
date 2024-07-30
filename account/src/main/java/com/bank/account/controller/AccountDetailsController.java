package com.bank.account.controller;

import com.bank.account.dto.AccountDetailsDto;
import com.bank.account.entity.AccountDetails;
import com.bank.account.service.AccountDetailsService;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bank.account.mapper.AccountDetailsMapper;
import java.util.List;




@Timed("repository: findUserByProfileId")
@RestController
@RequiredArgsConstructor
@RequestMapping("/details")
@EnableAspectJAutoProxy
public class AccountDetailsController {

    private final AccountDetailsService service;
    private final AccountDetailsMapper mapper;

    @Timed("controller: getUnsecuredData")
    @GetMapping("/{id}")  // Метод для получения данных аккаунта по его идентификатору
    public ResponseEntity<AccountDetails> read(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }
    @Timed("controller: createAuthToken")
    @PostMapping("/create")  // Метод для создания нового аккаунта
    public ResponseEntity<HttpStatus> create(@RequestBody AccountDetailsDto accountDetails) {
        service.save(
                mapper.toEntity(accountDetails));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")  // Метод для обновления существующего аккаунта по его идентификатору
    public ResponseEntity<HttpStatus> update(@PathVariable Long id,
                                                    @RequestBody AccountDetailsDto accountDetails) {
        service.update(id, mapper.toEntity(accountDetails));
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @GetMapping("read/all")  // Метод для получения списка аккаунтов по их идентификаторам
    public ResponseEntity<List<AccountDetails>> readAll() {
        return new ResponseEntity<>(service.findAll(),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")  // Метод для получения списка аккаунтов по их идентификаторам
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}