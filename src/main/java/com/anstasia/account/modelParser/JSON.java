//package com.anstasia.account.modelParser;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import model.taxiStation.StationHolder;
//import model.taxiStation.TaxiStation;
//
//import java.io.File;
//import java.io.IOException;
//
///**
// * Created by Anastasia on 17.11.2017.
// */




//public class JSON {
//
//    private final static String LIST_CAR_FILE = "List_cars.json";// Создаю файл с расширением .json
//
//    public static void writeModelToJSON(StationHolder taxiStation){
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            mapper.enable(SerializationFeature.INDENT_OUTPUT);// красиво парсит
//            mapper.writeValue(new File(LIST_CAR_FILE), taxiStation);
//            System.out.println("File "+LIST_CAR_FILE+" was created!");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Customers json created!");
//    }
//
//    public static TaxiStation readListCarsFromJSON() throws IOException {
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper.readValue(new File(LIST_CAR_FILE), TaxiStation.class);
//    }
//}
//
