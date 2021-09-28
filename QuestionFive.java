import java.util.Arrays; 
public class QuestionFive {
    private static int interationCounter = 0; 
    private static Integer  p = 0; 
    public static void printArray(int [] cells) {
        System.out.println("\n iteration: " + interationCounter); 
        System.out.print("|"); 
        for (int i =0; i < cells.length; i ++){
            System.out.print(cells[i] + "|"); 
        }
    }
    public static void main(String[] args) {
        p = Integer.parseInt(args[0]);
        Integer interations = Integer.parseInt(args[1]);

        System.out.println(p);

        int[] cells= new int[p];

        //fill array 

        for (int i = 0; i < p; i ++){
            cells[i]= i; 
        }

        int[] cellsTemp= Arrays.copyOf(cells, cells.length);


        //print intitial state
        printArray(cells);


        for (int j = 0; j < interations; j ++){
            interationCounter ++; 
            for (int i = 0; i < p; i ++){
                if( i == 0){
                    cells[i] = (cellsTemp[i] + cellsTemp[cells.length-1]) % p;
                } else {
                    cells[i] = (cellsTemp[i] + cellsTemp[i -1]) % p;
                }
            }
            cellsTemp = Arrays.copyOf(cells, cells.length); 
            printArray(cells);
        }
    }
}