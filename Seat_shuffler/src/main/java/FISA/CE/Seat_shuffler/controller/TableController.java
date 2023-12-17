package FISA.CE.Seat_shuffler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import FISA.CE.Seat_shuffler.service.TableService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class TableController {

    private static final Logger log = LoggerFactory.getLogger(TableController.class);
    @Autowired
    private TableService tableService;

    @GetMapping("/table/create") 
    public String createTable(@RequestParam int row, @RequestParam int col, Model model) {
        log.info("input row: " + row + "/ col: " + col);
        // 여기서 생성한 테이블 객체를 저장하고 있어야 함.
        tableService.table = tableService.createTable(row, col);
        log.info("table: " + Arrays.deepToString(tableService.table));
        model.addAttribute("table", tableService.table);
        return "main";
    }

    @GetMapping("/table/fix-student")

    public String fixedSeat(@RequestParam int row, @RequestParam int col, @RequestParam Integer id, @RequestParam String name, Model model) {
        log.info("input row: " + row + "/ col: " + col);
        tableService.setFixedSeat(row, col, id, name);
        log.info("table: " + Arrays.deepToString(tableService.table));
        model.addAttribute("table", tableService.table);
        return "main";
    }

    @GetMapping("/table/seatShuffle")
    public String seatShuffle() {
        
        return "main";
    }
}
