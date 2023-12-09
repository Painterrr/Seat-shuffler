package FISA.CE.Seat_shuffler.service;

import org.springframework.stereotype.Service;

@Service
public class TableService {
    
    public String[][] create(int row, int col) {
        String[][] table = new String[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                table[i][j] = "[" + i + "][" + j + "]";
            }
        }

        return table;
    }
}
