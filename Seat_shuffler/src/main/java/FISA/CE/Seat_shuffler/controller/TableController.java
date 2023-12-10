package FISA.CE.Seat_shuffler.controller;

import FISA.CE.Seat_shuffler.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

import FISA.CE.Seat_shuffler.service.TableService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class TableController {
    

    @Autowired
    private final TableService tableService = new TableService();

    @GetMapping("/table/create") 
    public String createTable(@RequestParam int row, @RequestParam int col, Model model) {
        log.info("input row: " + row + "/ col: " + col);
        // 여기서 생성한 테이블 객체를 저장하고 있어야 함.
        Student[][] table = tableService.create(row, col);
        model.addAttribute("table", table);
        return "main";
    }

    @GetMapping("/table/unused")
    public String fixedSeat(@PathVariable int row, int col) {
        log.info("input row: " + row + "/ col: " + col);
        

        return "main";
    }

    @GetMapping("/table/seatShuffle")
    public String seatShuffle() {
        
        return "main";
    }
}
