package FISA.CE.Seat_shuffler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import FISA.CE.Seat_shuffler.service.TableService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class TableController {

    @Autowired
    private TableService tableService = new TableService();

    @GetMapping("/table/create") 
    public String createTable(@PathVariable int row, int col) {
        log.info("input row: " + row + "/ col: " + col);
        String[][] table = tableService.create(row, col);
        return "view/main";
    }

}
