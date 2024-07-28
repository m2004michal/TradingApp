package com.tradingApp.tradingApp.controller;

import com.tradingApp.tradingApp.dto.BalancesResponse;
import com.tradingApp.tradingApp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("api/")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("{id}/getBalances")
    public ResponseEntity<BalancesResponse> getBalance(@PathVariable long id){
        return new ResponseEntity<>(userService.getBalances(id), HttpStatus.OK);
    }
    @GetMapping("{id}/getLevel")
    public ResponseEntity<Integer> getLevel(@PathVariable long id){
        return new ResponseEntity<>(userService.getLevel(id), HttpStatus.OK);
    }
}
