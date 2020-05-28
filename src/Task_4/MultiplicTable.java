package Task_4;

import javax.swing.*;
import java.awt.*;

public class MultiplicTable {
    static int FIRST_NUMB = 1;
    static int LAST_NUMB = 9;

    public static void main(String[] args) {
        JPanel panel=new JPanel();
        panel.setLayout(new BorderLayout());
        int [][] mass=printMultiplicTable();

        JTable upTable=new JTable(1,10);
        for (int i = 0,j=0; j <mass.length ; j++) {
            upTable.setValueAt(mass[i][j],i,j);
        }
        upTable.setBackground(Color.lightGray);
        panel.add("North",upTable);

        JTable leftTable=new JTable(9,1);
        for (int i = 1,j=0; i <mass.length ; i++) {
            leftTable.setValueAt(mass[i][j],i-1,j);
        }
        leftTable.setBackground(Color.lightGray);
        panel.add("West",leftTable);

        JTable table=new JTable(9,9);
        for (int i = 1; i <mass.length ; i++) {
            for (int j = 1; j <mass.length ; j++) {
                table.setValueAt(mass[i][j],i-1,j-1);
            }
        }
        panel.add(table);
        JFrame frame=new JFrame("Таблица умножения");
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    static int [][] printMultiplicTable() {
        int[][] mass = new int[LAST_NUMB + 1][LAST_NUMB + 1];
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass.length; j++) {
                if (i == 0 && j >= FIRST_NUMB) {
                    mass[i][j] = j;
                }
                if (j == 0 && i >= FIRST_NUMB) {
                    mass[i][j] = i;
                }
                if (i>=FIRST_NUMB && j>=FIRST_NUMB) {
                    mass[i][j]=(i)*(j);
                }
            }
        }
        return mass;
    }
}
