package ru.milovtim.youdrive

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import youdrive.today.models.LoginUser
import youdrive.today.network.CarsharingService

@Component
class Runner implements CommandLineRunner {

    @Autowired
    CarsharingService service

    @Autowired
    LoginUser loginUser

    @Override
    void run(String... strings) throws Exception {
        service.login(loginUser)

        def carResponce = service.statusCars
        assert carResponce.cars.size() > 0
    }
}
