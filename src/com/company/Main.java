package com.company;

import java.io.*;
import java.util.*;
import java.util.HashSet;
import java.util.Set;

abstract class Coder {
    protected static StringBuilder builder = new StringBuilder(); //characters <->  string after coding/decoding
    protected static ArrayList<Character> list = new ArrayList<Character>();// тут хранятся символы
    protected static ArrayList<String> strings = new ArrayList<String>();//тут слова

    void write() {
        //Convert to String and then write to bw
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("2.txt"))) {
            bw.write(builder.toString());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void read(String name) throws FileNotFoundException {
    }


    /***/
    void handle()// переводит  текст
    {

    }

}

class Alphabet {
    //sumbol => code
    static private Map<String, Character> M2En = new HashMap<String, Character>();// =>
    static private Map<Character, String> En2M = new HashMap<Character, String>();// <=

    Alphabet() {
        M2En.put(".-", 'a');
        M2En.put("-...", 'b');
        M2En.put("-.-.", 'c');
        M2En.put("-..", 'd');
        M2En.put(".", 'e');
        M2En.put("..-.", 'f');
        M2En.put("--.", 'g');
        M2En.put("....", 'h');
        M2En.put("..", 'i');
        M2En.put(".---", 'j');
        M2En.put("-.-", 'k');
        M2En.put(".-..", 'l');
        M2En.put("--", 'm');
        M2En.put("-.", 'n');
        M2En.put("---", 'o');
        M2En.put(".--.", 'p');
        M2En.put("--.-", 'q');
        M2En.put(".-.", 'r');
        M2En.put("...", 's');
        M2En.put("-", 't');
        M2En.put("..-", 'u');
        M2En.put("...-", 'v');
        M2En.put(".--", 'w');
        M2En.put("-..-", 'x');
        M2En.put("-.--", 'y');
        M2En.put("--..", 'z');
        M2En.put(".-.-.-", '.');
        M2En.put("--..--", ',');
        M2En.put("..--..", '?');
        M2En.put("-..-.", '/');
        M2En.put(".--.-.", '@');
        M2En.put(".----", '1');
        M2En.put("..---", '2');
        M2En.put("...--", '3');
        M2En.put("....-", '4');
        M2En.put(".....", '5');
        M2En.put("-....", '6');
        M2En.put("--...", '7');
        M2En.put("---..", '8');
        M2En.put("----.", '9');
        M2En.put("-----", '0');
        M2En.put("   ", ' ');
        M2En.put("-.--.-.", '(');
        M2En.put("-.--.-", ')');
        M2En.put("       ", '-');

        En2M.put('a', ".-");
        En2M.put('b', "-...");
        En2M.put('c', "-.-.");
        En2M.put('d', "-..");
        En2M.put('e', ".");
        En2M.put('f', "..-.");
        En2M.put('g', "--.");
        En2M.put('h', "....");
        En2M.put('i', "..");
        En2M.put('j', ".---");
        En2M.put('k', "-.-");
        En2M.put('l', ".-..");
        En2M.put('m', "--");
        En2M.put('n', "-.");
        En2M.put('o', "---");
        En2M.put('p', ".--.");
        En2M.put('q', "--.-");
        En2M.put('r', ".-.");
        En2M.put('s', "...");
        En2M.put('t', "-");
        En2M.put('u', "..-");
        En2M.put('v', "...-");
        En2M.put('w', ".--");
        En2M.put('x', "-..-");
        En2M.put('y', "-.--");
        En2M.put('z', "--..");
        En2M.put('.', ".-.-.-");
        En2M.put(',', "--..--");
        En2M.put('?', "..--..");
        En2M.put('/', "-..-.");
        En2M.put('@', ".--.-.");
        En2M.put('1', ".----");
        En2M.put('2', "..---");
        En2M.put('3', "...--");
        En2M.put('4', "....-");
        En2M.put('5', ".....");
        En2M.put('6', "-....");
        En2M.put('7', "--...");
        En2M.put('8', "---..");
        En2M.put('9', "----.");
        En2M.put('0', "-----");
        En2M.put(' ', " ");
        En2M.put('A', ".-");
        En2M.put('B', "-...");
        En2M.put('C', "-.-.");
        En2M.put('D', "-..");
        En2M.put('E', ".");
        En2M.put('F', "..-.");
        En2M.put('G', "--.");
        En2M.put('H', "....");
        En2M.put('I', "..");
        En2M.put('J', ".---");
        En2M.put('K', "-.-");
        En2M.put('L', ".-..");
        En2M.put('M', "--");
        En2M.put('N', "-.");
        En2M.put('O', "---");
        En2M.put('P', ".--.");
        En2M.put('Q', "--.-");
        En2M.put('R', ".-.");
        En2M.put('S', "...");
        En2M.put('T', "-");
        En2M.put('U', "..-");
        En2M.put('V', "...-");
        En2M.put('W', ".--");
        En2M.put('X', "-..-");
        En2M.put('Y', "-.--");
        En2M.put('Z', "--..");
        En2M.put('\n', "   ");
        En2M.put('\r', "   ");
        En2M.put('(', "-.--.-.");
        En2M.put(')', "-.--.-");
        En2M.put('-', "       ");

    }

