package ru.milovtim.youdrive.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import youdrive.today.models.LoginUser
import youdrive.today.network.CarsharingService
import youdrive.today.response.BaseResponse
import youdrive.today.response.LoginResponse

import static org.springframework.web.bind.annotation.RequestMethod.DELETE
import static org.springframework.web.bind.annotation.RequestMethod.GET

@RestController
@RequestMapping("/login")
class LoginController {

    @Autowired
    CarsharingService service

    @Autowired
    LoginUser loginUser

    @RequestMapping(method = GET)
    boolean login() {
        service.login(loginUser)?.success
    }

    @RequestMapping(method = DELETE)
    boolean logout() {
        service.logout()?.success
    }
}
