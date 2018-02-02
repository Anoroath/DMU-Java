// Anders Broch Ulsted

package application.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import application.model.Arrangement;
import application.model.Hold;
import application.model.Tutor;
import application.model.Uddannelse;
import storage.Storage;

public class Service {

    public static Uddannelse createUddannelse(String navn) {
        Uddannelse uddannelse = new Uddannelse(navn);
        Storage.addUddannelse(uddannelse);
        return uddannelse;
    }

    public static Hold createHold(String navn, String holdleder) {
        Hold hold = new Hold(navn, holdleder);
        Storage.addHold(hold);
        return hold;
    }

    public static Tutor createTutor(String navn, String email) {
        Tutor tutor = new Tutor(navn, email);
        Storage.addTutor(tutor);
        return tutor;
    }

    public static Arrangement createArrangement(String betegnelse, LocalDate date, LocalDateTime startTid,
            LocalDateTime slutTid, double pris) {
        Arrangement arrangement = new Arrangement(betegnelse, date, startTid, slutTid, pris);
        Storage.addArrangement(arrangement);
        return arrangement;
    }

    public static void initStorage() {
        Uddannelse DMU = new Uddannelse("DMU");
        Uddannelse FINØ = new Uddannelse("FINØ");
        Hold h1 = new Hold("1dmE17S", "Margrethe Dybdahl");
        Hold h2 = new Hold("1dmE17T", "Kristian Dorland");
        Hold h3 = new Hold("1dmE17U", "Kell Ørhøj");
        Hold h4 = new Hold("1fiE17B", "Karen Jensen");
        DMU.createHold("1dmE17S", "Margrethe Dybdahl");
        DMU.createHold("1dmE17T", "Kristian Dorland");
        DMU.createHold("1dmE17U", "Kell Ørhøj");
        FINØ.createHold("1fiE17B", "Karen Jensen");
        Tutor t1 = new Tutor("Anders Hansen", "aaa@students.eaaa.dk");
        Tutor t2 = new Tutor("Peter Jensen", "ppp@students.eaaa.dk");
        Tutor t3 = new Tutor("Niels Madsen", "nnn@students.eaaa.dk");
        Tutor t4 = new Tutor("Lone Andersen", "lll@students.eaaa.dk");
        Tutor t5 = new Tutor("Mads Miller", "mmm@students.eaaa.dk");
        Arrangement rus = new Arrangement("Rusfest", LocalDate.of(2017, 8, 31), LocalDateTime.of(2017, 8, 31, 18, 00),
                LocalDateTime.of(2017, 8, 31, 23, 30), 250);
        Arrangement fb = new Arrangement("Fodbold", LocalDate.of(2017, 8, 30), LocalDateTime.of(2017, 8, 30, 14, 0),
                LocalDateTime.of(2017, 8, 30, 17, 30), 100);
        Arrangement bs = new Arrangement("Brætspil", LocalDate.of(2017, 8, 29), LocalDateTime.of(2017, 8, 29, 12, 0),
                LocalDateTime.of(2017, 8, 29, 16, 30), 25);
        Arrangement mp = new Arrangement("Mindeparken", LocalDate.of(2017, 8, 30), LocalDateTime.of(2017, 8, 30, 18, 0),
                LocalDateTime.of(2017, 8, 30, 22, 0), 25);
    }

    // public static ArrayList<Hold> holdUdenTutorer(){
    // ArrayList<Hold> hold1 = new ArrayList<>();
    // for (Tutor t : ) {
    //
    // }
    // }
}
