package com.nakoya.thaipai.calcarinsur;

import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by ekapop on 1/28/2016.
 */
public class ReadText {
    private static final String FILE_ENCODE = "UTF-8";
    public ArrayList<String> band, model, year;
    public String tank,re="";
    BufferedReader brT;
    public ReadText(String path) {
        band = new ArrayList<String>();
        model = new ArrayList<String>();
        year = new ArrayList<String>();
        tank = "";
    }
    public ArrayList<String> getBand110(AssetManager am) {
        try {
            brT = new BufferedReader(new InputStreamReader(am.open("110/Carbrand.txt"), FILE_ENCODE));
            while ((tank = brT.readLine()) != null) {band.add(tank.trim());}
            brT.close();
        } catch (Exception e) {e.printStackTrace();}
        return band;
    }
    public ArrayList<String> getBand210(AssetManager am) {
        try {
            brT = new BufferedReader(new InputStreamReader(am.open("210/Carbrand.txt"), FILE_ENCODE));
            while ((tank = brT.readLine()) != null) {band.add(tank.trim());}
            brT.close();
        } catch (Exception e) {e.printStackTrace();}
        return band;
    }
    public ArrayList<String> getBand410(AssetManager am) {
        try {
            brT = new BufferedReader(new InputStreamReader(am.open("410/Carbrand.txt"), FILE_ENCODE));
            while ((tank = brT.readLine()) != null) {band.add(tank.trim());}
            brT.close();
        } catch (Exception e) {e.printStackTrace();}
        return band;
    }
    public ArrayList<String> getModel(String bandId, AssetManager am) {
        try {
            brT = new BufferedReader(new InputStreamReader(am.open("110/CarModel.txt"), FILE_ENCODE));
            while ((tank = brT.readLine()) != null) {
                String[] ll = tank.split("\t");
                if (ll[0].equalsIgnoreCase(bandId)) {model.add(ll[2].trim());}
            }
            brT.close();
        } catch (Exception e) {e.printStackTrace();}
        return model;
    }
    public ArrayList<String> getModel210(String bandId, AssetManager am) {
        try {
            brT = new BufferedReader(new InputStreamReader(am.open("210/CarModel.txt"), FILE_ENCODE));
            while ((tank = brT.readLine()) != null) {
                String[] ll = tank.split("\t");
                if (ll[0].equalsIgnoreCase(bandId)) {model.add(ll[2].trim());}
            }
            brT.close();
        } catch (Exception e) {e.printStackTrace();}
        return model;
    }
    public ArrayList<String> getModel410(String bandId, AssetManager am) {
        try {
            brT = new BufferedReader(new InputStreamReader(am.open("410/CarModel.txt"), FILE_ENCODE));
            while ((tank = brT.readLine()) != null) {
                String[] ll = tank.split("\t");
                if (ll[0].equalsIgnoreCase(bandId)) {model.add(ll[2].trim());}
            }
            brT.close();
        } catch (Exception e) {e.printStackTrace();}
        return model;
    }
    public ArrayList<String> getYear(AssetManager am) {
        try {
            brT = new BufferedReader(new InputStreamReader(am.open("110/CarYear.txt"), FILE_ENCODE));
            while ((tank = brT.readLine()) != null) {year.add(tank.trim());}
            brT.close();
        } catch (Exception e) {e.printStackTrace();}
        return year;
    }
    //---------------------------
    public String getModeCar(AssetManager am,String string) {
        try {
            re="";
            brT = new BufferedReader(new InputStreamReader(am.open("110/ModeCar.txt"), FILE_ENCODE));
            while ((tank = brT.readLine()) != null) {
                String[] ll = tank.split("\t");
                if (ll[0].equals(string)) {
                    re = (ll[1].trim());}
            }
            brT.close();
        } catch (Exception e) {e.printStackTrace();}
        return re;
    }
    public String getModeCar210(AssetManager am,String string) {
        try {
            re="";
            brT = new BufferedReader(new InputStreamReader(am.open("210/ModeCar.txt"), FILE_ENCODE));
            while ((tank = brT.readLine()) != null) {
                String[] ll = tank.split("\t");
                if (ll[0].equals(string)) {
                    re = (ll[1].trim());}
            }
            brT.close();
        } catch (Exception e) {e.printStackTrace();}
        return re;
    }
    public String getModeCar320(AssetManager am,String string) {
        try {
            re="";
            brT = new BufferedReader(new InputStreamReader(am.open("320/ModeCar.txt"), FILE_ENCODE));
            while ((tank = brT.readLine()) != null) {
                String[] ll = tank.split("\t");
                if (ll[0].equals(string)) {
                    re = (ll[1].trim());}
            }
            brT.close();
        } catch (Exception e) {e.printStackTrace();}
        return re;
    }
    public String getMotorCar(AssetManager am,String motor) {
        try {
            re="";
            if(Integer.parseInt(motor)>2000){motor="2001";}
            else
            {motor="2000";}
            brT = new BufferedReader(new InputStreamReader(am.open("110/MotorCar.txt"), FILE_ENCODE));
            while ((tank = brT.readLine()) != null) {
                String[] ll = tank.split("\t");
                if (ll[0].equals(motor)) {
                    re = (ll[1].trim());}
            }
            brT.close();
        } catch (Exception e) {e.printStackTrace();}
        return re;
    }
    public String getMotorCar210(AssetManager am,String motor) {
        try {
            re="";
            if(Integer.parseInt(motor)<=20){motor="1";}
            if(Integer.parseInt(motor)>20&&Integer.parseInt(motor)<=40){motor="21";}
            if (Integer.parseInt(motor)>40){motor="41";}
            brT = new BufferedReader(new InputStreamReader(am.open("210/MotorCar.txt"), FILE_ENCODE));
            while ((tank = brT.readLine()) != null) {
                String[] ll = tank.split("\t");
                if (ll[0].equals(motor)) {
                    re = (ll[1].trim());}
            }
            brT.close();
        } catch (Exception e) {e.printStackTrace();}
        return re;
    }
    public String getMotorCar320(AssetManager am,String motor) {
        try {
            re="";
            if(Integer.parseInt(motor)<=4000){motor="1";}
            if(Integer.parseInt(motor)>4000&&Integer.parseInt(motor)<=12000){motor="4001";}
            if (Integer.parseInt(motor)>12000){motor="12001";}
            brT = new BufferedReader(new InputStreamReader(am.open("320/MotorCar.txt"), FILE_ENCODE));
            while ((tank = brT.readLine()) != null) {
                String[] ll = tank.split("\t");
                if (ll[0].equals(motor)) {
                    re = (ll[1].trim());}
            }
            brT.close();
        } catch (Exception e) {e.printStackTrace();}
        return re;
    }
    public String getDriverAge(AssetManager am,String age,String numYear) {
        try {
            re="";
            int ageDrive = Integer.parseInt(age);
            int getYear = Integer.parseInt(numYear)-1;
            if(ageDrive>=0 && ageDrive<=200){
                ageDrive = ageDrive;
            }
            else if(ageDrive>=201 && ageDrive<=getYear){
                ageDrive = getYear - ageDrive;
            }
            else if(ageDrive>=getYear && ageDrive <= (getYear+543)){
                ageDrive = (getYear+543) - ageDrive;
            }
            if(Integer.parseInt(age)>=51){age="51";}
            if(Integer.parseInt(age)>=36&&Integer.parseInt(age)<51){age="36";}
            if(Integer.parseInt(age)>=25&&Integer.parseInt(age)<36){age="25";}
            if(Integer.parseInt(age)>=18&&Integer.parseInt(age)<25){age="18";}
            if(Integer.parseInt(age)<18) {age="17";}
            brT = new BufferedReader(new InputStreamReader(am.open("110/DriverAge.txt"), FILE_ENCODE));
            while ((tank = brT.readLine()) != null) {
                String[] ll1 = tank.split("\t");
                if (ll1[0].equals(age)) {
                    re = (ll1[1].trim());}
            }
            brT.close();
        } catch (Exception e) {e.printStackTrace();}
        return re;
    }
    public String getDriverAge210(AssetManager am,String age,String numYear) {
        try {
            re="";
            int ageDrive = Integer.parseInt(age);
            int getYear = Integer.parseInt(numYear)-1;
            if(ageDrive>=0 && ageDrive<=200){
                ageDrive = ageDrive;
            }
            else if(ageDrive>=201 && ageDrive<=getYear){
                ageDrive = getYear - ageDrive;
            }
            else if(ageDrive>=getYear && ageDrive <= (getYear+543)){
                ageDrive = (getYear+543) - ageDrive;
            }
            if(Integer.parseInt(age)>=51){age="51";}
            if(Integer.parseInt(age)>=36&&Integer.parseInt(age)<51){age="36";}
            if(Integer.parseInt(age)>=25&&Integer.parseInt(age)<36){age="25";}
            if(Integer.parseInt(age)>=18&&Integer.parseInt(age)<25){age="18";}
            if(Integer.parseInt(age)<18) {age="17";}
            brT = new BufferedReader(new InputStreamReader(am.open("210/DriverAge.txt"), FILE_ENCODE));
            while ((tank = brT.readLine()) != null) {
                String[] ll = tank.split("\t");
                if (ll[0].equals(age)) {
                    re = (ll[1].trim());}
            }
            brT.close();
        } catch (Exception e) {e.printStackTrace();}
        return re;
    }
    //-------------------------------------
    public String getCarAge(AssetManager am,String age) {
        try {
            re="";
            if(age.equals("0")){
                age = "1";
            }
            brT = new BufferedReader(new InputStreamReader(am.open("110/CarAge.txt"), FILE_ENCODE));
            while ((tank = brT.readLine()) != null) {
                String[] ll = tank.split("\t");
                if (ll[0].equals(age)) {
                    re = (ll[1].trim());}
            }
            brT.close();
        } catch (Exception e) {e.printStackTrace();}
        return re;
    }
    public String getCarAge210(AssetManager am,String age) {
        try {
            re="";
            if(age.equals("0")){
                age = "1";
            }
            brT = new BufferedReader(new InputStreamReader(am.open("210/CarAge.txt"), FILE_ENCODE));
            while ((tank = brT.readLine()) != null) {
                String[] ll = tank.split("\t");
                if (ll[0].equals(age)) {
                    re = (ll[1].trim());}
            }
            brT.close();
        } catch (Exception e) {e.printStackTrace();}
        return re;
    }
    public String getCarAge320(AssetManager am,String age) {
        try {
            re="";
            if(age.equals("0")){
                age = "1";
            }
            brT = new BufferedReader(new InputStreamReader(am.open("320/CarAge.txt"), FILE_ENCODE));
            while ((tank = brT.readLine()) != null) {
                String[] ll = tank.split("\t");
                if (ll[0].equals(age)) {
                    re = (ll[1].trim());}
            }
            brT.close();
        } catch (Exception e) {e.printStackTrace();}
        return re;
    }
    public String getGroupCar(AssetManager am,String groupCar) {
        try {
            re="";
            brT = new BufferedReader(new InputStreamReader(am.open("110/GroupCar.txt"), FILE_ENCODE));
            while ((tank = brT.readLine()) != null) {
                String[] ll = tank.split("\t");
                if (ll[0].equals(groupCar)) {
                    re = (ll[1].trim());}
            }
            brT.close();
        } catch (Exception e) {e.printStackTrace();}
        return re;
    }
    public String getTypeInsurance(AssetManager am,String row,String column) {
        try {
            re="";
            if(row.equalsIgnoreCase("") || row==null || row.equalsIgnoreCase("0") || row=="0"){
                row = "50000";
            }
            brT = new BufferedReader(new InputStreamReader(am.open("110/CarInsur.txt"), FILE_ENCODE));
            while ((tank = brT.readLine()) != null) {
                String[] ll = tank.split("\t");
                if (ll[0].equalsIgnoreCase(row)) {
                    if(column.equalsIgnoreCase("1")){
                        re = (ll[1].trim());}

                    if(column.equalsIgnoreCase("2")){
                        re = (ll[2].trim());}
                }
                else if(re == ""){
                    re = "0";
                }
            }
            brT.close();
        } catch (Exception e) {e.printStackTrace();}
        return re;
    }
    public String getTypeInsurance210(AssetManager am,String row,String column) {
        try {
            re="";
            if(row.equalsIgnoreCase("") || row==null || row.equalsIgnoreCase("0") || row=="0"){
                row = "50000";
            }
            brT = new BufferedReader(new InputStreamReader(am.open("210/CarInsur.txt"), FILE_ENCODE));
            while ((tank = brT.readLine()) != null) {
                String[] ll = tank.split("\t");
                if (ll[0].equalsIgnoreCase(row)) {
                    if(column.equalsIgnoreCase("1")){
                        re = (ll[1].trim());}

                    if(column.equalsIgnoreCase("2")){
                        re = (ll[2].trim());}
                }
                else if(re == ""){
                    re = "0";
                }
            }
            brT.close();
        } catch (Exception e) {e.printStackTrace();}
        return re;
    }
    public String getTypeInsurance320(AssetManager am,String row,String column) {
        try {
            re="";
            if(row.equalsIgnoreCase("") || row==null || row.equalsIgnoreCase("0") || row=="0"){
                row = "50000";
            }
            brT = new BufferedReader(new InputStreamReader(am.open("320/CarInsur.txt"), FILE_ENCODE));
            while ((tank = brT.readLine()) != null) {
                String[] ll = tank.split("\t");
                if (ll[0].equalsIgnoreCase(row)) {
                    if(column.equalsIgnoreCase("1")){
                        re = (ll[1].trim());}

                    if(column.equalsIgnoreCase("2")){
                        re = (ll[2].trim());}
                }
                else if(re == ""){
                    re = "0";
                }
            }
            brT.close();
        } catch (Exception e) {e.printStackTrace();}
        return re;
    }
    public String getDamagePerson(AssetManager am,String row,String column) {
        try {
            re="";
            brT = new BufferedReader(new InputStreamReader(am.open("110/Damageperson.txt"), FILE_ENCODE));
            while ((tank = brT.readLine()) != null) {
                String[] ll = tank.split("\t");
                if (ll[0].equalsIgnoreCase(row)) {
                    if(column.equalsIgnoreCase("1")){
                        re = (ll[1].trim());}

                    if(column.equalsIgnoreCase("2")){
                        re = (ll[2].trim());}
                }
                else if(Integer.parseInt(row)>Integer.parseInt(ll[0])){
                    if(column.equalsIgnoreCase("1")){
                        re = (ll[1].trim());}

                    if(column.equalsIgnoreCase("2")){
                        re = (ll[2].trim());}
                }
            }
            brT.close();
        } catch (Exception e) {e.printStackTrace();}
        return re;
    }
    public String getDamagePerson210(AssetManager am,String row,String column) {
        try {
            re="";
            brT = new BufferedReader(new InputStreamReader(am.open("210/Damageperson.txt"), FILE_ENCODE));
            while ((tank = brT.readLine()) != null) {
                String[] ll = tank.split("\t");
                if (ll[0].equalsIgnoreCase(row)) {
                    if(column.equalsIgnoreCase("1")){
                        re = (ll[1].trim());}

                    if(column.equalsIgnoreCase("2")){
                        re = (ll[2].trim());}
                }
                else if(Integer.parseInt(row)>Integer.parseInt(ll[0])){
                    if(column.equalsIgnoreCase("1")){
                        re = (ll[1].trim());}

                    if(column.equalsIgnoreCase("2")){
                        re = (ll[2].trim());}
                }
            }
            brT.close();
        } catch (Exception e) {e.printStackTrace();}
        return re;
    }
    public String getDamagePerson320(AssetManager am,String row,String column) {
        try {
            re="";
            brT = new BufferedReader(new InputStreamReader(am.open("320/Damageperson.txt"), FILE_ENCODE));
            while ((tank = brT.readLine()) != null) {
                String[] ll = tank.split("\t");
                if (ll[0].equalsIgnoreCase(row)) {
                    if(column.equalsIgnoreCase("1")){
                        re = (ll[1].trim());}

                    if(column.equalsIgnoreCase("2")){
                        re = (ll[2].trim());}
                }
                else if(Integer.parseInt(row)>Integer.parseInt(ll[0])){
                    if(column.equalsIgnoreCase("1")){
                        re = (ll[1].trim());}

                    if(column.equalsIgnoreCase("2")){
                        re = (ll[2].trim());}
                }
            }
            brT.close();
        } catch (Exception e) {e.printStackTrace();}
        return re;
    }
    public String getDamageAccient(AssetManager am,String row,String column) {
        try {
            re="";
            brT = new BufferedReader(new InputStreamReader(am.open("110/Damageaccient.txt"), FILE_ENCODE));
            while ((tank = brT.readLine()) != null) {
                String[] ll = tank.split("\t");
                if (ll[0].equalsIgnoreCase(row)) {
                    if(column.equalsIgnoreCase("1")){
                        re = (ll[1].trim());}

                    if(column.equalsIgnoreCase("2")){
                        re = (ll[2].trim());}
                }
                else if(Integer.parseInt(row)>Integer.parseInt(ll[0])){
                    if(column.equalsIgnoreCase("1")){
                        re = (ll[1].trim());}

                    if(column.equalsIgnoreCase("2")){
                        re = (ll[2].trim());}
                }
            }
            brT.close();
        } catch (Exception e) {e.printStackTrace();}
        return re;
    }
    public String getDamageAccient210(AssetManager am,String row,String column) {
        try {
            re="";
            brT = new BufferedReader(new InputStreamReader(am.open("210/Damageaccient.txt"), FILE_ENCODE));
            while ((tank = brT.readLine()) != null) {
                String[] ll = tank.split("\t");
                if (ll[0].equalsIgnoreCase(row)) {
                    if(column.equalsIgnoreCase("1")){
                        re = (ll[1].trim());}

                    if(column.equalsIgnoreCase("2")){
                        re = (ll[2].trim());}
                }
                else if(Integer.parseInt(row)>Integer.parseInt(ll[0])){
                    if(column.equalsIgnoreCase("1")){
                        re = (ll[1].trim());}

                    if(column.equalsIgnoreCase("2")){
                        re = (ll[2].trim());}
                }
            }
            brT.close();
        } catch (Exception e) {e.printStackTrace();}
        return re;
    }
    public String getDamageAccient320(AssetManager am,String row,String column) {
        try {
            re="";
            brT = new BufferedReader(new InputStreamReader(am.open("320/Damageaccient.txt"), FILE_ENCODE));
            while ((tank = brT.readLine()) != null) {
                String[] ll = tank.split("\t");
                if (ll[0].equalsIgnoreCase(row)) {
                    if(column.equalsIgnoreCase("1")){
                        re = (ll[1].trim());}

                    if(column.equalsIgnoreCase("2")){
                        re = (ll[2].trim());}
                }
                else if(Integer.parseInt(row)>Integer.parseInt(ll[0])){
                    if(column.equalsIgnoreCase("1")){
                        re = (ll[1].trim());}

                    if(column.equalsIgnoreCase("2")){
                        re = (ll[2].trim());}
                }
            }
            brT.close();
        } catch (Exception e) {e.printStackTrace();}
        return re;
    }
    public String getDamageProperty(AssetManager am,String row,String column) {
        try {
            re="";
            brT = new BufferedReader(new InputStreamReader(am.open("110/Damageproperty.txt"), FILE_ENCODE));
            while ((tank = brT.readLine()) != null) {
                String[] ll = tank.split("\t");
                if (ll[0].equalsIgnoreCase(row)) {
                    if(column.equalsIgnoreCase("1")){
                        re = (ll[1].trim());}

                    if(column.equalsIgnoreCase("2")){
                        re = (ll[2].trim());}
                }
                else if(Integer.parseInt(row)>Integer.parseInt(ll[0])){
                    if(column.equalsIgnoreCase("1")){
                        re = (ll[1].trim());}

                    if(column.equalsIgnoreCase("2")){
                        re = (ll[2].trim());}
                }
            }
            brT.close();
        } catch (Exception e) {e.printStackTrace();}
        return re;
    }
    public String getDamageProperty210(AssetManager am,String row,String column) {
        try {
            re="";
            brT = new BufferedReader(new InputStreamReader(am.open("210/Damageproperty.txt"), FILE_ENCODE));
            while ((tank = brT.readLine()) != null) {
                String[] ll = tank.split("\t");
                if (ll[0].equalsIgnoreCase(row)) {
                    if(column.equalsIgnoreCase("1")){
                        re = (ll[1].trim());}

                    if(column.equalsIgnoreCase("2")){
                        re = (ll[2].trim());}
                }
                else if(Integer.parseInt(row)>Integer.parseInt(ll[0])){
                    if(column.equalsIgnoreCase("1")){
                        re = (ll[1].trim());}

                    if(column.equalsIgnoreCase("2")){
                        re = (ll[2].trim());}
                }
            }
            brT.close();
        } catch (Exception e) {e.printStackTrace();}
        return re;
    }
    public String getDamageProperty320(AssetManager am,String row,String column) {
        try {
            re="";
            brT = new BufferedReader(new InputStreamReader(am.open("320/Damageproperty.txt"), FILE_ENCODE));
            while ((tank = brT.readLine()) != null) {
                String[] ll = tank.split("\t");
                if (ll[0].equalsIgnoreCase(row)) {
                    if(column.equalsIgnoreCase("1")){
                        re = (ll[1].trim());}

                    if(column.equalsIgnoreCase("2")){
                        re = (ll[2].trim());}
                }
                else if(Integer.parseInt(row)>Integer.parseInt(ll[0])){
                    if(column.equalsIgnoreCase("1")){
                        re = (ll[1].trim());}

                    if(column.equalsIgnoreCase("2")){
                        re = (ll[2].trim());}
                }
            }
            brT.close();
        } catch (Exception e) {e.printStackTrace();}
        return re;
    }
    public String getME(AssetManager am,String row,String column) {
        String f="";
        try {
            brT = new BufferedReader(new InputStreamReader(am.open("110/me.txt"), FILE_ENCODE));
            while ((tank = brT.readLine()) != null) {
                String[] ll = tank.split("\t");
                if (ll[0].equalsIgnoreCase(row)) {
                    if(column.equalsIgnoreCase("110")){
                        f = (ll[1].trim());}

                    if(column.equalsIgnoreCase("120")){
                        f = (ll[2].trim());}
                }
            }
            brT.close();
        } catch (Exception e) {e.printStackTrace();}
        return f;
    }
    public String getModel1(AssetManager am,String bandId,String modelId) {
        try {
            tank = "";
            brT = new BufferedReader(new InputStreamReader(am.open("110/CarModel.txt"), FILE_ENCODE));
            while ((tank = brT.readLine()) != null) {
                String[] ll = tank.split("\t");
                if (ll[0].equalsIgnoreCase(bandId)){
                    if (ll[1].equalsIgnoreCase(modelId)) {
                        break;
                    }
                }
            }
            brT.close();
        } catch (Exception e) {e.printStackTrace();}
        return tank;
    }
    public String getModel1210(AssetManager am,String bandId,String modelId) {
        try {
            tank = "";
            brT = new BufferedReader(new InputStreamReader(am.open("210/CarModel.txt"), FILE_ENCODE));
            while ((tank = brT.readLine()) != null) {
                String[] ll = tank.split("\t");
                if (ll[0].equalsIgnoreCase(bandId)){
                    if (ll[1].equalsIgnoreCase(modelId)) {
                        break;
                    }
                }
            }
            brT.close();
        } catch (Exception e) {e.printStackTrace();}
        return tank;
    }
    public String getModel1410(AssetManager am,String bandId,String modelId) {
        try {
            tank = "";
            brT = new BufferedReader(new InputStreamReader(am.open("410/CarModel.txt"), FILE_ENCODE));
            while ((tank = brT.readLine()) != null) {
                String[] ll = tank.split("\t");
                if (ll[0].equalsIgnoreCase(bandId)){
                    if (ll[1].equalsIgnoreCase(modelId)) {
                        break;
                    }
                }
            }
            brT.close();
        } catch (Exception e) {e.printStackTrace();}
        return tank;
    }
    public ArrayList<String> getModelId(AssetManager am,String bandId) {
        try {
            brT = new BufferedReader(new InputStreamReader(am.open("110/CarModel.txt"), FILE_ENCODE));
            while ((tank = brT.readLine()) != null) {
                String[] ll = tank.split("\t");
                if (ll[0].equalsIgnoreCase(bandId)) {model.add(ll[1].trim());}
            }
            brT.close();
        } catch (Exception e) {e.printStackTrace();}
        return model;
    }
    public ArrayList<String> getModelId210(AssetManager am,String bandId) {
        try {
            brT = new BufferedReader(new InputStreamReader(am.open("210/CarModel.txt"), FILE_ENCODE));
            while ((tank = brT.readLine()) != null) {
                String[] ll = tank.split("\t");
                if (ll[0].equalsIgnoreCase(bandId)) {model.add(ll[1].trim());}
            }
            brT.close();
        } catch (Exception e) {e.printStackTrace();}
        return model;
    }
    public ArrayList<String> getModelId410(AssetManager am,String bandId) {
        try {
            brT = new BufferedReader(new InputStreamReader(am.open("410/CarModel.txt"), FILE_ENCODE));
            while ((tank = brT.readLine()) != null) {
                String[] ll = tank.split("\t");
                if (ll[0].equalsIgnoreCase(bandId)) {model.add(ll[1].trim());}
            }
            brT.close();
        } catch (Exception e) {e.printStackTrace();}
        return model;
    }
}
