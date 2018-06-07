/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class03;

/**
 *
 * @author sumi3
 */
public class BlackJack {
    public static void main(String[] args){
        //ディーラーインスタンス作成
        Dealer tonegawa = new Dealer();
        //ユーザーインスタンス作成
        User kaiji = new User();
        //ユーザーにディーラーがカードを2枚配る
        kaiji.setCard(tonegawa.deal());
        //ディーラーにディーラーがカードを2枚配る
        tonegawa.setCard(tonegawa.deal());
        //ユーザーが新しくカードを引くかどうか
        while(kaiji.checkSum() == true){
            System.out.println("プレイヤーの現在の得点は" + kaiji.open() + "点です");
            System.out.println("プレイヤーがヒットを宣言しました");
            kaiji.setCard(tonegawa.hit());
        }
        //プレイヤーがバストしたかどうか
        if(kaiji.open() > 21){
            System.out.println("プレイヤーがバストした為プレイヤーの負けです。");
            System.out.println("プレイヤーの得点は" + kaiji.open() +"点です");
            System.exit(0);
        }    
        System.out.println("プレイヤーがスタンドを宣言しました");
        //ディーラーが新しくカードを引くかどうか
        while(tonegawa.checkSum() == true){
            System.out.println("ディーラーの現在の得点は" + tonegawa.open() + "点です");
            System.out.println("ディーラーがヒットを宣言しました");
            tonegawa.setCard(tonegawa.hit());
        }
        //ディーラーがバストしたかどうか
        if(tonegawa.open() > 21){
            System.out.println("ディーラ－がバストした為プレイヤーの勝利です。");
            System.out.println("プレイヤーの得点は" + kaiji.open() +"点です");
            System.out.println("ディーラーの得点は" + tonegawa.open() + "点です");
            System.exit(0);
        }
        System.out.println("ディーラーがスタンドを宣言しました");
        //プレイヤーとディーラーの得点比較
        if(tonegawa.open() > kaiji.open()){
            System.out.println("プレイヤーの得点は" + kaiji.open() +"点です");
            System.out.println("ディーラーの得点は" + tonegawa.open() + "点です");
            System.out.println("ディーラーの得点がプレイヤーの得点を上回ったのでディーラーの勝利です");
        } else if(tonegawa.open() == kaiji.open()) {
            System.out.println("プレイヤーの得点は" + kaiji.open() +"点です");
            System.out.println("ディーラーの得点は" + tonegawa.open() + "点です");
            System.out.println("ディーラーの得点とプレイヤーの得点が同値なので引き分けです");
        } else {
            System.out.println("プレイヤーの得点は" + kaiji.open() +"点です");
            System.out.println("ディーラーの得点は" + tonegawa.open() + "点です");
            System.out.println("プレイヤーの得点がディーラーの得点を上回ったのでプレイヤーの勝利です");
        }    
    }    
}
