package com.example.quanly.controller.covid;

import com.example.quanly.Database;
import com.example.quanly.models.CachLy;
import com.example.quanly.models.HoKhau;
import com.example.quanly.models.KhaiBaoYTe;
import com.example.quanly.models.NhanKhau;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TrangChuController {
    @FXML
    private Label tongCachLy;
    @FXML
    private Label tongDaKhaiBao;
    @FXML
    private Label tongChuaKhaiBao;
    @FXML
    private Label tongNhanKhauMac;
    public void initialize(){
        ArrayList<CachLy> cachLyArrayList = Database.findCachLy("*", "");
        ArrayList<KhaiBaoYTe> khaiBaoYTeArrayList = Database.findKhaiBao("*", "");
        ArrayList<NhanKhau> nhanKhauArrayList = Database.findNhanKhau("*", "");

        this.tongCachLy.setText(String.valueOf(cachLyArrayList.size()));
        Set<Integer> idNhanKhauSet = new HashSet<>();
        for(KhaiBaoYTe x: khaiBaoYTeArrayList){
            idNhanKhauSet.add(x.getID());
        }
        int t=0;
        for(CachLy c: cachLyArrayList){
            if(c.getMucDoCachLy().equals("F0")) t+=1;
        }
        this.tongDaKhaiBao.setText(String.valueOf(idNhanKhauSet.size()));
        this.tongChuaKhaiBao.setText(String.valueOf(nhanKhauArrayList.size() - idNhanKhauSet.size()));
        this.tongNhanKhauMac.setText(String.valueOf(t));
    }
}
