package org.example;

import com.phonecompany.billing.TelephoneBill;

public class Main {
    public static void main(String[] args) {
        TelephoneBill tel=new TelephoneBill();
        tel.calculate("420774577453,13-01-2020 18:10:15,13-01-2020 18:12:57\n420776562353,18-01-2020 08:59:20,18-01-2020 09:10:00");
    }
}