import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
	
		Map<Integer, Integer> save = new HashMap(); //Comparação de valores no arquivo
		//A
		try (Scanner scanner = new Scanner(new File("C:/Users/Star/Coding/balance-line/A.txt"))) {

			int contador = 0;
            while (scanner.hasNext()){
            	String[] parts = scanner.nextLine().split(",");
            	int id = Integer.parseInt(parts[0].trim()); 
            	int valor = Integer.parseInt(parts[1].trim());
            	
            	if (save.containsKey(id)) {
          		  	save.put(id, save.get(id) + valor);
          		} else {
          		  save.put(id, valor);
          	    }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
		
		//B
		try (Scanner scanner = new Scanner(new File("C:/Users/Star/Coding/balance-line/B.txt"))) {

            while (scanner.hasNext()){
            	String[] parts = scanner.nextLine().split(",");
            	int id = Integer.parseInt(parts[0].trim()); 
            	int valor = Integer.parseInt(parts[1].trim()); 
            	
            	
            	if (save.containsKey(id)) {
          		  	save.put(id, save.get(id) + valor);
          		} else {
          		  save.put(id, valor);
          	    }
            	
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		//C
		try {
		File file = new File("C:/Users/Star/Coding/balance-line/C.txt");
		BufferedWriter grava = new BufferedWriter(new FileWriter(file, true));
		
		save.entrySet().forEach(entry -> {
		try{
		  grava.write(entry.getKey() + ", " + entry.getValue()); // Id
		  grava.newLine(); //próxima linha
		} catch (IOException e) {
            e.printStackTrace();
		}
	  	 });
		
		System.out.println("Gravação Concluida!");
		grava.close();
		
		} catch (IOException e) {
            e.printStackTrace();
        }

	}
	

}
