import java.util.Arrays; 
public class QuestionFive {
    private static int interationCounter = 0; 
    public static void printArray(int [] cells) {
        System.out.println("\n iteration: " + interationCounter); 
        System.out.print("|"); 
        for (int i =0; i < cells.length; i ++){
            System.out.print(cells[i] + "|"); 
        }
    }
    public static void main(String[] args) {
        //Script assumes that the cellspace wraps
        Integer p = Integer.parseInt(args[0]);
        Integer interations = Integer.parseInt(args[1]);

        // This was given as an answer on piazza 
        int arraylength = p < 5 ? 5 : p; 
        
        int[] cells= new int[arraylength];

        //fill array 
        for (int i = 0; i < arraylength; i ++){
            cells[i]= i%p; 
        }

        int[] cellsTemp= Arrays.copyOf(cells, cells.length);


        //print intitial state
        printArray(cells);


        for (int j = 0; j < interations; j ++){
            interationCounter ++; 
            for (int i = 0; i < arraylength; i ++){
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