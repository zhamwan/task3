package src;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Random random = new Random();
        Scanner in = new Scanner(System.in);
        Table table = new Table(args);
        table.CreateTable();
        if (args.length  == 0 ){
            System.out.println("Введите  ходы");
            System.exit(0);
        }
        if (args.length % 2 == 0 || args.length == 1 ){
            System.out.println("Введите нечетное кол-во ходов и больше 1");
            System.exit(0);
        }
        while (true){
            byte[] keyRandom = random.getKey();
            Key key = new Key(keyRandom.toString());
            int step = random.getStep(args.length);
            try{
            String hmac = key.getHmac(args[step], step);
                System.out.println(hmac);}
            catch (Exception e) {
                System.out.println("ERROR");
                System.exit(0);}
            for(int i = 0; i< args.length; i++){
                System.out.println(i + 1 + " - " + args[i]);
            }
            System.out.println("0 - exit");
            System.out.println("? - help");
            if (in.hasNextInt()){
                int num = in.nextInt();
                if (num == 0){
                    System.exit(0);
                }
                if (num > args.length+1){
                    System.out.println("Не верный ход");
                }else{
                    boolean win = false;
                    int vin = (args.length-1)/2 + num;
                    if(num < step && vin >= step ){
                        win = true;
                    }
                    if(vin > args.length && vin - args.length >= step){
                        win = true;
                    }
                    if(win && num!=step){
                        System.out.println("Ты выбрал: " + args[num-1]);
                        System.out.println("Компьютер выбрал: " + args[step-1]);
                        System.out.println("Ты выйграл");
                    }
                    if(!win && num!=step){
                        System.out.println("Ты выбрал: " + args[num-1]);
                        System.out.println("Компьютер выбрал: " + args[step-1]);
                        System.out.println("Ты проиграл");
                    }
                    if(num == step){
                    System.out.println("Ты выбрал: " + args[num-1]);
                    System.out.println("Компьютер выбрал: " + args[step-1]);
                    System.out.println("ничья");}

                }
            }else{
            String input = in.next();
            if(!input.equals("?")){
                System.out.println("Не верный ход");
            }else{
                table.getTable();
            }}
            System.out.println(String.format("key:%032x", new BigInteger(1, keyRandom)));
            }
    }
}
