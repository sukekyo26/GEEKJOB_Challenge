/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import java.io.Serializable;

/**
 * トップページ関連の表示、エラー処理クラス
 * @author sumi3
 */
public class TopError implements Serializable{
    private boolean markCheck = true;//キーワード検索が未記入の場合に使う
    private String keyword;
    private String highPrice;//いまんとこつかってない
    private String lowPrice;//いまんとこつかってない
    private String compare;//いまんとこつかってない
    
    public TopError(){}
    
    
    public void setKeyword(String keyword){
        this.keyword = keyword;
    }
    public String getKeyword(){
        return keyword;
    }
    public void setHighPrice(String price){
        this.highPrice = price;
    }
    public String getHighPrice(){
        return highPrice;
    }
    public void setLowPrice(String price){
        this.lowPrice = price;
    }
    public String getLowPrice(){
        return lowPrice;
    }
    public void setMarkCheck(boolean search){
        this.markCheck = search;
    }
    public boolean getMarkCheck(){
        return markCheck;
    }
    public void setCompare(String compare){
        this.compare = compare;
    }
    public String getCompare(){
        return compare;
    } 
}
