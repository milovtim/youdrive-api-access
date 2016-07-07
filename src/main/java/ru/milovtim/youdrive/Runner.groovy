package ru.milovtim.youdrive

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.context.event.ContextClosedEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import youdrive.today.models.LoginUser
import youdrive.today.network.CarsharingService

//@Component
class Runner implements CommandLineRunner {

    @Autowired
    CarsharingService service

    @Autowired
    LoginUser loginUser

    @EventListener(classes = ContextClosedEvent)
    void logout(ContextClosedEvent event) {
        service.logout()
    }

    @Override
    void run(String... strings) throws Exception {
        service.login(loginUser)
        def carResponse = service.getStatusCars(55.7760401, 37.6553453)
        toFile(carResponse.car, 'car')
        toFile(carResponse.cars, 'cars')
        toFile(carResponse.check, 'check')
        toFile(carResponse.status, 'status')
    }


    def om = new ObjectMapper()

    void toFile(obj, fileName) {
        if (obj)
            new File("./${fileName}1.json").withOutputStream { out ->
                om.writeValue(out, obj)
            }
    }
}
