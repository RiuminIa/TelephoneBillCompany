package com.phonecompany.billing;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TelephoneBill implements TelephoneBillCalculator {
    @Override
    public BigDecimal calculate(String phoneLog) {
        List<PhoneData> phoneDataList = new ArrayList<>();
        parseData(phoneLog,phoneDataList);
        BigDecimal sum=new BigDecimal(0);
        for(PhoneData phone:phoneDataList){
            int startCallMinutes=0;
            int startCallHours=0;
            if(!phone.getFree()){
                startCallMinutes=phone.getMinutesFrom();
                startCallHours=phone.getHourFrom();
                int hour;
                for(int i=1;i<=phone.getMinutes();i++){
                    hour=(startCallMinutes+i)/60;
                    if(i<=5){
                        if((startCallHours+hour)>8 && (startCallHours+hour)<16){
                            sum=sum.add(new BigDecimal(1));
                        }
                        else{
                            sum=sum.add(new BigDecimal(0.5));
                        }
                    }
                    else{
                        sum=sum.add(new BigDecimal(0.2));
                    }
                }
            }
        }
        return sum;
    }
    private void parseData(String telephoneData,List<PhoneData> dataList){
        final String datePattern = "dd-MM-yyyy HH:mm:ss";
        Map<String, Integer> frequencyMap = new HashMap<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
        String[] lines = telephoneData.split("\n");
        try {
            Calendar calendar = Calendar.getInstance();
            for (String line : lines) {
                String[] data = line.split(",");
                String phoneNumber = data[0];
                frequencyMap.put(data[0], frequencyMap.getOrDefault(data[0], 0) + 1);
                Date date1=dateFormat.parse(data[1]);
                Date date2 = dateFormat.parse(data[2]);
                long diffInMilliseconds = Math.abs(date2.getTime() - date1.getTime());
                long diffInMinutes = diffInMilliseconds / (60 * 1000);
                calendar.setTime(date1);
                int hourFrom = calendar.get(Calendar.HOUR_OF_DAY);
                int minutsFrom = calendar.get(Calendar.MINUTE);
                PhoneData phoneData = new PhoneData(phoneNumber, date1, date2);
                phoneData.setMinutes(diffInMinutes);
                phoneData.setHourFrom(hourFrom);
                phoneData.setMinutesFrom(minutsFrom);
                dataList.add(phoneData);
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String mostFrequentString = null;
        int maxFrequency = 1;
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                mostFrequentString = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }
        for(PhoneData phone:dataList){
            if(phone.getPhoneNumber().equals(mostFrequentString)){
                phone.setFree(true);
            }
        }

    }


}
