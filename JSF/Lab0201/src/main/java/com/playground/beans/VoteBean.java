package com.playground.beans;

import jakarta.annotation.PostConstruct;
import jakarta.faces.bean.ManagedProperty;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;


@Named
public class VoteBean implements Serializable {

//    @ManagedProperty(value = "#{listBean}")
//    @Inject
    private CatListBean catListBean;

    @PostConstruct
    public  void init(){
        System.out.println(catListBean);
    }

    private boolean voted;
    private String choosen;

    public boolean isVoted() {
        return voted;
    }

    public void setVoted(boolean voted) {
        this.voted = voted;
    }

    public String getChoosen() {
        return choosen;
    }

    public void setChoosen(String choosen) {
        this.choosen = choosen;
    }


    public CatListBean getCatListBean() {
        return catListBean;
    }

    public void setCatListBean(CatListBean catListBean) {
        this.catListBean = catListBean;
    }

    public String voteBtn(){

        if(getChoosen() != null){
            catListBean.incCategory(getChoosen());
            setVoted(true);
            return "Results";
        }else {
            return null;
        }
    }

}