    Map<String, Character> get_M2En() {


        return M2En;
    }

    Map<Character, String> get_En2M() {
        return En2M;
    }


}

class En2Morze extends Coder {
    static Alphabet alphabet = new Alphabet();

    /* void write() {

         OutputStreamWriter writer = null;
         try {
             writer = new OutputStreamWriter(new FileOutputStream("2.txt"));
             for (String str : strings) { //write here
                 writer.write(str + System.lineSeparator());
             }
         } catch (IOException e) {
             System.err.println("Error while reading file: " + e.getLocalizedMessage());
         } finally {
             if (null != writer) {
                 try {
                     writer.close();

                 } catch (IOException e) {
                     e.printStackTrace(System.err);
                 }
             }
         }

     }*/
    void read(String name) throws FileNotFoundException {
        try (FileReader reader = new FileReader(name)) {
            int r;
            while ((r = reader.read()) != -1) {
                char ch = (char) r;
                list.add(ch);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    void handle() {
        /**
         * тут переводит и сохраняет в bilder
         */
        builder = new StringBuilder();
        for (Character character : list) {

            builder.append(alphabet.get_En2M().get(character));
            builder.append(' ');
        }
    }
}

class Morse2En extends Coder {

    Alphabet alphabet = new Alphabet();

  /*  void write() {

        OutputStreamWriter writer = null;
        try {
            writer = new OutputStreamWriter(new FileOutputStream("2.txt"));
            for (Character ch : list) { //write here
                writer.write(ch + System.lineSeparator());
            }
        } catch (IOException e) {
            System.err.println("Error while reading file: " + e.getLocalizedMessage());
        } finally {
            if (null != writer) {
                try {
                    writer.close();

                } catch (IOException e) {
                    e.printStackTrace(System.err);
                }
            }
        }

    }*/

    /**
     * считывает по словам текст из файла в ArrayList<Character> list
     *
     * @throws FileNotFoundException
     */
    void read(String name) throws FileNotFoundException {
        StringBuilder build = new StringBuilder();

        try (FileReader reader = new FileReader(name)) {
            int r = reader.read();

            while (r != -1) {
                char ch = (char) r;
                while (ch != ' ' && r != -1) {
                    build.append(ch);

                    r = reader.read();
                    ch = (char) r;
                }
                Map<String, Character> m = alphabet.get_M2En();
                String s = build.toString();
                list.add(m.get(s));
                build = new StringBuilder();
                int i = 0;
                while (ch == ' ' && r != -1) {
                    i++;

                    r = reader.read();
                    ch = (char) r;
                }
                if (i == 3) {
                    list.add(' ');
                }
                if (i == 7) {
                    list.add('-');
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        /*Scanner sc2 = null;
        try {
            sc2 = new Scanner(new File(name));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert sc2 != null;
        while (sc2.hasNextLine()) {
            Scanner s2 = new Scanner(sc2.nextLine());
            while (s2.hasNext()) {
                String s = s2.next();
                strings.add(s);
            }
        }*/


    void handle() {
        /**
         * тут сохраняет в bilder
         */

        for (Character character : list) {
            builder.append(character);
        }
    }

}

class statistic {

    int counter =0;
    char ch;
    statistic (char ch){
        this.ch=ch;
    }
    public int hashCode(){
        return ch;
    }
    public boolean equals (Object o){
        counter++;
        return true;
    }
}

public class Main {

    public static void main(String[] args) {


        //Ввод:
        //Code 1.txt
        //Decode 2.txt
        //Использовать stringbuilder + property

        /**
         * считывание команды и аргумента
         */
        Scanner in = new Scanner(System.in);
        System.out.print("Введите команду и аргумент: ");
        String num = in.nextLine();
        /****/

        /**
         * отделение команды от аргумента
         */
        ArrayList<String> command_arg = new ArrayList<String>();
        Collections.addAll(command_arg, num.split(" "));
        /****/

        Coder coder = null;
        if (command_arg.get(0).equals("code")) coder = new En2Morze();
        else coder = new Morse2En();

        Reader reader = null;
        /**
         * открытие файла
         */
        try {
            reader = new InputStreamReader(new FileInputStream("1.txt"));
            //read the data here
        } catch (IOException e) {
            System.err.println("Error while reading file: " + e.getLocalizedMessage());
        } finally {
            if (null != reader) {
                try {
                    coder.read(command_arg.get(1));
                    coder.handle();
                    coder.write();
                    reader.close();
                    HashSet <statistic> hs=new HashSet<statistic>();
                    hs.add(new statistic('a'));

                } catch (IOException e) {
                    e.printStackTrace(System.err);
                }
            }
        }
        /***/

    }
}
