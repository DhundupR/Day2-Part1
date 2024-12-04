import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        int sum = 0;
        int amt = 0;
        boolean safe = true;
        ArrayList<String> fileData = getFileData("src/Input.txt");
        int max = 0;
        for (int i = 0; i < fileData.size(); i++) {
            max++;
        }
        boolean inc = false;
        for (int i = 0; i < fileData.size(); i++) {
            inc = false;
            safe = true;
            String[] line = fileData.get(i).split(" ");
            int leng = line.length;

            for (int k = 0; k < leng -1; k++) {
                if (Integer.parseInt(line[0]) == Integer.parseInt(line[1])) {
                    if (Integer.parseInt(line[1]) == Integer.parseInt(line[2])) {
                        if (Integer.parseInt(line[2]) < Integer.parseInt(line[3])) {
                            inc = true;
                        }
                    }   else if (Integer.parseInt(line[0]) < Integer.parseInt(line[1])) {
                        inc = true;
                    }
                } else if (Integer.parseInt(line[0]) < Integer.parseInt(line[1])) {
                    inc = true;
                }


                if (inc) {
                    if (!(Integer.parseInt(line[k]) < Integer.parseInt(line[k + 1]))) {
                        safe = false;
                        break;

                    }
                } else {
                    if (!(Integer.parseInt(line[k]) > Integer.parseInt(line[k + 1]))) {
                        safe = false;
                        break;
                    }
                }

                int val1 = Integer.parseInt(line[k]);
                int val2 = Integer.parseInt(line[k+1]);
                if (inc){
                    int diff = val2 - val1 ;
                    if (diff > 3 || diff < 1){
                        safe = false;
                        break;
                    }
                } else {
                    int diff = val1 - val2 ;
                    if (diff > 3 || diff < 1){
                        safe = false;
                        break;
                    }
                }

        }
            if(safe){
                amt++;
            } else {
                safe = true;
            }

    }
        System.out.println(amt);
    }


    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}

