package com.example.sassydesign;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DailyScreen extends Fragment {

    TextView dailyOutcome;
    TextView dailyIncome;
    TextView dailyTotal;

    int totalIncome = 0;
    int totalOutcome = 0;
    int total = 0;

    ItemAdapter itemAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_daily_screen, container, false);

        //선언문
        String title = null;
        String cacheOrCard = null;
        ArrayList<String> itemList = new ArrayList<String>();
        ArrayList<String> categoryList = new ArrayList<String>();
        ArrayList<String> quantityList = new ArrayList<String>();
        ArrayList<String> priceList = new ArrayList<String>();


        dailyOutcome = rootView.findViewById(R.id.dailyOutcome);
        dailyIncome = rootView.findViewById(R.id.dailyIncome);
        dailyTotal = rootView.findViewById(R.id.dailyTotal);

        RecyclerView dailyReceiptList = rootView.findViewById(R.id.dailyReceiptList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        dailyReceiptList.setLayoutManager(layoutManager);
        itemAdapter = new ItemAdapter();


        //데베에서 받아온 제목 넣기
        title = "제목";
        //데베에서 받아온 현금/카드 넣기
        cacheOrCard = "카드";
        //데베에서 받아온 물품 목록 넣기

        //튜플 개수 받아오기
        int cursor = 3;
        //튜플 개수만큼 반복

        setItemList(itemList, cursor);
        setCategoryList(categoryList, cursor);
        setQuantityList(quantityList, cursor);
        setPriceList(priceList, cursor);

        setItemObject(title, cacheOrCard, itemList, categoryList, quantityList, priceList, cursor);

        dailyReceiptList.setAdapter(itemAdapter);

        setTotal();

        return rootView;
    }

    public void setItemList(ArrayList<String> itemList, int cursor){
        for( int i = 0; i < cursor ; i++){
            //데베에서 가져온 항목을 arraylsit에 넣기
            itemList.add("데베항목");
            //마지막에는 엔터 넣지 않음
            if (i != cursor-1)
                itemList.add("\n");
        }
    }

    public void setCategoryList(ArrayList<String> categoryList, int cursor){
        for( int i = 0; i < cursor ; i++){
            categoryList.add("데베카테고리");
            //마지막에는 엔터 넣지 않음
            if (i != cursor-1)
                categoryList.add("\n");
        }
    }

    public void setQuantityList(ArrayList<String> quantityList, int cursor){
        for( int i = 0; i < cursor ; i++){
            quantityList.add("1");
            //마지막에는 엔터 넣지 않음
            if (i != cursor-1)
                quantityList.add("\n　");
        }
    }

    public void setPriceList(ArrayList<String> priceList, int cursor){
        String priceEX = "-4000"; //데베에서 받아온 가격 예시

        for( int i = 0; i < cursor ; i++){
            if(priceEX.charAt(0) == '-'){
                int newPriceEX = Math.abs(Integer.parseInt(priceEX));
                totalOutcome += newPriceEX*(-1);
                priceList.add(priceEX);
            }

            else if(priceEX.charAt(0) == '+'){
                int newPriceEX = Integer.parseInt(priceEX);
                totalIncome += newPriceEX;
                priceList.add(priceEX);
            }

            //마지막에는 엔터 넣지 않음
            if (i != cursor-1)
                priceList.add("\n　");
        }
    }

    public void setItemObject(String title, String cacheOrCard, ArrayList<String> itemList, ArrayList<String> categoryList,
                              ArrayList<String> quantityList, ArrayList<String> priceList, int cursor){
        String date = "";
        ArrayList<String> items = new ArrayList<>();
        ArrayList<String> categories = new ArrayList<>();
        ArrayList<String> quantities = new ArrayList<>();
        ArrayList<String> price = new ArrayList<>();

        items.add("냠냠굿 과자");
        categories.add("식비");
        quantities.add("1");
        price.add("-3500");


        items.add("냠냠굿 과자2");
        categories.add("식비");
        quantities.add("1");
        price.add("-3500");

        itemAdapter.addItem(new Item(date, title, cacheOrCard, items,
                categories, quantities, price));

    }

    public void setTotal(){
        dailyOutcome.setText(""+totalOutcome);
        dailyIncome.setText("+"+totalIncome);

        total = totalIncome + totalOutcome;
        if (total>0)
        {
            dailyTotal.setText("+" + total);
        }
        else
        {
            dailyTotal.setText(""+total);
        }
    }
}