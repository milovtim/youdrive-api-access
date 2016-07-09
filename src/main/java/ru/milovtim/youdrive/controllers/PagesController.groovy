package ru.milovtim.youdrive.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import ru.milovtim.youdrive.session.ActiveCarStore
import youdrive.today.network.CarsharingService

import static org.springframework.util.MimeTypeUtils.TEXT_HTML_VALUE
import static org.springframework.web.bind.annotation.RequestMethod.GET

@Controller
@RequestMapping(value = '/', produces = TEXT_HTML_VALUE)
class PagesController {

    @Autowired
    ActiveCarStore activeCarStore

    @Autowired
    CarsharingService carService

    @RequestMapping(value = ['/', '/cars'], method = GET)
    String carsPage() {
        'cars'
    }

    @RequestMapping(value = '/car', method = GET)
    def car(ModelAndView mav) {
        def active = activeCarStore.activeCar
        if (active) {
            def resp = carService.statusCars
            def fullCar = resp?.cars?.findAll {it.id == active.id}?.first()
            mav.addObject('car', fullCar)
        }
        mav.setViewName('activeCar')
        mav
    }
}
