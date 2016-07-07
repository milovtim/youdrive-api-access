package ru.milovtim.youdrive.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.milovtim.youdrive.domain.Car
import ru.milovtim.youdrive.session.ActiveCarStore
import youdrive.today.models.ApiCommand
import youdrive.today.models.Command
import youdrive.today.network.CarsharingService

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE
import static org.springframework.web.bind.annotation.RequestMethod.DELETE
import static org.springframework.web.bind.annotation.RequestMethod.GET
import static org.springframework.web.bind.annotation.RequestMethod.POST
import static org.springframework.web.bind.annotation.RequestMethod.PUT
import static ru.milovtim.youdrive.domain.Car.fromApiCar
import static youdrive.today.models.Command.fromString

@RestController
@RequestMapping("/car")
class CarsController {

    @Autowired
    CarsharingService carService

    @Autowired
    ActiveCarStore activeCarStore

    @RequestMapping(value = '/all', method = GET, produces = APPLICATION_JSON_VALUE)
    List<Car> getCars(@RequestParam(name = 'lat', defaultValue = '0') double lat,
                      @RequestParam(name = 'lng', defaultValue = '0') double lng) {
        def apiResult = (lat && lng)? carService.getStatusCars(lat, lng): carService.getStatusCars()

        def active = activeCarStore.activeCar
        if (apiResult.status == 'normal')
            (apiResult.cars?:[])
                .collect {c ->
                    def car = fromApiCar(c)
                    car.active = active && car.id == active.id
                    car
                }
                .sort {car1, car2 -> car1.distanceToCar.compareTo(car2.distanceToCar)}
        else []
    }

    @RequestMapping(value = '/active', method = GET, produces = APPLICATION_JSON_VALUE)
    Car getActiveCar() {
        fromApiCar(activeCarStore.activeCar)
    }

    @RequestMapping(value = '/active', method = POST, consumes = APPLICATION_JSON_VALUE)
    void setActiveCar(@RequestBody Car car) {
        def apiCar = new youdrive.today.models.Car(car.id, car.coord.latitude?.floatValue(), car.coord.longitude?.floatValue())
        activeCarStore.activeCar = apiCar
    }

    @RequestMapping(value = '/active/reserve', method = POST)
    boolean bookActiveCar() {
        if (!(activeCarStore.activeCar))
            false
        def bookingResult = carService.booking(activeCarStore.activeCar)
        fromApiCar(bookingResult.car)
    }

    @RequestMapping(value = '/active/reserve/{action}', method = PUT)
    def openCloseCar(@PathVariable('action') String command) {
        if (!(activeCarStore.activeCar))
            false

        Command cmnd = fromString(command)
        if (!cmnd)
            false

        def cmndRes = carService.command(new ApiCommand(cmnd.toString()))
        cmndRes.resultToken
    }

    @RequestMapping(value = '/active/reserve', method = DELETE)
    boolean unbookActiveCar() {
        def response = carService.complete()
        response.code == null
    }
}
