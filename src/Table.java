package src;

import aat.AsciiArtTable;

public class Table {
    String[] data;
    AsciiArtTable table = new AsciiArtTable();
    public Table(String[] data){
        this.data = data;
    }
    public void CreateTable(){
        table.addHeaderCols("PC \\ USER");
        for(int i = 0; i< data.length; i++){
            table.addHeaderCols(data[i]);
        }
        for(int i = 1; i<= data.length; i++){
            table.add(data[i-1]);
            for(int k = 1; k<= data.length; k++){
                if(k==i){
                    table.add("DRAW");
                }else{
                boolean win = false;
                int vin = (data.length-1)/2 + i;
                if(i < k && vin >= k ){
                    win = true;
                }
                if(vin > data.length && vin - data.length >= k){
                    win = true;
                }
                if(win){
                    table.add("WIN");
                }else{
                    table.add("LOSE");
                }}
            }
        }
    }
    public void getTable(){
        table.print(System.out);
    }
}
